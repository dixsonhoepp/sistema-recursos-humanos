
package reportes;

import java.io.File;
import java.util.ArrayList;


public class Prueba {
    
    public static void main(String[] args) {
        RGFuncionariosExcel r = new RGFuncionariosExcel(new File("prueba.xls"));
        r.generarExcel();

    }

}
