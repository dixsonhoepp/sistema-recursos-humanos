package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Ascenso;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoAscenso {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Ascenso buscar = new Ascenso();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoAscenso(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoAscenso(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoAscenso.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoAscenso.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoAscenso.getColumnModel().getColumn(1).setPreferredWidth(100);
        ef.listadoAscenso.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoAscenso.getColumnModel().getColumn(3).setPreferredWidth(200);
        ef.listadoAscenso.getColumnModel().getColumn(4).setPreferredWidth(100);
        ef.listadoAscenso.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoAscenso.getColumnModel().getColumn(6).setMinWidth(0);
        ef.listadoAscenso.getColumnModel().getColumn(6).setMaxWidth(0);
        ef.listadoAscenso.getColumnModel().getColumn(6).setPreferredWidth(0);
        
        ef.listadoAscenso.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoAscenso.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoAscenso.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoAscenso.getColumnModel().getColumn(1).setPreferredWidth(100);
        vf.listadoAscenso.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoAscenso.getColumnModel().getColumn(3).setPreferredWidth(200);
        vf.listadoAscenso.getColumnModel().getColumn(4).setPreferredWidth(100);
        vf.listadoAscenso.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoAscenso.getColumnModel().getColumn(6).setMinWidth(0);
        vf.listadoAscenso.getColumnModel().getColumn(6).setMaxWidth(0);
        vf.listadoAscenso.getColumnModel().getColumn(6).setPreferredWidth(0);
        
        vf.listadoAscenso.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
