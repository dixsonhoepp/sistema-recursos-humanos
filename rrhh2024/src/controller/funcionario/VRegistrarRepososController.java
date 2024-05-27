package controller.funcionario;

import evento.funcionario.RegistrarReposos;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarReposos;


public class VRegistrarRepososController extends VRegistrarReposos{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarRepososController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
        
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarReposos());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
