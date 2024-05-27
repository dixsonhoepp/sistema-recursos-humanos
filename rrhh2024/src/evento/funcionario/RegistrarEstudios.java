package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoEstudios;
import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VRegistrarEstudiosController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Estudios;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarEstudios extends MouseAdapter {
    
    private VRegistrarEstudiosController frame;


    @Override
    public void mouseClicked(MouseEvent e) {
        
        frame = (VRegistrarEstudiosController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (frame.getBtn_registrar() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                String tipo = frame.getNivel().getSelectedItem().toString();
                String carrera = frame.getCarrera().getText();
                String universidad = frame.getUniversidad().getText();
                String fecha1 = "";

                try {
                    Date date = frame.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fecha1 = fecha.toString();

                } catch (Exception ex) {
                }

                int ID = VEditarFuncionarioController.IDFuncionario;

                if (tipo.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (carrera.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (universidad.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(frame);
                    Estudios estudios = new Estudios();
                    try {

                        //registrar
                        estudios.Registrar(ID, tipo, carrera, universidad, fecha1);

                        //mostrar listado
                        ListadoEstudios listado = new ListadoEstudios(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(ID);

                        //Ocultar btn ELiminar
                        frame.getVentanaEditarFuncionario().getBtnEliminarEstudios().setVisible(false);
                        
                        loader.ocultar();

                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(frame, true);
                        ventanaExito.setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrarEstudios.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo.start();

        }

    }

}
