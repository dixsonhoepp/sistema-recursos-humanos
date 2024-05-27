package evento.otro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.VPrincipal;
import view.personas.VListadoPersona;
import view.personas.VRegistrarPersona;


public class EventoAbrirVRP extends MouseAdapter{
    
    private VPrincipal vn;
    private VListadoPersona lp;
    private VRegistrarPersona rp;

    public EventoAbrirVRP(VPrincipal vn, VListadoPersona lp, VRegistrarPersona rp) {
        this.vn = vn;
        this.lp = lp;
        this.rp = rp;
    }


    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        rp.setLocationRelativeTo(lp);
        rp.setVisible(true);
        
    }
    
    
    
    
}
