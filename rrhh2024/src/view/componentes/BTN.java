package view.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class BTN extends JButton {

    public BTN() {

        setFocusable(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(128,125,230));
        
        //evento para el btn
        //esto permitira cambiar de color al btn cuando el mouse pase por encima
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                setBackground(new Color(128,125,200));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//               setBackground(new Color(128,125,230));
//            }
//            
//            
//        });
        

    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(g);
        

    }
}
