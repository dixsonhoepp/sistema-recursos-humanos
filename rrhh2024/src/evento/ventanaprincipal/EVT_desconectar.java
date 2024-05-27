
package evento.ventanaprincipal;

import controller.VLoginController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import myclass.Cargando;
import myclass.RegistroHistorial;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;

public class EVT_desconectar extends MouseAdapter{

    private VPrincipal VentanaPrincipal;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        VentanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(e.getComponent());
        
                //BTN DESCONECTAR
        if (VentanaPrincipal.getBTN_DESCONECTAR() == e.getSource()) {

            VConfirmar c = new VConfirmar(VentanaPrincipal, true);

            if (c.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(new JFrame());

                    //HISTORIAL
                    RegistroHistorial r = new RegistroHistorial();
                    r.Login(2);

                    //ocultar ventana principal
                    VentanaPrincipal.dispose();
                    
                    loader.ocultar();
                    
                    //mostrar Login
                    VLoginController ventanaLogin = new VLoginController();
                    ventanaLogin.setVisible(true);

                });

                hilo.start();

            }

        }
        
        
    }
    
    
    
}
