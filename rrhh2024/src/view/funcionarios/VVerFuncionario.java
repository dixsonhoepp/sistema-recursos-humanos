/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.funcionarios;

import com.formdev.flatlaf.FlatLightLaf;
import evento.funcionario.reportePDF.ConstanciaTrabajo;
import evento.funcionario.reportePDF.ConstanciaUbicacion;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import view.componentes.BTN;

/**
 *
 * @author Dixson
 */
public class VVerFuncionario extends javax.swing.JDialog {

    public static int IDFuncionario;

    public VVerFuncionario(JFrame v, boolean modal) {

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
        jtable.getTableHeader().setBackground(new Color(51, 51, 51));
        jtable.getTableHeader().setForeground(Color.WHITE);
    }

    public JLabel getBanco() {
        return banco;
    }

    public JLabel getCamisa() {
        return camisa;
    }

    public JLabel getCedula() {
        return cedula;
    }

    public JLabel getCodigocarnet() {
        return codigocarnet;
    }

    public JLabel getCondicion() {
        return condicion;
    }

    public JLabel getCorreo() {
        return correo;
    }

    public JTextArea getDireccion() {
        return direccion;
    }

    public JLabel getEstado() {
        return estado;
    }

    public JLabel getEstadocivil() {
        return estadocivil;
    }

    public JLabel getFechaascenso() {
        return fechaascenso;
    }

    public JLabel getFechaingreso() {
        return fechaingreso;
    }

    public JLabel getFechanacimiento() {
        return fechanacimiento;
    }

