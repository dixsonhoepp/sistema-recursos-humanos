package model;

import myclass.ModificarFecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;

public class Directores {

    //Conexion
    private Conexion cc = new Conexion();
    private Connection con = cc.conectar();
    private ModificarFecha fecha = new ModificarFecha();

    //crear DefaultTableModel y no dejar que sea aditado
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Registrar DIRECTOR
    public void Reginstrar(String cargo, String rango, String fecha, String resolucion, int IDPersona) throws SQLException {

        String sql = "INSERT INTO Directores (cargo, rango, fecha, resolucion, idpersona) "
                + "VALUE (?,?,?,?,?)"; 
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cargo.toUpperCase());
        ps.setString(2, rango.toUpperCase());
        ps.setString(3, fecha);
        ps.setString(4, resolucion.toUpperCase());
        ps.setInt(5, IDPersona);
        ps.executeUpdate();
        con.close();

    }

    //Eliminar DIRECTOR
    public void Eliminar(int id) {

        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Directores WHERE IDDirectores = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado de Directores
    public DefaultTableModel Listado(String cargo) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Directores "
                    + "INNER JOIN Persona ON Directores.IDPersona = Persona.IDPersona "
                    + "WHERE Directores.Cargo = ?");
            ps.setString(1, cargo);
            ResultSet rs = ps.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("RANGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("CEDULA");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("FECHA");
            modelo.addColumn("RESOLUCIÓN");
            modelo.addColumn("");

            int numero = 1;
            String[] datos = new String[11];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Rango").toUpperCase();
                datos[2] = rs.getString("PrimerNombre").toUpperCase();
                datos[3] = rs.getString("SegundoNombre").toUpperCase();
                datos[4] = rs.getString("PrimerApellido").toUpperCase();
                datos[5] = rs.getString("SegundoApellido");
                datos[6] = rs.getString("Cedula").toUpperCase();
                datos[7] = rs.getString("Telefono").toUpperCase();
                datos[8] = fecha.getFecha(rs.getString("Fecha"));
                datos[9] = rs.getString("Resolucion").toUpperCase();
                datos[10] = rs.getString("IDDirectores");

                modelo.addRow(datos);
                numero++;

            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return this.modelo;
    }

    //Consultar Listado de Directores
    public List<model.list.Directores> getInformacion(String cargo) {

        List<model.list.Directores> lista = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Persona "
                    + "INNER JOIN Directores ON Directores.IDPersona = Persona.IDPersona "
                    + "WHERE Cargo = ?");
            ps.setString(1, cargo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new model.list.Directores(
                        rs.getString("PrimerNombre"),
                        rs.getString("SegundoNombre"),
                        rs.getString("PrimerApellido"),
                        rs.getString("SegundoApellido"),
                        fecha.getFecha(rs.getString("fecha")),
                        rs.getString("Resolucion"),
                        rs.getString("Genero"),
                        rs.getString("NivelAcademico"),
                        rs.getString("Rango"),
                        rs.getString("Cargo")
                ));
            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return lista;
    }

    //Consultar
    public int Consultar(String Cargo) throws SQLException {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Directores WHERE Cargo = ?");
        ps.setString(1, Cargo);
        ResultSet rs = ps.executeQuery();
        int num = 0;
        while (rs.next()) {
            num++;
        }

        con.close();

        return num;
    }

    //Consutar para historial
    public String[] ConsultarH(int ID) {

        String[] datos = new String[5];

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Directores "
                    + "INNER JOIN Persona on Directores.IDPersona = Persona.IDPersona WHERE IDDirectores = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                datos[0] = rs.getString("PrimerNombre");
                datos[1] = rs.getString("SegundoNombre");
                datos[2] = rs.getString("PrimerApellido");
                datos[3] = rs.getString("SegundoApellido");
                datos[4] = rs.getString("Cedula");
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Directores.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;
    }

}
