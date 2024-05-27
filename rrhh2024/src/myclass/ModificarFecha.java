package myclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarFecha {

    private String Fecha = "0000-00-00";

    public String getFecha(String fecha) {

        if (!fecha.isEmpty()) {

            try {
                SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy");

                Date fechaTX = formato1.parse(fecha);

                this.Fecha = formato2.format(fechaTX);

            } catch (ParseException ex) {
                Logger.getLogger(ModificarFecha.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return this.Fecha;
    }

}
