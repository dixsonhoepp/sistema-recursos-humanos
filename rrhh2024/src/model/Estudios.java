package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Estudios {
    
    
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
    public void Registrar(int id, String tipo, String carrera, String universidad, String fecha) throws SQLException{
        
        String sql = "INSERT INTO Estudios (nivel, carrera, universidad, fecha, idfuncionario) "
                + "VALUE (?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql); 
                ps.setString(1, tipo.toUpperCase());
                ps.setString(2, carrera.toUpperCase());
                ps.setString(3, universidad.toUpperCase());
                ps.setString(4, fecha);
                ps.setInt(5, id);
                ps.executeUpdate();
                con.close();

    }
    
    
    //Eliminar
    
    public void Eliminar(int id){
        
        try {
            
            PreparedStatement ps = con.prepareStatement("DELETE FROM Estudios WHERE IDEstudios = ?");
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

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Estudios WHERE IDFuncionario = ? ORDER BY Fecha DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();
            

            modelo.addColumn("N°");
            modelo.addColumn("TIPO");
            modelo.addColumn("CARRERA");
            modelo.addColumn("UNIVERSIDAD");
            modelo.addColumn("FECHA");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[6];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Nivel").toUpperCase();
                datos[2] = rs.getString("Carrera").toUpperCase();
                datos[3] = rs.getString("Universidad").toUpperCase();
                datos[4] = rs.getString("Fecha").toUpperCase();
                datos[5] = rs.getString("IDEstudios");

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
