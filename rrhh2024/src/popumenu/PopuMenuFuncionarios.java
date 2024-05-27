package popumenu;

import myclass.Cargando;
import myclass.RegistroHistorial;
import consulta.listado.informaciondefuncinario.ListadoAscenso;
import consulta.listado.informaciondefuncinario.ListadoCursos;
import consulta.listado.informaciondefuncinario.ListadoEstudios;
import consulta.listado.informaciondefuncinario.ListadoExperiencia;
import consulta.listado.informaciondefuncinario.ListadoFamiliares;
import consulta.listado.ventanaprincipal.ConsultaListado;
import consulta.listado.informaciondefuncinario.ListadoSanciones;
import consulta.listado.informaciondefuncinario.ListadoPermisos;
import consulta.listado.informaciondefuncinario.ListadoReposos;
import consulta.listado.informaciondefuncinario.ListadoVacaciones;
import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VVerFuncionarioController;
import myclass.ModificarFecha;
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
import model.Funcionario;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;

import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VError;

public class PopuMenuFuncionarios {

    private static int FILA;
    private JTable table;
    private ModificarFecha fecha = new ModificarFecha();
    JPopupMenu popumenu;
    JMenuItem ver;
    JMenuItem editar;
    JMenuItem eliminar;

    public PopuMenuFuncionarios(JTable table) {

        this.table = table;

        PopuMenu();

    }