    public JLabel getFoto1() {
        return foto1;
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

    public JLabel getGenero() {
        return genero;
    }

    public JLabel getGorra() {
        return gorra;
    }

    public JLabel getGruposanguineo() {
        return gruposanguineo;
    }

    public JLabel getLugarnacimiento() {
        return lugarnacimiento;
    }

    public JLabel getMunicipio() {
        return municipio;
    }

    public JLabel getMunicipiotrabajo() {
        return municipiotrabajo;
    }

    public JLabel getNivelacademico() {
        return nivelacademico;
    }

    public JLabel getNumerocuenta() {
        return numerocuenta;
    }

    public JLabel getOtrotelefono() {
        return otrotelefono;
    }

    public JLabel getOtrotitulo() {
        return otrotitulo;
    }

    public JLabel getPantalon() {
        return pantalon;
    }

    public JLabel getParroquia() {
        return parroquia;
    }

    public JLabel getPrimerapellido() {
        return primerapellido;
    }

    public JLabel getPrimernombre() {
        return primernombre;
    }

    public JLabel getRango() {
        return rango;
    }

    public JLabel getSegundoapellido() {
        return segundoapellido;
    }

    public JLabel getSegundonombre() {
        return segundonombre;
    }

    public JLabel getServicio() {
        return servicio;
    }

    public JLabel getTelefono() {
        return telefono;
    }

    public JLabel getTituloobtenido() {
        return tituloobtenido;
    }

    public JLabel getZapato() {
        return zapato;
    }

    public JLabel getFechaegreso() {
        return fechaegreso;
    }

    public JPanel getJpanel_motivoegreso() {
        return jpanel_motivoegreso;
    }

    public JLabel getMotivoegreso() {
        return motivoegreso;
    }

    public JTextArea getObservacionegreso() {
        return observacionegreso;
    }

    public BTN getBTN_VERFAMILIA() {
        return BTN_VERFAMILIA;
    }

    public JLabel getEstatus() {
        return estatus;
    }

    public BTN getBtnConstancia() {
        return btnConstancia;
    }

    public BTN getBtnNombramiento() {
        return btnNombramiento;
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane = new javax.swing.JTabbedPane();
        datosPersonales = new javax.swing.JPanel();
        foto1 = new javax.swing.JLabel();
        primernombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        segundonombre = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        primerapellido = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        segundoapellido = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cedula = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fechanacimiento = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lugarnacimiento = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        estadocivil = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        genero = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nivelacademico = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        tituloobtenido = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        otrotitulo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        otrotelefono = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        municipio = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        parroquia = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        gruposanguineo = new javax.swing.JLabel();
        btnNombramiento = new view.componentes.BTN();
        btnConstancia = new view.componentes.BTN();
        datosPoliciales = new javax.swing.JPanel();
        foto2 = new javax.swing.JLabel();
        rango = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        fechaingreso = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        fechaascenso = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        codigocarnet = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        municipiotrabajo = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        condicion = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        servicio = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        camisa = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        pantalon = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        zapato = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        gorra = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jpanel_motivoegreso = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        observacionegreso = new javax.swing.JTextArea();
        motivoegreso = new javax.swing.JLabel();
        fechaegreso = new javax.swing.JLabel();
        familiares = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        foto3 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ListadoFamilia = new javax.swing.JTable();
        BTN_VERFAMILIA = new view.componentes.BTN();
        experienciaPolicial = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        foto4 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        listadoExperiencia = new javax.swing.JTable();
        ascenso = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        listadoAscenso = new javax.swing.JTable();
        jLabel195 = new javax.swing.JLabel();
        foto5 = new javax.swing.JLabel();
        medidasDisciplinaria = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        ListadoSanciones = new javax.swing.JTable();
        foto6 = new javax.swing.JLabel();
        vacaciones = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        listadoVacaciones = new javax.swing.JTable();
        jLabel190 = new javax.swing.JLabel();
        foto7 = new javax.swing.JLabel();
        permisos = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        listadoPermisos = new javax.swing.JTable();
        jLabel191 = new javax.swing.JLabel();
        foto8 = new javax.swing.JLabel();
        reposos = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        listadoReposo = new javax.swing.JTable();
        jLabel192 = new javax.swing.JLabel();
        foto9 = new javax.swing.JLabel();
        cursos = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        listadoCursos = new javax.swing.JTable();
        jLabel193 = new javax.swing.JLabel();
        foto10 = new javax.swing.JLabel();
        estudios = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        listadoEstudios = new javax.swing.JTable();
        jLabel194 = new javax.swing.JLabel();
        foto11 = new javax.swing.JLabel();
        nomina = new javax.swing.JPanel();
        estatus = new javax.swing.JLabel();
        estatus1 = new javax.swing.JLabel();
        foto12 = new javax.swing.JLabel();
        numerocuenta = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        banco = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INFORMACIÓN");
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMACIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 526, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 680, 10));

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        datosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        datosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datosPersonales.add(foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        primernombre.setBackground(new java.awt.Color(0, 0, 51));
        primernombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        primernombre.setForeground(new java.awt.Color(102, 102, 102));
        primernombre.setText("DIXSON");
        datosPersonales.add(primernombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 310, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("- PRIMER NOMBRE:");
        datosPersonales.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel5.setBackground(new java.awt.Color(249, 249, 249));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setOpaque(true);
        datosPersonales.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 20));

