package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Reposos;
import model.Vacaciones;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoVacaciones {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Vacaciones buscar = new Vacaciones();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoVacaciones(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoVacaciones(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoVacaciones.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoVacaciones.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoVacaciones.getColumnModel().getColumn(1).setPreferredWidth(200);
        ef.listadoVacaciones.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoVacaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
        ef.listadoVacaciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        ef.listadoVacaciones.getColumnModel().getColumn(5).setPreferredWidth(100);
        ef.listadoVacaciones.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoVacaciones.getColumnModel().getColumn(7).setMinWidth(0);
        ef.listadoVacaciones.getColumnModel().getColumn(7).setMaxWidth(0);
        ef.listadoVacaciones.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        ef.listadoVacaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoVacaciones.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoVacaciones.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoVacaciones.getColumnModel().getColumn(1).setPreferredWidth(200);
        vf.listadoVacaciones.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoVacaciones.getColumnModel().getColumn(3).setPreferredWidth(100);
        vf.listadoVacaciones.getColumnModel().getColumn(4).setPreferredWidth(200);
        vf.listadoVacaciones.getColumnModel().getColumn(5).setPreferredWidth(100);
        vf.listadoVacaciones.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoVacaciones.getColumnModel().getColumn(7).setMinWidth(0);
        vf.listadoVacaciones.getColumnModel().getColumn(7).setMaxWidth(0);
        vf.listadoVacaciones.getColumnModel().getColumn(7).setPreferredWidth(0);
        
        vf.listadoVacaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
