package view.funcionarios;

import com.formdev.flatlaf.FlatLightLaf;
import evento.otro.TextoMayuscula;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import view.componentes.BTN;


public class VServicios extends javax.swing.JDialog {

    public static int modo;
    private int opcion;

    public VServicios(JDialog v, boolean modal) {
        super(v, modal);
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf");
        }
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/view/img/peda.png")).getImage());
        setLocationRelativeTo(this);

        DecorarJtablet(jTable);


    }

    public JButton getBtn() {
        return btnSelection;
    }

    private void DecorarJtablet(JTable jtable) {
        jtable.getTableHeader().setOpaque(false);
        jtable.getTableHeader().setBackground(new Color(102, 102, 102));
        jtable.getTableHeader().setForeground(Color.WHITE);
    }

    public BTN getBTN_BUSCAR_SERVICIOS() {
        return BTN_BUSCAR_SERVICIOS;
    }

    public void setBTN_BUSCAR_SERVICIOS(BTN BTN_BUSCAR_SERVICIOS) {
        this.BTN_BUSCAR_SERVICIOS = BTN_BUSCAR_SERVICIOS;
    }

    public BTN getBtnSelection() {
        return btnSelection;
    }

    public void setBtnSelection(BTN btnSelection) {
        this.btnSelection = btnSelection;
    }

    public JTextField getBuscadorServicio() {
        return buscadorServicio;
    }

    public void setBuscadorServicio(JTextField buscadorServicio) {
        this.buscadorServicio = buscadorServicio;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel92 = new javax.swing.JLabel();
        btnSelection = new view.componentes.BTN();
        buscadorServicio = new javax.swing.JTextField();
        BTN_BUSCAR_SERVICIOS = new view.componentes.BTN();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MEDIDAS DISCIPLINARIAS");
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
        jLabel1.setText("Servicios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 630, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 650, 10));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_no_16px.png"))); // NOI18N
        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        btnSelection.setBackground(new java.awt.Color(102, 102, 102));
        btnSelection.setForeground(new java.awt.Color(255, 255, 255));
        btnSelection.setText("Seleccionar");
        btnSelection.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel1.add(btnSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 160, 30));

        buscadorServicio.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        buscadorServicio.setForeground(new java.awt.Color(51, 51, 51));
        buscadorServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorServicioKeyReleased(evt);
            }
        });
        jPanel1.add(buscadorServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 180, 40));

        BTN_BUSCAR_SERVICIOS.setBackground(new java.awt.Color(102, 102, 102));
        BTN_BUSCAR_SERVICIOS.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BUSCAR_SERVICIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_view_24px.png"))); // NOI18N
        BTN_BUSCAR_SERVICIOS.setText("BUSCAR");
        BTN_BUSCAR_SERVICIOS.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel1.add(BTN_BUSCAR_SERVICIOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, -1, 40));

        jTable.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable.setForeground(new java.awt.Color(102, 102, 102));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Servicio", "Observación"
            }
        ));
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(25);
            jTable.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 120, 660, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buscadorServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorServicioKeyReleased
        TextoMayuscula texto = new TextoMayuscula(buscadorServicio);
        texto.keyReleased(evt);
    }//GEN-LAST:event_buscadorServicioKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public view.componentes.BTN BTN_BUSCAR_SERVICIOS;
    private view.componentes.BTN btnSelection;
    private javax.swing.JTextField buscadorServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
