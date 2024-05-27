
package controller.funcionario;

import evento.funcionario.RegistrarAscenso;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarAscenso;


public class VRegistrarAscensoController extends VRegistrarAscenso{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarAscensoController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
        
        
    }
    
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarAscenso());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
    
}
