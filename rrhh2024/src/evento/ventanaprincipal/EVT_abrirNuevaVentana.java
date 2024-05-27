package evento.ventanaprincipal;

import controller.ventanaprincipal.VPrincipalController;
import controller.persona.VListadoPersonaController;
import controller.persona.VRegistrarPersonaController;
import controller.servicio.VNuevoServicioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import myclass.Cargando;

public class EVT_abrirNuevaVentana extends MouseAdapter {

    private VPrincipalController VentanaPrincipal;

    @Override
    public void mouseClicked(MouseEvent e) {

        VentanaPrincipal = (VPrincipalController) SwingUtilities.getWindowAncestor(e.getComponent());

        //BTN NUEVO FUNCIONARIO
        if (VentanaPrincipal.getBTN_NUEVOFUNCIONARIO() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(VentanaPrincipal);

                VListadoPersonaController frame = new VListadoPersonaController(VentanaPrincipal, true);
                frame.setOpcionPopuMenu(VListadoPersonaController.POPUMENU_FUNCIONARIO);

                loader.ocultar();

                frame.setVisible(true);

            });

            hilo.start();

        }

        //BTN NUEVO SERVICIO
        if (VentanaPrincipal.getBTN_NUEVOSERVICIO() == e.getSource()) {
            
            VNuevoServicioController ventanaServicio = new VNuevoServicioController(VentanaPrincipal, true);
            ventanaServicio.setVisible(true);

        }

        // BTN NUEVA PERSONA
        if (VentanaPrincipal.getBTN_NUEVAPERSONA() == e.getSource()) {

            VRegistrarPersonaController ventanaRegistrarPersona
                    = new VRegistrarPersonaController(VentanaPrincipal, true);
            ventanaRegistrarPersona.setVisible(true);

        }

    }

}
