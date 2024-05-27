package controller.persona;

import evento.persona.EventoRegistrarPersona;
import javax.swing.JFrame;
import view.VPrincipal;
import view.personas.VRegistrarPersona;


public class VRegistrarPersonaController extends VRegistrarPersona{
    
    VPrincipal ventanaPrincipal;
    
    public VRegistrarPersonaController(JFrame v, boolean modal) {
        super(v, modal);
        ventanaPrincipal = (VPrincipal) v;
        eventos();
    }
    
    private void eventos(){
        
        getBTN_REGISTRARPERSONA().addMouseListener(new EventoRegistrarPersona(ventanaPrincipal));
        getBTN_FOTO().addMouseListener(new EventoRegistrarPersona(ventanaPrincipal));
        
    }
    
}
