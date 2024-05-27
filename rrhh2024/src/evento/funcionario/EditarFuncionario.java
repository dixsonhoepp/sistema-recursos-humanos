package evento.funcionario;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Funcionario;
import model.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class EditarFuncionario extends MouseAdapter {

    //private static String foto = "";
    private static File file;
    private Path fuente, destino;


    @Override
    public void mouseClicked(MouseEvent e) {
        //EDITAR 

        VEditarFuncionario frame = (VEditarFuncionario) SwingUtilities.getWindowAncestor(e.getComponent());

        if (frame.getBTN_GUARDAR() == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {

                    //guardar en variables los datos que se encuentra en los JText
                    String primernombre = frame.getPrimernombre().getText();
                    String segundonombre = frame.getSegundonombre().getText();
                    String primerapellido = frame.getPrimerapellido().getText();
                    String segundoapellido = frame.getSegundoapellido().getText();
                    String cedula = frame.getCedula().getText();

                    //fecha nacimiento
                    String fechanacimiento = "";
                    try {
                        Date date = frame.getFechanacimiento().getDate();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha = formato.format(date);
                        fechanacimiento = fecha;

                    } catch (Exception ex) {
                    }
                    String lugarnacimiento = frame.getLugarnacimiento().getText();
                    String genero = (String) frame.getGenero().getSelectedItem();
                    String estadocivil = (String) frame.getEstadocivil().getSelectedItem();
                    String nivelacademico = (String) frame.getNivelacademico().getSelectedItem();
                    String tituloobtenido1 = frame.getTituloobtenido().getText();
                    String tituloobtenido2 = frame.getOtrotitulo().getText();
                    String telefono1 = frame.getTelefono().getText();
                    String telefono2 = frame.getOtrotelefono().getText();
                    String correo = frame.getCorreo().getText();
                    String gruposanguineo = frame.getGruposanguineo().getSelectedItem().toString();
                    String estado = frame.getEstado().getSelectedItem().toString();
                    String municipio = frame.getMunicipio().getText();
                    String parroquia = frame.getParroquia().getText();
                    String direccion = frame.getDireccion().getText();
                    String foto = frame.foto;

                    int rango = frame.getRango().getSelectedIndex();

                    //FECHA INGRESO
                    String FechaIngreso = "";
                    try {
                        Date date = frame.getFechaingreso().getDate();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha = formato.format(date);
                        FechaIngreso = fecha;

                    } catch (Exception ex) {

                    }

                    //FECHA ASCENSO
                    String FechaAscenso = "";

                    try {
                        Date date = frame.getFechaascenso().getDate();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha = formato.format(date);
                        FechaAscenso = fecha;

                    } catch (Exception ex) {

                    }

                    String CodigoCarnet = frame.getCodigocarnet().getText();
                    String Condicion = (String) frame.getCondicion().getSelectedItem();
                    String Servicio = frame.getTxtServicio().getText();
                    String Municipio = (String) frame.getMunicipiotrabajo().getSelectedItem();
                    String TallaCamisa = frame.getCamisa().getText();
                    String TallaPantalon = frame.getPantalon().getText();
                    String TallaZapato = frame.getZapato().getText();
                    String TallaGorra = frame.getGorra().getText();
                    String Banco = frame.getBanco().getText();
                    String NumeroCuenta = frame.getNumeroCuenta().getText();
                    String Estatus = frame.getEstatus().getSelectedItem().toString();

                    //FECHA EGRESO
                    String FechaEgreso = "";
                    try {
                        Date date = frame.getFechaegreso().getDate();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fecha = formato.format(date);
                        FechaEgreso = fecha;

                    } catch (Exception ex) {

                    }

                    String MotivoEgreso = (String) frame.getMotivoegreso().getSelectedItem();
                    String ObservacionEgreso = frame.getObservacionegreso().getText();

                    int IDFuncionario = frame.IDFuncionario;

                    //despues de tener los datos armacenados en variables, se procede a verificar si los importantes estan vacio
                    if (primernombre.isEmpty()) {
                        VError VError = new VError(frame, true);
                        VError.texto.setText("El Primer Nombre Esta Vacío");
                        VError.setVisible(true);
                    } else if (primerapellido.isEmpty()) {
                        VError VError = new VError(frame, true);
                        VError.texto.setText("El Primer Apellido Esta Vacío");
                        VError.setVisible(true);
                    } else if (cedula.isEmpty()) {
                        VError VError = new VError(frame, true);
                        VError.texto.setText("La Cédula Esta Vacía");
                        VError.setVisible(true);
                    } else if (FechaIngreso.isEmpty()) {
                        VError VError = new VError(frame, true);
                        VError.texto.setText("La Fecha De Ingreso Esta Vacía");
                        VError.setVisible(true);
                    } else if (FechaAscenso.isEmpty()) {
                        VError VError = new VError(frame, true);
                        VError.texto.setText("La Fecha De Ascenso Esta Vacía");
                        VError.setVisible(true);
                    } else {

                        //Mostrar ventana cargando
                        Cargando loader = new Cargando();
                        loader.mostrar(frame);

                        //ruta y destino de foto
                        if (frame.foto.isEmpty()) {
                            frame.foto = frame.rutaFoto;
                        } else {

                            //RUTA JSON
                            String ruta = "";
                            try {
                                Object object = new JSONParser().parse(new FileReader("rutas.txt"));
                                JSONObject JSON = (JSONObject) object;
                                ruta = JSON.get("foto").toString();
                            } catch (Exception ex) {
                            }

                            //obtener el formato de la imagen
                            String formato = frame.foto.substring(frame.foto.indexOf("."));

                            //fuentes y destino de la foto
                            fuente = Paths.get(frame.foto);
                            destino = Paths.get(ruta + cedula + formato);

                            //nombre y formato
                            frame.foto = cedula + formato;

                            //copiar imagen en la ruta indicada
                            try {
                                //crear directorio o carpeta si no existe
                                if (!Files.exists(Paths.get(ruta))) {
                                    Files.createDirectory(Paths.get(ruta));
                                }
                                Files.copy(fuente, destino, StandardCopyOption.REPLACE_EXISTING);

                            } catch (IOException ex) {
                                Logger.getLogger(EditarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                        //creamos las instancia de persona y funcionario
                        Persona persona = new Persona();
                        Funcionario funcionario = new Funcionario();

                        //Consultar Codigo de Persona
                        Funcionario Consulta = new Funcionario();
                        String[] IDPersona = Consulta.DatosFuncionarioID(IDFuncionario);

                        //enviar datos a la base de dato
                        if (persona.EditarPersona(Integer.parseInt(IDPersona[5]), primernombre, segundonombre,
                                primerapellido, segundoapellido, cedula, fechanacimiento,
                                lugarnacimiento, estadocivil, genero, nivelacademico,
                                tituloobtenido1, tituloobtenido2, telefono1, telefono2,
                                correo, gruposanguineo, estado, municipio, parroquia,
                                direccion, frame.foto)) {

                            if (funcionario.EditarFuncionario(IDFuncionario, rango,
                                    FechaIngreso, FechaAscenso, CodigoCarnet, Condicion,
                                    Servicio, Municipio, TallaCamisa, TallaPantalon,
                                    TallaZapato, TallaGorra, Banco, NumeroCuenta, Estatus,
                                    FechaEgreso, MotivoEgreso, ObservacionEgreso)) {

                                //HISTORIAL
                                RegistroHistorial r = new RegistroHistorial();
                                r.Funcionarios(3, IDFuncionario);

                                frame.foto = "";

                                Thread.sleep(100);
                                //ocultar
                                loader.ocultar();

                                //datos cambiados
                                //Ventana de exito
                                VAprobado ventanaExito = new VAprobado(frame, true);
                                ventanaExito.setVisible(true);
                            }

                        }

                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(EditarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            hilo.start();
        }

        //FOTO
        if (frame.getBTN_FOTO() == e.getSource()) {

            //Buscar foto
            JFileChooser archivo = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagen", "jpg", "png", "jpeg");
            archivo.setFileFilter(filtro);

            int confirmar = archivo.showOpenDialog(frame);

            if (confirmar != JFileChooser.CANCEL_OPTION) {

                Thread hilo = new Thread(() -> {

                    //Cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(frame);

                    file = archivo.getSelectedFile();

                    //obtener filtro
                    String nombreArchivo = file.getName();
                    String filtroD = nombreArchivo.substring(nombreArchivo.lastIndexOf("."),
                            nombreArchivo.length());

                    if (filtroD.equals(".png") || filtroD.equals(".jpg") || filtroD.equals(".jpeg")) {

                        //Obtenemos el nombre del archivo
                        frame.foto = file.getAbsolutePath();

                        try {
                            //ocultar cargando
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EditarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        loader.ocultar();

                        //Colocar foto en el JLABEL
                        ImageIcon img = new ImageIcon(file.getAbsolutePath());
                        Icon icono = new ImageIcon(img.getImage().getScaledInstance(frame.getFoto1().getWidth(),
                                frame.getFoto1().getHeight(), Image.SCALE_DEFAULT));

                        frame.getFoto1().setIcon(icono);
                        frame.getFoto2().setIcon(icono);
                        frame.getFoto3().setIcon(icono);
                        frame.getFoto4().setIcon(icono);
                        frame.getFoto5().setIcon(icono);
                        frame.getFoto6().setIcon(icono);
                        frame.getFoto7().setIcon(icono);
                        frame.getFoto8().setIcon(icono);
                        frame.getFoto9().setIcon(icono);
                        frame.getFoto10().setIcon(icono);
                        frame.getFoto11().setIcon(icono);
                        frame.getFoto12().setIcon(icono);

                    } else {

                        VError error = new VError(frame, true);
                        error.texto.setText("DEBE SELECCIONAR UNA IMAGEN JPG O PNG");
                        error.setVisible(true);
                    }

                });

                hilo.start();

            }

        }

    }

}