        segundonombre.setBackground(new java.awt.Color(0, 0, 51));
        segundonombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        segundonombre.setForeground(new java.awt.Color(102, 102, 102));
        segundonombre.setText("GABRIEL");
        datosPersonales.add(segundonombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 310, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("- SEGUNDO NOMBRE:");
        datosPersonales.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setOpaque(true);
        datosPersonales.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 20));

        primerapellido.setBackground(new java.awt.Color(0, 0, 51));
        primerapellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        primerapellido.setForeground(new java.awt.Color(102, 102, 102));
        primerapellido.setText("HOEPP");
        datosPersonales.add(primerapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 310, 20));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel11.setText("- PRIMER APELLIDO:");
        datosPersonales.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel9.setBackground(new java.awt.Color(249, 249, 249));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setOpaque(true);
        datosPersonales.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 20));

        segundoapellido.setBackground(new java.awt.Color(0, 0, 51));
        segundoapellido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        segundoapellido.setForeground(new java.awt.Color(102, 102, 102));
        segundoapellido.setText("MARCANO");
        datosPersonales.add(segundoapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 310, 20));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel13.setText("- SEGUNDO APELLIDO:");
        datosPersonales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setOpaque(true);
        datosPersonales.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, 20));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel15.setText("- CÉDULA DE IDENTIDAD:");
        datosPersonales.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        cedula.setBackground(new java.awt.Color(0, 0, 51));
        cedula.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        cedula.setForeground(new java.awt.Color(102, 102, 102));
        cedula.setText("19402417");
        datosPersonales.add(cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 310, 20));

        jLabel17.setBackground(new java.awt.Color(249, 249, 249));
        jLabel17.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel17.setOpaque(true);
        datosPersonales.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 490, 20));

        fechanacimiento.setBackground(new java.awt.Color(0, 0, 51));
        fechanacimiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fechanacimiento.setForeground(new java.awt.Color(102, 102, 102));
        fechanacimiento.setText("08/04/1989");
        datosPersonales.add(fechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 310, 20));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel19.setText("- FECHA DE NACIMIENTO:");
        datosPersonales.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel20.setOpaque(true);
        datosPersonales.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 490, 20));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel21.setText("- LUGAR DE NACIMIENTO:");
        datosPersonales.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        lugarnacimiento.setBackground(new java.awt.Color(0, 0, 51));
        lugarnacimiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lugarnacimiento.setForeground(new java.awt.Color(102, 102, 102));
        lugarnacimiento.setText("TUCUPITA");
        datosPersonales.add(lugarnacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 310, 20));

        jLabel23.setBackground(new java.awt.Color(249, 249, 249));
        jLabel23.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel23.setOpaque(true);
        datosPersonales.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 490, 20));

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel24.setText("- ESTADO CIVIL:");
        datosPersonales.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        estadocivil.setBackground(new java.awt.Color(0, 0, 51));
        estadocivil.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estadocivil.setForeground(new java.awt.Color(102, 102, 102));
        estadocivil.setText("SOLTERO(A)");
        datosPersonales.add(estadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 310, 20));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel26.setOpaque(true);
        datosPersonales.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 490, 20));

        jLabel27.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel27.setText("- GENERO:");
        datosPersonales.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        genero.setBackground(new java.awt.Color(0, 0, 51));
        genero.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        genero.setForeground(new java.awt.Color(102, 102, 102));
        genero.setText("M");
        datosPersonales.add(genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 310, 20));

        jLabel29.setBackground(new java.awt.Color(249, 249, 249));
        jLabel29.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel29.setOpaque(true);
        datosPersonales.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 490, 20));

        jLabel30.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel30.setText("- NIVEL ACADEMICO:");
        datosPersonales.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        nivelacademico.setBackground(new java.awt.Color(0, 0, 51));
        nivelacademico.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        nivelacademico.setForeground(new java.awt.Color(102, 102, 102));
        nivelacademico.setText("INGENIERO");
        datosPersonales.add(nivelacademico, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 310, 20));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel32.setOpaque(true);
        datosPersonales.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 490, 20));

        jLabel33.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel33.setText("- TITULO OBTENIDO:");
        datosPersonales.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        tituloobtenido.setBackground(new java.awt.Color(0, 0, 51));
        tituloobtenido.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tituloobtenido.setForeground(new java.awt.Color(102, 102, 102));
        tituloobtenido.setText("INGENIERO EN INFORMATICA");
        datosPersonales.add(tituloobtenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 310, 20));

        jLabel35.setBackground(new java.awt.Color(249, 249, 249));
        jLabel35.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel35.setOpaque(true);
        datosPersonales.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 490, 20));

        jLabel36.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel36.setText("- OTRO TITULO:");
        datosPersonales.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        otrotitulo.setBackground(new java.awt.Color(0, 0, 51));
        otrotitulo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        otrotitulo.setForeground(new java.awt.Color(102, 102, 102));
        otrotitulo.setText("TSU EN INVESTIGACIÓN PENAL");
        datosPersonales.add(otrotitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 310, 20));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel38.setOpaque(true);
        datosPersonales.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 490, 20));

        jLabel39.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel39.setText("- TELEFONO:");
        datosPersonales.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        telefono.setBackground(new java.awt.Color(0, 0, 51));
        telefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        telefono.setForeground(new java.awt.Color(102, 102, 102));
        telefono.setText("04249190376");
        datosPersonales.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 310, 20));

        jLabel41.setBackground(new java.awt.Color(249, 249, 249));
        jLabel41.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel41.setOpaque(true);
        datosPersonales.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 490, 20));

        jLabel42.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel42.setText("- OTRO TELEFONO:");
        datosPersonales.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        otrotelefono.setBackground(new java.awt.Color(0, 0, 51));
        otrotelefono.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        otrotelefono.setForeground(new java.awt.Color(102, 102, 102));
        otrotelefono.setText("04120885926");
        datosPersonales.add(otrotelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 310, 20));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel44.setOpaque(true);
        datosPersonales.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 490, 20));

        jLabel45.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel45.setText("- CORREO:");
        datosPersonales.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        correo.setBackground(new java.awt.Color(0, 0, 51));
        correo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        correo.setForeground(new java.awt.Color(102, 102, 102));
        correo.setText("DIXSONHOEPP@GMAIL.COM");
        datosPersonales.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 310, 20));

        jLabel47.setBackground(new java.awt.Color(249, 249, 249));
        jLabel47.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel47.setOpaque(true);
        datosPersonales.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 490, 20));

        jLabel48.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel48.setText("- DIRECCIÓN:");
        datosPersonales.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 20));

        jLabel51.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel51.setText("- ESTADO:");
        datosPersonales.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, 20));

        estado.setBackground(new java.awt.Color(0, 0, 51));
        estado.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estado.setForeground(new java.awt.Color(102, 102, 102));
        estado.setText("DELTA AMACURO");
        datosPersonales.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 310, 20));

        jLabel53.setBackground(new java.awt.Color(249, 249, 249));
        jLabel53.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel53.setOpaque(true);
        datosPersonales.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 490, 20));

        jLabel54.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel54.setText("- MUNICIPIO:");
        datosPersonales.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, 20));

        municipio.setBackground(new java.awt.Color(0, 0, 51));
        municipio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        municipio.setForeground(new java.awt.Color(102, 102, 102));
        municipio.setText("TUCUPITA");
        datosPersonales.add(municipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 310, 20));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel56.setOpaque(true);
        datosPersonales.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 490, 20));

        jLabel57.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel57.setText("- PARROQUIA:");
        datosPersonales.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 20));

        parroquia.setBackground(new java.awt.Color(0, 0, 51));
        parroquia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        parroquia.setForeground(new java.awt.Color(102, 102, 102));
        parroquia.setText("SAN JOSE");
        datosPersonales.add(parroquia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 310, 20));

        jLabel59.setBackground(new java.awt.Color(249, 249, 249));
        jLabel59.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel59.setOpaque(true);
        datosPersonales.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 490, 20));

        direccion.setColumns(20);
        direccion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        direccion.setForeground(new java.awt.Color(102, 102, 102));
        direccion.setLineWrap(true);
        direccion.setRows(5);
        direccion.setText("CALLE SAN CRISTOBA, CASA 47, AL FRENTE DEL HOTEL SAN CRISTOBAL");
        direccion.setWrapStyleWord(true);
        direccion.setBorder(null);
        direccion.setEnabled(false);
        jScrollPane2.setViewportView(direccion);

        datosPersonales.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 310, -1));

        jLabel46.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel46.setText("- GRUPO SANGUINEO:");
        datosPersonales.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 20));

        gruposanguineo.setBackground(new java.awt.Color(0, 0, 51));
        gruposanguineo.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        gruposanguineo.setForeground(new java.awt.Color(102, 102, 102));
        gruposanguineo.setText("O+");
        datosPersonales.add(gruposanguineo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 310, 20));

        btnNombramiento.setBackground(new java.awt.Color(204, 0, 51));
        btnNombramiento.setForeground(new java.awt.Color(255, 255, 255));
        btnNombramiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-pdf-22.png"))); // NOI18N
        btnNombramiento.setText("NOMBRAMIENTO");
        btnNombramiento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datosPersonales.add(btnNombramiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 160, 30));

        btnConstancia.setBackground(new java.awt.Color(204, 0, 51));
        btnConstancia.setForeground(new java.awt.Color(255, 255, 255));
        btnConstancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8-pdf-22.png"))); // NOI18N
        btnConstancia.setText("CONSTANCIA");
        btnConstancia.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        datosPersonales.add(btnConstancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 160, 30));

        jTabbedPane.addTab("DATOS PERSONALES", datosPersonales);

        datosPoliciales.setBackground(new java.awt.Color(255, 255, 255));
        datosPoliciales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        datosPoliciales.add(foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        rango.setBackground(new java.awt.Color(0, 0, 51));
        rango.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rango.setForeground(new java.awt.Color(102, 102, 102));
        rango.setText("SUPERVISOR");
        datosPoliciales.add(rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 290, 20));

        jLabel60.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel60.setText("- RANGO:");
        datosPoliciales.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel61.setBackground(new java.awt.Color(249, 249, 249));
        jLabel61.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel61.setOpaque(true);
        datosPoliciales.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 20));

        fechaingreso.setBackground(new java.awt.Color(0, 0, 51));
        fechaingreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fechaingreso.setForeground(new java.awt.Color(102, 102, 102));
        fechaingreso.setText("25/09/2012");
        datosPoliciales.add(fechaingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 290, 20));

        jLabel63.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel63.setText("- FECHA DE INGRESO:");
        datosPoliciales.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel64.setOpaque(true);
        datosPoliciales.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 20));

        fechaascenso.setBackground(new java.awt.Color(0, 0, 51));
        fechaascenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fechaascenso.setForeground(new java.awt.Color(102, 102, 102));
        fechaascenso.setText("16/07/2021");
        datosPoliciales.add(fechaascenso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 290, 20));

        jLabel66.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel66.setText("- FECHA DE ASCENSO:");
        datosPoliciales.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel67.setBackground(new java.awt.Color(249, 249, 249));
        jLabel67.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel67.setOpaque(true);
        datosPoliciales.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 20));

        codigocarnet.setBackground(new java.awt.Color(0, 0, 51));
        codigocarnet.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        codigocarnet.setForeground(new java.awt.Color(102, 102, 102));
        codigocarnet.setText("90000435");
        datosPoliciales.add(codigocarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 290, 20));

        jLabel69.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel69.setText("- CODIGO DEL CARNET:");
        datosPoliciales.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel70.setOpaque(true);
        datosPoliciales.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, 20));

        jLabel90.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel90.setText("- MUNICIPIO:");
        datosPoliciales.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        municipiotrabajo.setBackground(new java.awt.Color(0, 0, 51));
        municipiotrabajo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        municipiotrabajo.setForeground(new java.awt.Color(102, 102, 102));
        municipiotrabajo.setText("TUCUPITA");
        datosPoliciales.add(municipiotrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 290, 20));

        jLabel71.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel71.setText("- CONDICIÓN:");
        datosPoliciales.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        condicion.setBackground(new java.awt.Color(0, 0, 51));
        condicion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        condicion.setForeground(new java.awt.Color(102, 102, 102));
        condicion.setText("ACTIVO");
        datosPoliciales.add(condicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 290, 20));

        jLabel73.setBackground(new java.awt.Color(249, 249, 249));
        jLabel73.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel73.setOpaque(true);
        datosPoliciales.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 490, 20));

        servicio.setBackground(new java.awt.Color(0, 0, 51));
        servicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        servicio.setForeground(new java.awt.Color(102, 102, 102));
        servicio.setText("SERVICIO DE INVESTIGACÓN PENAL");
        datosPoliciales.add(servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 290, 20));

        jLabel75.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel75.setText("- SERVICIO:");
        datosPoliciales.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel76.setOpaque(true);
        datosPoliciales.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 490, 20));

        jLabel77.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel77.setText("- TALLA DE CAMISA:");
        datosPoliciales.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        camisa.setBackground(new java.awt.Color(0, 0, 51));
        camisa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        camisa.setForeground(new java.awt.Color(102, 102, 102));
        camisa.setText("XL");
        datosPoliciales.add(camisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 290, 20));

        jLabel79.setBackground(new java.awt.Color(249, 249, 249));
        jLabel79.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel79.setOpaque(true);
        datosPoliciales.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 490, 20));

        jLabel80.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel80.setText("- TALLA DE PANTALON:");
        datosPoliciales.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        pantalon.setBackground(new java.awt.Color(0, 0, 51));
        pantalon.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        pantalon.setForeground(new java.awt.Color(102, 102, 102));
        pantalon.setText("36");
        datosPoliciales.add(pantalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 290, 20));

        jLabel82.setBackground(new java.awt.Color(255, 255, 255));
        jLabel82.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel82.setOpaque(true);
        datosPoliciales.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 490, 20));

        jLabel83.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel83.setText("- TALLA DE ZAPATO:");
        datosPoliciales.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        zapato.setBackground(new java.awt.Color(0, 0, 51));
        zapato.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        zapato.setForeground(new java.awt.Color(102, 102, 102));
        zapato.setText("41");
        datosPoliciales.add(zapato, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 290, 20));

        jLabel86.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel86.setText("- TALLA DE GORRA:");
        datosPoliciales.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        gorra.setBackground(new java.awt.Color(0, 0, 51));
        gorra.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        gorra.setForeground(new java.awt.Color(102, 102, 102));
        gorra.setText("55");
        datosPoliciales.add(gorra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 290, 20));

        jLabel88.setBackground(new java.awt.Color(255, 255, 255));
        jLabel88.setOpaque(true);
        datosPoliciales.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 490, 20));

        jLabel85.setBackground(new java.awt.Color(249, 249, 249));
        jLabel85.setOpaque(true);
        datosPoliciales.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 490, 20));

        jLabel89.setBackground(new java.awt.Color(249, 249, 249));
        jLabel89.setOpaque(true);
        datosPoliciales.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 490, 20));

        jpanel_motivoegreso.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_motivoegreso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOTIVO DE EGRESO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jpanel_motivoegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jpanel_motivoegreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel65.setText("- FECHA DE EGRESO:");
        jpanel_motivoegreso.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        jLabel68.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel68.setText("- MOTIVO:");
        jpanel_motivoegreso.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel72.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel72.setText("- OBSERVACIÓN:");
        jpanel_motivoegreso.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        observacionegreso.setColumns(20);
        observacionegreso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        observacionegreso.setForeground(new java.awt.Color(102, 102, 102));
        observacionegreso.setLineWrap(true);
        observacionegreso.setRows(5);
        observacionegreso.setEnabled(false);
        jScrollPane4.setViewportView(observacionegreso);

        jpanel_motivoegreso.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 360, 50));

        motivoegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        motivoegreso.setForeground(new java.awt.Color(51, 51, 51));
        motivoegreso.setText("PROPIA SOLICITUD");
        jpanel_motivoegreso.add(motivoegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 310, -1));

        fechaegreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        fechaegreso.setForeground(new java.awt.Color(51, 51, 51));
        fechaegreso.setText("09/05/1989");
        jpanel_motivoegreso.add(fechaegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 310, -1));

        datosPoliciales.add(jpanel_motivoegreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 600, 160));

        jTabbedPane.addTab("DATOS POLICIAL", datosPoliciales);

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
        ListadoFamilia.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ListadoFamilia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane12.setViewportView(ListadoFamilia);
        if (ListadoFamilia.getColumnModel().getColumnCount() > 0) {
            ListadoFamilia.getColumnModel().getColumn(0).setPreferredWidth(50);
            ListadoFamilia.getColumnModel().getColumn(0).setMaxWidth(50);
            ListadoFamilia.getColumnModel().getColumn(2).setPreferredWidth(200);
            ListadoFamilia.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        familiares.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 420));

        BTN_VERFAMILIA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_VERFAMILIA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_VERFAMILIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_view_24px.png"))); // NOI18N
        BTN_VERFAMILIA.setText("VER");
        BTN_VERFAMILIA.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BTN_VERFAMILIA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BTN_VERFAMILIA.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        familiares.add(BTN_VERFAMILIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 120, 30));

        jTabbedPane.addTab("FAMILIARES", familiares);

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

        jTabbedPane.addTab("EXPERIENCIA POLICIAL", experienciaPolicial);

        ascenso.setBackground(new java.awt.Color(255, 255, 255));
        ascenso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listadoAscenso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listadoAscenso.setForeground(new java.awt.Color(51, 51, 51));
        listadoAscenso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        listadoAscenso.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane25.setViewportView(listadoAscenso);

        ascenso.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 380));

        jLabel195.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel195.setText("- INFORMACIÓN ASCENSOS");
        ascenso.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        foto5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ascenso.add(foto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("ASCENSOS", ascenso);

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

        foto6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        medidasDisciplinaria.add(foto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("MEDIDAS DISCIPLINARIA", medidasDisciplinaria);

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

        foto7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vacaciones.add(foto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("VACACIONES", vacaciones);

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

        foto8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        permisos.add(foto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("PERMISOS", permisos);

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

        foto9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reposos.add(foto9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("REPOSOS", reposos);

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

        foto10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cursos.add(foto10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("CURSOS", cursos);

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

        foto11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        estudios.add(foto11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        jTabbedPane.addTab("ESTUDIOS", estudios);

        nomina.setBackground(new java.awt.Color(255, 255, 255));
        nomina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estatus.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estatus.setForeground(new java.awt.Color(102, 102, 102));
        estatus.setText("SIN GOCE DE SUELDO");
        nomina.add(estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 230, 20));

        estatus1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        estatus1.setText("- ESTATUS:");
        nomina.add(estatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        foto12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nomina.add(foto12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 160));

        numerocuenta.setBackground(new java.awt.Color(0, 0, 51));
        numerocuenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        numerocuenta.setForeground(new java.awt.Color(102, 102, 102));
        numerocuenta.setText("01020470450000024518");
        nomina.add(numerocuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 290, 20));

        jLabel140.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel140.setText("- CUENTA BANCARIA:");
        nomina.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel141.setBackground(new java.awt.Color(249, 249, 249));
        jLabel141.setOpaque(true);
        nomina.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 20));

        banco.setBackground(new java.awt.Color(0, 0, 51));
        banco.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        banco.setForeground(new java.awt.Color(102, 102, 102));
        banco.setText("VENEZUELA");
        nomina.add(banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 290, 20));

        jLabel143.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel143.setText("- BANCO:");
        nomina.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel144.setBackground(new java.awt.Color(255, 255, 255));
        jLabel144.setOpaque(true);
        nomina.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 490, 20));

        jLabel147.setBackground(new java.awt.Color(249, 249, 249));
        jLabel147.setOpaque(true);
        nomina.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 490, 20));

        jLabel150.setBackground(new java.awt.Color(255, 255, 255));
        jLabel150.setOpaque(true);
        nomina.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 490, 20));

        jLabel153.setBackground(new java.awt.Color(249, 249, 249));
        jLabel153.setOpaque(true);
        nomina.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 490, 20));

        jLabel156.setBackground(new java.awt.Color(255, 255, 255));
        jLabel156.setOpaque(true);
        nomina.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 490, 20));

        jLabel159.setBackground(new java.awt.Color(249, 249, 249));
        jLabel159.setOpaque(true);
        nomina.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 490, 20));

        jLabel162.setBackground(new java.awt.Color(255, 255, 255));
        jLabel162.setOpaque(true);
        nomina.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 490, 20));

        jLabel165.setBackground(new java.awt.Color(249, 249, 249));
        jLabel165.setOpaque(true);
        nomina.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 490, 20));

        jLabel168.setBackground(new java.awt.Color(255, 255, 255));
        jLabel168.setOpaque(true);
        nomina.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 490, 20));

        jLabel171.setBackground(new java.awt.Color(249, 249, 249));
        jLabel171.setOpaque(true);
        nomina.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 490, 20));

        jTabbedPane.addTab("NOMINA", nomina);

        jPanel1.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 680, 550));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_no_16px.png"))); // NOI18N
        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel92MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VVerFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VVerFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VVerFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VVerFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.componentes.BTN BTN_VERFAMILIA;
    public javax.swing.JTable ListadoFamilia;
    public javax.swing.JTable ListadoSanciones;
    private javax.swing.JPanel ascenso;
    private javax.swing.JLabel banco;
    private view.componentes.BTN btnConstancia;
    private view.componentes.BTN btnNombramiento;
    private javax.swing.JLabel camisa;
    private javax.swing.JLabel cedula;
    private javax.swing.JLabel codigocarnet;
    private javax.swing.JLabel condicion;
    private javax.swing.JLabel correo;
    private javax.swing.JPanel cursos;
    private javax.swing.JPanel datosPersonales;
    private javax.swing.JPanel datosPoliciales;
    private javax.swing.JTextArea direccion;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel estadocivil;
    private javax.swing.JLabel estatus;
    private javax.swing.JLabel estatus1;
    private javax.swing.JPanel estudios;
    private javax.swing.JPanel experienciaPolicial;
    private javax.swing.JPanel familiares;
    private javax.swing.JLabel fechaascenso;
    private javax.swing.JLabel fechaegreso;
    private javax.swing.JLabel fechaingreso;
    private javax.swing.JLabel fechanacimiento;
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
    private javax.swing.JLabel genero;
    private javax.swing.JLabel gorra;
    private javax.swing.JLabel gruposanguineo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
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
    public javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel jpanel_motivoegreso;
    public javax.swing.JTable listadoAscenso;
    public javax.swing.JTable listadoCursos;
    public javax.swing.JTable listadoEstudios;
    public javax.swing.JTable listadoExperiencia;
    public javax.swing.JTable listadoPermisos;
    public javax.swing.JTable listadoReposo;
    public javax.swing.JTable listadoVacaciones;
    private javax.swing.JLabel lugarnacimiento;
    private javax.swing.JPanel medidasDisciplinaria;
    private javax.swing.JLabel motivoegreso;
    private javax.swing.JLabel municipio;
    private javax.swing.JLabel municipiotrabajo;
    private javax.swing.JLabel nivelacademico;
    private javax.swing.JPanel nomina;
    private javax.swing.JLabel numerocuenta;
    private javax.swing.JTextArea observacionegreso;
    private javax.swing.JLabel otrotelefono;
    private javax.swing.JLabel otrotitulo;
    private javax.swing.JLabel pantalon;
    private javax.swing.JLabel parroquia;
    private javax.swing.JPanel permisos;
    private javax.swing.JLabel primerapellido;
    private javax.swing.JLabel primernombre;
    private javax.swing.JLabel rango;
    private javax.swing.JPanel reposos;
    private javax.swing.JLabel segundoapellido;
    private javax.swing.JLabel segundonombre;
    private javax.swing.JLabel servicio;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel tituloobtenido;
    private javax.swing.JPanel vacaciones;
    private javax.swing.JLabel zapato;
    // End of variables declaration//GEN-END:variables
}
