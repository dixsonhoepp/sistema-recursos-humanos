package popumenu;

import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VRegistrarFamiliarController;
import controller.persona.VListadoPersonaController;
import myclass.Cargando;
import myclass.ModificarFecha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import view.VPrincipal;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class PopuMenuPersonasVMFAMILIA {

    private VListadoPersonaController vListadoPersona;
    private VEditarFuncionarioController ventanaEditarFuncionario;
    private Persona persona = new Persona();
    private VError error = new VError(new VPrincipal(), true);
    private VAprobado exito = new VAprobado(new VPrincipal(), true);
    private static int FILA;
    private ModificarFecha fecha = new ModificarFecha();

    public PopuMenuPersonasVMFAMILIA(VListadoPersonaController lp, VEditarFuncionarioController ve) {
        this.vListadoPersona = lp;
        this.ventanaEditarFuncionario = ve;

        PopuMenuPersonas();
    }

    public void PopuMenuPersonas() {

        JPopupMenu popumenu = new JPopupMenu();
        JMenuItem crear = new JMenuItem("Agregar Familia", new ImageIcon(getClass().getResource("/view/img/add.png")));
        popumenu.add(crear);

        //CREAR
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                

                Thread hilo = new Thread(() -> {

                    //ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(vListadoPersona);

                    VRegistrarFamiliarController rfamiliar = new VRegistrarFamiliarController(vListadoPersona, true);
                    rfamiliar.setVentanaEditarFuncionario(ventanaEditarFuncionario);

                    try {
                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) vListadoPersona.getjTable_PERSONAS().getModel();

                        datos = persona.DatosPersonaID(modelo.getValueAt(vListadoPersona.getjTable_PERSONAS().getSelectedRow(), 21).toString());

                        rfamiliar.IDPersona = Integer.parseInt(datos[21]);
                        rfamiliar.getDatos().setText(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3]);

                        //Ocultar ventana cargando
                        Thread.sleep(100);
                        loader.ocultar();

                        //MOSTRAR VENTANA REGISTRAR FAMILIAR
                        rfamiliar.setLocationRelativeTo(vListadoPersona);
                        rfamiliar.setVisible(true);

                        //OCULTAR POPUPMENU
                        FILA = vListadoPersona.getjTable_PERSONAS().getSelectedRow();
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

        vListadoPersona.getjTable_PERSONAS().setComponentPopupMenu(popumenu);
    }

    public void OcultarPopupMenu() {
        try {
            vListadoPersona.getjTable_PERSONAS().setComponentPopupMenu(null);
            vListadoPersona.getjTable_PERSONAS().removeRowSelectionInterval(FILA, 0);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

}
