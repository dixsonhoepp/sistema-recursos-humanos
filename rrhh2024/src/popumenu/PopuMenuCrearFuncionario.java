package popumenu;

import controller.funcionario.VRegistrarFuncionarioController;
import controller.persona.VListadoPersonaController;
import java.awt.Dialog;
import myclass.Cargando;
import myclass.ModificarFecha;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import view.VPrincipal;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class PopuMenuCrearFuncionario {

    private VListadoPersonaController ventanaListadoPersona;
    private VRegistrarFuncionarioController ventanaRegistrarFuncionario;
    private VError error = new VError(new VPrincipal(), true);
    private VAprobado exito = new VAprobado(new VPrincipal(), true);
    private static int FILA;
    private ModificarFecha fecha = new ModificarFecha();

    public PopuMenuCrearFuncionario(VListadoPersonaController lp) {

        this.ventanaListadoPersona = lp;
        PopuMenuPersonas();

    }

    public void PopuMenuPersonas() {

        JPopupMenu popumenu = new JPopupMenu();
        JMenuItem crear = new JMenuItem("Crear Funcionario", new ImageIcon(getClass().getResource("/view/img/add.png")));
        popumenu.add(crear);

        //CREAR
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread hilo = new Thread(() -> {

                    //DATOS DE LA PERSONA
                    try {

                        //Mostrar ventana cargando
                        Cargando loader = new Cargando();
                        loader.mostrar(new JFrame());

                        ventanaRegistrarFuncionario = new VRegistrarFuncionarioController(ventanaListadoPersona, true);

                        Persona persona = new Persona();

                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) ventanaListadoPersona.getjTable_PERSONAS().getModel();

                        datos = persona.DatosPersonaID(modelo.getValueAt(ventanaListadoPersona.getjTable_PERSONAS().getSelectedRow(), 21).toString());

                        ventanaRegistrarFuncionario.getPrimernombre().setText(datos[0].toUpperCase());
                        ventanaRegistrarFuncionario.getSegundonombre().setText(datos[1].toUpperCase());
                        ventanaRegistrarFuncionario.getPrimerapellido().setText(datos[2].toUpperCase());
                        ventanaRegistrarFuncionario.getSegundoapellido().setText(datos[3].toUpperCase());
                        ventanaRegistrarFuncionario.getCedula().setText(datos[4].toUpperCase());
                        ventanaRegistrarFuncionario.getFechanacimiento().setText(fecha.getFecha(datos[5]));
                        ventanaRegistrarFuncionario.getLugarnacimiento().setText(datos[6].toUpperCase());
                        ventanaRegistrarFuncionario.getEstadocivil().setText(datos[7].toUpperCase());
                        ventanaRegistrarFuncionario.getGenero().setText(datos[8]);
                        ventanaRegistrarFuncionario.getNivelacademico().setText(datos[9]);
                        ventanaRegistrarFuncionario.getTituloobtenido().setText(datos[10].toUpperCase());
                        ventanaRegistrarFuncionario.getOtrotitulo().setText(datos[11].toUpperCase());
                        ventanaRegistrarFuncionario.getTelefono().setText(datos[12].toUpperCase());
                        ventanaRegistrarFuncionario.getOtrotelefono().setText(datos[13].toUpperCase());
                        ventanaRegistrarFuncionario.getCorreo().setText(datos[14].toUpperCase());
                        //rf.getgruposanguineo().setText(datos[15].toUpperCase());
                        ventanaRegistrarFuncionario.getEstado().setText(datos[16].toUpperCase());
                        ventanaRegistrarFuncionario.getMunicipio().setText(datos[17].toUpperCase());
                        ventanaRegistrarFuncionario.getParroquia().setText(datos[18].toUpperCase());
                        ventanaRegistrarFuncionario.getDireccion().setText(datos[19].toUpperCase());
                        ventanaRegistrarFuncionario.setIDPersona(Integer.parseInt(datos[21]));//codigo de la persona

                        //COLOCAR FOTO EN JLABEL
                        ImageIcon img = new ImageIcon(datos[20]);
                        Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaRegistrarFuncionario.getFoto().getWidth(),
                                ventanaRegistrarFuncionario.getFoto().getHeight(), Image.SCALE_DEFAULT));

                        ventanaRegistrarFuncionario.getFoto().setIcon(icono);
                        ventanaRegistrarFuncionario.getFoto2().setIcon(icono);
                        ventanaRegistrarFuncionario.getFoto3().setIcon(icono);

                        loader.ocultar();

                        ventanaRegistrarFuncionario.setVisible(true);
                        ventanaRegistrarFuncionario.setLocationRelativeTo(ventanaListadoPersona);

                        //OCULTAR POPUPMENU
                        FILA = ventanaListadoPersona.getjTable_PERSONAS().getSelectedRow();
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

        ventanaListadoPersona.getjTable_PERSONAS().setComponentPopupMenu(popumenu);
    }

    public void OcultarPopupMenu() {
        try {
            ventanaListadoPersona.getjTable_PERSONAS().setComponentPopupMenu(null);
            ventanaListadoPersona.getjTable_PERSONAS().removeRowSelectionInterval(FILA, 0);
        } catch (Exception e) {
        }

    }

}
