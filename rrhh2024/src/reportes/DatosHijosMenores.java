
package reportes;


public class DatosHijosMenores {
    
    private int edad;
    private String pn;
    private String sn;
    private String pa;
    private String sa;
    private String genero;
    private String cedula;
    private int idFuncionario;

    public DatosHijosMenores(int edad, String pn, String sn, String pa, String sa, String genero, String cedula, int idFuncionario) {
        this.edad = edad;
        this.pn = pn;
        this.sn = sn;
        this.pa = pa;
        this.sa = sa;
        this.genero = genero;
        this.cedula = cedula;
        this.idFuncionario = idFuncionario;
    }

    public int getEdad() {
        return edad;
    }

    public String getPn() {
        return pn;
    }

    public String getSn() {
        return sn;
    }

    public String getPa() {
        return pa;
    }

    public String getSa() {
        return sa;
    }

    public String getGenero() {
        return genero;
    }

    public String getCedula() {
        return cedula;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }
    
    
    
 

}
