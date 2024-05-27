package popumenu;

import consulta.listado.ventanaprincipal.ConsultaListado;
import myclass.Cargando;
import myclass.RegistroHistorial;
import myclass.ModificarFecha;
import controller.persona.VEditarPersonaController;
import controller.persona.VVerPersonaController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class PopuMenuPersonasVP {

    private static int FILA;
    private ModificarFecha fecha = new ModificarFecha();
    private JTable table;
    JPopupMenu popumenu;
    JMenuItem ver;
    JMenuItem editar;
    JMenuItem eliminar;

    public PopuMenuPersonasVP(JTable table) {

        this.table = table;

        PopuMenuPersonas();

    }

    public void PopuMenuPersonas() {

        //Cramos Popu Menu
        popumenu = new JPopupMenu();
        ver = new JMenuItem("Ver", new ImageIcon(getClass().getResource(RutaIcono.URL_VER)));
        editar = new JMenuItem("Editar", new ImageIcon(getClass().getResource(RutaIcono.URL_EDITAR)));
        eliminar = new JMenuItem("Eliminar", new ImageIcon(getClass().getResource(RutaIcono.URL_ELIMINAR)));

        //asignamos los items
        popumenu.add(ver);
        popumenu.add(editar);
        popumenu.add(eliminar);

        ver.addActionListener(new evento());
        editar.addActionListener(new evento());
        eliminar.addActionListener(new evento());

        table.setComponentPopupMenu(popumenu);

    }

    public void OcultarPopupMenu() {
        try {
            table.setComponentPopupMenu(null);
            table.removeRowSelectionInterval(FILA, 0);
        } catch (Exception e) {
        }

    }

    private class evento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            VPrincipal ventanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(table);

            //ver
            if (ver == e.getSource()) {
                Thread hilo = new Thread(() -> {
                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaPrincipal);

                    Persona persona = new Persona();
                    VVerPersonaController ventanaVerPersona = new VVerPersonaController(ventanaPrincipal, true);

                    try {
                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();

                        datos = persona.DatosPersonaID(modelo.getValueAt(table.getSelectedRow(), 21).toString());

                        ventanaVerPersona.getprimernombre().setText(datos[0].toUpperCase());
                        ventanaVerPersona.getsegundonombre().setText(datos[1].toUpperCase());
                        ventanaVerPersona.getprimerapellido().setText(datos[2].toUpperCase());
                        ventanaVerPersona.getsegundoapellido().setText(datos[3].toUpperCase());
                        ventanaVerPersona.getcedula().setText(datos[4].toUpperCase());
                        ventanaVerPersona.getfechanacimiento().setText(fecha.getFecha(datos[5]));
                        ventanaVerPersona.getlugarnacimiento().setText(datos[6].toUpperCase());
                        ventanaVerPersona.getestadocivil().setText(datos[7].toUpperCase());
                        ventanaVerPersona.getgenero().setText(datos[8]);
                        ventanaVerPersona.getnivelacademico().setText(datos[9]);
                        ventanaVerPersona.gettituloobtenido().setText(datos[10].toUpperCase());
                        ventanaVerPersona.getotrotitulo().setText(datos[11].toUpperCase());
                        ventanaVerPersona.gettelefono().setText(datos[12].toUpperCase());
                        ventanaVerPersona.getotrotelefono().setText(datos[13].toUpperCase());
                        ventanaVerPersona.getcorreo().setText(datos[14].toUpperCase());
                        ventanaVerPersona.getgruposanguineo().setText(datos[15]);
                        ventanaVerPersona.getestado().setText(datos[16].toUpperCase());
                        ventanaVerPersona.getmunicipio().setText(datos[17].toUpperCase());
                        ventanaVerPersona.getparroquia().setText(datos[18].toUpperCase());
                        ventanaVerPersona.getdireccion().setText(datos[19].toUpperCase());

                        //RUTA JSON
                        String ruta = "";
                        try {
                            Object object = new JSONParser().parse(new FileReader("rutas.txt"));
                            JSONObject JSON = (JSONObject) object;

                            ruta = JSON.get("foto").toString();

                        } catch (Exception ex) {
                        }

                        //COLOCAR FOTO EN JLABEL
                        ImageIcon img = new ImageIcon(ruta + datos[20]);
                        Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaVerPersona.getfoto().getWidth(),
                                ventanaVerPersona.getfoto().getHeight(), Image.SCALE_DEFAULT));

                        ventanaVerPersona.getfoto().setIcon(icono);

                        Thread.sleep(100);

                        //ocultar ventana cargando
                        loader.ocultar();

                        ventanaVerPersona.setVisible(true);
                        ventanaVerPersona.setLocationRelativeTo(ventanaPrincipal);

                        //OCULTAR POPUPMENU
                        FILA = table.getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {

                        //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                        VError error = new VError(ventanaPrincipal, true);
                        error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                        error.setVisible(true);

                    }

                });

                hilo.start();

            }

            //editar 
            if (editar == e.getSource()) {
                Thread hilo = new Thread(() -> {

                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaPrincipal);

                    Persona persona = new Persona();
                    VEditarPersonaController ventanaEditarPersona = new VEditarPersonaController(ventanaPrincipal, true);

                    try {
                        String[] datos = new String[21];
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();

                        datos = persona.DatosPersonaID(modelo.getValueAt(table.getSelectedRow(), 21).toString());

                        ventanaEditarPersona.getPrimernombre().setText(datos[0].toUpperCase());
                        ventanaEditarPersona.getSegundonombre().setText(datos[1].toUpperCase());
                        ventanaEditarPersona.getPrimerapellido().setText(datos[2].toUpperCase());
                        ventanaEditarPersona.getSegundoapellido().setText(datos[3].toUpperCase());
                        ventanaEditarPersona.getCedula().setText(datos[4].toUpperCase());

                        //Fecha de Nacimiento
                        SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaTxt;

                        if (datos[5].isEmpty()) {
                            fechaTxt = dateFormato.parse("2050-10-10");
                        } else {
                            fechaTxt = dateFormato.parse(datos[5]);
                        }

                        ventanaEditarPersona.getFechanacimiento().setDate(fechaTxt);
                        ventanaEditarPersona.getLugarnacimiento().setText(datos[6].toUpperCase());
                        ventanaEditarPersona.getEstadocivil().setSelectedItem(datos[7]);
                        ventanaEditarPersona.getGenero().setSelectedItem(datos[8]);
                        ventanaEditarPersona.getNivelacademico().setSelectedItem(datos[9]);
                        ventanaEditarPersona.getTituloobtenido1().setText(datos[10].toUpperCase());
                        ventanaEditarPersona.getTituloobtenido2().setText(datos[11].toUpperCase());
                        ventanaEditarPersona.getTelefono1().setText(datos[12].toUpperCase());
                        ventanaEditarPersona.getTelefono2().setText(datos[13].toUpperCase());
                        ventanaEditarPersona.getCorreo().setText(datos[14].toUpperCase());
                        ventanaEditarPersona.getGruposanguineo().setSelectedItem(datos[15]);
                        ventanaEditarPersona.getEstado().setSelectedItem(datos[16].toUpperCase());
                        ventanaEditarPersona.getMunicipio().setText(datos[17].toUpperCase());
                        ventanaEditarPersona.getParroquia().setText(datos[18].toUpperCase());
                        ventanaEditarPersona.getDireccion().setText(datos[19].toUpperCase());
                        ventanaEditarPersona.rutaFoto = datos[20];

                        //Obtener ID 
                        ventanaEditarPersona.idpersona = Integer.parseInt(datos[21]);

                        //RUTA JSON
                        String ruta = "";
                        try {
                            Object object = new JSONParser().parse(new FileReader("rutas.txt"));
                            JSONObject JSON = (JSONObject) object;

                            ruta = JSON.get("foto").toString();

                        } catch (Exception ex) {
                        }

                        //COLOCAR FOTO EN JLABEL
                        ImageIcon img = new ImageIcon(ruta + ventanaEditarPersona.rutaFoto);
                        Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaEditarPersona.getFoto().getWidth(),
                                ventanaEditarPersona.getFoto().getHeight(), Image.SCALE_DEFAULT));

                        ventanaEditarPersona.getFoto().setIcon(icono);

                        Thread.sleep(100);
                        loader.ocultar();

                        ventanaEditarPersona.setVisible(true);
                        ventanaEditarPersona.setLocationRelativeTo(ventanaPrincipal);

                        //OCULTAR POPUPMENU
                        FILA = table.getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {

                        //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                        VError error = new VError(ventanaPrincipal, true);
                        error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                        error.setVisible(true);

                    }

                });

                hilo.start();

            }

            //Eliminar
            if (eliminar == e.getSource()) {
                //ventana de confirmacion
                VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                boolean confirmar = vc.confirmacion;

                if (confirmar) {

                    Thread hilo = new Thread(() -> {

                        try {
                            //Mostrar ventana cargando
                            Cargando loader = new Cargando();
                            loader.mostrar(ventanaPrincipal);

                            Persona persona = new Persona();
                            DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                            int id = Integer.parseInt(modelo.getValueAt(table.getSelectedRow(), 21).toString());

                            //HISTORIAL
                            RegistroHistorial h = new RegistroHistorial();
                            h.Persona(2, id, "");

                            //ELIMINAR
                            persona.EliminarPersona(id);

                            //OCULTAR POPUPMENU
                            FILA = table.getSelectedRow();
                            OcultarPopupMenu();

                            //ACTUALIZAR LISTADO
                            ConsultaListado listado = new ConsultaListado(ventanaPrincipal, table);
                            listado.MostrarListadoPersonas(
                                    Integer.parseInt(ventanaPrincipal.JLabel_Desde_Persona.getText()));

                            Thread.sleep(100);
                            loader.ocultar();

                            VAprobado exito = new VAprobado(ventanaPrincipal, true);
                            exito.setVisible(true);

                        } catch (InterruptedException ex) {
                            Logger.getLogger(PopuMenuPersonasVP.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });

                    hilo.start();

                }
            }
        }

    }

}
