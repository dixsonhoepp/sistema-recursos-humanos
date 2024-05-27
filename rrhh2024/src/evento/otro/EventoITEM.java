package evento.otro;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.SwingUtilities;
import view.funcionarios.VEditarFuncionario;

public class EventoITEM implements ItemListener{
    
    private VEditarFuncionario ventanaEditarFuncioanrio;
    

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        ventanaEditarFuncioanrio = 
                (VEditarFuncionario) SwingUtilities.getWindowAncestor((Component) e.getSource());
        
        if(ventanaEditarFuncioanrio.getCondicion() == e.getSource()){
            
            if(ventanaEditarFuncioanrio.getCondicion().getSelectedItem() == "BAJA"){
                
                ventanaEditarFuncioanrio.getJpanel_motivoegreso().setVisible(true);
                
            }else{
                ventanaEditarFuncioanrio.getJpanel_motivoegreso().setVisible(false);
            }

        }
        
    }
    
}
