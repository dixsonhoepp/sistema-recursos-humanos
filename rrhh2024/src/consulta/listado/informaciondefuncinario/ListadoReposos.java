package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Reposos;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoReposos {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Reposos buscar = new Reposos();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoReposos(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoReposos(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoReposo.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoReposo.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoReposo.getColumnModel().getColumn(1).setPreferredWidth(200);
        ef.listadoReposo.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoReposo.getColumnModel().getColumn(3).setPreferredWidth(100);
        ef.listadoReposo.getColumnModel().getColumn(4).setPreferredWidth(200);
        ef.listadoReposo.getColumnModel().getColumn(5).setPreferredWidth(100);
        ef.listadoReposo.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoReposo.getColumnModel().getColumn(7).setMinWidth(0);
        ef.listadoReposo.getColumnModel().getColumn(7).setMaxWidth(0);
        ef.listadoReposo.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        ef.listadoReposo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoReposo.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoReposo.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoReposo.getColumnModel().getColumn(1).setPreferredWidth(200);
        vf.listadoReposo.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoReposo.getColumnModel().getColumn(3).setPreferredWidth(100);
        vf.listadoReposo.getColumnModel().getColumn(4).setPreferredWidth(200);
        vf.listadoReposo.getColumnModel().getColumn(5).setPreferredWidth(100);
        vf.listadoReposo.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoReposo.getColumnModel().getColumn(7).setMinWidth(0);
        vf.listadoReposo.getColumnModel().getColumn(7).setMaxWidth(0);
        vf.listadoReposo.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        vf.listadoReposo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
