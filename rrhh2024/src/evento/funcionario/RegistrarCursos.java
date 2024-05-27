package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoCursos;
import controller.funcionario.VRegistrarCursosController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Cursos;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarCursos extends MouseAdapter {
    
    private VRegistrarCursosController frame;


    @Override
    public void mouseClicked(MouseEvent e) {
        
        frame = (VRegistrarCursosController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (frame.getBtn_registrar() == e.getSource()) {

            Thread hilo = new Thread(() -> {

                String nombre = frame.getNombre().getText();
                String institucion = frame.getInstitucion().getText();
                String duraccion = frame.getDuracion().getText();
                String fecha1 = "";

                try {
                    Date date = frame.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fecha1 = fecha.toString();

                } catch (Exception ex) {
                }

                int ID = VEditarFuncionario.IDFuncionario;

                if (nombre.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (institucion.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (duraccion.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(frame);

                    Cursos cursos = new Cursos();
                    try {

                        //registrar
                        cursos.Registrar(ID, nombre, institucion, duraccion, fecha1);

                        //mostrar listado
                        ListadoCursos listado = new ListadoCursos(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(ID);

                        //Ocultar btn ELiminar
                        frame.getVentanaEditarFuncionario().getBtnEliminarCursos().setVisible(false);

                        loader.ocultar();

                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(frame, true);
                        ventanaExito.setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrarCursos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo.start();

        }

    }

}
