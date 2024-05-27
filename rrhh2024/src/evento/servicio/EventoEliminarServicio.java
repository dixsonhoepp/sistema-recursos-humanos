package evento.servicio;

import consulta.listado.ListadoServiciosVP;
import myclass.Cargando;
import myclass.RegistroHistorial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Servicios;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VConfirmar;

public class EventoEliminarServicio extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {

        VPrincipal ventanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(e.getComponent());

        //ELIMINAR SERVICIO
        if (e.getSource() == ventanaPrincipal.getBTN_ELIMINARSERVICIO()) {

            Thread hilo = new Thread(() -> {
                //ventana de confirmacion
                VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                boolean confirmar = vc.confirmacion;

                if (confirmar) {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaPrincipal);

                    //Obtener el valor del JTABLET
                    DefaultTableModel modelo = (DefaultTableModel) ventanaPrincipal.getjTable_SERVICIO().getModel();
                    int ID = Integer.parseInt(modelo.getValueAt(ventanaPrincipal.getjTable_SERVICIO().getSelectedRow(), 3).toString());

                    Servicios servicio = new Servicios();
                    servicio.Eliminar(ID);

                    ventanaPrincipal.getBuscadorServicio().setText("");
                    ventanaPrincipal.getBTN_ELIMINARSERVICIO().setVisible(false);
                    ListadoServiciosVP listado = new ListadoServiciosVP(ventanaPrincipal);
                    listado.MostrarListado();

                    //HISTORIAL
                    RegistroHistorial h = new RegistroHistorial();
                    h.Servicio(2);

                    try {
                        //Quitar Seleccion del JTABLET
                        ventanaPrincipal.getjTable_SERVICIO().removeRowSelectionInterval(ventanaPrincipal.getjTable_SERVICIO().getSelectedRow(), 0);
                    } catch (Exception ex) {
                        System.err.println(ex);
                    }


                    loader.ocultar();

                    //Ventana de exito
                    VAprobado ventanaExito = new VAprobado(ventanaPrincipal, true);
                    ventanaExito.setVisible(true);

                }

            });

            hilo.start();

        }

    }

}
