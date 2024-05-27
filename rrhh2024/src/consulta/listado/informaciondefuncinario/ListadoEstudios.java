package consulta.listado.informaciondefuncinario;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Estudios;
import view.funcionarios.VEditarFuncionario;
import view.funcionarios.VVerFuncionario;

public class ListadoEstudios {

    private VEditarFuncionario ef;
    private VVerFuncionario vf;
    private Estudios buscar = new Estudios();

    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoEstudios(VEditarFuncionario ef) {
        this.ef = ef;
    }

    public ListadoEstudios(VVerFuncionario vf) {
        this.vf = vf;
    }

    public void MostrarListadoEF(int ID) {

        modelo = buscar.Listado(ID);

        ef.listadoEstudios.setModel(modelo);

        //VENTANA EDITAR
        ef.listadoEstudios.getColumnModel().getColumn(0).setPreferredWidth(30);
        ef.listadoEstudios.getColumnModel().getColumn(1).setPreferredWidth(200);
        ef.listadoEstudios.getColumnModel().getColumn(2).setPreferredWidth(200);
        ef.listadoEstudios.getColumnModel().getColumn(3).setPreferredWidth(100);
        ef.listadoEstudios.getColumnModel().getColumn(4).setPreferredWidth(100);

        //OCUTAR ID
        ef.listadoEstudios.getColumnModel().getColumn(5).setMinWidth(0);
        ef.listadoEstudios.getColumnModel().getColumn(5).setMaxWidth(0);
        ef.listadoEstudios.getColumnModel().getColumn(5).setPreferredWidth(0);

        ef.listadoEstudios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

    public void MostrarListadoVF(int ID) {

        modelo = buscar.Listado(ID);

        vf.listadoEstudios.setModel(modelo);

        //VENTANA EDITAR
        vf.listadoEstudios.getColumnModel().getColumn(0).setPreferredWidth(30);
        vf.listadoEstudios.getColumnModel().getColumn(1).setPreferredWidth(200);
        vf.listadoEstudios.getColumnModel().getColumn(2).setPreferredWidth(200);
        vf.listadoEstudios.getColumnModel().getColumn(3).setPreferredWidth(100);
        vf.listadoEstudios.getColumnModel().getColumn(4).setPreferredWidth(100);

        //OCUTAR ID
        vf.listadoEstudios.getColumnModel().getColumn(5).setMinWidth(0);
        vf.listadoEstudios.getColumnModel().getColumn(5).setMaxWidth(0);
        vf.listadoEstudios.getColumnModel().getColumn(5).setPreferredWidth(0);

        vf.listadoEstudios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

}
