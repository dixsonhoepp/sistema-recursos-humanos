package controller.funcionario;

import evento.funcionario.RegistrarFuncionario;
import javax.swing.JDialog;
import javax.swing.JFrame;
import view.funcionarios.VRegistrarFuncionario;

public class VRegistrarFuncionarioController extends VRegistrarFuncionario{
    
    public VRegistrarFuncionarioController(JFrame v, boolean modal) {
        super(v, modal);
        evento();
    }
    
    public VRegistrarFuncionarioController(JDialog v, boolean modal) {
        super(v, modal);
        evento();
    }
    
    private void evento(){
        getBTN_REGISTRAR().addMouseListener(new RegistrarFuncionario());
    }
    
}
