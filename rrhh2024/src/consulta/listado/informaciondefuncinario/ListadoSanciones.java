package consulta.listado.informaciondefuncinario;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sanciones;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;

public class ListadoSanciones {

    private VEditarFuncionario ef;
    private VVerFuncionario vf;

    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoSanciones(VEditarFuncionario ef) {
        this.ef = ef;
    }

    public ListadoSanciones(VVerFuncionario vf) {
        this.vf = vf;
    }

    public void MostrarListadoEF(int ID) {

        Sanciones sanciones = new Sanciones();

        modelo = sanciones.ListadoConsultarSanciones(ID);

        ef.ListadoSanciones.setModel(modelo);

        //VENTANA EDITAR
        ef.ListadoSanciones.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.ListadoSanciones.getColumnModel().getColumn(1).setPreferredWidth(70);
        ef.ListadoSanciones.getColumnModel().getColumn(2).setPreferredWidth(180);
        ef.ListadoSanciones.getColumnModel().getColumn(3).setPreferredWidth(500);
        ef.ListadoSanciones.getColumnModel().getColumn(4).setPreferredWidth(200);

        //OCUTAR ID
        ef.ListadoSanciones.getColumnModel().getColumn(5).setMinWidth(0);
        ef.ListadoSanciones.getColumnModel().getColumn(5).setMaxWidth(0);
        ef.ListadoSanciones.getColumnModel().getColumn(5).setPreferredWidth(0);

        ef.ListadoSanciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

    public void MostrarListadoVF(int ID) {
        
        Sanciones sanciones = new Sanciones();
        
        modelo = sanciones.ListadoConsultarSanciones(ID);

        vf.ListadoSanciones.setModel(modelo);

        //VENTANA EDITAR
        vf.ListadoSanciones.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.ListadoSanciones.getColumnModel().getColumn(1).setPreferredWidth(70);
        vf.ListadoSanciones.getColumnModel().getColumn(2).setPreferredWidth(180);
        vf.ListadoSanciones.getColumnModel().getColumn(3).setPreferredWidth(500);
        vf.ListadoSanciones.getColumnModel().getColumn(4).setPreferredWidth(200);

        //OCUTAR ID
        vf.ListadoSanciones.getColumnModel().getColumn(5).setMinWidth(0);
        vf.ListadoSanciones.getColumnModel().getColumn(5).setMaxWidth(0);
        vf.ListadoSanciones.getColumnModel().getColumn(5).setPreferredWidth(0);

        vf.ListadoSanciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

}
