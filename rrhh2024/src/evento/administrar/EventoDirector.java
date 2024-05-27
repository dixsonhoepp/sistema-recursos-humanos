package evento.administrar;

import consulta.listado.informaciondefuncinario.ListadoDirectores;
import consulta.listado.informaciondefuncinario.ListadoHistorial;
import controller.administrar.VAdministradorController;
import controller.persona.VListadoPersonaController;
import myclass.RegistroHistorial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import model.Directores;
import myclass.Cargando;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VError;

public class EventoDirector extends MouseAdapter {

    private VAdministradorController admin;
    private VListadoPersonaController vlistado;
    private String cargo, rango, resolucion, fecha;
    private VError VError = new VError(admin, true);

    public EventoDirector(VAdministradorController admin) {
        this.admin = admin;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //ABRIR VENTANA DE LISTADO PERSONA DG
        if (e.getSource() == admin.getBTN_NUEVODIRECTORGENERAL() || e.getSource() == admin.getBTN_NUEVODIRECTORRRHH()) {

            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(admin);
                vlistado = new VListadoPersonaController(admin, true);
                vlistado.setOpcionPopuMenu(VListadoPersonaController.POPUMENU_DIRECTORES);
                loader.ocultar();
                vlistado.setVisible(true);

            });

            hilo.start();

        }

        //ELIMINAR DG
        if (e.getSource() == admin.getBTN_ELIMINARDIRECTORGENERAL()) {

            Thread hilo = new Thread(() -> {

                if (admin.getjTable_DIRECTORGENERAL().getSelectedRow() >= 0) {
                    admin.getBTN_ELIMINARDIRECTORGENERAL().setVisible(false);

                    DefaultTableModel modelo = (DefaultTableModel) admin.getjTable_DIRECTORGENERAL().getModel();
                    int ID = Integer.parseInt(modelo.getValueAt(admin.getjTable_DIRECTORGENERAL().getSelectedRow(), 10).toString());

                    //ventana de confirmacion
                    VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                    boolean confirmar = vc.confirmacion;

                    if (confirmar) {

                        Cargando loader = new Cargando();
                        loader.mostrar(admin);

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Directores(3, ID);

                        //ELIMINAR
                        Directores d = new Directores();
                        d.Eliminar(ID);
                        //MOSTRAR LISTADO
                        ListadoDirectores Listado = new ListadoDirectores(admin);
                        Listado.MostrarListadoDG();
                        
                        ListadoHistorial historial = new ListadoHistorial(admin);
                        historial.MostrarListado();

                        loader.ocultar();
                    }

                    try {
                        //Quitar Seleccion del JTABLET
                        admin.getjTable_DIRECTORGENERAL().removeRowSelectionInterval(admin.getjTable_DIRECTORGENERAL().getSelectedRow(), 0);
                    } catch (Exception ex) {
                    }

                }
            });

            hilo.start();

        }

        //ELIMINAR DRRHH
        if (e.getSource() == admin.getBTN_ELIMINARDIRECTORRRHH()) {

            Thread hilo = new Thread(() -> {

                if (admin.getjTable_DIRECTORRRHH().getSelectedRow() >= 0) {
                    admin.getBTN_ELIMINARDIRECTORRRHH().setVisible(false);

                    DefaultTableModel modelo = (DefaultTableModel) admin.getjTable_DIRECTORRRHH().getModel();
                    int ID = Integer.parseInt(modelo.getValueAt(admin.getjTable_DIRECTORRRHH().getSelectedRow(), 10).toString());

                    //ventana de confirmacion
                    VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                    boolean confirmar = vc.confirmacion;

                    if (confirmar) {
                        
                        Cargando loader = new Cargando();
                        loader.mostrar(admin);

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Directores(4, ID);

                        //ELIMINAR
                        Directores d = new Directores();
                        d.Eliminar(ID);
                        
                        //MOSTRAR LISTADO
                        ListadoDirectores Listado = new ListadoDirectores(admin);
                        Listado.MostrarListadoRRHH();
                        
                        ListadoHistorial historial = new ListadoHistorial(admin);
                        historial.MostrarListado();
                        
                        loader.ocultar();
                    }

                    try {
                        //Quitar Seleccion del JTABLET
                        admin.getjTable_DIRECTORRRHH().removeRowSelectionInterval(admin.getjTable_DIRECTORRRHH().getSelectedRow(), 0);
                    } catch (Exception ex) {
                    }

                }
            });

            hilo.start();

        }

    }

}
