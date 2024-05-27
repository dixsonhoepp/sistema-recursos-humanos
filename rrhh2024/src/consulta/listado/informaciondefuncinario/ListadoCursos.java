package consulta.listado.informaciondefuncinario;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cursos;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;


public class ListadoCursos {
    
    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Cursos buscar = new Cursos();
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoCursos(VEditarFuncionario ef) {
        this.ef = ef;
    }
    
    public ListadoCursos(VVerFuncionario vf) {
        this.vf = vf;
    }

    
    
    
    public void MostrarListadoEF(int ID) {



        modelo = buscar.Listado(ID);

        ef.listadoCursos.setModel(modelo);
        
        //VENTANA EDITAR
        ef.listadoCursos.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoCursos.getColumnModel().getColumn(1).setPreferredWidth(200);
        ef.listadoCursos.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoCursos.getColumnModel().getColumn(3).setPreferredWidth(100);
        ef.listadoCursos.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        //OCUTAR ID
        ef.listadoCursos.getColumnModel().getColumn(5).setMinWidth(0);
        ef.listadoCursos.getColumnModel().getColumn(5).setMaxWidth(0);
        ef.listadoCursos.getColumnModel().getColumn(5).setPreferredWidth(0);
        
        ef.listadoCursos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    
    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoCursos.setModel(modelo);
        
        //VENTANA EDITAR
        vf.listadoCursos.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoCursos.getColumnModel().getColumn(1).setPreferredWidth(200);
        vf.listadoCursos.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoCursos.getColumnModel().getColumn(3).setPreferredWidth(100);
        vf.listadoCursos.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        //OCUTAR ID
        vf.listadoCursos.getColumnModel().getColumn(5).setMinWidth(0);
        vf.listadoCursos.getColumnModel().getColumn(5).setMaxWidth(0);
        vf.listadoCursos.getColumnModel().getColumn(5).setPreferredWidth(0);
        
        vf.listadoCursos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }
    
    

}
