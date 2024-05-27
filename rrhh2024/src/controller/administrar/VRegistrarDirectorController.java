package controller.administrar;
import evento.administrar.RegistrarDirector;
import javax.swing.JDialog;
import view.administrar.VRegistrarDirector;

public class VRegistrarDirectorController extends VRegistrarDirector{
    
    VAdministradorController admin;
    
    public VRegistrarDirectorController(JDialog v, boolean modal) {
        super(v, modal);
        admin = (VAdministradorController) v;
        evento();
    }
    
    private void evento(){
        getBTN_REGISTRAR().addMouseListener(new RegistrarDirector());
    }
    
    public VAdministradorController getVentanaAdministrador(){
        return admin;
    }
    
}
