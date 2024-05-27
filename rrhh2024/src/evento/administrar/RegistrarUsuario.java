package evento.administrar;

import consulta.listado.informaciondefuncinario.ListadoHistorial;
import consulta.listado.informaciondefuncinario.ListadoUsuario;
import controller.administrar.VRegistrarUsuarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import model.Usuario;
import myclass.Cargando;
import myclass.Encriptar;
import myclass.RegistroHistorial;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarUsuario extends MouseAdapter {

    private VError VError = new VError(new JDialog(), true);
    private String usuario, clave1, clave2;

    @Override
    public void mouseClicked(MouseEvent e) {

        VRegistrarUsuarioController rusuario = (VRegistrarUsuarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        Thread hilo = new Thread(() -> {
            //REGISTRAR
            if (e.getSource() == rusuario.getBtn_registrar()) {
                
                Cargando loader = new Cargando();
                loader.mostrar(rusuario.getVentanaAdministrar());

                //OBTENER VALOR DE LOS CAMPOS
                usuario = rusuario.getUsuario().getText();
                clave1 = new String(rusuario.getClave1().getPassword());
                clave2 = new String(rusuario.getClave2().getPassword());

                //CONSULTAR USUARIO 
                int resultado = 0;
                try {
                    Usuario ru = new Usuario();
                    resultado = ru.Consultar(usuario.toUpperCase());
                } catch (SQLException ex) {
                    Logger.getLogger(EventoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }

                //VALIDAR QUE LOS CAMPOR NO ESTEN VACIOS
                if (usuario.isEmpty()) {
                    loader.ocultar();
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (clave1.isEmpty()) {
                    loader.ocultar();
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (clave2.isEmpty()) {
                    loader.ocultar();
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (!clave1.equals(clave2)) {
                    loader.ocultar();
                    VError.texto.setText("LA CLAVE NO CONCIDE");
                    VError.setVisible(true);

                } else if (resultado != 0) {
                    loader.ocultar();
                    VError.texto.setText("EL NOMBRE DE USUARIO YA EXISTE");
                    VError.setVisible(true);

                } else {

                    try {
                        //REGISTRAR SI CUMPLE CON LOS REQUISITORS
                        Encriptar encriptar = new Encriptar();
                        Usuario ru = new Usuario();
                        ru.Reginstrar(usuario, encriptar.GetEncriptado(clave1), rusuario.IDPersona);

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Usuario(1, 0, usuario);

                        //OCULTAR VENTANA DESPUES DE REGISTRAR
                        rusuario.dispose();

                        //OCULTAR BTN DE ELIMINAR
                        rusuario.getVentanaAdministrar().getBTN_ELIMINARUSUARIO().setVisible(false);
                        rusuario.getVentanaAdministrar().getBTN_ELIMINARDIRECTORGENERAL().setVisible(false);
                        rusuario.getVentanaAdministrar().getBTN_ELIMINARDIRECTORRRHH().setVisible(false);

                        //ACTUALIZAR LISTADO
                        ListadoUsuario ListadoUsuario = new ListadoUsuario(rusuario.getVentanaAdministrar());
                        ListadoUsuario.MostrarListado();
                        
                        ListadoHistorial historial = new ListadoHistorial(rusuario.getVentanaAdministrar());
                        historial.MostrarListado();
                        
                        
                        loader.ocultar();
                        
                        VAprobado exito = new VAprobado(rusuario.getVentanaAdministrar(), true);
                        exito.setVisible(true);
                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(EventoUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                
                

            }
        });

        hilo.start();

    }

}
