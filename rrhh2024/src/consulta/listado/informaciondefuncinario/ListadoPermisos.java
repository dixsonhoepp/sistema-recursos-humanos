package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Permisos;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoPermisos {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Permisos buscar = new Permisos();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoPermisos(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoPermisos(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoPermisos.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoPermisos.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoPermisos.getColumnModel().getColumn(1).setPreferredWidth(200);
        ef.listadoPermisos.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoPermisos.getColumnModel().getColumn(3).setPreferredWidth(100);
        ef.listadoPermisos.getColumnModel().getColumn(4).setPreferredWidth(200);
        ef.listadoPermisos.getColumnModel().getColumn(5).setPreferredWidth(100);
        ef.listadoPermisos.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoPermisos.getColumnModel().getColumn(7).setMinWidth(0);
        ef.listadoPermisos.getColumnModel().getColumn(7).setMaxWidth(0);
        ef.listadoPermisos.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        ef.listadoPermisos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoPermisos.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoPermisos.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoPermisos.getColumnModel().getColumn(1).setPreferredWidth(200);
        vf.listadoPermisos.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoPermisos.getColumnModel().getColumn(3).setPreferredWidth(100);
        vf.listadoPermisos.getColumnModel().getColumn(4).setPreferredWidth(200);
        vf.listadoPermisos.getColumnModel().getColumn(5).setPreferredWidth(100);
        vf.listadoPermisos.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoPermisos.getColumnModel().getColumn(7).setMinWidth(0);
        vf.listadoPermisos.getColumnModel().getColumn(7).setMaxWidth(0);
        vf.listadoPermisos.getColumnModel().getColumn(7).setPreferredWidth(0);
       
        vf.listadoPermisos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
