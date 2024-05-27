package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoFamiliares;
import controller.funcionario.VEditarFuncionarioController;
import controller.persona.VEditarPersonaController;
import controller.persona.VVerPersonaController;
import myclass.RegistroHistorial;
import myclass.ModificarFecha;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Familiares;
import model.Persona;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VError;
import view.ventanaemergente.VAprobado;

public class BTNFamilia extends MouseAdapter {

    private VEditarFuncionarioController ventanaEditarFuncionario;
    private ModificarFecha fecha = new ModificarFecha();

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (ventanaEditarFuncionario.ListadoFamilia.getSelectedRow() != -1) {
            
            ventanaEditarFuncionario.getBTN_VERFAMILIA().setVisible(true);
            ventanaEditarFuncionario.getBTN_ELIMINARFAMILIA().setVisible(true);
            ventanaEditarFuncionario.getBTN_EDITARFAMILIA().setVisible(true);
        }

        //ver familia desde la ventana ver funcionario 
        if (e.getSource() == ventanaEditarFuncionario.getBTN_VERFAMILIA()) {

            Thread hilo = new Thread(() -> {

                //cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaEditarFuncionario);

                ventanaEditarFuncionario.getBTN_VERFAMILIA().setVisible(false);
                ventanaEditarFuncionario.getBTN_ELIMINARFAMILIA().setVisible(false);
                ventanaEditarFuncionario.getBTN_EDITARFAMILIA().setVisible(false);

                try {
                    String[] datos = new String[22];
                    DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.ListadoFamilia.getModel();
                    VVerPersonaController ventanaVerPersona = new VVerPersonaController(new VPrincipal(), true);
                    
                    Persona persona = new Persona();
                    datos = persona.DatosPersonaID(modelo.getValueAt(ventanaEditarFuncionario.ListadoFamilia.getSelectedRow(), 13).toString());
                    
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
                    ventanaVerPersona.getgruposanguineo().setText(datos[15].toUpperCase());
                    ventanaVerPersona.getestado().setText(datos[16].toUpperCase());
                    ventanaVerPersona.getmunicipio().setText(datos[17].toUpperCase());
                    ventanaVerPersona.getparroquia().setText(datos[18].toUpperCase());
                    ventanaVerPersona.getdireccion().setText(datos[19].toUpperCase());

                    //COLOCAR FOTO EN JLABEL
                    ImageIcon img = new ImageIcon(datos[20]);
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaVerPersona.getfoto().getWidth(),
                            ventanaVerPersona.getfoto().getHeight(), Image.SCALE_DEFAULT));

                    ventanaVerPersona.getfoto().setIcon(icono);

                    Thread.sleep(100);
                    loader.ocultar();

                    ventanaVerPersona.setVisible(true);
                    ventanaVerPersona.setLocationRelativeTo(ventanaEditarFuncionario);

                } catch (Exception ex) {

                    System.out.println(ex);

                    //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                    VError error = new VError(ventanaEditarFuncionario, true);
                    error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                    error.setVisible(true);

                }
            });

            hilo.start();

        }

        //EDITAR FAMILIAR 
        if (e.getSource() == ventanaEditarFuncionario.getBTN_EDITARFAMILIA()) {

            Thread hilo = new Thread(() -> {

                Cargando loader = new Cargando();
                loader.mostrar(ventanaEditarFuncionario);

                ventanaEditarFuncionario.getBTN_VERFAMILIA().setVisible(false);
                ventanaEditarFuncionario.getBTN_ELIMINARFAMILIA().setVisible(false);
                ventanaEditarFuncionario.getBTN_EDITARFAMILIA().setVisible(false);

                try {
                    String[] datos = new String[21];
                    DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.ListadoFamilia.getModel();

                    Persona persona = new Persona();
                    datos = persona.DatosPersonaID(modelo.getValueAt(ventanaEditarFuncionario.ListadoFamilia.getSelectedRow(), 13).toString());
                    VEditarPersonaController ventanaEditarPersona = new VEditarPersonaController(new VPrincipal(), true);

                    ventanaEditarPersona.getPrimernombre().setText(datos[0].toUpperCase());
                    ventanaEditarPersona.getSegundonombre().setText(datos[1].toUpperCase());
                    ventanaEditarPersona.getPrimerapellido().setText(datos[2].toUpperCase());
                    ventanaEditarPersona.getSegundoapellido().setText(datos[3].toUpperCase());
                    ventanaEditarPersona.getCedula().setText(datos[4].toUpperCase());

                    //Fecha de Nacimiento
                    SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaTxt;
                    fechaTxt = dateFormato.parse(datos[5]);
                    ventanaEditarPersona.getFechanacimiento().setDate(fechaTxt);
                    ventanaEditarPersona.getLugarnacimiento().setText(datos[6].toUpperCase());
                    ventanaEditarPersona.getGenero().setSelectedItem(datos[7]);
                    ventanaEditarPersona.getEstadocivil().setSelectedItem(datos[8]);
                    ventanaEditarPersona.getNivelacademico().setSelectedItem(datos[9]);
                    ventanaEditarPersona.getTituloobtenido1().setText(datos[10].toUpperCase());
                    ventanaEditarPersona.getTituloobtenido2().setText(datos[11].toUpperCase());
                    ventanaEditarPersona.getTelefono1().setText(datos[12].toUpperCase());
                    ventanaEditarPersona.getTelefono2().setText(datos[13].toUpperCase());
                    ventanaEditarPersona.getCorreo().setText(datos[14].toUpperCase());
                    ventanaEditarPersona.getGruposanguineo().setSelectedItem(datos[15].toUpperCase());
                    ventanaEditarPersona.getEstado().setSelectedItem(datos[16].toUpperCase());
                    ventanaEditarPersona.getMunicipio().setText(datos[17].toUpperCase());
                    ventanaEditarPersona.getParroquia().setText(datos[18].toUpperCase());
                    ventanaEditarPersona.getDireccion().setText(datos[19].toUpperCase());
                    ventanaEditarPersona.rutaFoto = datos[20];

                    //COLOCAR FOTO EN JLABEL
                    ImageIcon img = new ImageIcon(ventanaEditarPersona.rutaFoto);
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaEditarPersona.getFoto().getWidth(),
                            ventanaEditarPersona.getFoto().getHeight(), Image.SCALE_DEFAULT));

                    ventanaEditarPersona.getFoto().setIcon(icono);

                    //IDPERSONA
                    ventanaEditarPersona.idpersona = Integer.parseInt(datos[21]);

                    Thread.sleep(100);
                    loader.ocultar();

                    ventanaEditarPersona.setVisible(true);
                    ventanaEditarPersona.setLocationRelativeTo(ventanaEditarFuncionario);

                } catch (Exception ex) {

                    //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                    VError error = new VError(ventanaEditarFuncionario, true);
                    error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                    error.setVisible(true);

                }
            });

            hilo.start();

        }

        //ELIMINAR FAMILIAR 
        if (e.getSource() == ventanaEditarFuncionario.getBTN_ELIMINARFAMILIA()) {

            //ventana de confirmacion
            VConfirmar vc = new VConfirmar(new VPrincipal(), true);
            boolean confirmar = vc.confirmacion;

            if (confirmar) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.ListadoFamilia.getModel();

                    Familiares familia = new Familiares();
                    familia.EliminarFamiliar(Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.ListadoFamilia.getSelectedRow(), 12).toString()));

                    //HISTORIAL
                    RegistroHistorial h = new RegistroHistorial();
                    h.Funcionarios(7, ventanaEditarFuncionario.IDFuncionario);

                    ventanaEditarFuncionario.getBTN_VERFAMILIA().setVisible(false);
                    ventanaEditarFuncionario.getBTN_ELIMINARFAMILIA().setVisible(false);
                    ventanaEditarFuncionario.getBTN_EDITARFAMILIA().setVisible(false);

                    //ACTUALIZAR LISTADO
                    ListadoFamiliares listado = new ListadoFamiliares(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BTNFamilia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loader.ocultar();
                    VAprobado exito = new VAprobado(ventanaEditarFuncionario, true);
                    exito.setVisible(true);
                    exito.setLocationRelativeTo(ventanaEditarFuncionario);
                });

                hilo.start();

            }

        }

    }

}
