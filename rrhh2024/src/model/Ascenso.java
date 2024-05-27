package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Ascenso {

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
    public int Registrar(int id, String tipo, String rangoAnterior, 
            String rangoObtenido, String fecha, String orden) {
        
        int valor = 0;
        try {

            String sql  = "INSERT INTO Ascenso (tipo, rangoanterior, rangoobtenido, fechaascenso, ordenmerito, idfuncionario) "
                    + "VALUE (?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tipo.toUpperCase());
            ps.setString(2, rangoAnterior.toUpperCase());
            ps.setString(3, rangoObtenido.toUpperCase());
            ps.setString(4, fecha);
            ps.setString(5, orden);
            ps.setInt(6, id);
            valor = ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Ascenso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }

    //Eliminar
    public void Eliminar(int id) {

        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Ascenso WHERE IDAscenso = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Consultar Listado
    public DefaultTableModel Listado(int IdFuncionario) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Ascenso WHERE IDFuncionario = ? ORDER BY FechaAscenso DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("TIPO");
            modelo.addColumn("RANGO ANTERIOR");
            modelo.addColumn("RANGO OBTENIDO");
            modelo.addColumn("FECHA ASCENSO");
            modelo.addColumn("ORDEN DE MERITO");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[7];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Tipo").toUpperCase();
                datos[2] = rs.getString("RangoAnterior").toUpperCase();
                datos[3] = rs.getString("RangoObtenido").toUpperCase();
                datos[4] = rs.getString("FechaAscenso");
                datos[5] = rs.getString("OrdenMerito").toUpperCase();
                datos[6] = rs.getString("IDAscenso");

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
