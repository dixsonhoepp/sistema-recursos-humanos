package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoSanciones;
import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VRegistrarSancionesController;
import myclass.RegistroHistorial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Sanciones;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VConfirmar;

public class RegistrarSanciones extends MouseAdapter {

    private VRegistrarSancionesController frame;

    private int id;
    private String fecha, motivo, medida, funcionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        frame = (VRegistrarSancionesController) SwingUtilities.getWindowAncestor(e.getComponent());

        //REGISTRAR SANCION
        if (e.getSource() == frame.getBtn_registrar()) {
            Thread hilo = new Thread(() -> {
                id = VEditarFuncionarioController.IDFuncionario;

                fecha = "";

                //Fecha 
                try {

                    Date date = frame.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha1 = new java.sql.Date(d);
                    fecha = fecha1.toString();

                } catch (Exception ex) {
                }

                medida = frame.getMedida().getSelectedItem().toString();
                motivo = frame.getMotivo().getText();
                funcionario = frame.getFuncionario().getText();

                Cargando loader = new Cargando();
                loader.mostrar(frame);

                Sanciones sanciones = new Sanciones();

                try {
                    sanciones.ReginstrarSancion(id, fecha, medida, motivo, funcionario);

                    //HISTORIAL 
                    RegistroHistorial r = new RegistroHistorial();
                    r.Funcionarios(5, VEditarFuncionarioController.IDFuncionario);

                } catch (SQLException ex) {
                    Logger.getLogger(RegistrarSanciones.class.getName()).log(Level.SEVERE, null, ex);
                }

                //MOSTRAR LISTADO DE SANCIONES
                ListadoSanciones listado = new ListadoSanciones(frame.getVentanaEditarFuncionario());
                listado.MostrarListadoEF(VEditarFuncionarioController.IDFuncionario);

                //Ocultar btn ELiminar
                frame.getVentanaEditarFuncionario().getBTN_ELIMINARMD().setVisible(false);
                loader.ocultar();

                //Ventana de exito
                VAprobado ventanaExito = new VAprobado(frame, true);
                ventanaExito.setVisible(true);
            });

            hilo.start();

        }

    }

}
