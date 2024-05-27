package view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Dixson
 */
public class VLogin extends javax.swing.JFrame {

    public VLogin() {
        
        
        init();
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/view/img/peda.png")).getImage());
        setLocationRelativeTo(this);

        usuario.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresar Usuario");
        clave.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresar Clave");

        setBackground(new Color(0, 0, 0, 0));
        



    }

    private void init() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf");
        }
        UIManager.put("TextComponent.arc", 5);

    }

    public JButton getBTN_INGRESAR() {
        return BTN_NUEVOFUNCIONARIO;
    }

    public JPasswordField getClave() {
        return clave;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Clases.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        clave = new javax.swing.JPasswordField();
        BTN_NUEVOFUNCIONARIO = new view.componentes.BTN();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        panelRound1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(4, 0, 0, 25));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel2.add(jLabel1);

        usuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usuario.setForeground(new java.awt.Color(102, 102, 102));
        usuario.setSelectionColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(usuario);

        clave.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        clave.setForeground(new java.awt.Color(102, 102, 102));
        clave.setSelectionColor(new java.awt.Color(102, 102, 102));
        jPanel2.add(clave);

        BTN_NUEVOFUNCIONARIO.setBackground(new java.awt.Color(102, 102, 102));
        BTN_NUEVOFUNCIONARIO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_NUEVOFUNCIONARIO.setText("Ingresar");
        BTN_NUEVOFUNCIONARIO.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel2.add(BTN_NUEVOFUNCIONARIO);

        panelRound1.add(jPanel2);
        jPanel2.setBounds(10, 30, 210, 200);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/icons8_no_16px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panelRound1.add(jLabel2);
        jLabel2.setBounds(200, 10, 16, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

//    @Override
//    public void paint(Graphics g) {
//        
//        super.paint(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(new Color(102, 102, 102));
//        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
//        
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.componentes.BTN BTN_NUEVOFUNCIONARIO;
    private javax.swing.JPasswordField clave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private Clases.PanelRound panelRound1;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
