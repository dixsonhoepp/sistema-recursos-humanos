
package controller.funcionario;

import evento.funcionario.RegistrarExperiencia;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarExperiencia;


public class VRegistrarExperienciaController extends VRegistrarExperiencia{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarExperienciaController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
        
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarExperiencia());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
