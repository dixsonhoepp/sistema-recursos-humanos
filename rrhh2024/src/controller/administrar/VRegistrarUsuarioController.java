
package controller.administrar;

import evento.administrar.RegistrarUsuario;
import javax.swing.JDialog;
import javax.swing.JFrame;
import view.administrar.VRegistrarUsuario;

public class VRegistrarUsuarioController extends VRegistrarUsuario{
    
    private VAdministradorController ventanaAdministrar;
    
    public VRegistrarUsuarioController(JFrame v, boolean modal) {
        super(v, modal);
        evento();
    }
    
    public VRegistrarUsuarioController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaAdministrar = (VAdministradorController) v;
        evento();
    }
    
    public VAdministradorController getVentanaAdministrar(){
        return ventanaAdministrar;
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarUsuario());
    }
    
    
}
