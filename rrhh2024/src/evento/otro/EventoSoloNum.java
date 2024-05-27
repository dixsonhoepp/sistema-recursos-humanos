
package evento.otro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VRegistrarFuncionario;
import view.personas.VEditarPersona;
import view.personas.VRegistrarPersona;


public class EventoSoloNum extends KeyAdapter{

    private VRegistrarPersona rp;
    private VRegistrarFuncionario rf;
    private VEditarFuncionario ef;
    private VEditarPersona ep;

    public EventoSoloNum(VRegistrarPersona rp) {
        this.rp = rp;
    }

    public EventoSoloNum(VRegistrarFuncionario rf) {
        this.rf = rf;
    }

    public EventoSoloNum(VEditarFuncionario ef) {
        this.ef = ef;
    }

    public EventoSoloNum(VEditarPersona ep) {
        this.ep = ep;
    }
    
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        
        //VENTANA REGISTRAR PERSONA

            System.out.println("hola mundo");


    
    }

}
