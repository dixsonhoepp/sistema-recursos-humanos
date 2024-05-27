
package model.list;

public class Directores {
    String primerNombre, 
            segundoNombre, 
            primerApellido, 
            segundoApellido, 
            resolucion,
            fecha,
            genero,
            nivelAcademico,
            rango, 
            cargo;

    public Directores(String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, String fecha, String resolucion, 
            String genero, String nivelAcademico, String rango, String cargo) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;  
        this.fecha = fecha;
        this.resolucion = resolucion;
        this.genero = genero;
        this.nivelAcademico = nivelAcademico;
        this.rango = rango;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }


    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }


    public String getResolucion() {
        return resolucion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    
    public String getRango() {
        return rango;
    }

    public String getGenero() {
        return genero;
    }
    
    
    
    
    
}
