package main;

import com.formdev.flatlaf.FlatLaf;
import myclass.Cargando;
import controller.VLoginController;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Conexion;

public class Main {

    public static void main(String[] args) {

        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#666"));

        Thread hilo = new Thread(() -> {
            //Cargando
            Cargando loader = new Cargando();
            loader.mostrar(new JFrame());

            Conexion con = new Conexion();
            con.conectar();

            if (con.getStatus()) {
                VLoginController ventanaLogin = new VLoginController();
                //ocultar ventana cargando
                loader.ocultar();
                ventanaLogin.setVisible(true);

            } else {
                //ocultar ventana cargando
                loader.ocultar();
                JOptionPane.showMessageDialog(null, "Error de Conexion a la Base de Dato");

            }

        });
        hilo.start();
    }

}
