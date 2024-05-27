package controller.funcionario;

import evento.funcionario.RegistrarPermisos;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarPermisos;

public class VRegistrarPermisosController extends VRegistrarPermisos{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarPermisosController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
        
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarPermisos());
        
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
