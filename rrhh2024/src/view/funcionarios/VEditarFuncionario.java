/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionarios;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;
import controller.funcionario.VServiciosController;
import evento.otro.TextoMayuscula;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import view.componentes.BTN;

/**
 *
 * @author Dixson
 */
public class VEditarFuncionario extends javax.swing.JDialog {

    public static String rutaFoto;
    public static int IDFuncionario;
    public static String foto = "";

    public VEditarFuncionario(JFrame v, boolean modal) {

        super(v, modal);
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf");
        }

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/view/img/peda.png")).getImage());
        setLocationRelativeTo(this);

        DecorarJtablet(ListadoSanciones);
        DecorarJtablet(listadoExperiencia);
        DecorarJtablet(listadoAscenso);
        DecorarJtablet(listadoCursos);
        DecorarJtablet(listadoEstudios);
        DecorarJtablet(listadoPermisos);
        DecorarJtablet(listadoReposo);
        DecorarJtablet(listadoVacaciones);
        DecorarJtablet(ListadoFamilia);

    }

    private void DecorarJtablet(JTable jtable) {
        jtable.getTableHeader().setOpaque(false);
        jtable.getTableHeader().setBackground(new Color(102, 102, 102));
        jtable.getTableHeader().setForeground(Color.WHITE);
    }

    public JButton getBTN_FOTO() {
        return BTN_FOTO;
    }

    public JButton getBTN_GUARDAR() {
        return BTN_GUARDAR;
    }

    public JTextField getNumeroCuenta() {
        return numerocuenta;
    }

    public JTextField getCamisa() {
        return camisa;
    }

    public JTextField getCedula() {
        return cedula;
    }

    public JTextField getCodigocarnet() {
        return codigocarnet;
    }

    public JComboBox<String> getCondicion() {
        return condicion;
    }

    public JTextField getCorreo() {
        return correo;
    }

    public JTextField getBanco() {
        return banco;
    }

    public JTextArea getDireccion() {
        return direccion;
    }

    public JComboBox getEstado() {
        return estado;
    }

    public JComboBox<String> getEstadocivil() {
        return estadocivil;
    }

    public JDateChooser getFechaascenso() {
        return fechaascenso;
    }

    public JDateChooser getFechaingreso() {
        return fechaingreso;
    }

    public JDateChooser getFechanacimiento() {
        return fechanacimiento;
    }

    public JLabel getFoto1() {
        return foto1;
    }

    public JLabel getFoto2() {
        return foto2;
    }

    public JLabel getFoto3() {
        return foto3;
    }

    public JLabel getFoto4() {
        return foto4;
    }

    public JLabel getFoto5() {
        return foto5;
    }

    public JLabel getFoto6() {
        return foto6;
    }

    public JLabel getFoto7() {
        return foto7;
    }

    public JLabel getFoto8() {
        return foto8;
    }

    public JLabel getFoto9() {
        return foto9;
    }

    public JLabel getFoto10() {
        return foto10;
    }

    public JLabel getFoto11() {
        return foto11;
    }

    public JLabel getFoto12() {
        return foto12;
    }

    public JComboBox<String> getGenero() {
        return genero;
    }

    public JTextField getGorra() {
        return gorra;
    }

    public JTextField getMunicipio() {
        return municipio;
    }

    public JComboBox<String> getMunicipiotrabajo() {
        return municipiotrabajo;
    }

    public JComboBox<String> getNivelacademico() {
        return nivelacademico;
    }

    public JTextField getOtrotelefono() {
        return otrotelefono;
    }

    public JTextField getOtrotitulo() {
        return otrotitulo;
    }

    public JTextField getPantalon() {
        return pantalon;
    }

    public JTextField getParroquia() {
        return parroquia;
    }

    public JTextField getPrimerapellido() {
        return primerapellido;
    }

    public JTextField getPrimernombre() {
        return primernombre;
    }

    public JComboBox<String> getRango() {
        return rango;
    }

    public JTextField getSegundoapellido() {
        return segundoapellido;
    }

    public JTextField getSegundonombre() {
        return segundonombre;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public JTextField getTituloobtenido() {
        return tituloobtenido;
    }

    public JTextField getZapato() {
        return zapato;
    }

    public JTextField getLugarnacimiento() {
        return lugarnacimiento;
    }

    public JComboBox getGruposanguineo() {
        return gruposanguineo;
    }

    public JPanel getJpanel_motivoegreso() {
        return jpanel_motivoegreso;
    }

    public JComboBox<String> getMotivoegreso() {
        return motivoegreso;
    }

    public JTextField getNumerocuenta() {
        return numerocuenta;
    }

    public JTextArea getObservacionegreso() {
        return observacionegreso;
    }

    public JDateChooser getFechaegreso() {
        return fechaegreso;
    }

    public JButton getBTN_EDITARFAMILIA() {
        return BTN_EDITARFAMILIA;
    }

    public JButton getBTN_ELIMINARFAMILIA() {
        return BTN_ELIMINARFAMILIA;
    }

    public JButton getBTN_VERFAMILIA() {
        return BTN_VERFAMILIA;
    }

    public JButton getBTN_AGREGARFAMILIA() {
        return BTN_AGREGARFAMILIA;
    }

    public JButton getBTN_ELIMINARMD() {
        return btn_eliminarMD;
    }

    public JButton getBTN_REGISTRARMD() {
        return btn_registrarMD;
    }

    public BTN getBtnEliminarCursos() {
        return btnEliminarCursos;
    }

    public JButton getBtnEliminarEstudios() {
        return btnEliminarEstudios;
    }

    public JButton getBtnEliminarExp() {
        return btnEliminarExp;
    }

    public JButton getBtnEliminarPermisos() {
        return btnEliminarPermisos;
    }

    public BTN getBtnEliminarReposo() {
        return btnEliminarReposo;
    }

    public JButton getBtnEliminarVacaciones() {
        return btnEliminarVacaciones;
    }

    public BTN getBtnRegistrarCursos() {
        return btnRegistrarCursos;
    }

    public BTN getBtnRegistrarEstudios() {
        return btnRegistrarEstudios;
    }

    public JButton getBtnRegistrarExp() {
        return btnRegistrarExp;
    }

    public JButton getBtnRegistrarPermisos() {
        return btnRegistrarPermisos;
    }

    public BTN getBtnRegistrarReposo() {
        return btnRegistrarReposo;
    }

    public JButton getBtnRegistrarVacaciones() {
        return btnRegistrarVacaciones;
    }

    public JButton getBtnEliminarAscenso() {
        return btnEliminarAscenso;
    }

    public JButton getBtnRegistrarAscenso() {
        return btnRegistrarAscenso;
    }

    public JComboBox<String> getEstatus() {
        return estatus;
    }

    public JLabel getTxtServicio() {
        return txtServicio;
    }

    public void setTxtServicio(JLabel txtServicio) {
        this.txtServicio = txtServicio;
    }

    public BTN getBtnAgregarServicio() {
        return btnAgregarServicio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        BTN_GUARDAR = new view.componentes.BTN();
        tabbed = new javax.swing.JTabbedPane();
        datosPersonales = new javax.swing.JPanel();
        foto1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        parroquia = new javax.swing.JTextField();
        primernombre = new javax.swing.JTextField();
        segundonombre = new javax.swing.JTextField();
        primerapellido = new javax.swing.JTextField();
        segundoapellido = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();
        tituloobtenido = new javax.swing.JTextField();
        lugarnacimiento = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        otrotelefono = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        estadocivil = new javax.swing.JComboBox<>();
        genero = new javax.swing.JComboBox<>();
        gruposanguineo = new javax.swing.JComboBox<>();
        fechanacimiento = new com.toedter.calendar.JDateChooser();
        otrotitulo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        nivelacademico = new javax.swing.JComboBox<>();
        BTN_FOTO = new view.componentes.BTN();
        datosPoliciales = new javax.swing.JPanel();
        foto2 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        codigocarnet = new javax.swing.JTextField();
        camisa = new javax.swing.JTextField();
        pantalon = new javax.swing.JTextField();
        gorra = new javax.swing.JTextField();
        zapato = new javax.swing.JTextField();
        rango = new javax.swing.JComboBox<>();
        municipiotrabajo = new javax.swing.JComboBox<>();
        txtServicio = new javax.swing.JLabel();
        fechaascenso = new com.toedter.calendar.JDateChooser();
        fechaingreso = new com.toedter.calendar.JDateChooser();
        condicion = new javax.swing.JComboBox<>();
        jpanel_motivoegreso = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        fechaegreso = new com.toedter.calendar.JDateChooser();
        motivoegreso = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        observacionegreso = new javax.swing.JTextArea();
        jLabel78 = new javax.swing.JLabel();
        btnAgregarServicio = new view.componentes.BTN();
        familiares = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        foto3 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ListadoFamilia = new javax.swing.JTable();
        BTN_AGREGARFAMILIA = new view.componentes.BTN();
        BTN_ELIMINARFAMILIA = new view.componentes.BTN();
        BTN_VERFAMILIA = new view.componentes.BTN();
        BTN_EDITARFAMILIA = new view.componentes.BTN();
        experienciaPolicial = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        foto4 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        listadoExperiencia = new javax.swing.JTable();
        btnRegistrarExp = new view.componentes.BTN();
        btnEliminarExp = new view.componentes.BTN();
        ascenso = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        listadoAscenso = new javax.swing.JTable();
        jLabel195 = new javax.swing.JLabel();
        foto12 = new javax.swing.JLabel();
        btnRegistrarAscenso = new view.componentes.BTN();
        btnEliminarAscenso = new view.componentes.BTN();
        medidasDisciplinaria = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        ListadoSanciones = new javax.swing.JTable();
        foto5 = new javax.swing.JLabel();
        btn_registrarMD = new view.componentes.BTN();
        btn_eliminarMD = new view.componentes.BTN();
        vacaciones = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        listadoVacaciones = new javax.swing.JTable();
        jLabel190 = new javax.swing.JLabel();
        foto6 = new javax.swing.JLabel();
        btnRegistrarVacaciones = new view.componentes.BTN();
        btnEliminarVacaciones = new view.componentes.BTN();
        permisos = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        listadoPermisos = new javax.swing.JTable();
        jLabel191 = new javax.swing.JLabel();
        foto7 = new javax.swing.JLabel();
        btnRegistrarPermisos = new view.componentes.BTN();
        btnEliminarPermisos = new view.componentes.BTN();
        reposos = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        listadoReposo = new javax.swing.JTable();
        jLabel192 = new javax.swing.JLabel();
        foto8 = new javax.swing.JLabel();
        btnRegistrarReposo = new view.componentes.BTN();
        btnEliminarReposo = new view.componentes.BTN();
        cursos = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        listadoCursos = new javax.swing.JTable();
        jLabel193 = new javax.swing.JLabel();
        foto9 = new javax.swing.JLabel();
        btnRegistrarCursos = new view.componentes.BTN();
        btnEliminarCursos = new view.componentes.BTN();
        estudios = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        listadoEstudios = new javax.swing.JTable();
        jLabel194 = new javax.swing.JLabel();
        foto10 = new javax.swing.JLabel();
        btnRegistrarEstudios = new view.componentes.BTN();
        btnEliminarEstudios = new view.componentes.BTN();
        nomina = new javax.swing.JPanel();
        foto11 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        banco = new javax.swing.JTextField();
        numerocuenta = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        estatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDITAR INFORMACIÓN");
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 680, 10));

        BTN_GUARDAR.setBackground(new java.awt.Color(102, 102, 102));
        BTN_GUARDAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_GUARDAR.setText("REGISTRAR");
        BTN_GUARDAR.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(BTN_GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 160, 30));

        tabbed.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbed.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        datosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        datosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datosPersonales.add(foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel4.setText("- PRIMER NOMBRE:");
        datosPersonales.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel8.setText("- SEGUNDO NOMBRE:");
        datosPersonales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel11.setText("- PRIMER APELLIDO:");
        datosPersonales.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel13.setText("- SEGUNDO APELLIDO:");
        datosPersonales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel15.setText("- CÉDULA DE IDENTIDAD:");
        datosPersonales.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jLabel19.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel19.setText("- FECHA DE NACIMIENTO:");
        datosPersonales.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel21.setText("- LUGAR DE NACIMIENTO:");
        datosPersonales.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel24.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel24.setText("- ESTADO CIVIL:");
        datosPersonales.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        jLabel27.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel27.setText("- GENERO:");
        datosPersonales.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jLabel30.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel30.setText("- NIVEL ACADEMICO:");
        datosPersonales.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jLabel33.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel33.setText("- TITULO OBTENIDO:");
        datosPersonales.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        jLabel36.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel36.setText("- OTRO TITULO:");
        datosPersonales.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        jLabel39.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel39.setText("- TELEFONO:");
        datosPersonales.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        jLabel42.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel42.setText("- OTRO TELEFONO:");
        datosPersonales.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        jLabel45.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel45.setText("- CORREO:");
        datosPersonales.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        jLabel48.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel48.setText("- DIRECCIÓN:");
        datosPersonales.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, 20));

        jLabel51.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel51.setText("- ESTADO:");
        datosPersonales.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 20));

        jLabel54.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel54.setText("- MUNICIPIO:");
        datosPersonales.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, 20));

        jLabel57.setFont(new java.awt.Font("Rockwell", 0, 12));
        jLabel57.setText("- PARROQUIA:");
        datosPersonales.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 20));

        direccion.setColumns(20);
        direccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        direccion.setForeground(new java.awt.Color(102, 102, 102));
        direccion.setLineWrap(true);
        direccion.setRows(5);
        direccion.setText("CALLE SAN CRISTOBA, CASA 47, AL FRENTE DEL HOTEL SAN CRISTOBAL");
        direccion.setWrapStyleWord(true);
        direccion.setBorder(null);
        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                direccionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(direccion);

        datosPersonales.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 310, -1));

        parroquia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        parroquia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        parroquia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                parroquiaKeyReleased(evt);
            }
        });
        datosPersonales.add(parroquia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 220, -1));

        primernombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        primernombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        primernombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                primernombreKeyReleased(evt);
            }
        });
        datosPersonales.add(primernombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 220, -1));

        segundonombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        segundonombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        segundonombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                segundonombreKeyReleased(evt);
            }
        });
        datosPersonales.add(segundonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 220, -1));

        primerapellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        primerapellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        primerapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                primerapellidoKeyReleased(evt);
            }
        });
        datosPersonales.add(primerapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 220, -1));

        segundoapellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        segundoapellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        segundoapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                segundoapellidoKeyReleased(evt);
            }
        });
        datosPersonales.add(segundoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 220, -1));

        cedula.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });
        datosPersonales.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, -1));

        tituloobtenido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tituloobtenido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        tituloobtenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tituloobtenidoKeyReleased(evt);
            }
        });
        datosPersonales.add(tituloobtenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 220, -1));

        lugarnacimiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lugarnacimiento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        lugarnacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lugarnacimientoKeyReleased(evt);
            }
        });
        datosPersonales.add(lugarnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, -1));

        telefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        telefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        datosPersonales.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 220, -1));

        otrotelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        otrotelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        otrotelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                otrotelefonoKeyTyped(evt);
            }
        });
        datosPersonales.add(otrotelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 220, -1));

        correo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        correo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                correoKeyReleased(evt);
            }
        });
        datosPersonales.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 220, -1));

        municipio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        municipio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        municipio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                municipioKeyReleased(evt);
            }
        });
        datosPersonales.add(municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 220, -1));

        estadocivil.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estadocivil.setForeground(new java.awt.Color(0, 0, 51));
        estadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLTERO(A)", "CASADO(A)", "VIUDO(A)", "CONCUBINATO" }));
        estadocivil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPersonales.add(estadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 260, -1));

        genero.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        genero.setForeground(new java.awt.Color(0, 0, 51));
        genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        genero.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPersonales.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 260, -1));

        gruposanguineo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gruposanguineo.setForeground(new java.awt.Color(0, 0, 51));
        gruposanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        gruposanguineo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPersonales.add(gruposanguineo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 260, -1));

        fechanacimiento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        fechanacimiento.setDateFormatString("dd-MM-yyyy");
        fechanacimiento.setMinSelectableDate(new java.util.Date(-62135751487000L));
        datosPersonales.add(fechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 107, -1, -1));

        otrotitulo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        otrotitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 51)));
        otrotitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                otrotituloKeyReleased(evt);
            }
        });
        datosPersonales.add(otrotitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 220, -1));

        jLabel46.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel46.setText("- GRUPO SANGUINEO:");
        datosPersonales.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 20));

        estado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISTRITO CAPITAL", "AMAZONAS", "ANZOÁTEGUI", "APURE", "ARAGUA", "BARINAS", "BOLÍVAR", "CARABOBO", "COJEDES", "DELTA AMACURO", "FALCÓN", "GUÁRICO", "LA GUAIRA", "LARA", "MÉRIDA", "MIRANDA", "MONAGAS", "NUEVA ESPARTA", "PORTUGUESA", "SUCRE", "TÁCHIRA", "TRUJILLO", "YARACUY", "ZULIA" }));
        estado.setSelectedIndex(9);
        estado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPersonales.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 260, -1));

        nivelacademico.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nivelacademico.setForeground(new java.awt.Color(0, 0, 51));
        nivelacademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO BACHILLER", "BACHILLER", "TÉCNICO MEDIO", "TÉCNICO SUPERIOR UNIVERSITARIO", "LICENCIADO(A)", "INGENIERO(A)", "ABOGADO", "PROFESOR(A)", "MEDICO", "ESPECIALIDAD", "MAGISTER", "DOCTORADO" }));
        nivelacademico.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPersonales.add(nivelacademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 260, -1));

        BTN_FOTO.setBackground(new java.awt.Color(102, 102, 102));
        BTN_FOTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_FOTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_pictures_folder_16px.png"))); // NOI18N
        BTN_FOTO.setText("FOTO");
        BTN_FOTO.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datosPersonales.add(BTN_FOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 160, 30));

        tabbed.addTab("DATOS PERSONALES", datosPersonales);

        datosPoliciales.setBackground(new java.awt.Color(255, 255, 255));
        datosPoliciales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        datosPoliciales.add(foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jLabel60.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel60.setText("- RANGO:");
        datosPoliciales.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel63.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel63.setText("- FECHA DE INGRESO:");
        datosPoliciales.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel66.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel66.setText("- FECHA DE ASCENSO:");
        datosPoliciales.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel69.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel69.setText("- CODIGO DEL CARNET:");
        datosPoliciales.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel71.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel71.setText("- CONDICIÓN:");
        datosPoliciales.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jLabel75.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel75.setText("- MUNICIPIO:");
        datosPoliciales.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel77.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel77.setText("- TALLA DE CAMISA:");
        datosPoliciales.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));

        jLabel80.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel80.setText("- TALLA DE PANTALON:");
        datosPoliciales.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel83.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel83.setText("- TALLA DE ZAPATO:");
        datosPoliciales.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 20));

        jLabel86.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel86.setText("- TALLA DE GORRA:");
        datosPoliciales.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        codigocarnet.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        codigocarnet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(codigocarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 180, -1));

        camisa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        camisa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        camisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                camisaKeyReleased(evt);
            }
        });
        datosPoliciales.add(camisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 180, -1));

        pantalon.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        pantalon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        pantalon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pantalonKeyReleased(evt);
            }
        });
        datosPoliciales.add(pantalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 180, -1));

        gorra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gorra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        gorra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gorraKeyTyped(evt);
            }
        });
        datosPoliciales.add(gorra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 180, -1));

        zapato.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        zapato.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        zapato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                zapatoKeyTyped(evt);
            }
        });
        datosPoliciales.add(zapato, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 180, -1));

        rango.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OFICIAL", "PRIMER OFICIAL", "OFICIAL JEFE", "INSPECTOR", "PRIMER INSPECTOR", "INSPECTOR JEFE", "COMISARIO", "PRIMER COMISARIO", "COMISARIO JEFE" }));
        rango.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 240, -1));

        municipiotrabajo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        municipiotrabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "TUCUPITA", "CASACOIMA", "ANTONIO DIAZ", "PEDERNALES" }));
        municipiotrabajo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(municipiotrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 240, -1));

        txtServicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtServicio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 190, 20));

        fechaascenso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        fechaascenso.setDateFormatString("dd-MM-yyyy");
        fechaascenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datosPoliciales.add(fechaascenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 110, 20));

        fechaingreso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        fechaingreso.setDateFormatString("dd-MM-yyyy");
        fechaingreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datosPoliciales.add(fechaingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 110, 20));

        condicion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        condicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABANDONO", "ACTIVO", "BAJA", "IVSS", "PERMISO", "PRIVADO DE LIBERTAD", "REPOSO", "SUSPENDIDO", "VACACIONES" }));
        condicion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(condicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 240, -1));

        jpanel_motivoegreso.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_motivoegreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOTIVO DE EGRESO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jpanel_motivoegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jpanel_motivoegreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel64.setText("- FECHA DE EGRESO:");
        jpanel_motivoegreso.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        fechaegreso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        fechaegreso.setDateFormatString("dd-MM-yyyy");
        fechaegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jpanel_motivoegreso.add(fechaegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, 20));

        motivoegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        motivoegreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PROPIA SOLICITUD", "DESTITUCIÓN", "FALLECIMIENTO", "JUBILADO(A)" }));
        motivoegreso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        jpanel_motivoegreso.add(motivoegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 170, -1));

        jLabel67.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel67.setText("- MOTIVO:");
        jpanel_motivoegreso.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel65.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel65.setText("- OBSERVACIÓN:");
        jpanel_motivoegreso.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        observacionegreso.setColumns(20);
        observacionegreso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        observacionegreso.setForeground(new java.awt.Color(102, 102, 102));
        observacionegreso.setLineWrap(true);
        observacionegreso.setRows(5);
        observacionegreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observacionegresoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(observacionegreso);

        jpanel_motivoegreso.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 320, 80));

        datosPoliciales.add(jpanel_motivoegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 600, 190));

        jLabel78.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel78.setText("- SERVICIO:");
        datosPoliciales.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        btnAgregarServicio.setBackground(new java.awt.Color(102, 102, 102));
        btnAgregarServicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarServicio.setText("+");
        btnAgregarServicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnAgregarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarServicioMouseClicked(evt);
            }
        });
        datosPoliciales.add(btnAgregarServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 30, 20));

        tabbed.addTab("DATOS POLICIAL", datosPoliciales);

        familiares.setBackground(new java.awt.Color(255, 255, 255));
        familiares.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel181.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel181.setText("- INFORMACIÓN FAMILIAR");
        familiares.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        familiares.add(foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        ListadoFamilia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ListadoFamilia.setForeground(new java.awt.Color(51, 51, 51));
        ListadoFamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListadoFamilia.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane12.setViewportView(ListadoFamilia);

        familiares.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        BTN_AGREGARFAMILIA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_AGREGARFAMILIA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGARFAMILIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        BTN_AGREGARFAMILIA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        familiares.add(BTN_AGREGARFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 40, 30));

        BTN_ELIMINARFAMILIA.setBackground(new java.awt.Color(204, 0, 0));
        BTN_ELIMINARFAMILIA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ELIMINARFAMILIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        BTN_ELIMINARFAMILIA.setText("ELIMINAR");
        BTN_ELIMINARFAMILIA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BTN_ELIMINARFAMILIA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BTN_ELIMINARFAMILIA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        familiares.add(BTN_ELIMINARFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 120, 30));

        BTN_VERFAMILIA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_VERFAMILIA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VERFAMILIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_view_24px.png"))); // NOI18N
        BTN_VERFAMILIA.setText("VER");
        BTN_VERFAMILIA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BTN_VERFAMILIA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BTN_VERFAMILIA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        familiares.add(BTN_VERFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        BTN_EDITARFAMILIA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_EDITARFAMILIA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_EDITARFAMILIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_edit_file_24px.png"))); // NOI18N
        BTN_EDITARFAMILIA.setText("EDITAR");
        BTN_EDITARFAMILIA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BTN_EDITARFAMILIA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BTN_EDITARFAMILIA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        familiares.add(BTN_EDITARFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("FAMILIARES", familiares);

        experienciaPolicial.setBackground(new java.awt.Color(255, 255, 255));
        experienciaPolicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel188.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel188.setText("- INFORMACIÓN EXPERIENCIA POLICIAL");
        experienciaPolicial.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        experienciaPolicial.add(foto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        listadoExperiencia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoExperiencia.setForeground(new java.awt.Color(51, 51, 51));
        listadoExperiencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoExperiencia.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane18.setViewportView(listadoExperiencia);

        experienciaPolicial.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        btnRegistrarExp.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarExp.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarExp.setText("REGISTRAR");
        btnRegistrarExp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarExp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarExp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        experienciaPolicial.add(btnRegistrarExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarExp.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarExp.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarExp.setText("ELIMINAR");
        btnEliminarExp.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarExp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarExp.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        experienciaPolicial.add(btnEliminarExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("EXPERIENCIA POLICIAL", experienciaPolicial);

        ascenso.setBackground(new java.awt.Color(255, 255, 255));
        ascenso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoAscenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoAscenso.setForeground(new java.awt.Color(51, 51, 51));
        listadoAscenso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoAscenso.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane25.setViewportView(listadoAscenso);

        ascenso.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel195.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel195.setText("- INFORMACIÓN ASCENSOS");
        ascenso.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ascenso.add(foto12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarAscenso.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarAscenso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarAscenso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarAscenso.setText("REGISTRAR");
        btnRegistrarAscenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarAscenso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarAscenso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ascenso.add(btnRegistrarAscenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarAscenso.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarAscenso.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAscenso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarAscenso.setText("ELIMINAR");
        btnEliminarAscenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarAscenso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarAscenso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ascenso.add(btnEliminarAscenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("ASCENSOS", ascenso);

        medidasDisciplinaria.setBackground(new java.awt.Color(255, 255, 255));
        medidasDisciplinaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel189.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel189.setText("- INFORMACIÓN MEDIDAS DICIPLINARIAS");
        medidasDisciplinaria.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        ListadoSanciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ListadoSanciones.setForeground(new java.awt.Color(51, 51, 51));
        ListadoSanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListadoSanciones.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane19.setViewportView(ListadoSanciones);

        medidasDisciplinaria.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        foto5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        medidasDisciplinaria.add(foto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btn_registrarMD.setBackground(new java.awt.Color(102, 102, 102));
        btn_registrarMD.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrarMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btn_registrarMD.setText("REGISTRAR");
        btn_registrarMD.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_registrarMD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_registrarMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        medidasDisciplinaria.add(btn_registrarMD, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btn_eliminarMD.setBackground(new java.awt.Color(204, 0, 0));
        btn_eliminarMD.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminarMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btn_eliminarMD.setText("ELIMINAR");
        btn_eliminarMD.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_eliminarMD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_eliminarMD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        medidasDisciplinaria.add(btn_eliminarMD, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("MEDIDAS DISCIPLINARIA", medidasDisciplinaria);

        vacaciones.setBackground(new java.awt.Color(255, 255, 255));
        vacaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoVacaciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoVacaciones.setForeground(new java.awt.Color(51, 51, 51));
        listadoVacaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoVacaciones.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane20.setViewportView(listadoVacaciones);

        vacaciones.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel190.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel190.setText("- INFORMACIÓN VACACIONES");
        vacaciones.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vacaciones.add(foto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarVacaciones.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarVacaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarVacaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarVacaciones.setText("REGISTRAR");
        btnRegistrarVacaciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarVacaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarVacaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        vacaciones.add(btnRegistrarVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarVacaciones.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarVacaciones.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarVacaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarVacaciones.setText("ELIMINAR");
        btnEliminarVacaciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarVacaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarVacaciones.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        vacaciones.add(btnEliminarVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("VACACIONES", vacaciones);

        permisos.setBackground(new java.awt.Color(255, 255, 255));
        permisos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoPermisos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoPermisos.setForeground(new java.awt.Color(51, 51, 51));
        listadoPermisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoPermisos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane21.setViewportView(listadoPermisos);

        permisos.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel191.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel191.setText("- INFORMACIÓN PERMISOS");
        permisos.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        permisos.add(foto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarPermisos.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarPermisos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarPermisos.setText("REGISTRAR");
        btnRegistrarPermisos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarPermisos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarPermisos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        permisos.add(btnRegistrarPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarPermisos.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarPermisos.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarPermisos.setText("ELIMINAR");
        btnEliminarPermisos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarPermisos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarPermisos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        permisos.add(btnEliminarPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("PERMISOS", permisos);

        reposos.setBackground(new java.awt.Color(255, 255, 255));
        reposos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoReposo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoReposo.setForeground(new java.awt.Color(51, 51, 51));
        listadoReposo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoReposo.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane22.setViewportView(listadoReposo);

        reposos.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel192.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel192.setText("- INFORMACIÓN REPOSOS");
        reposos.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reposos.add(foto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarReposo.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarReposo.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarReposo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarReposo.setText("REGISTRAR");
        btnRegistrarReposo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarReposo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarReposo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        reposos.add(btnRegistrarReposo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarReposo.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarReposo.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarReposo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarReposo.setText("ELIMINAR");
        btnEliminarReposo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarReposo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarReposo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        reposos.add(btnEliminarReposo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("REPOSOS", reposos);

        cursos.setBackground(new java.awt.Color(255, 255, 255));
        cursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoCursos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoCursos.setForeground(new java.awt.Color(51, 51, 51));
        listadoCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoCursos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane23.setViewportView(listadoCursos);

        cursos.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel193.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel193.setText("- INFORMACIÓN CURSOS");
        cursos.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cursos.add(foto9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarCursos.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarCursos.setText("REGISTRAR");
        btnRegistrarCursos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarCursos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cursos.add(btnRegistrarCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarCursos.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarCursos.setText("ELIMINAR");
        btnEliminarCursos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarCursos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cursos.add(btnEliminarCursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("CURSOS", cursos);

        estudios.setBackground(new java.awt.Color(255, 255, 255));
        estudios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoEstudios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoEstudios.setForeground(new java.awt.Color(51, 51, 51));
        listadoEstudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TIPO", "MOTIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listadoEstudios.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane24.setViewportView(listadoEstudios);

        estudios.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel194.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel194.setText("- INFORMACIÓN ESTUDIOS");
        estudios.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        estudios.add(foto10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        btnRegistrarEstudios.setBackground(new java.awt.Color(102, 102, 102));
        btnRegistrarEstudios.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEstudios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_book_24px.png"))); // NOI18N
        btnRegistrarEstudios.setText("REGISTRAR");
        btnRegistrarEstudios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnRegistrarEstudios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistrarEstudios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        estudios.add(btnRegistrarEstudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        btnEliminarEstudios.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminarEstudios.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarEstudios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_delete_trash_24px.png"))); // NOI18N
        btnEliminarEstudios.setText("ELIMINAR");
        btnEliminarEstudios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminarEstudios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminarEstudios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        estudios.add(btnEliminarEstudios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 120, 30));

        tabbed.addTab("ESTUDIOS", estudios);

        nomina.setBackground(new java.awt.Color(255, 255, 255));
        nomina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nomina.add(foto11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jLabel140.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel140.setText("- BANCO:");
        nomina.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel143.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel143.setText("- ESTATUS:");
        nomina.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        banco.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        banco.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        banco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bancoKeyReleased(evt);
            }
        });
        nomina.add(banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 290, -1));

        numerocuenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        numerocuenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        numerocuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numerocuentaKeyTyped(evt);
            }
        });
        nomina.add(numerocuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 290, -1));

        jLabel144.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel144.setText("- CUENTA:");
        nomina.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        estatus.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estatus.setForeground(new java.awt.Color(0, 0, 51));
        estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CON GOCE DE SUELDO ", "SIN GOCE DE SUELDO" }));
        estatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        nomina.add(estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 260, -1));

        tabbed.addTab("NOMINA", nomina);

        jPanel1.add(tabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 680, 530));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_no_16px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EDITAR INFORMACÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 526, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xx, xy;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void camisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camisaKeyReleased
        TextoMayuscula texto = new TextoMayuscula(camisa);
        texto.keyReleased(evt);
    }//GEN-LAST:event_camisaKeyReleased

    private void pantalonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pantalonKeyReleased
        TextoMayuscula texto = new TextoMayuscula(pantalon);
        texto.keyReleased(evt);
    }//GEN-LAST:event_pantalonKeyReleased

    private void zapatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_zapatoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_zapatoKeyTyped

    private void gorraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gorraKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_gorraKeyTyped

    private void observacionegresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observacionegresoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(observacionegreso);
        texto.keyReleased(evt);
    }//GEN-LAST:event_observacionegresoKeyReleased

    private void bancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bancoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(banco);
        texto.keyReleased(evt);
    }//GEN-LAST:event_bancoKeyReleased

    private void numerocuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numerocuentaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_numerocuentaKeyTyped

    private void otrotituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otrotituloKeyReleased
        TextoMayuscula texto = new TextoMayuscula(otrotitulo);
        texto.keyReleased(evt);
    }//GEN-LAST:event_otrotituloKeyReleased

    private void municipioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_municipioKeyReleased
        TextoMayuscula texto = new TextoMayuscula(municipio);
        texto.keyReleased(evt);
    }//GEN-LAST:event_municipioKeyReleased

    private void correoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(correo);
        texto.keyReleased(evt);
    }//GEN-LAST:event_correoKeyReleased

    private void otrotelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_otrotelefonoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_otrotelefonoKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void lugarnacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lugarnacimientoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(lugarnacimiento);
        texto.keyReleased(evt);
    }//GEN-LAST:event_lugarnacimientoKeyReleased

    private void tituloobtenidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloobtenidoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(tituloobtenido);
        texto.keyReleased(evt);
    }//GEN-LAST:event_tituloobtenidoKeyReleased

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_cedulaKeyTyped

    private void segundoapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_segundoapellidoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(segundoapellido);
        texto.keyReleased(evt);
    }//GEN-LAST:event_segundoapellidoKeyReleased

    private void primerapellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_primerapellidoKeyReleased
        TextoMayuscula texto = new TextoMayuscula(primerapellido);
        texto.keyReleased(evt);
    }//GEN-LAST:event_primerapellidoKeyReleased

    private void segundonombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_segundonombreKeyReleased
        TextoMayuscula texto = new TextoMayuscula(segundonombre);
        texto.keyReleased(evt);
    }//GEN-LAST:event_segundonombreKeyReleased

    private void primernombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_primernombreKeyReleased
        TextoMayuscula texto = new TextoMayuscula(primernombre);
        texto.keyReleased(evt);
    }//GEN-LAST:event_primernombreKeyReleased

    private void parroquiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parroquiaKeyReleased
        TextoMayuscula texto = new TextoMayuscula(parroquia);
        texto.keyReleased(evt);
    }//GEN-LAST:event_parroquiaKeyReleased

    private void direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyReleased
        TextoMayuscula texto = new TextoMayuscula(direccion);
        texto.keyReleased(evt);
    }//GEN-LAST:event_direccionKeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnAgregarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarServicioMouseClicked
 
        
    }//GEN-LAST:event_btnAgregarServicioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.componentes.BTN BTN_AGREGARFAMILIA;
    private view.componentes.BTN BTN_EDITARFAMILIA;
    private view.componentes.BTN BTN_ELIMINARFAMILIA;
    private view.componentes.BTN BTN_FOTO;
    private view.componentes.BTN BTN_GUARDAR;
    private view.componentes.BTN BTN_VERFAMILIA;
    public javax.swing.JTable ListadoFamilia;
    public javax.swing.JTable ListadoSanciones;
    private javax.swing.JPanel ascenso;
    private javax.swing.JTextField banco;
    private view.componentes.BTN btnAgregarServicio;
    private view.componentes.BTN btnEliminarAscenso;
    private view.componentes.BTN btnEliminarCursos;
    private view.componentes.BTN btnEliminarEstudios;
    private view.componentes.BTN btnEliminarExp;
    private view.componentes.BTN btnEliminarPermisos;
    private view.componentes.BTN btnEliminarReposo;
    private view.componentes.BTN btnEliminarVacaciones;
    private view.componentes.BTN btnRegistrarAscenso;
    private view.componentes.BTN btnRegistrarCursos;
    private view.componentes.BTN btnRegistrarEstudios;
    private view.componentes.BTN btnRegistrarExp;
    private view.componentes.BTN btnRegistrarPermisos;
    private view.componentes.BTN btnRegistrarReposo;
    private view.componentes.BTN btnRegistrarVacaciones;
    private view.componentes.BTN btn_eliminarMD;
    private view.componentes.BTN btn_registrarMD;
    private javax.swing.JTextField camisa;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField codigocarnet;
    private javax.swing.JComboBox<String> condicion;
    private javax.swing.JTextField correo;
    private javax.swing.JPanel cursos;
    private javax.swing.JPanel datosPersonales;
    private javax.swing.JPanel datosPoliciales;
    private javax.swing.JTextArea direccion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JComboBox<String> estadocivil;
    private javax.swing.JComboBox<String> estatus;
    private javax.swing.JPanel estudios;
    private javax.swing.JPanel experienciaPolicial;
    private javax.swing.JPanel familiares;
    private com.toedter.calendar.JDateChooser fechaascenso;
    private com.toedter.calendar.JDateChooser fechaegreso;
    private com.toedter.calendar.JDateChooser fechaingreso;
    private com.toedter.calendar.JDateChooser fechanacimiento;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto10;
    private javax.swing.JLabel foto11;
    private javax.swing.JLabel foto12;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel foto3;
    private javax.swing.JLabel foto4;
    private javax.swing.JLabel foto5;
    private javax.swing.JLabel foto6;
    private javax.swing.JLabel foto7;
    private javax.swing.JLabel foto8;
    private javax.swing.JLabel foto9;
    private javax.swing.JComboBox<String> genero;
    private javax.swing.JTextField gorra;
    private javax.swing.JComboBox<String> gruposanguineo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanel_motivoegreso;
    public javax.swing.JTable listadoAscenso;
    public javax.swing.JTable listadoCursos;
    public javax.swing.JTable listadoEstudios;
    public javax.swing.JTable listadoExperiencia;
    public javax.swing.JTable listadoPermisos;
    public javax.swing.JTable listadoReposo;
    public javax.swing.JTable listadoVacaciones;
    private javax.swing.JTextField lugarnacimiento;
    private javax.swing.JPanel medidasDisciplinaria;
    private javax.swing.JComboBox<String> motivoegreso;
    private javax.swing.JTextField municipio;
    private javax.swing.JComboBox<String> municipiotrabajo;
    private javax.swing.JComboBox<String> nivelacademico;
    private javax.swing.JPanel nomina;
    private javax.swing.JTextField numerocuenta;
    private javax.swing.JTextArea observacionegreso;
    private javax.swing.JTextField otrotelefono;
    private javax.swing.JTextField otrotitulo;
    private javax.swing.JTextField pantalon;
    private javax.swing.JTextField parroquia;
    private javax.swing.JPanel permisos;
    private javax.swing.JTextField primerapellido;
    private javax.swing.JTextField primernombre;
    private javax.swing.JComboBox<String> rango;
    private javax.swing.JPanel reposos;
    private javax.swing.JTextField segundoapellido;
    private javax.swing.JTextField segundonombre;
    public javax.swing.JTabbedPane tabbed;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField tituloobtenido;
    private javax.swing.JLabel txtServicio;
    private javax.swing.JPanel vacaciones;
    private javax.swing.JTextField zapato;
    // End of variables declaration//GEN-END:variables
}
