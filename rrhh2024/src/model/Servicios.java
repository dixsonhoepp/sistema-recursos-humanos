package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Servicios {

    //Conexion
    private Conexion cc = new Conexion();
    private Connection con = cc.conectar();

    //total persona registradas
    private static int totalServicio;

    //crear DefaultTableModel y no dejar que sea aditado
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Registrar Servicio
    public void Registrar(String nombre, String descripcion) {

        
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Servicios (nombre, observacion) VALUE (?,?)");
            ps.setString(1, nombre.toUpperCase());
            ps.setString(2, descripcion.toUpperCase());
            ps.executeQuery();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Eliminar Servicio
    public void Eliminar(int id) {

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Servicios WHERE IDServicios = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();


        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Total Servicio
    public int TotalServicioRegistrado(String consulta) {

        try {
            String sql = "SELECT * FROM Servicios WHERE "
                    + "Nombre LIKE '%" + consulta + "%' ORDER by Nombre ";

            //Consultar si el Numero de Cedula existe.
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int total = 0;
            while (rs.next()) {
                total++;
            }

            totalServicio = total;

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalServicio;
    }

    public int getTotalServicio() {
        return totalServicio;
    }

    //Consultar Listado de Persona
    public DefaultTableModel ListadoConsultarServicio(String consulta) {

        try {

            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Servicios WHERE "
                    + "Nombre LIKE '%" + consulta + "%' ORDER by Nombre DESC");

            ResultSet rs = psconsultar.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCIÓN");
            modelo.addColumn("");

            int numero = 1;
            String[] datos = new String[4];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("Nombre").toUpperCase();
                datos[2] = rs.getString("Observacion").toUpperCase();
                datos[3] = rs.getString("IDServicios").toUpperCase();
                modelo.addRow(datos);
                numero++;

            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex);
        }

        return this.modelo;
    }
    
    
    
    //LISTADO DE SERVICIO
    public String [] Listado (){
        
        String [] datos = new String [totalServicio];
       
        
        try {
            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Servicios ORDER BY Nombre");
            ResultSet rs = psconsultar.executeQuery();
            
            int num = 0;
            
            while (rs.next()) {
                
                datos[num] = rs.getString("Nombre").toUpperCase();
                num++;
            }
           
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return datos;
        
    }
    
    
    

}
