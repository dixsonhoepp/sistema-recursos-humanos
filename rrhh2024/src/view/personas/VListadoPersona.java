package view.personas;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import view.componentes.BTN;

public class VListadoPersona extends javax.swing.JDialog {

    public VListadoPersona(JDialog v, boolean modal) {
        super(v, modal);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf");
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/view/img/peda.png")).getImage());

        setLocationRelativeTo(this);
        DecorarJtablet(jTable_PERSONAS);

    }

    public VListadoPersona(JFrame v, boolean modal) {
        super(v, modal);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf");
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/view/img/peda.png")).getImage());

        setLocationRelativeTo(this);
        DecorarJtablet(jTable_PERSONAS);

    }

    private void DecorarJtablet(JTable jtable) {
        jtable.getTableHeader().setOpaque(false);
        jtable.getTableHeader().setBackground(new Color(102, 102, 102));
        jtable.getTableHeader().setForeground(Color.WHITE);

    }

    public JTextField getBuscadorpersona() {
        return buscadorpersona;
    }

    public JTable getjTable_PERSONAS() {
        return jTable_PERSONAS;
    }

    public JButton getBTN_NUEVAPERSONAVM() {
        return BTN_NUEVAPERSONAVM;
    }

    public BTN getBTN_BUSCAR() {
        return BTN_BUSCAR;
    }

    public JLabel getCantidadPersona() {
        return CantidadPersona;
    }

    public JLabel getJLabel_Desde_Persona() {
        return JLabel_Desde_Persona;
    }

    public JLabel getJLabel_TotalPagina_Persona() {
        return JLabel_TotalPagina_Persona;
    }

    public JLabel getBtnAtras() {
        return btnAtras;
    }

    public JLabel getBtnSiguiente() {
        return btnSiguiente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_PERSONAS = new javax.swing.JTable();
        buscadorpersona = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CantidadPersona = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JLabel();
        JLabel_Desde_Persona = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        JLabel_TotalPagina_Persona = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JLabel();
        BTN_NUEVAPERSONAVM = new view.componentes.BTN();
        BTN_BUSCAR = new view.componentes.BTN();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTADO DE PERSONA");
        setUndecorated(true);
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

        jTable_PERSONAS.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable_PERSONAS.setForeground(new java.awt.Color(102, 102, 102));
        jTable_PERSONAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "PRIMER NOMBRE", "SEGUNDO NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO", "CEDULA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PERSONAS.setRowHeight(24);
        jTable_PERSONAS.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable_PERSONAS.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_PERSONAS.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jTable_PERSONAS);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 870, 240));

        buscadorpersona.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        buscadorpersona.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(buscadorpersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 180, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_no_16px.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, -1));

        CantidadPersona.setForeground(new java.awt.Color(153, 153, 153));
        CantidadPersona.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CantidadPersona.setText("400");
        jPanel1.add(CantidadPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 50, -1));

        jLabel65.setForeground(new java.awt.Color(153, 153, 153));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("TOTAL: ");
        jPanel1.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 50, -1));

        btnAtras.setForeground(new java.awt.Color(153, 153, 153));
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras.setText("<");
        btnAtras.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, 20, -1));

        JLabel_Desde_Persona.setForeground(new java.awt.Color(153, 153, 153));
        JLabel_Desde_Persona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel_Desde_Persona.setText("120");
        jPanel1.add(JLabel_Desde_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, 30, -1));

        jLabel41.setForeground(new java.awt.Color(153, 153, 153));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("/");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 20, -1));

        JLabel_TotalPagina_Persona.setForeground(new java.awt.Color(153, 153, 153));
        JLabel_TotalPagina_Persona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel_TotalPagina_Persona.setText("120");
        jPanel1.add(JLabel_TotalPagina_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 30, -1));

        btnSiguiente.setForeground(new java.awt.Color(153, 153, 153));
        btnSiguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setText(">");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 20, -1));

        BTN_NUEVAPERSONAVM.setBackground(new java.awt.Color(102, 102, 102));
        BTN_NUEVAPERSONAVM.setForeground(new java.awt.Color(255, 255, 255));
        BTN_NUEVAPERSONAVM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_add_32px.png"))); // NOI18N
        BTN_NUEVAPERSONAVM.setText("NUEVO");
        BTN_NUEVAPERSONAVM.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(BTN_NUEVAPERSONAVM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        BTN_BUSCAR.setBackground(new java.awt.Color(102, 102, 102));
        BTN_BUSCAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_view_24px.png"))); // NOI18N
        BTN_BUSCAR.setText("BUSCAR");
        BTN_BUSCAR.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(BTN_BUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.componentes.BTN BTN_BUSCAR;
    private view.componentes.BTN BTN_NUEVAPERSONAVM;
    private javax.swing.JLabel CantidadPersona;
    private javax.swing.JLabel JLabel_Desde_Persona;
    private javax.swing.JLabel JLabel_TotalPagina_Persona;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnSiguiente;
    private javax.swing.JTextField buscadorpersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable_PERSONAS;
    // End of variables declaration//GEN-END:variables
}
