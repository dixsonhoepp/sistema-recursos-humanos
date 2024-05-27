package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Historial {

    //Conexion
    private Conexion cc = new Conexion();
    private Connection con = cc.conectar();

    //crear DefaultTableModel y no dejar que sea aditado
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Registrar Historial
    public void Registrar(String Usuario, String Evento) {

        //OBTENER FECHA Y HORA ACTUAL
        Date fecha = new Date();
        SimpleDateFormat forma = new SimpleDateFormat("ddMMMyyyy hh:mm:ss");

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Historial (Fecha, Usuario, Evento) VALUE (?,?,?)");
            ps.setString(1, forma.format(fecha));
            ps.setString(2, Usuario.toLowerCase());
            ps.setString(3, Evento.toUpperCase());
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado
    public DefaultTableModel Listado() {

        try {

            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Historial ORDER BY IDHistorial DESC LIMIT 20");

            ResultSet rs = psconsultar.executeQuery();

            modelo.addColumn("FECHA");
            modelo.addColumn("USUARIO");
            modelo.addColumn("ACCIÓN");

            String[] datos = new String[3];

            while (rs.next()) {
                datos[0] = rs.getString("Fecha");
                datos[1] = rs.getString("Usuario");
                datos[2] = rs.getString("Evento").toUpperCase();
                modelo.addRow(datos);

            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        return this.modelo;
    }


    

}
