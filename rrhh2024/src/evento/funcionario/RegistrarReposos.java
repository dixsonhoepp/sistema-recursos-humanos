package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoReposos;
import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VRegistrarRepososController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Reposos;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarReposos extends MouseAdapter {

    private VRegistrarRepososController frame;


    @Override
    public void mouseClicked(MouseEvent e) {
        
        frame = (VRegistrarRepososController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (frame.getBtn_registrar() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                String motivo = frame.getMotivo().getText();
                String departamento = frame.getDepartamento().getText();
                String dias = frame.getDias().getText();
                String jefe = frame.getJefe().getText();
                String fechaSalida = "";
                String fechaEntrada = "";

                try {
                    Date date = frame.getFechasalida().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechaSalida = fecha.toString();

                } catch (Exception ex) {
                }

                try {
                    Date date = frame.getFechaEntrada().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechaEntrada = fecha.toString();

                } catch (Exception ex) {
                }

                int ID = VEditarFuncionarioController.IDFuncionario;

                if (motivo.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (departamento.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (dias.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(frame);

                    Reposos r = new Reposos();
                    try {

                        //registrar
                        r.Registrar(ID, motivo, departamento, dias, jefe, fechaSalida, fechaEntrada);

                        //mostrar listado
                        ListadoReposos listado = new ListadoReposos(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(ID);

                        //Ocultar btn ELiminar
                        frame.getVentanaEditarFuncionario().getBtnEliminarReposo().setVisible(false);
                        loader.ocultar();

                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(frame, true);
                        ventanaExito.setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrarReposos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

            hilo.start();

        }

    }

}
