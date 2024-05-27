
package controller.funcionario;

import evento.funcionario.RegistrarFamilia;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarFamiliar;

public class VRegistrarFamiliarController extends VRegistrarFamiliar{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarFamiliarController(JDialog v, boolean modal) {
        super(v, modal);
        evento();
    }
    
    
    public void setVentanaEditarFuncionario(VEditarFuncionarioController ventanaRegistrarFuncionario){
        this.ventanaRegistrarFuncionario = ventanaRegistrarFuncionario;
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
    public void evento(){
        getBtn_registrar().addMouseListener(new RegistrarFamilia());
    }
    
}
