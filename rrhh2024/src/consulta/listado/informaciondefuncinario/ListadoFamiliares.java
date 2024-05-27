package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Familiares;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoFamiliares {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Familiares familiares = new Familiares();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoFamiliares(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoFamiliares(VVerFuncionario vf) {
        this.vf = vf;
    }


    

    
    public void MostrarListadoEF(int ID) {



        modelo = familiares.ListadoConsultarFamiliares(ID);

        ef.ListadoFamilia.setModel(modelo);
        
        //VENTANA VER
        ef.ListadoFamilia.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.ListadoFamilia.getColumnModel().getColumn(1).setPreferredWidth(100);
        ef.ListadoFamilia.getColumnModel().getColumn(2).setPreferredWidth(130);
        ef.ListadoFamilia.getColumnModel().getColumn(3).setPreferredWidth(130);
        ef.ListadoFamilia.getColumnModel().getColumn(4).setPreferredWidth(130);
        ef.ListadoFamilia.getColumnModel().getColumn(5).setPreferredWidth(130);
        ef.ListadoFamilia.getColumnModel().getColumn(6).setPreferredWidth(100);
        ef.ListadoFamilia.getColumnModel().getColumn(7).setPreferredWidth(100);
        ef.ListadoFamilia.getColumnModel().getColumn(8).setPreferredWidth(130);
        ef.ListadoFamilia.getColumnModel().getColumn(9).setPreferredWidth(50);
        ef.ListadoFamilia.getColumnModel().getColumn(10).setPreferredWidth(150);
        ef.ListadoFamilia.getColumnModel().getColumn(11).setPreferredWidth(300);

        //OCUTAR IDFamiliares
        ef.ListadoFamilia.getColumnModel().getColumn(12).setMinWidth(0);
        ef.ListadoFamilia.getColumnModel().getColumn(12).setMaxWidth(0);
        ef.ListadoFamilia.getColumnModel().getColumn(12).setPreferredWidth(0);
        
        //OCUTAR IDPersonas
        ef.ListadoFamilia.getColumnModel().getColumn(13).setMinWidth(0);
        ef.ListadoFamilia.getColumnModel().getColumn(13).setMaxWidth(0);
        ef.ListadoFamilia.getColumnModel().getColumn(13).setPreferredWidth(0);
        
        ef.ListadoFamilia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
   
    //MOSTRAR LISTADO EN VENTANA VER
    
    public void MostrarListadoVF(int ID) {



        modelo = familiares.ListadoConsultarFamiliares(ID);

        vf.ListadoFamilia.setModel(modelo);
        
        //VENTANA VER
        vf.ListadoFamilia.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.ListadoFamilia.getColumnModel().getColumn(1).setPreferredWidth(100);
        vf.ListadoFamilia.getColumnModel().getColumn(2).setPreferredWidth(130);
        vf.ListadoFamilia.getColumnModel().getColumn(3).setPreferredWidth(130);
        vf.ListadoFamilia.getColumnModel().getColumn(4).setPreferredWidth(130);
        vf.ListadoFamilia.getColumnModel().getColumn(5).setPreferredWidth(130);
        vf.ListadoFamilia.getColumnModel().getColumn(6).setPreferredWidth(100);
        vf.ListadoFamilia.getColumnModel().getColumn(7).setPreferredWidth(100);
        vf.ListadoFamilia.getColumnModel().getColumn(8).setPreferredWidth(130);
        vf.ListadoFamilia.getColumnModel().getColumn(9).setPreferredWidth(50);
        vf.ListadoFamilia.getColumnModel().getColumn(10).setPreferredWidth(150);
        vf.ListadoFamilia.getColumnModel().getColumn(11).setPreferredWidth(300);

        //OCUTAR IDFamiliares
        vf.ListadoFamilia.getColumnModel().getColumn(12).setMinWidth(0);
        vf.ListadoFamilia.getColumnModel().getColumn(12).setMaxWidth(0);
        vf.ListadoFamilia.getColumnModel().getColumn(12).setPreferredWidth(0);
        
        //OCUTAR IDPersonas
        vf.ListadoFamilia.getColumnModel().getColumn(13).setMinWidth(0);
        vf.ListadoFamilia.getColumnModel().getColumn(13).setMaxWidth(0);
        vf.ListadoFamilia.getColumnModel().getColumn(13).setPreferredWidth(0);
        
        vf.ListadoFamilia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
