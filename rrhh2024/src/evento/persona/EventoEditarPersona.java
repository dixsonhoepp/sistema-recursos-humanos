package evento.persona;

import consulta.listado.ventanaprincipal.ConsultaListado;
import controller.persona.VEditarPersonaController;
import myclass.Cargando;
import myclass.RegistroHistorial;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class EventoEditarPersona extends MouseAdapter {
    
    private VPrincipal ventanaPrincipal;
    private static File file;
    private Path fuente, destino;
    
    public EventoEditarPersona(VPrincipal ventaPrincipal){
        this.ventanaPrincipal = ventaPrincipal;
        
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        //EDITAR PERSONA
        
        VEditarPersonaController ventanaEditarPersona = (VEditarPersonaController)
                SwingUtilities.getWindowAncestor(e.getComponent());

        if (ventanaEditarPersona.getBTN_EDITARPERSONA() == e.getSource()) {
            
            
            Thread hilo = new Thread(() -> {

                String primernombre = ventanaEditarPersona.getPrimernombre().getText();
                String segundonombre = ventanaEditarPersona.getSegundonombre().getText();
                String primerapellido = ventanaEditarPersona.getPrimerapellido().getText();
                String segundoapellido = ventanaEditarPersona.getSegundoapellido().getText();
                String cedula = ventanaEditarPersona.getCedula().getText();

                //fecha nacimiento
                String fechanacimiento = "";
                try {
                    Date date = ventanaEditarPersona.getFechanacimiento().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechanacimiento = fecha.toString();

                } catch (Exception ex) {
                }
                String lugarnacimiento = ventanaEditarPersona.getLugarnacimiento().getText();
                String genero = (String) ventanaEditarPersona.getGenero().getSelectedItem();
                String estadocivil = (String) ventanaEditarPersona.getEstadocivil().getSelectedItem();
                String nivelacademico = (String) ventanaEditarPersona.getNivelacademico().getSelectedItem();
                String tituloobtenido1 = ventanaEditarPersona.getTituloobtenido1().getText();
                String tituloobtenido2 = ventanaEditarPersona.getTituloobtenido2().getText();
                String telefono1 = ventanaEditarPersona.getTelefono1().getText();
                String telefono2 = ventanaEditarPersona.getTelefono2().getText();
                String correo = ventanaEditarPersona.getCorreo().getText();
                String gruposanguineo = ventanaEditarPersona.getGruposanguineo().getSelectedItem().toString();
                String estado = ventanaEditarPersona.getEstado().getSelectedItem().toString();
                String municipio = ventanaEditarPersona.getMunicipio().getText();
                String parroquia = ventanaEditarPersona.getParroquia().getText();
                String direccion = ventanaEditarPersona.getDireccion().getText();
                String foto = ventanaEditarPersona.foto1;

                //VERIFICAR SI EL NOMBRE NO ESTA VACIO 
                if (primernombre.isEmpty()) {

                    VError VError = new VError(ventanaEditarPersona, true);
                    VError.texto.setText("EL PRIMER NOMBRE ESTA VACIO");
                    VError.setLocationRelativeTo(ventanaEditarPersona);
                    VError.setVisible(true);

                    //VERIFICAR SI EL APELLIDO NO ESTA VACIO 
                } else if (primerapellido.isEmpty()) {
                    VError VError = new VError(ventanaEditarPersona, true);
                    VError.texto.setText("EL PRIMER APELLIDO ESTA VACIO");
                    VError.setLocationRelativeTo(ventanaEditarPersona);
                    VError.setVisible(true);

                } else if (fechanacimiento.isEmpty()) {
                    VError VError = new VError(ventanaEditarPersona, true);
                    VError.texto.setText("LA FECHA DE NACIMIENTO ESTA VACIA");
                    VError.setLocationRelativeTo(ventanaEditarPersona);
                    VError.setVisible(true);

                } else {

                    //ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarPersona);

                    //RUTA Y DESTINO DE FOTO
                    if (ventanaEditarPersona.foto1.isEmpty()) {

                        ventanaEditarPersona.foto1 = ventanaEditarPersona.rutaFoto;

                    } else {

                        //RUTA JSON
                        String ruta = "";
                        try {
                            Object object = new JSONParser().parse(new FileReader("rutas.txt"));
                            JSONObject JSON = (JSONObject) object;

                            ruta = JSON.get("foto").toString();

                        } catch (Exception ex) {
                        }

                        //OBTENER EL FORMATO DE LA IMAGEN
                        String formato = ventanaEditarPersona.foto1.substring(ventanaEditarPersona.foto1.indexOf("."));

                        //FUENTE Y DESTINO DE FOTO
                        fuente = Paths.get(ventanaEditarPersona.foto1);
                        destino = Paths.get(ruta + cedula + formato);

                        //NUEVA RUTA, NOMBRE Y FORMATO
                        ventanaEditarPersona.foto1 = cedula + formato;

                        //COPIAR IMAGEN
                        try {
                            //CREAR DIRECTORIO DE FOTO SI NO EXISTE

                            if (!Files.exists(Paths.get(ruta))) {
                                Files.createDirectory(Paths.get(ruta));
                            }
                            Files.copy(fuente, destino, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException ex) {
                            Logger.getLogger(EventoEditarPersona.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                    Persona persona = new Persona();

                    if (persona.EditarPersona(ventanaEditarPersona.idpersona,
                            primernombre,
                            segundonombre,
                            primerapellido,
                            segundoapellido,
                            cedula,
                            fechanacimiento,
                            lugarnacimiento,
                            estadocivil,
                            genero,
                            nivelacademico,
                            tituloobtenido1,
                            tituloobtenido2,
                            telefono1,
                            telefono2,
                            correo,
                            gruposanguineo,
                            estado,
                            municipio,
                            parroquia,
                            direccion,
                            ventanaEditarPersona.foto1)) {

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Persona(3, ventanaEditarPersona.idpersona, "");

                        //ACTUALIZAR LISTADO DE PERSONA
                        ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                                ventanaPrincipal.getjTable_PERSONAS());
                        listado.setConsulta(ventanaPrincipal.getBuscadorpersona().getText());
                        listado.MostrarListadoPersonas(
                                Integer.parseInt(
                                        ventanaPrincipal.JLabel_Desde_Persona
                                                .getText()));
                        
                        

                        ventanaEditarPersona.foto1 = "";

                        //VACIAR LOS CAMPOS Y CERRAR VENTANA
                        ventanaEditarPersona.getPrimernombre().setText("");
                        ventanaEditarPersona.getSegundonombre().setText("");
                        ventanaEditarPersona.getPrimerapellido().setText("");
                        ventanaEditarPersona.getSegundoapellido().setText("");
                        ventanaEditarPersona.getCedula().setText("");
                        ventanaEditarPersona.getFechanacimiento().setDate(null);
                        ventanaEditarPersona.getLugarnacimiento().setText("");
                        ventanaEditarPersona.getGenero().setSelectedIndex(0);
                        ventanaEditarPersona.getEstadocivil().setSelectedIndex(0);
                        ventanaEditarPersona.getNivelacademico().setSelectedIndex(0);
                        ventanaEditarPersona.getTituloobtenido1().setText("");
                        ventanaEditarPersona.getTituloobtenido2().setText("");
                        ventanaEditarPersona.getTelefono1().setText("");
                        ventanaEditarPersona.getTelefono2().setText("");
                        ventanaEditarPersona.getCorreo().setText("");
                        ventanaEditarPersona.getGruposanguineo().setSelectedIndex(0);
                        ventanaEditarPersona.getEstado().setSelectedIndex(9);
                        ventanaEditarPersona.getMunicipio().setText("");
                        ventanaEditarPersona.getParroquia().setText("");
                        ventanaEditarPersona.getDireccion().setText("");
                        ventanaEditarPersona.getFoto().setIcon(null);
                        ventanaEditarPersona.dispose();

                    }

                    //ocultar
                    loader.ocultar();
                    
                    //Mostrar que todo se guardo sin novedad
                    VAprobado exito = new VAprobado(ventanaPrincipal, true);
                    exito.setVisible(true);
                    

                }

            });
            hilo.start();

        }

        //FOTO
        if (ventanaEditarPersona.getBTN_FOTO() == e.getSource()) {

            try {

                //Buscar foto
                JFileChooser archivo = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagen", "jpg", "png", "jpeg");
                archivo.setFileFilter(filtro);

                int confirmar = archivo.showOpenDialog(ventanaEditarPersona);

                if (confirmar != JFileChooser.CANCEL_OPTION) {

                    Thread hilo = new Thread(() -> {

                        //Cargando
                        Cargando loader = new Cargando();
                        loader.mostrar(ventanaEditarPersona);

                        file = archivo.getSelectedFile();

                        //obtener filtro
                        String nombreArchivo = file.getName();
                        String filtroD = nombreArchivo.substring(nombreArchivo.lastIndexOf("."),
                                nombreArchivo.length());

                        if (filtroD.equals(".png") || filtroD.equals(".jpg") || filtroD.equals(".jpeg")) {

                            //Colocar foto en el JLABEL
                            ImageIcon img = new ImageIcon(file.getAbsolutePath());
                            Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaEditarPersona.getFoto().getWidth(),
                                    ventanaEditarPersona.getFoto().getHeight(), Image.SCALE_DEFAULT));

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(EventoEditarPersona.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            //ocultar cargando
                            loader.ocultar();

                            ventanaEditarPersona.getFoto().setIcon(icono);

                            //Nombre de la foto
                            ventanaEditarPersona.foto1 = file.getAbsolutePath();
                            

                        } else {

                            //ocultar cargando
                            loader.ocultar();

                            VError error = new VError(ventanaPrincipal, true);
                            error.texto.setText("DEBE SELECCIONAR UNA IMAGEN JPG O PNG");
                            error.setVisible(true);

                        }

                    });

                    hilo.start();

                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        }

    }

}
