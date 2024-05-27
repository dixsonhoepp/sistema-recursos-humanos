package controller.funcionario;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Servicios;
import myclass.Cargando;
import view.funcionarios.VServicios;

public class VServiciosController {

    private VServicios v;
    private VEditarFuncionarioController frame;

    public VServiciosController(VEditarFuncionarioController frame) {

        this.frame = frame;

        v = new VServicios(frame, true);

        //btn buscar
        v.getBTN_BUSCAR_SERVICIOS().addActionListener((e) -> {
            
            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(v);
                btnBuscarEvento();
                loader.ocultar();
            });
            hilo.start();

        });
        //btn selection
        v.getBtnSelection().addActionListener((e) -> {
            btnSelectionEvento();
        });

        MostrarServicios("");
        ModificacioJTable();

    }

    public void MostrarServicios(String buscar) {

        Servicios servicio = new Servicios();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo = servicio.ListadoConsultarServicio(buscar);

        v.getjTable().setModel(modelo);

    }

    private void ModificacioJTable() {

        v.getjTable().getColumnModel().getColumn(0).setPreferredWidth(40);
        v.getjTable().getColumnModel().getColumn(1).setPreferredWidth(600);
        v.getjTable().getColumnModel().getColumn(2).setPreferredWidth(800);
        //OCUTAR ID
        v.getjTable().getColumnModel().getColumn(3).setMinWidth(0);
        v.getjTable().getColumnModel().getColumn(3).setMaxWidth(0);
        v.getjTable().getColumnModel().getColumn(3).setPreferredWidth(0);

        v.getjTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    private void btnBuscarEvento() {

        String txt = v.getBuscadorServicio().getText();
        MostrarServicios(txt);
        ModificacioJTable();
    }

    private void btnSelectionEvento() {

        String servicio = "";

        v.getjTable().getModel().getValueAt(0, 0);

        if (v.getjTable().isRowSelected(v.getjTable().getSelectedRow())) {

            servicio = v.getjTable().getModel().getValueAt(
                    v.getjTable().getSelectedRow(), 1).toString();

            frame.getTxtServicio().setText(servicio);

            v.dispose();

        }

    }

    public void mostrar() {
        v.setVisible(true);
    }

}
