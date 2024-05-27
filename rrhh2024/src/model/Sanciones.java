package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Sanciones {
    
   
    
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
    
    
    //Registrar Sanciones
    public void ReginstrarSancion(int id, String fecha, String medida, String motivo, String funcionario) throws SQLException{
        String sql = "INSERT INTO Sanciones (fecha, medida, motivo, funcionario, idfuncionario) "
                + "VALUE (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql); 
                ps.setString(1, fecha.toUpperCase());
                ps.setString(2, medida.toUpperCase());
                ps.setString(3, motivo.toUpperCase());
                ps.setString(4, funcionario.toUpperCase());
                ps.setInt(5, id);
                ps.executeUpdate();
                con.close();
    }
    
    
    //Eliminar Sanciones
    
    public void EliminarSanciones(int id){
        
        try {
            
            PreparedStatement ps = con.prepareStatement("DELETE FROM Sanciones WHERE IDSanciones = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
     //Consultar Listado de Sanciones
    public DefaultTableModel ListadoConsultarSanciones(int IdFuncionario) {

        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Sanciones WHERE IDFuncionario = ? ORDER BY Fecha DESC");
            ps.setInt(1, IdFuncionario);
            ResultSet rs = ps.executeQuery();
            

            modelo.addColumn("N°");
            modelo.addColumn("FECHA");
            modelo.addColumn("MEDIDA");
            modelo.addColumn("MOTIVO");
            modelo.addColumn("FUNCIONARIO");
            modelo.addColumn("ID");

            int numero = 1;
            String[] datos = new String[6];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Fecha").toUpperCase();
                datos[2] = rs.getString("Medida").toUpperCase();
                datos[3] = rs.getString("Motivo").toUpperCase();
                datos[4] = rs.getString("Funcionario").toUpperCase();
                datos[5] = rs.getString("IDSanciones");

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
