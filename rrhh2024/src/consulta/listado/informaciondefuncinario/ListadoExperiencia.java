package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Experiencia;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoExperiencia {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Experiencia buscar = new Experiencia();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoExperiencia(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoExperiencia(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoExperiencia.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoExperiencia.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoExperiencia.getColumnModel().getColumn(1).setPreferredWidth(400);
        ef.listadoExperiencia.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoExperiencia.getColumnModel().getColumn(3).setMinWidth(0);
        ef.listadoExperiencia.getColumnModel().getColumn(3).setMaxWidth(0);
        ef.listadoExperiencia.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        ef.listadoExperiencia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoExperiencia.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoExperiencia.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoExperiencia.getColumnModel().getColumn(1).setPreferredWidth(400);
        vf.listadoExperiencia.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoExperiencia.getColumnModel().getColumn(3).setMinWidth(0);
        vf.listadoExperiencia.getColumnModel().getColumn(3).setMaxWidth(0);
        vf.listadoExperiencia.getColumnModel().getColumn(3).setPreferredWidth(0);
        
        vf.listadoExperiencia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
