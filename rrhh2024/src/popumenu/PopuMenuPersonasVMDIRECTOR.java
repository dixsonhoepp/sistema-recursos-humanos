package popumenu;

import controller.administrar.VAdministradorController;
import controller.administrar.VRegistrarDirectorController;
import controller.persona.VListadoPersonaController;
import myclass.Cargando;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import view.VPrincipal;
import view.ventanaemergente.VError;

public class PopuMenuPersonasVMDIRECTOR {

    private VListadoPersonaController lp;
    private VAdministradorController admin;
    private VRegistrarDirectorController director;

    private Persona persona = new Persona();
    private VError error = new VError(new VPrincipal(), true);
    private static int FILA;

    public PopuMenuPersonasVMDIRECTOR(VListadoPersonaController lp, VAdministradorController admin) {
        this.lp = lp;
        this.admin = admin;

        PopuMenuPersonas();
    }

    public void PopuMenuPersonas() {

        JPopupMenu popumenu = new JPopupMenu();
        JMenuItem crear = new JMenuItem("Crear Director", new ImageIcon(getClass().getResource("/view/img/add.png")));
        popumenu.add(crear);

        //CREAR
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread hilo = new Thread(() -> {

                    //cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(lp);

                    //datos personales
                    try {
                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) lp.getjTable_PERSONAS().getModel();

                        datos = persona.DatosPersonaID(modelo.getValueAt(lp.getjTable_PERSONAS().getSelectedRow(), 21).toString());

                        director = new VRegistrarDirectorController(lp.getVentanaAdministrar(), true);

                        director.IDPersona = Integer.parseInt(datos[21]);
                        director.getDatos().setText(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3]);

                        Thread.sleep(500);
                        loader.ocultar();

                        //MOSTRAR VENTANA REGISTRAR FAMILIAR
                        director.setLocationRelativeTo(lp);
                        director.setVisible(true);

                        //OCULTAR POPUPMENU
                        FILA = lp.getjTable_PERSONAS().getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {

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
