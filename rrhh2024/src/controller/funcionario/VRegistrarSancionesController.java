package controller.funcionario;

import evento.funcionario.RegistrarSanciones;
import javax.swing.JDialog;
import view.funcionarios.VRegistrarSanciones;


public class VRegistrarSancionesController extends VRegistrarSanciones{
    
    private VEditarFuncionarioController ventanaRegistrarFuncionario;
    
    public VRegistrarSancionesController(JDialog v, boolean modal) {
        super(v, modal); 
        ventanaRegistrarFuncionario = (VEditarFuncionarioController) v;
        evento();
        
    }
    
    private void evento(){
        getBtn_registrar().addMouseListener(new RegistrarSanciones());
        
        //JTABLE SANCIONES
//        ListadoSanciones.addMouseListener(new RegistrarSanciones(ventanaPrincipal, ef, rs));
    }
    
    public VEditarFuncionarioController getVentanaEditarFuncionario(){
        return ventanaRegistrarFuncionario;
    }
    
}
