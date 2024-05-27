
package myclass;


public class Encriptar {
    

    public String GetEncriptado(String texto){
        
        char [] array = texto.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            
            array[i] = (char)(array[i]+6);
        }
        String resultado = String.valueOf(array);
        
        return resultado;
    }
    
    
    public String GetNoEncriptado(String texto){
        
        char [] array = texto.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            
            array[i] = (char)(array[i]-6);
        }
        String resultado = String.valueOf(array);
        
        return resultado;
    }
    
    
    
    
}
