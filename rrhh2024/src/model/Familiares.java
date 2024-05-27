package model;

import myclass.Edad;
import myclass.ModificarFecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Familiares {

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

    private ModificarFecha fecha = new ModificarFecha();
    private Date date = new Date();
    private SimpleDateFormat getAno = new SimpleDateFormat("yyyy");
    private Edad edad = new Edad();
    private int registro;

    //Registrar Familiar
    public void ReginstrarFamiliar(int IDFuncionario, int IDPersona, String Parentesco) throws SQLException {

        String sql = "INSERT INTO Familiares (parentesco, idfuncionario, idpersona) VALUES(?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Parentesco);
        ps.setInt(2, IDFuncionario);
        ps.setInt(3, IDPersona);
        ps.executeUpdate();
        con.close();
    }

    //Eliminar Familiar
    public void EliminarFamiliar(int id) {

        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Familiares WHERE IDFamiliares = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado de Familiares
    public DefaultTableModel ListadoConsultarFamiliares(int IdFuncionario) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Familiares INNER JOIN Persona ON Familiares.IDPersona = Persona.IDPersona INNER JOIN Funcionario ON Familiares.IDFuncionario = Funcionario.IDFuncionario WHERE Funcionario.IDFuncionario = ?");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("PARENTESCO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("CEDULA°");
            modelo.addColumn("GÉNERO°");
            modelo.addColumn("FECHA DE NACIMIENTO");
            modelo.addColumn("EDAD");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("DIRECCIÓN");
            modelo.addColumn("ID");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[14];
            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Parentesco").toUpperCase();
                datos[2] = rs.getString("PrimerNombre").toUpperCase();
                datos[3] = rs.getString("SegundoNombre").toUpperCase();
                datos[4] = rs.getString("PrimerApellido").toUpperCase();
                datos[5] = rs.getString("SegundoApellido").toUpperCase();
                datos[6] = rs.getString("Cedula").toUpperCase();
                datos[7] = rs.getString("Genero").toUpperCase();
                datos[8] = rs.getString("FechaNacimiento").toUpperCase();
                datos[9] = Integer.toString(edad.getEdad(rs.getString("FechaNacimiento")));
                datos[10] = rs.getString("Telefono");
                datos[11] = rs.getString("Direccion").toUpperCase();
                datos[12] = rs.getString("IDFamiliares");
                datos[13] = rs.getString("IDPersona");

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

    public int ConsultarFamiliares(int IDPersona, int IDFuncionario) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Familiares INNER JOIN Persona ON Familiares.IDPersona = Persona.IDPersona INNER JOIN Funcionario ON Familiares.IDFuncionario = Funcionario.IDFuncionario WHERE Familiares.IDFuncionario = ? AND Familiares.IDPersona = ?");

            ps.setInt(1, IDFuncionario);
            ps.setInt(2, IDPersona);

            ResultSet rs = ps.executeQuery();

            int numero = 0;
            while (rs.next()) {
                numero = 1;
            }

            registro = numero;

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return registro;
    }

    //CONSULTAR PERSONA
    public int ConsultarFuncionario(int IDFuncionario) {

        int dato = 0;

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Funcionario "
                    + "INNER JOIN Persona ON Funcionario.IDPersona = Persona.IDPersona "
                    + "WHERE Funcionario.IDFuncionario = ?");

            ps.setInt(1, IDFuncionario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dato = rs.getInt("IDPersona");
            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);

        }

        return dato;
    }

}
