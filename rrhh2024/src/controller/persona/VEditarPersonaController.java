package controller.persona;

import evento.persona.EventoEditarPersona;
import javax.swing.JFrame;
import view.VPrincipal;
import view.personas.VEditarPersona;


public class VEditarPersonaController extends VEditarPersona{
    
    VPrincipal ventanaPrincipal;
    
    public VEditarPersonaController(JFrame v, boolean modal) {
        super(v, modal);
        
        this.ventanaPrincipal = (VPrincipal) v;
        
        btnEvento();
    }
    
    private void btnEvento(){
        getBTN_EDITARPERSONA().addMouseListener(new EventoEditarPersona(ventanaPrincipal));
        getBTN_FOTO().addMouseListener(new EventoEditarPersona(ventanaPrincipal));
    }
    
}
