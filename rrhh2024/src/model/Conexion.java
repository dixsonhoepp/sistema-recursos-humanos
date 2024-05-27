package model;

import java.io.FileReader;
import java.sql.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Conexion {

    Connection conectar = null;
    private boolean status = false;
    
    public Connection conectar() {

        try {
            Object object = new JSONParser().parse(new FileReader("rutas.txt"));
            JSONObject JSON = (JSONObject) object;

            String ruta = JSON.get("host").toString();
            String db = JSON.get("db").toString();
            String user = JSON.get("user").toString();
            String password = JSON.get("password").toString();
            
            StringBuilder sURL = new StringBuilder();
            sURL.append("jdbc:mariadb://");
            sURL.append(ruta);
            sURL.append("/");
            sURL.append(db);

            conectar = DriverManager.getConnection(sURL.toString(), user, password);
            
            //conectar = DriverManager.getConnection(sURL, "root", "dghm1989");

            System.out.println("conectado");
            
            status  = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            
            status = false;

        }

//        try {
//
//            String sURL = "jdbc:mariadb://192.168.1.122:3306/rrhh";
//            conectar = DriverManager.getConnection(sURL, "usuario", "1234");
//            
//            System.out.println("conectado");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        return conectar;
    }
    
    public boolean getStatus(){
        return status;
    }

}
