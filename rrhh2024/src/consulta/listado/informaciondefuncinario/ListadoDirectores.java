package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Directores;
import view.administrar.VAdministrador;



public class ListadoDirectores {
    private VAdministrador admin;
    private Directores directores = new Directores();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoDirectores(VAdministrador admin) {
        this.admin = admin;
    }


    public void MostrarListadoDG() {

        modelo = directores.Listado("DIRECTOR GENERAL");
        
        admin.getjTable_DIRECTORGENERAL().setModel(modelo);
        
        //VENTANA VER
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(0).setPreferredWidth(30);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(1).setPreferredWidth(100);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(2).setPreferredWidth(130);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(3).setPreferredWidth(130);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(4).setPreferredWidth(130);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(5).setPreferredWidth(130);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(6).setPreferredWidth(100);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(7).setPreferredWidth(130);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(8).setPreferredWidth(100);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(9).setPreferredWidth(150);


        //OCUTAR IDDirectores
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(10).setMinWidth(0);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(10).setMaxWidth(0);
        admin.getjTable_DIRECTORGENERAL().getColumnModel().getColumn(10).setPreferredWidth(0);
        
        
        admin.getjTable_DIRECTORGENERAL().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    public void MostrarListadoRRHH() {

        modelo = directores.Listado("DIRECTOR DE GESTIÓN HUMANA");
        
        admin.getjTable_DIRECTORRRHH().setModel(modelo);
        
        //VENTANA VER
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(0).setPreferredWidth(30);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(1).setPreferredWidth(100);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(2).setPreferredWidth(130);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(3).setPreferredWidth(130);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(4).setPreferredWidth(130);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(5).setPreferredWidth(130);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(6).setPreferredWidth(100);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(7).setPreferredWidth(130);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(8).setPreferredWidth(100);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(9).setPreferredWidth(150);


        //OCUTAR IDDirectores
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(10).setMinWidth(0);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(10).setMaxWidth(0);
        admin.getjTable_DIRECTORRRHH().getColumnModel().getColumn(10).setPreferredWidth(0);
        
        
        admin.getjTable_DIRECTORRRHH().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
  
    
    

}
