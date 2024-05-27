/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myclass;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Edad {
    
    
    
    public int getEdad(String fecha){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        
        if(fecha.isEmpty()){
            return 0;
        }else{
          return periodo.getYears();  
        }
        
    }

}
