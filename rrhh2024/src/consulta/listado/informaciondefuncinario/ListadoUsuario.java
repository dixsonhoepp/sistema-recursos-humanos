package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import view.administrar.VAdministrador;



public class ListadoUsuario {
    private VAdministrador admin;
    private Usuario usuario = new Usuario();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoUsuario(VAdministrador admin) {
        this.admin = admin;
    }


    public void MostrarListado() {



        modelo = usuario.Listado();
        
        admin.getjTable_USUARIOS().setModel(modelo);
        
        //VENTANA VER
        admin.getjTable_USUARIOS().getColumnModel().getColumn(0).setPreferredWidth(30);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(1).setPreferredWidth(100);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(2).setPreferredWidth(130);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(3).setPreferredWidth(130);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(4).setPreferredWidth(130);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(5).setPreferredWidth(130);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(6).setPreferredWidth(100);


        //OCUTAR IDUsuario
        admin.getjTable_USUARIOS().getColumnModel().getColumn(7).setMinWidth(0);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(7).setMaxWidth(0);
        admin.getjTable_USUARIOS().getColumnModel().getColumn(7).setPreferredWidth(0);
        
        
        admin.getjTable_USUARIOS().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
  
    
    

}
