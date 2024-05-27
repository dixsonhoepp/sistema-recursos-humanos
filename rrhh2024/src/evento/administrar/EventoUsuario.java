package evento.administrar;

import consulta.listado.informaciondefuncinario.ListadoHistorial;
import consulta.listado.informaciondefuncinario.ListadoUsuario;
import controller.administrar.VAdministradorController;
import controller.persona.VListadoPersonaController;
import myclass.RegistroHistorial;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import myclass.Cargando;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VError;

public class EventoUsuario extends MouseAdapter {

    private VError VError = new VError(new VPrincipal(), true);
    private VAdministradorController admin;
    private int opcion;

    @Override
    public void mouseClicked(MouseEvent e) {
        admin = (VAdministradorController) SwingUtilities.getWindowAncestor(e.getComponent());

        //ABRIR VENTANA DE LISTADO PERSONA
        if (e.getSource() == admin.getBTN_NUEVOUSUARIO()) {

            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(admin);
                VListadoPersonaController listado = new VListadoPersonaController(admin, true);
                listado.setOpcionPopuMenu(VListadoPersonaController.POPUMENU_USUARIO);
                loader.ocultar();
                listado.setVisible(true);
            });

            hilo.start();

        }

        //ELIMINAR
        if (e.getSource() == admin.getBTN_ELIMINARUSUARIO()) {

            if (admin.getjTable_USUARIOS().getSelectedRow() >= 0) {

                Thread hilo = new Thread(() -> {

                    DefaultTableModel modelo = (DefaultTableModel) admin.getjTable_USUARIOS().getModel();
                    int ID = Integer.parseInt(modelo.getValueAt(admin.getjTable_USUARIOS().getSelectedRow(), 7).toString());

                    //ventana de confirmacion
                    VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                    boolean confirmar = vc.confirmacion;

                    if (confirmar) {

                        Cargando loader = new Cargando();
                        loader.mostrar(admin);

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Usuario(2, ID, "");

                        Usuario ru = new Usuario();
                        ru.Eliminar(ID);

                        //MOSTRAR LISTADO
                        ListadoUsuario ListadoUsuario = new ListadoUsuario(admin);
                        ListadoUsuario.MostrarListado();
                        
                        ListadoHistorial historial = new ListadoHistorial(admin);
                        historial.MostrarListado();

                        admin.getBTN_ELIMINARUSUARIO().setVisible(false);

                        loader.ocultar();

                    }

                    try {
                        //Quitar Seleccion del JTABLET
                        admin.getjTable_USUARIOS().removeRowSelectionInterval(admin.getjTable_USUARIOS().getSelectedRow(), 0);
                    } catch (Exception ex) {
                    }

                });
                hilo.start();

            }

        }

    }

}
