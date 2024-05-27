package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Historial;
import view.administrar.VAdministrador;



public class ListadoHistorial {
    private VAdministrador admin;
    private Historial h = new Historial();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoHistorial(VAdministrador admin) {
        this.admin = admin;
    }


    public void MostrarListado() {

        modelo = h.Listado();
        
        admin.getjTable_HISTORIAL().setModel(modelo);
        
        //VENTANA VER
        admin.getjTable_HISTORIAL().getColumnModel().getColumn(0).setPreferredWidth(150);
        admin.getjTable_HISTORIAL().getColumnModel().getColumn(1).setPreferredWidth(150);
        admin.getjTable_HISTORIAL().getColumnModel().getColumn(2).setPreferredWidth(800);

        
        admin.getjTable_HISTORIAL().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
   
  
    
    

}
