package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Cursos {
   
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
    public void Registrar(int id, String nombre, String institucion, String duracion, String fecha) throws SQLException{
        
        String sql = "INSERT INTO Cursos (nombre, institucion, duracion, fecha, idfuncionario) "
                + "VALUE (?,?,?,?,?)";
        
        PreparedStatement ps = con.prepareStatement(sql); 
                ps.setString(1, nombre.toUpperCase());
                ps.setString(2, institucion.toUpperCase());
                ps.setString(3, duracion.toUpperCase());
                ps.setString(4, fecha.toUpperCase());
                ps.setInt(5, id);
                ps.executeQuery();
                con.close();
    }
    
    
    //Eliminar
    
    public void Eliminar(int id){
        
        try {
            
            PreparedStatement ps = con.prepareStatement("DELETE FROM Cursos WHERE IDCursos = ?");
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

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Cursos WHERE IDFuncionario = ? ORDER BY Fecha DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();
            

            modelo.addColumn("N°");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("INSTITUCIÓN");
            modelo.addColumn("DURACIÓN");
            modelo.addColumn("FECHA");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[6];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Nombre").toUpperCase();
                datos[2] = rs.getString("Institucion").toUpperCase();
                datos[3] = rs.getString("Duracion").toUpperCase();
                datos[4] = rs.getString("Fecha").toUpperCase();
                datos[5] = rs.getString("IDCursos");

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
