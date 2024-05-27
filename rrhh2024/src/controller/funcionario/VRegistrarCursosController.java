package controller.funcionario;

import evento.funcionario.RegistrarCursos;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarCursos;


public class VRegistrarCursosController extends VRegistrarCursos{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarCursosController(JDialog v, boolean modal) {
        super(v, modal);
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarCursos());
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
