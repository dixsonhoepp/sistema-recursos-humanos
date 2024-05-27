package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Permisos {

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

    //Registrar 
    public void Registrar(int id, String motivo, String departamento, String dias,
            String jefeInmediato, String fechaSalida, String fechaRegreso) throws SQLException {

        String sql = "INSERT INTO Permisos (motivo, departamento, dias, jefe, fechasalida, fecharegreso, idfuncionario) "
                + "VALUE (?,?,?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, motivo.toUpperCase());
        ps.setString(2, departamento.toUpperCase());
        ps.setString(3, dias.toUpperCase());
        ps.setString(4, jefeInmediato.toUpperCase());
        ps.setString(5, fechaSalida.toUpperCase());
        ps.setString(6, fechaRegreso.toUpperCase());
        ps.setInt(7, id);
        ps.executeUpdate();
        con.close();
    }

    //Eliminar
    public void Eliminar(int id) {

        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Permisos WHERE IDPermisos = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado de Sanciones
    public DefaultTableModel Listado(int IdFuncionario) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Permisos WHERE IDFuncionario = ? ORDER BY FechaSalida DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("MOTIVO");
            modelo.addColumn("DEPARTAMENTO");
            modelo.addColumn("DIAS");
            modelo.addColumn("JEFE INMEDIATO");
            modelo.addColumn("FECHA DE LA SALIDA");
            modelo.addColumn("FECHA DEL REGRESO");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[8];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Motivo").toUpperCase();
                datos[2] = rs.getString("Departamento").toUpperCase();
                datos[3] = rs.getString("Dias").toUpperCase();
                datos[4] = rs.getString("Jefe").toUpperCase();
                datos[5] = rs.getString("FechaSalida");
                datos[6] = rs.getString("FechaRegreso");
                datos[7] = rs.getString("IDPermisos");

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

}
