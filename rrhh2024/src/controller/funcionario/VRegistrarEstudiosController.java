
package controller.funcionario;

import evento.funcionario.RegistrarEstudios;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarEstudios;


public class VRegistrarEstudiosController extends VRegistrarEstudios{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarEstudiosController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        eveto();
        
    }
    
    private void eveto(){
        
        getBtn_registrar().addMouseListener(new RegistrarEstudios());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
