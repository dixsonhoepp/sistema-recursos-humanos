package consulta.listado;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Servicios;
import view.VPrincipal;

public class ListadoServiciosVP {

    private VPrincipal vn;
    private String consulta = "";

    
    DefaultTableModel modelo = new DefaultTableModel();

    public ListadoServiciosVP(VPrincipal vn) {
        this.vn = vn;

    }

    public void MostrarListado() {
        
        Servicios servicio = new Servicios();

        //Consultar Total Registro
        servicio.TotalServicioRegistrado(consulta);

        //Asignar Total Personas
        vn.Cantidad_SERVICIO.setText("TOTAL: " + Integer.toString(servicio.getTotalServicio()));

        modelo = servicio.ListadoConsultarServicio(consulta);

        vn.jTable_SERVICIO.setModel(modelo);
        vn.jTable_SERVICIO.getColumnModel().getColumn(0).setPreferredWidth(40);
        vn.jTable_SERVICIO.getColumnModel().getColumn(1).setPreferredWidth(600);
        vn.jTable_SERVICIO.getColumnModel().getColumn(2).setPreferredWidth(800);
        //OCUTAR ID
        vn.jTable_SERVICIO.getColumnModel().getColumn(3).setMinWidth(0);
        vn.jTable_SERVICIO.getColumnModel().getColumn(3).setMaxWidth(0);
        vn.jTable_SERVICIO.getColumnModel().getColumn(3).setPreferredWidth(0);

        vn.jTable_SERVICIO.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

 

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

}
