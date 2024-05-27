package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Experiencia {
    
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
    public void Registrar(int id, String funciones, String fechaIngreso) throws SQLException{
        
        String sql = "INSERT INTO Experiencia (funciones, fechaingreso, idfuncionario) "
                + "VALUE (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql); 
                ps.setString(1, funciones.toUpperCase());
                ps.setString(2, fechaIngreso);
                ps.setInt(3, id);
                ps.executeUpdate();
                con.close();
    }
    
    
    //Eliminar
    
    public void Eliminar(int id){
        
        try {
            
            PreparedStatement ps = con.prepareStatement("DELETE FROM Experiencia WHERE IDExperiencia = ?");
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

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Experiencia WHERE IDFuncionario = ? ORDER BY FechaIngreso DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();
            

            modelo.addColumn("N°");
            modelo.addColumn("FUNCIONES");
            modelo.addColumn("FECHA");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[6];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Funciones").toUpperCase();
                datos[2] = rs.getString("FechaIngreso").toUpperCase();
                datos[3] = rs.getString("IDExperiencia");

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
