package popumenu;

import controller.administrar.VAdministradorController;
import controller.administrar.VRegistrarUsuarioController;
import controller.persona.VListadoPersonaController;
import java.awt.Component;
import myclass.Cargando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import view.VPrincipal;
import view.ventanaemergente.VError;

public class PopuMenuPersonasVMUSUARIO {

    private VListadoPersonaController lp;
    private VError error = new VError(new VPrincipal(), true);
    private static int FILA;

    public PopuMenuPersonasVMUSUARIO(VListadoPersonaController lp) {
        this.lp = lp;

        PopuMenuPersonas();
    }

    public void PopuMenuPersonas() {

        JPopupMenu popumenu = new JPopupMenu();
        JMenuItem crear = new JMenuItem("Crear Usuario", new ImageIcon(getClass().getResource("/view/img/add.png")));
        popumenu.add(crear);

        //CREAR
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                VAdministradorController admin = (VAdministradorController) SwingUtilities.getWindowAncestor((Component) e.getSource());

                Thread hilo = new Thread(() -> {

                    //Cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(lp);

                    //DATOS DE LA PERSONA
                    try {
                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) lp.getjTable_PERSONAS().getModel();

                        Persona persona = new Persona();

                        datos = persona.DatosPersonaID(modelo.getValueAt(lp.getjTable_PERSONAS().getSelectedRow(), 21).toString());

                        VRegistrarUsuarioController rusuario = new VRegistrarUsuarioController(lp.getVentanaAdministrar(), true);

                        rusuario.IDPersona = Integer.parseInt(datos[21]);
                        rusuario.getDatos().setText(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3]);

                        loader.ocultar();

                        //MOSTRAR VENTANA REGISTRAR FAMILIAR
                        rusuario.setLocationRelativeTo(lp);
                        rusuario.setVisible(true);

                        //OCULTAR POPUPMENU
                        FILA = lp.getjTable_PERSONAS().getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {

                        System.err.println(ex);

                        //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                        error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                        error.setVisible(true);

                    }

                });
                hilo.start();

            }
        });

        lp.getjTable_PERSONAS().setComponentPopupMenu(popumenu);
    }

    public void OcultarPopupMenu() {
        try {
            lp.getjTable_PERSONAS().setComponentPopupMenu(null);
            lp.getjTable_PERSONAS().removeRowSelectionInterval(FILA, 0);
        } catch (Exception e) {
        }

    }

}
