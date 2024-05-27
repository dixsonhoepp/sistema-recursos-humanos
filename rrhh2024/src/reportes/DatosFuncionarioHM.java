
package reportes;


public class DatosFuncionarioHM {
    
    private int id;
    private int rango;
    private String pn;
    private String sn;
    private String pa;
    private String sa;
    private String genero;
    private String cedula;
    public int ch;
    

    public DatosFuncionarioHM(int id, int rango, String pn, String sn, String pa, String sa, String genero, String cedula, int ch) {
        this.id = id;
        this.rango = rango;
        this.pn = pn;
        this.sn = sn;
        this.pa = pa;
        this.sa = sa;
        this.genero = genero;
        this.cedula = cedula;
        this.ch = ch;
    }

    public int getId() {
        return id;
    }

    public int getRango() {
        return rango;
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

    public int getCh() {
        return ch;
    }
        

}