    public void PopuMenu() {

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

    private String rango(int rango) {

        StringBuilder valor = new StringBuilder();

        switch (rango) {
            case 0:
                valor.append("OFICIAL");
                break;
            case 1:
                valor.append("PRIMER OFICIAL");
                break;
            case 2:
                valor.append("OFICIAL JEFE");
                break;
            case 3:
                valor.append("INSPECTOR");
                break;
            case 4:
                valor.append("PRIMER INSPECTOR");
                break;
            case 5:
                valor.append("INSPECTOR JEFE");
                break;
            case 6:
                valor.append("COMISARIO");
                break;
            case 7:
                valor.append("PRIMER COMISARIO");
                break;
            case 8:
                valor.append("COMISARIO JEFE");
                break;
        }

        return valor.toString();
    }

    private class evento implements ActionListener{

        
        public void mouseClicked(MouseEvent e) {
            


        }

        @Override
        public void actionPerformed(ActionEvent e) {
                       

            VPrincipal ventanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(table);

            //ver
            if (ver == e.getSource()) {

                Thread hilo = new Thread(() -> {

                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaPrincipal);

                    Funcionario funcionario = new Funcionario();

                    try {
                        String[] datos = new String[46];
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                        datos = funcionario.DatosFuncionario(modelo.getValueAt(table.getSelectedRow(), 6).toString());

                        VVerFuncionarioController ventanaVerFuncionario
                                = new VVerFuncionarioController(ventanaPrincipal, true);

                        ventanaVerFuncionario.getPrimernombre().setText(datos[0].toUpperCase());
                        ventanaVerFuncionario.getSegundonombre().setText(datos[1].toUpperCase());
                        ventanaVerFuncionario.getPrimerapellido().setText(datos[2].toUpperCase());
                        ventanaVerFuncionario.getSegundoapellido().setText(datos[3].toUpperCase());
                        ventanaVerFuncionario.getCedula().setText(datos[4].toUpperCase());
                        ventanaVerFuncionario.getFechanacimiento().setText(fecha.getFecha(datos[5]));
                        ventanaVerFuncionario.getLugarnacimiento().setText(datos[6].toUpperCase());
                        ventanaVerFuncionario.getEstadocivil().setText(datos[7].toUpperCase());
                        ventanaVerFuncionario.getGenero().setText(datos[8]);
                        ventanaVerFuncionario.getNivelacademico().setText(datos[9]);
                        ventanaVerFuncionario.getTituloobtenido().setText(datos[10].toUpperCase());
                        ventanaVerFuncionario.getOtrotitulo().setText(datos[11].toUpperCase());
                        ventanaVerFuncionario.getTelefono().setText(datos[12].toUpperCase());
                        ventanaVerFuncionario.getOtrotelefono().setText(datos[13].toUpperCase());
                        ventanaVerFuncionario.getCorreo().setText(datos[14].toUpperCase());
                        ventanaVerFuncionario.getGruposanguineo().setText(datos[15]);
                        ventanaVerFuncionario.getEstado().setText(datos[16].toUpperCase());
                        ventanaVerFuncionario.getMunicipio().setText(datos[17].toUpperCase());
                        ventanaVerFuncionario.getParroquia().setText(datos[18].toUpperCase());
                        ventanaVerFuncionario.getDireccion().setText(datos[19].toUpperCase());

                        //RANGO
                        String Rango = rango(Integer.parseInt(datos[22]));

                        //ID FUNCIONARIO
                        ventanaVerFuncionario.IDFuncionario = Integer.parseInt(datos[21]);

                        //MOSTRAR LISTADO DE SANCIONES
                        ListadoSanciones sanciones1 = new ListadoSanciones(ventanaVerFuncionario);
                        sanciones1.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE FAMILIARES
                        ListadoFamiliares familiares = new ListadoFamiliares(ventanaVerFuncionario);
                        familiares.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE ASCENSO
                        ListadoAscenso listadoAscenso = new ListadoAscenso(ventanaVerFuncionario);
                        listadoAscenso.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE CURSOS
                        ListadoCursos listadoCursos = new ListadoCursos(ventanaVerFuncionario);
                        listadoCursos.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE ESTUDIOS
                        ListadoEstudios listadoEstudios = new ListadoEstudios(ventanaVerFuncionario);
                        listadoEstudios.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE PERMISOS
                        ListadoPermisos listadoPermisos = new ListadoPermisos(ventanaVerFuncionario);
                        listadoPermisos.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE REPOSOS
                        ListadoReposos listadoReposo = new ListadoReposos(ventanaVerFuncionario);
                        listadoReposo.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE VACACIONES
                        ListadoVacaciones listadoVacaciones = new ListadoVacaciones(ventanaVerFuncionario);
                        listadoVacaciones.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE EXPERIENCIA
                        ListadoExperiencia listadoExperiencia = new ListadoExperiencia(ventanaVerFuncionario);
                        listadoExperiencia.MostrarListadoVF(ventanaVerFuncionario.IDFuncionario);

                        ventanaVerFuncionario.getRango().setText(Rango);
                        ventanaVerFuncionario.getFechaingreso().setText(fecha.getFecha(datos[23]));
                        ventanaVerFuncionario.getFechaascenso().setText(fecha.getFecha(datos[24]));
                        ventanaVerFuncionario.getCodigocarnet().setText(datos[25].toUpperCase());
                        ventanaVerFuncionario.getCondicion().setText(datos[26].toUpperCase());
                        ventanaVerFuncionario.getServicio().setText(datos[27].toUpperCase());
                        ventanaVerFuncionario.getMunicipiotrabajo().setText(datos[28].toUpperCase());
                        ventanaVerFuncionario.getCamisa().setText(datos[29].toUpperCase());
                        ventanaVerFuncionario.getPantalon().setText(datos[30].toUpperCase());
                        ventanaVerFuncionario.getZapato().setText(datos[31].toUpperCase());
                        ventanaVerFuncionario.getGorra().setText(datos[32].toUpperCase());
                        ventanaVerFuncionario.getNumerocuenta().setText(datos[33].toUpperCase());
                        ventanaVerFuncionario.getBanco().setText(datos[34].toUpperCase());
                        ventanaVerFuncionario.getEstatus().setText(datos[38]);

                        if (datos[26].equals("BAJA")) {
                            ventanaVerFuncionario.getJpanel_motivoegreso().setVisible(true);

                            ventanaVerFuncionario.getFechaegreso().setText(fecha.getFecha(datos[35]));
                            ventanaVerFuncionario.getMotivoegreso().setText(datos[36]);
                            ventanaVerFuncionario.getObservacionegreso().setText(datos[37]);

                        } else {
                            ventanaVerFuncionario.getJpanel_motivoegreso().setVisible(false);
                        }

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
                        Icon icono = new ImageIcon(img.getImage()
                                .getScaledInstance(
                                        ventanaVerFuncionario.getFoto1().getWidth(),
                                        ventanaVerFuncionario.getFoto1().getHeight(),
                                        Image.SCALE_DEFAULT));

                        ventanaVerFuncionario.getFoto1().setIcon(icono);
                        ventanaVerFuncionario.getFoto2().setIcon(icono);
                        ventanaVerFuncionario.getFoto3().setIcon(icono);
                        ventanaVerFuncionario.getFoto4().setIcon(icono);
                        ventanaVerFuncionario.getFoto5().setIcon(icono);
                        ventanaVerFuncionario.getFoto5().setIcon(icono);
                        ventanaVerFuncionario.getFoto6().setIcon(icono);
                        ventanaVerFuncionario.getFoto7().setIcon(icono);
                        ventanaVerFuncionario.getFoto8().setIcon(icono);
                        ventanaVerFuncionario.getFoto9().setIcon(icono);
                        ventanaVerFuncionario.getFoto10().setIcon(icono);
                        ventanaVerFuncionario.getFoto11().setIcon(icono);
                        ventanaVerFuncionario.getFoto12().setIcon(icono);

                        ventanaVerFuncionario.jTabbedPane.setSelectedIndex(0);

                        //ocultar ventana cargando
                        Thread.sleep(100);
                        loader.ocultar();

                        ventanaVerFuncionario.setVisible(true);
                        ventanaVerFuncionario.setLocationRelativeTo(ventanaPrincipal);

                        //OCULTAR POPUPMENU
                        FILA = table.getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {

                        loader.ocultar();

                        System.out.println(ex);

                        //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                        VError error = new VError(ventanaPrincipal, true);
                        error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                        error.setVisible(true);

                    }

                });

                hilo.start();

            }

            //Editar funcionario
            if (editar == e.getSource()) {

                Thread hilo = new Thread(() -> {

                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaPrincipal);

                    try {
                        String[] datos = new String[46];
                        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                        Funcionario funcionario = new Funcionario();
                        datos = funcionario.DatosFuncionario(modelo.getValueAt(table.getSelectedRow(), 6).toString());

                        VEditarFuncionarioController ventanaEditarFuncionario
                                = new VEditarFuncionarioController(ventanaPrincipal, true);

                        ventanaEditarFuncionario.getPrimernombre().setText(datos[0].toUpperCase());
                        ventanaEditarFuncionario.getSegundonombre().setText(datos[1].toUpperCase());
                        ventanaEditarFuncionario.getPrimerapellido().setText(datos[2].toUpperCase());
                        ventanaEditarFuncionario.getSegundoapellido().setText(datos[3].toUpperCase());
                        ventanaEditarFuncionario.getCedula().setText(datos[4].toUpperCase());

                        //FECHA DE NACIMIENTO
                        if (!datos[5].isEmpty()) {
                            SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                            Date fechaTxt;
                            fechaTxt = dateFormato.parse(datos[5]);
                            ventanaEditarFuncionario.getFechanacimiento().setDate(fechaTxt);
                        } else {
                            ventanaEditarFuncionario.getFechanacimiento().setDate(null);
                        }

                        ventanaEditarFuncionario.getLugarnacimiento().setText(datos[6].toUpperCase());
                        ventanaEditarFuncionario.getEstadocivil().setSelectedItem(datos[7].toUpperCase());
                        ventanaEditarFuncionario.getGenero().setSelectedItem(datos[8]);
                        ventanaEditarFuncionario.getNivelacademico().setSelectedItem(datos[9]);
                        ventanaEditarFuncionario.getTituloobtenido().setText(datos[10].toUpperCase());
                        ventanaEditarFuncionario.getOtrotitulo().setText(datos[11].toUpperCase());
                        ventanaEditarFuncionario.getTelefono().setText(datos[12].toUpperCase());
                        ventanaEditarFuncionario.getOtrotelefono().setText(datos[13].toUpperCase());
                        ventanaEditarFuncionario.getCorreo().setText(datos[14].toUpperCase());
                        ventanaEditarFuncionario.getGruposanguineo().setSelectedItem(datos[15]);
                        ventanaEditarFuncionario.getEstado().setSelectedItem(datos[16].toUpperCase());
                        ventanaEditarFuncionario.getMunicipio().setText(datos[17].toUpperCase());
                        ventanaEditarFuncionario.getParroquia().setText(datos[18].toUpperCase());
                        ventanaEditarFuncionario.getDireccion().setText(datos[19].toUpperCase());

                        //ID FUNCIONARIO
                        ventanaEditarFuncionario.IDFuncionario = Integer.parseInt(datos[21]);

                        //MOSTRAR LISTADO DE SANCIONES
                        ListadoSanciones sanciones = new ListadoSanciones(ventanaEditarFuncionario);
                        sanciones.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //RANGO POLICIAL
                        //RANGO
                        String Rango = rango(Integer.parseInt(datos[22]));

                        ventanaEditarFuncionario.getRango().setSelectedItem(Rango);

                        //FECHA DE INGRESO
                        if (!datos[23].isEmpty()) {
                            SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                            Date fechaTxt;
                            fechaTxt = dateFormato.parse(datos[23]);
                            ventanaEditarFuncionario.getFechaingreso().setDate(fechaTxt);

                        } else {
                            ventanaEditarFuncionario.getFechaingreso().setDate(null);
                        }

                        //FECHA DE ASCENSO
                        if (!datos[24].isEmpty()) {
                            SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                            Date fechaTxt;
                            fechaTxt = dateFormato.parse(datos[24]);
                            ventanaEditarFuncionario.getFechaascenso().setDate(fechaTxt);
                        } else {
                            ventanaEditarFuncionario.getFechaascenso().setDate(null);
                        }

                        ventanaEditarFuncionario.getCodigocarnet().setText(datos[25].toUpperCase());
                        ventanaEditarFuncionario.getCondicion().setSelectedItem(datos[26].toUpperCase());

                        //MOSTRAR LISTADO DE FAMILIARES
                        ListadoFamiliares familiares = new ListadoFamiliares(ventanaEditarFuncionario);
                        familiares.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE ASCENSO
                        ListadoAscenso listadoAscenso = new ListadoAscenso(ventanaEditarFuncionario);
                        listadoAscenso.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE CURSOS
                        ListadoCursos listadoCursos = new ListadoCursos(ventanaEditarFuncionario);
                        listadoCursos.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE ESTUDIOS
                        ListadoEstudios listadoEstudios = new ListadoEstudios(ventanaEditarFuncionario);
                        listadoEstudios.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE PERMISOS
                        ListadoPermisos listadoPermisos = new ListadoPermisos(ventanaEditarFuncionario);
                        listadoPermisos.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE REPOSOS
                        ListadoReposos listadoReposo = new ListadoReposos(ventanaEditarFuncionario);
                        listadoReposo.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE VACACIONES
                        ListadoVacaciones listadoVacaciones = new ListadoVacaciones(ventanaEditarFuncionario);
                        listadoVacaciones.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        //MOSTRAR LISTADO DE EXPERIENCIA
                        ListadoExperiencia listadoExperiencia = new ListadoExperiencia(ventanaEditarFuncionario);
                        listadoExperiencia.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                        ventanaEditarFuncionario.getTxtServicio().setText(datos[27].toUpperCase());
                        ventanaEditarFuncionario.getMunicipiotrabajo().setSelectedItem(datos[28].toUpperCase());
                        ventanaEditarFuncionario.getCamisa().setText(datos[29].toUpperCase());
                        ventanaEditarFuncionario.getPantalon().setText(datos[30].toUpperCase());
                        ventanaEditarFuncionario.getZapato().setText(datos[31].toUpperCase());
                        ventanaEditarFuncionario.getGorra().setText(datos[32].toUpperCase());
                        ventanaEditarFuncionario.getBanco().setText(datos[33].toUpperCase());
                        ventanaEditarFuncionario.getNumeroCuenta().setText(datos[34].toUpperCase());

                        if (datos[38] != null) {
                            ventanaEditarFuncionario.getEstatus().setSelectedItem(datos[38]);
                        }

                        //FECHA DE EGRESO
                        if (!datos[35].isEmpty()) {
                            SimpleDateFormat dateFormato = new SimpleDateFormat("yyyy-MM-dd");
                            Date fechaTxt;
                            fechaTxt = dateFormato.parse(datos[35]);
                            ventanaEditarFuncionario.getFechaegreso().setDate(fechaTxt);
                        }

                        ventanaEditarFuncionario.getMotivoegreso().setSelectedItem(datos[36]);
                        ventanaEditarFuncionario.getObservacionegreso().setText(datos[37]);

                        ventanaEditarFuncionario.rutaFoto = datos[20];

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
                        Icon icono = new ImageIcon(img.getImage().getScaledInstance(ventanaEditarFuncionario.getFoto1().getWidth(),
                                ventanaEditarFuncionario.getFoto1().getHeight(), Image.SCALE_DEFAULT));

                        ventanaEditarFuncionario.getFoto1().setIcon(icono);
                        ventanaEditarFuncionario.getFoto2().setIcon(icono);
                        ventanaEditarFuncionario.getFoto3().setIcon(icono);
                        ventanaEditarFuncionario.getFoto4().setIcon(icono);
                        ventanaEditarFuncionario.getFoto5().setIcon(icono);
                        ventanaEditarFuncionario.getFoto6().setIcon(icono);
                        ventanaEditarFuncionario.getFoto7().setIcon(icono);
                        ventanaEditarFuncionario.getFoto8().setIcon(icono);
                        ventanaEditarFuncionario.getFoto9().setIcon(icono);
                        ventanaEditarFuncionario.getFoto10().setIcon(icono);
                        ventanaEditarFuncionario.getFoto11().setIcon(icono);
                        ventanaEditarFuncionario.getFoto12().setIcon(icono);

                        //INICIAR EN JTABBED1
                        ventanaEditarFuncionario.tabbed.setSelectedIndex(0);

                        //ocultar ventana cargando
                        Thread.sleep(100);
                        loader.ocultar();

                        //MOSTRAR VENTANA
                        ventanaEditarFuncionario.setVisible(true);
                        ventanaEditarFuncionario.setLocationRelativeTo(ventanaPrincipal);

                        //OCULTAR POPUPMENU
                        FILA = table.getSelectedRow();
                        OcultarPopupMenu();

                    } catch (Exception ex) {
                        System.out.println(ex);
                        //MOSTRAR ERROR SI NO SELECCIONA UNA PERSONA
                        VError error = new VError(ventanaPrincipal, true);
                        error.texto.setText("DEBE SELECCIONAR UNA PERSONA");
                        error.setVisible(true);

                    }

                });

                hilo.start();
            }

            //eliminar
            if (eliminar == e.getSource()) {

                Thread hilo = new Thread(() -> {

                    try {
                        //ventana de confirmacion
                        VConfirmar vc = new VConfirmar(ventanaPrincipal, true);
                        boolean confirmar = vc.confirmacion;

                        if (confirmar) {

                            //Mostrar ventana cargando
                            Cargando loader = new Cargando();
                            loader.mostrar(ventanaPrincipal);
                            int IDFuncionario = 0;

                            if (table == ventanaPrincipal.jTable_FUNCIONARIOSBAJA) {
                                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                                IDFuncionario = Integer.parseInt(modelo.getValueAt(table.getSelectedRow(), 18).toString());
                            } else {
                                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                                IDFuncionario = Integer.parseInt(modelo.getValueAt(table.getSelectedRow(), 15).toString());
                            }

                            //HISTORIAL
                            RegistroHistorial h = new RegistroHistorial();
                            h.Funcionarios(2, IDFuncionario);
                            
                            Funcionario funcionario = new Funcionario();
                            funcionario.EliminarFuncionario(IDFuncionario);
                            
                            //Consultar funcionarios activos
                            if(table == ventanaPrincipal.jTable_FUNCIONARIOSACTIVOS){
                                ConsultaListado consulta = new ConsultaListado(ventanaPrincipal, table);
                                consulta.setConsulta(ventanaPrincipal.getBuscadorFuncionariosActivos().getText());
                                consulta.MostrarListadoFuncionariosActivos(Integer.parseInt(ventanaPrincipal.JLabel_Desde_FA.getText()));
                            }
                            
                            //Consultar funcionarios suspendidos
                            if(table == ventanaPrincipal.jTable_FUNCIONARIOSSUSPENDIDOS){
                                ConsultaListado consulta = new ConsultaListado(ventanaPrincipal, table);
                                consulta.setConsulta(ventanaPrincipal.getBuscadorFuncionariosSuspendidos().getText());
                                consulta.MostrarListadoFuncionariosSuspendidos(Integer.parseInt(ventanaPrincipal.Desde_FS.getText()));
                            }
                            
                            //Consultar funcionarios de IVSS
                            if(table == ventanaPrincipal.jTable_FUNCIONARIOSIVSS){
                                ConsultaListado consulta = new ConsultaListado(ventanaPrincipal, table);
                                consulta.setConsulta(ventanaPrincipal.getBuscadorFuncionariosIVSS().getText());
                                consulta.MostrarListadoFuncionariosIVSS(Integer.parseInt(ventanaPrincipal.Desde_IVSS.getText()));
                            }
                            
                            //Consultar funcionarios de baja
                            if(table == ventanaPrincipal.jTable_FUNCIONARIOSBAJA){
                                ConsultaListado consulta = new ConsultaListado(ventanaPrincipal, table);
                                consulta.setConsulta(ventanaPrincipal.getBuscadorFuncionariosBAJA().getText());
                                consulta.MostrarListadoFuncionariosBaja(Integer.parseInt(ventanaPrincipal.Desde_BAJA.getText()));
                            }
                            
                            

                            Thread.sleep(100);

                            //ocultar ventana cargando
                            loader.ocultar();
                            
                            //mostrar ventana de aprobado
                            VAprobado exito = new VAprobado(ventanaPrincipal, true);
                            exito.setVisible(true);

                            //OCULTAR POPUPMENU
                            FILA = table.getSelectedRow();
                            OcultarPopupMenu();

                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PopuMenuFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });

                hilo.start();

            }
        }

    }

}
