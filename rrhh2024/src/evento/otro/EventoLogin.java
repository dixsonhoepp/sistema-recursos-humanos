package evento.otro;

import controller.ventanaprincipal.VPrincipalController;
import myclass.Cargando;
import myclass.RegistroHistorial;
import myclass.Encriptar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.Usuario;
import view.VLogin;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class EventoLogin extends MouseAdapter {

    private VLogin login;
    private Encriptar encriptar = new Encriptar();

    @Override
    public void mouseClicked(MouseEvent e) {

        login = (VLogin) SwingUtilities.getWindowAncestor(e.getComponent());

        if (e.getSource() == login.getBTN_INGRESAR()) {

            Thread hilo = new Thread(() -> {

                String usuario = login.getUsuario().getText();
                String clave = new String(login.getClave().getPassword());

                if (usuario.isEmpty() || clave.isEmpty()) {

                    VError VError = new VError(login, true);
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else {

                    try {

                        //MOSTRAAR VENTANA CARGANDO
                        Cargando loader = new Cargando();
                        loader.mostrar(new JFrame());

                        //VERIFICAR USUARIO
                        Usuario u = new Usuario();
                        int resultado = u.Ingresar(usuario, encriptar.GetEncriptado(clave));

                        VPrincipalController ventanaPrincipal = new VPrincipalController();

                        if (resultado != 0) {

                            ventanaPrincipal.login = usuario;
                            login.getUsuario().setText("");
                            login.getClave().setText("");
                            login.dispose();

                            //Mostrar Ventana principal
                            ventanaPrincipal.usuarioconectado.setText("@" + ventanaPrincipal.login.toLowerCase());
                            ventanaPrincipal.setVisible(true);

                            //HISTORIAL
                            RegistroHistorial r = new RegistroHistorial();
                            r.Login(1);

                            //ocultar panel cargando
                            loader.ocultar();
                            VAprobado exito = new VAprobado(ventanaPrincipal, true);
                            exito.setVisible(true);

                        } else {
                            //ocultar panel cargando
                            loader.ocultar();
                            VError VError = new VError(ventanaPrincipal, true);
                            VError.texto.setText("USUARIO INCORRECTO");
                            VError.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(EventoLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo.start();
        }

    }

}
