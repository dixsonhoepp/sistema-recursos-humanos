package controller.ventanaprincipal;

import popumenu.PopuMenuFuncionarios;
import popumenu.PopuMenuPersonasVP;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import view.VPrincipal;

public class EventoTableVentanaPrincipal extends MouseAdapter {

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        VPrincipal ventanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(e.getComponent());

        try {

            if (ventanaPrincipal.getjTable_PERSONAS() == e.getSource() 
                    && ventanaPrincipal.getjTable_PERSONAS().getSelectedRow() != -1) {
                PopuMenuPersonasVP popumenu = new PopuMenuPersonasVP(ventanaPrincipal.getjTable_PERSONAS());

            } 
            
            if (ventanaPrincipal.getjTable_FUNCIONARIOSACTIVOS() == e.getSource() 
                    && ventanaPrincipal.getjTable_FUNCIONARIOSACTIVOS().getSelectedRow() != -1) {
                PopuMenuFuncionarios popumenu = new PopuMenuFuncionarios(
                        ventanaPrincipal.getjTable_FUNCIONARIOSACTIVOS());
            } 
          
            if (ventanaPrincipal.getjTable_FUNCIONARIOSSUSPENDIDOS() == e.getSource()
                    && ventanaPrincipal.getjTable_FUNCIONARIOSSUSPENDIDOS().getSelectedRow() != -1) {
                PopuMenuFuncionarios popumenu = new PopuMenuFuncionarios(
                        ventanaPrincipal.getjTable_FUNCIONARIOSSUSPENDIDOS());

            } 
            
            if (ventanaPrincipal.getjTable_FUNCIONARIOSIVSS() == e.getSource() 
                    && ventanaPrincipal.getjTable_FUNCIONARIOSIVSS().getSelectedRow() != -1) {
                PopuMenuFuncionarios popumenu = new PopuMenuFuncionarios(
                        ventanaPrincipal.getjTable_FUNCIONARIOSIVSS());

            } 
            
            if (ventanaPrincipal.getjTable_FUNCIONARIOSBAJA() == e.getSource() 
                    && ventanaPrincipal.getjTable_FUNCIONARIOSBAJA().getSelectedRow() != -1) {
                PopuMenuFuncionarios popumenu = new PopuMenuFuncionarios(
                        ventanaPrincipal.getjTable_FUNCIONARIOSBAJA());

            }
            
            if (ventanaPrincipal.getjTable_SERVICIO() == e.getSource() 
                    && ventanaPrincipal.getjTable_SERVICIO().getSelectedRow() != -1) {
                ventanaPrincipal.getBTN_ELIMINARSERVICIO().setVisible(true);

            } 
                  

        } catch (Exception ex) {
            
            System.out.println(ex);
        }

    }

}
