
package controller.funcionario;

import evento.funcionario.reportePDF.ConstanciaTrabajo;
import evento.funcionario.reportePDF.ConstanciaUbicacion;
import javax.swing.JFrame;
import view.funcionarios.VVerFuncionario;


public class VVerFuncionarioController extends VVerFuncionario{
    
    public VVerFuncionarioController(JFrame v, boolean modal) {
        super(v, modal);
        
        getBTN_VERFAMILIA().setVisible(false);
        
        evento();
    }
    
    private void evento(){
        getBtnConstancia().addMouseListener(new ConstanciaTrabajo());
        getBtnNombramiento().addMouseListener(new ConstanciaUbicacion());
    }
    
}
