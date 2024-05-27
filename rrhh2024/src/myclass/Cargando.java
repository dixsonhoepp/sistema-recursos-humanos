package myclass;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import view.ventanaemergente.VCargando;

public class Cargando {

    private VCargando vn;
    Thread hilo;

    public void mostrar(JFrame frame) {

        hilo = new Thread(() -> {
            vn = new VCargando(frame, true);
            vn.setLocationRelativeTo(frame);
            vn.setAlwaysOnTop(true);
            vn.setVisible(true);
        });

        hilo.start();

    }

    public void mostrar(JDialog dialog) {

        hilo = new Thread(() -> {
            vn = new VCargando(dialog, true);
            vn.setLocationRelativeTo(dialog);
            vn.setAlwaysOnTop(true);
            vn.setVisible(true);
        });

        hilo.start();

    }

    public void ocultar() {
        hilo = new Thread(() -> {
            vn.dispose();
        });

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilo.start();

    }

}
