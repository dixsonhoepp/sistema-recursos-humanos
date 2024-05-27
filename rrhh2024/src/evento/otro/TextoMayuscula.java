
package evento.otro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextoMayuscula  extends KeyAdapter{
    
    private JTextField texto;
    private JTextArea textoArea;

    public TextoMayuscula(JTextField texto) {
        this.texto = texto;
    }

    public TextoMayuscula(JTextArea textoArea) {
        this.textoArea = textoArea;
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getSource() == texto){
          this.texto.setText(this.texto.getText().toUpperCase());   
        }
        
        if(e.getSource() == textoArea){
            this.textoArea.setText(this.textoArea.getText().toUpperCase());
        }
               
    }
    
    
    
    
}
