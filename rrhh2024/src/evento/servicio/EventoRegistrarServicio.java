package evento.servicio;

import myclass.Cargando;
import consulta.listado.ListadoServiciosVP;
import myclass.RegistroHistorial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Servicios;
import view.VPrincipal;
import view.servicios.VNuevoServicio;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VConfirmar;

public class EventoRegistrarServicio extends MouseAdapter {

    private VPrincipal vn;
    private VNuevoServicio rs;

    public EventoRegistrarServicio(VPrincipal vn, VNuevoServicio rs) {
        this.vn = vn;
        this.rs = rs;
    }
    
    public EventoRegistrarServicio(VPrincipal vn) {
        this.vn = vn;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //registrar servicio
        if (e.getSource() == rs.getBtn_registrarservicio()) {

            Thread hilo = new Thread(() -> {

                Cargando loader = new Cargando();
                loader.mostrar(rs);

                Servicios servicio = new Servicios();
                servicio.Registrar(rs.getNombre().getText().toUpperCase(), rs.getObservacion().getText().toUpperCase());

                rs.getNombre().setText("");
                rs.getObservacion().setText("");

                ListadoServiciosVP listado = new ListadoServiciosVP(vn);
                listado.MostrarListado();

                //HISTORIAL
                RegistroHistorial h = new RegistroHistorial();
                h.Servicio(1);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EventoRegistrarServicio.class.getName()).log(Level.SEVERE, null, ex);
                }

                loader.ocultar();

                //Ventana de exito
                VAprobado ventanaExito = new VAprobado(rs, true);
                ventanaExito.setVisible(true);

            });

            hilo.start();

        }
    }

}
