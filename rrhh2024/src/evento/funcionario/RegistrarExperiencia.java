package evento.funcionario;

import consulta.listado.informaciondefuncinario.ListadoExperiencia;
import myclass.Cargando;
import controller.funcionario.VRegistrarExperienciaController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Experiencia;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarExperiencia extends MouseAdapter {
    
    private VRegistrarExperienciaController frame;

    @Override
    public void mouseClicked(MouseEvent e) {
        
        frame = (VRegistrarExperienciaController) SwingUtilities.getWindowAncestor(e.getComponent());
        

        if (frame.getBtn_registrar() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                String funciones = frame.getFunciones().getText();
                String fechaIngreso = "";
                String fechaEgreso = "";

                try {
                    Date date = frame.getFechaIngreso().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechaIngreso = fecha.toString();

                } catch (Exception ex) {
                }

                int ID = frame.getVentanaEditarFuncionario().IDFuncionario;

                if (funciones.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(frame);

                    Experiencia exp = new Experiencia();
                    try {

                        //registrar
                        exp.Registrar(ID, funciones, fechaIngreso);

                        //mostrar listado
                        ListadoExperiencia listado = new ListadoExperiencia(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(ID);

                        //Ocultar btn ELiminar
                        frame.getVentanaEditarFuncionario().getBtnEliminarExp().setVisible(false);
                        loader.ocultar();

                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(frame, true);
                        ventanaExito.setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrarExperiencia.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo.start();

        }

    }

}
