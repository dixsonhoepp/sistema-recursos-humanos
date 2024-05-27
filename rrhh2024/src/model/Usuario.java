package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;

public class Usuario {

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

    //Registrar Usuario
    public void Reginstrar(String usuario, String clave, int IDPersona) throws SQLException {

        PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario (usuario, clave, idpersona) VALUES(?,?,?)");
        ps.setString(1, usuario.toLowerCase());
        ps.setString(2, clave);
        ps.setInt(3, IDPersona);
        ps.executeUpdate();
        con.close();
    }

    //Eliminar Usuario
    public void Eliminar(int id) {

        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Usuario WHERE IDUsuario = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado de Usuario
    public DefaultTableModel Listado() {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario INNER JOIN Persona ON Usuario.IDPersona = Persona.IDPersona WHERE Usuario != 'admin'");
            ResultSet rs = ps.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("USUARIO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("CEDULA");
            modelo.addColumn("");

            int numero = 1;
            String[] datos = new String[8];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = "@" + rs.getString("Usuario");
                datos[2] = rs.getString("PrimerNombre").toUpperCase();
                datos[3] = rs.getString("SegundoNombre").toUpperCase();
                datos[4] = rs.getString("PrimerApellido").toUpperCase();
                datos[5] = rs.getString("SegundoApellido");
                datos[6] = rs.getString("Cedula").toUpperCase();
                datos[7] = rs.getString("IDUsuario");

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

    //Consultar
    public int Consultar(String Usuario) throws SQLException {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE Usuario = ?");
        ps.setString(1, Usuario);
        ResultSet rs = ps.executeQuery();
        int num = 0;
        while (rs.next()) {
            num = 1;
        }

        con.close();

        return num;
    }

    //Ingresar
    public int Ingresar(String Usuario, String Clave) throws SQLException {

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE Usuario = ? AND Clave = ?");
        ps.setString(1, Usuario.toLowerCase());
        ps.setString(2, Clave);
        ResultSet rs = ps.executeQuery();
        int num = 0;
        while (rs.next()) {
            num = 1;
        }

        con.close();

        return num;
    }

    //Consultar usurio
    public String ConsultarUsuarioID(int id) {
        
        String dato = "";
        
        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario "
                    + "INNER JOIN Persona ON Usuario.IDPersona = Persona.IDPersona "
                    + "WHERE IDUsuario = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dato = rs.getString("Usuario");

            }
            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return dato;
    }

}
