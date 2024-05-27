package consulta.listado;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.VPrincipal;
import view.personas.VListadoPersona;

public class Listado {

    protected VPrincipal ventanaPrincipal;
    protected VListadoPersona ventanaListadoPersona;
    protected int totalPagina;
    protected int pagina;
    protected int desde;
    protected String consulta = "";
    protected JTable jtable;

    protected DefaultTableModel modelo = new DefaultTableModel();

    public Listado(VPrincipal ventanaPrincipal, JTable table) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.jtable = table;

    }

    public Listado(VListadoPersona vListadoPersona, JTable table) {
        this.ventanaListadoPersona = vListadoPersona;
        this.jtable = table;

    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    //btn paginación
    protected void btnPaginacion(int numPag, int maxPag, JLabel btnSiguiente, JLabel btnAtras) {

        //OCULTAR BTN SIGUIENTE
        if (numPag == maxPag || maxPag == 0) {
            btnSiguiente.setVisible(false);
        }

        //MOSTRAR BTN SIGUIENTE
        if (numPag < maxPag) {
            btnSiguiente.setVisible(true);
        }

        //MOSTRAR BTN ATRAS
        if (numPag > 1) {
            btnAtras.setVisible(true);
        }

        //OCULTAR BTN ATRAS
        if (numPag == 1 || maxPag == 0) {
            btnAtras.setVisible(false);
        }

    }

}
