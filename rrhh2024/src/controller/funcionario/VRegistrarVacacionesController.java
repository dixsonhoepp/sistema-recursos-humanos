package controller.funcionario;

import evento.funcionario.RegistrarVacaciones;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarVacaciones;


public class VRegistrarVacacionesController extends VRegistrarVacaciones{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarVacacionesController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarVacaciones());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
