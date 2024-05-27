package evento.administrar;

import controller.administrar.VAdministradorController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class EventoTableVentanaAdministrar extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        
        VAdministradorController admin = (VAdministradorController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (admin.getjTable_USUARIOS()
                == e.getSource() && admin.getjTable_USUARIOS().getSelectedRow() != -1) {
            admin.getBTN_ELIMINARUSUARIO().setVisible(true);

        }

        if (admin.getjTable_DIRECTORGENERAL()
                == e.getSource() && admin.getjTable_DIRECTORGENERAL().getSelectedRow() != -1) {
            admin.getBTN_ELIMINARDIRECTORGENERAL().setVisible(true);

        }

        if (admin.getjTable_DIRECTORRRHH()
                == e.getSource() && admin.getjTable_DIRECTORRRHH().getSelectedRow() != -1) {
            admin.getBTN_ELIMINARDIRECTORRRHH().setVisible(true);
        }

    }

}
