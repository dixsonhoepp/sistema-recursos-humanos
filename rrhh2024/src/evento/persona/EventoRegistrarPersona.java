package evento.persona;

import consulta.listado.ventanaprincipal.ConsultaListado;
import controller.persona.VRegistrarPersonaController;
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

public class EventoRegistrarPersona extends MouseAdapter {

    private VPrincipal ventanaPrincipal;
    private static String foto = "";
    //private JFileChooser archivo = new JFileChooser();
    private static File file;
    private Path fuente, destino;

    public EventoRegistrarPersona(VPrincipal vn) {
        this.ventanaPrincipal = vn;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        VRegistrarPersonaController ventanaRegistrarPersona = (VRegistrarPersonaController) 
                SwingUtilities.getWindowAncestor(e.getComponent());
        
        //Registrar Persona
        if (ventanaRegistrarPersona.getBTN_REGISTRARPERSONA() == e.getSource()) {

            Thread hilo = new Thread(() -> {

                String primernombre = ventanaRegistrarPersona.getPrimernombre().getText();
                String segundonombre = ventanaRegistrarPersona.getSegundonombre().getText();
                String primerapellido = ventanaRegistrarPersona.getPrimerapellido().getText();
                String segundoapellido = ventanaRegistrarPersona.getSegundoapellido().getText();
                String cedula = ventanaRegistrarPersona.getCedula().getText();

                //fecha nacimiento
                String fechanacimiento = "";
                try {
                    Date date = ventanaRegistrarPersona.getFechanacimiento().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechanacimiento = fecha.toString();

                } catch (Exception ex) {
                }

                String lugarnacimiento = ventanaRegistrarPersona.getLugarnacimiento().getText();
                String genero = (String) ventanaRegistrarPersona.getGenero().getSelectedItem();
                String estadocivil = (String) ventanaRegistrarPersona.getEstadocivil().getSelectedItem();
                String nivelacademico = (String) ventanaRegistrarPersona.getNivelacademico().getSelectedItem();
                String tituloobtenido1 = ventanaRegistrarPersona.getTituloobtenido1().getText();
                String tituloobtenido2 = ventanaRegistrarPersona.getTituloobtenido2().getText();
                String telefono1 = ventanaRegistrarPersona.getTelefono1().getText();
                String telefono2 = ventanaRegistrarPersona.getTelefono2().getText();
                String correo = ventanaRegistrarPersona.getCorreo().getText();
                String gruposanguineo = ventanaRegistrarPersona.getGruposanguineo().getSelectedItem().toString();
                String estado = ventanaRegistrarPersona.getEstado().getSelectedItem().toString();
                String municipio = ventanaRegistrarPersona.getMunicipio().getText();
                String parroquia = ventanaRegistrarPersona.getParroquia().getText();
                String direccion = ventanaRegistrarPersona.getDireccion().getText();
                String foto = this.foto;

                //VERIFICAR SI EL NOMBRE NO ESTA VACIO 
                if (primernombre.isEmpty()) {

                    VError VError = new VError(ventanaRegistrarPersona, true);
                    VError.texto.setText("EL PRIMER NOMBRE ESTA VACIO");
                    VError.setAlwaysOnTop(true);
                    VError.setVisible(true);

                    //VERIFICAR SI EL APELLIDO NO ESTA VACIO 
                } else if (primerapellido.isEmpty()) {
                    VError VError = new VError(ventanaRegistrarPersona, true);
                    VError.texto.setText("EL PRIMER APELLIDO ESTA VACIO");
                    VError.setVisible(true);

                } else if (fechanacimiento.isEmpty()) {
                    VError VError = new VError(ventanaRegistrarPersona, true);
                    VError.texto.setText("LA FECHA DE NACIMIENTO ESTA VACIA");
                    VError.setVisible(true);

                } else {

                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaRegistrarPersona);

                    //RUTA Y DESTINO DE FOTO
                    if (!this.foto.isEmpty()) {

                        //RUTA JSON
                        String ruta = "";
                        try {
                            Object object = new JSONParser().parse(new FileReader("rutas.txt"));
                            JSONObject JSON = (JSONObject) object;

                            ruta = JSON.get("foto").toString();

                        } catch (Exception ex) {
                        }

                        //OBTENER EL FORMATO DE LA IMAGEN
                        String formato = this.foto.substring(this.foto.indexOf("."));

                        //FUENTE Y DESTINO DE FOTO
                        fuente = Paths.get(this.foto);
                        destino = Paths.get(ruta + cedula + formato);

                        //NUEVA RUTA, NOMBRE Y FORMATO
                        this.foto = cedula + formato;

                        //COPIAR IMAGEN
                        try {

                            //CREAR DIRECTORIO DE FOTO SI NO EXISTE
                            if (!Files.exists(Paths.get(ruta))) {
                                Files.createDirectory(Paths.get(ruta));
                            }

                            Files.copy(fuente, destino, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                    }

                    Persona persona = new Persona();

                    if (persona.RegistrarPersona(primernombre, segundonombre,
                            primerapellido, segundoapellido, cedula,
                            fechanacimiento, lugarnacimiento, estadocivil,
                            genero, nivelacademico, tituloobtenido1,
                            tituloobtenido2, telefono1, telefono2, correo,
                            gruposanguineo, estado, municipio, parroquia,
                            direccion, this.foto)) {


                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Persona(1, 0, primernombre + " " + segundonombre + " "
                                + primerapellido + " " + segundoapellido + " " + cedula);

                        this.foto = "";
                        

                        //ACTUALIZAR LISTADO DE PERSONA
                        ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                                ventanaPrincipal.getjTable_PERSONAS());
                        listado.setConsulta(ventanaPrincipal.getBuscadorpersona().getText());
                        listado.MostrarListadoPersonas(
                                Integer.parseInt(
                                        ventanaPrincipal.JLabel_Desde_Persona
                                                .getText()));
                        
                        //ventana cargando ocultar
                        loader.ocultar();
                        
                        //Mensaje de confirmacion!
                        VAprobado exito = new VAprobado(ventanaRegistrarPersona, true);
                        exito.setVisible(true);
                        
                        ventanaRegistrarPersona.dispose();

                    } else {
                        
                        //ventana cargando ocultar
                        loader.ocultar();
                        VError error = new VError(ventanaRegistrarPersona, true);
                        error.texto.setText("N° de cédula en uso");
                        error.setVisible(true);
                    }

                }

            });

            hilo.start();

        }

        //FOTO
        if (ventanaRegistrarPersona.getBTN_FOTO() == e.getSource()) {

            //Buscar foto
            JFileChooser archivo = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagen", "jpg", "png", "jpeg");
            archivo.setFileFilter(filtro);

            int confirmar = archivo.showOpenDialog(ventanaRegistrarPersona);

            if (confirmar != JFileChooser.CANCEL_OPTION) {

                file = archivo.getSelectedFile();

                //obtener filtro
                String nombreArchivo = file.getName();
                String filtroD = nombreArchivo.substring(nombreArchivo.lastIndexOf("."),
                        nombreArchivo.length());

                if (filtroD.equals(".png") || filtroD.equals(".jpg") || filtroD.equals(".jpeg")) {

                    //Colocar foto en el JLABEL
                    ImageIcon img = new ImageIcon(file.getAbsolutePath());
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaRegistrarPersona.getFoto().getWidth(),
                            ventanaRegistrarPersona.getFoto().getHeight(), Image.SCALE_DEFAULT));

                    ventanaRegistrarPersona.getFoto().setIcon(icono);

                    //Nombre de la foto
                    this.foto = file.getAbsolutePath();

                } else {
                    VError error = new VError(ventanaPrincipal, true);
                    error.texto.setText("DEBE SELECCIONAR UNA IMAGEN JPG O PNG");
                    error.setVisible(true);

                }

            }
        }

    }

}
