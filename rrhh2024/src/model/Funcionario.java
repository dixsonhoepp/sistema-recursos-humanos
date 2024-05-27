package model;

import myclass.ModificarFecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;

public class Funcionario {

    //Modificar fecha
    private ModificarFecha fecha = new ModificarFecha();

    //Conexion
    private Conexion cc = new Conexion();
    private Connection con = cc.conectar();
    //total persona registradas
    private int totalFuncionario;
    //resultado de registro
    private boolean registro;

    //crear DefaultTableModel y no dejar que sea aditado
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //REGISTRAR FUNCIONARIO
    public boolean RegistrarFuncionario(int IDPersona, int rango, String FechaIngreso,
            String FechaAscenso, String CodigoCarnet, String Condicion, String Servicio,
            String Municipio, String TallaCamisa, String TallaPantalon, String TallaZapato,
            String TallaGorra, String Banco, String NumeroCuenta, String Estatus) {

        try {

            //Consultar si El Funcionario Existe
            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Persona INNER JOIN Funcionario "
                    + "on Persona.IDPersona = Funcionario.IDPersona WHERE Persona.IDPersona = ?");
            psconsultar.setInt(1, IDPersona);
            ResultSet rs = psconsultar.executeQuery();

            if (rs.next()) {
                registro = false;
                con.close();

            } else {
                PreparedStatement ps = con.prepareStatement("INSERT INTO Funcionario "
                        + "(Rango, FechaIngreso, FechaAscenso, CodigoCarnet, Condicion, Servicio, Municipio, "
                        + "TallaCamisa, TallaPantalon, TallaZapato, TallaGorra, Banco, NumeroCuenta, Estatus, IDPersona) "
                        + "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                ps.setInt(1, rango);
                ps.setString(2, FechaIngreso.toUpperCase());
                ps.setString(3, FechaAscenso.toUpperCase());
                ps.setString(4, CodigoCarnet.toUpperCase());
                ps.setString(5, Condicion.toUpperCase());
                ps.setString(6, Servicio.toUpperCase());
                ps.setString(7, Municipio.toUpperCase());
                ps.setString(8, TallaCamisa.toUpperCase());
                ps.setString(9, TallaPantalon.toUpperCase());
                ps.setString(10, TallaZapato.toUpperCase());
                ps.setString(11, TallaGorra.toUpperCase());
                ps.setString(12, Banco.toUpperCase());
                ps.setString(13, NumeroCuenta.toUpperCase());
                ps.setString(14, Estatus.toUpperCase());
                ps.setInt(15, IDPersona);
                ps.executeUpdate();
                con.close();

                registro = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registro;

    }

    //EDITAR FUNCIONARIO
    public boolean EditarFuncionario(int IDFuncionario, int rango, String FechaIngreso,
            String FechaAscenso, String CodigoCarnet, String Condicion, String Servicio,
            String Municipio, String TallaCamisa, String TallaPantalon, String TallaZapato,
            String TallaGorra, String Banco, String NumeroCuenta, String Estatus,
            String FechaEgreso, String MotivoEgreso,
            String ObservacionEgreso) {

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE Funcionario SET Rango = ?, "
                    + "FechaIngreso = ?, FechaAscenso = ?, CodigoCarnet = ?, "
                    + "Condicion = ?, Servicio = ?, Municipio = ?, TallaCamisa = ?, "
                    + "TallaPantalon = ?, TallaZapato = ?, TallaGorra = ?, Banco = ?, "
                    + "NumeroCuenta = ?, Estatus = ?, FechaEgreso = ?, MotivoEgreso = ?, ObservacionEgreso = ? "
                    + "WHERE IDFuncionario = ?");

            ps.setInt(1, rango);
            ps.setString(2, FechaIngreso.toUpperCase());
            ps.setString(3, FechaAscenso.toUpperCase());
            ps.setString(4, CodigoCarnet.toUpperCase());
            ps.setString(5, Condicion.toUpperCase());
            ps.setString(6, Servicio.toUpperCase());
            ps.setString(7, Municipio.toUpperCase());
            ps.setString(8, TallaCamisa.toUpperCase());
            ps.setString(9, TallaPantalon.toUpperCase());
            ps.setString(10, TallaZapato.toUpperCase());
            ps.setString(11, TallaGorra.toUpperCase());
            ps.setString(12, Banco.toUpperCase());
            ps.setString(13, NumeroCuenta.toUpperCase());
            ps.setString(14, Estatus.toUpperCase());
            ps.setString(15, FechaEgreso.toUpperCase());
            ps.setString(16, MotivoEgreso.toUpperCase());
            ps.setString(17, ObservacionEgreso.toUpperCase());
            ps.setInt(18, IDFuncionario);
            ps.executeUpdate();
            con.close();

            registro = true;

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registro;

    }

    //CONSULTAR FUNCIONARIOS 
    public DefaultTableModel ListadoConsultarFuncionarios(String consulta, int desde, int condicion) {

        String sql = "";

        switch (condicion) {
            case 0:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE Condicion != 'BAJA' AND"
                        + "(PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' "
                        + " OR Rango like '" + consulta + "%' OR NivelAcademico like '" + consulta + "%' "
                        + " OR TituloObtenido like '" + consulta + "%' OR Condicion like '" + consulta + "%') ORDER by Rango "
                        + "DESC LIMIT " + desde + ",20";
                break;

            case 1:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE "
                        + "Condicion = 'SUSPENDIDO' AND ("
                        + "PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' "
                        + " OR Rango like '" + consulta + "%' OR NivelAcademico like '" + consulta + "%' "
                        + " OR TituloObtenido like '" + consulta + "%' OR Condicion like '" + consulta + "%') ORDER by Rango "
                        + "DESC LIMIT " + desde + ",20";
                break;

            case 2:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE "
                        + "Condicion = 'IVSS' AND ("
                        + "PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' "
                        + " OR Rango like '" + consulta + "%' OR NivelAcademico like '" + consulta + "%' "
                        + " OR TituloObtenido like '" + consulta + "%' OR Condicion like '" + consulta + "%') ORDER by Rango "
                        + "DESC LIMIT " + desde + ",20";
                break;

            case 3:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE "
                        + "Condicion = 'BAJA' AND ("
                        + "PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' "
                        + " OR Rango like '" + consulta + "%' OR NivelAcademico like '" + consulta + "%' "
                        + " OR TituloObtenido like '" + consulta + "%' OR Condicion like '" + consulta + "%') ORDER BY FechaEgreso DESC "
                        + "LIMIT " + desde + ",20";
                break;
        }

        try {

            PreparedStatement psconsultar = con.prepareStatement(sql);

            ResultSet rs = psconsultar.executeQuery();

            if (condicion != 3) {

                modelo.addColumn("N°");
                modelo.addColumn("RANGO");
                modelo.addColumn("PRIMER NOMBRE");
                modelo.addColumn("SEGUNDO NOMBRE");
                modelo.addColumn("PRIMER APELLIDO");
                modelo.addColumn("SEGUNDO APELLIDO");
                modelo.addColumn("CÉDULA");
                modelo.addColumn("FECHA DE NACIMIENTO");
                modelo.addColumn("GENERO");
                modelo.addColumn("FECHA INGRESO");
                modelo.addColumn("FECHA ASCENSO");
                modelo.addColumn("NIVEL ACEDEMICO");
                modelo.addColumn("CARNET");
                modelo.addColumn("SERVICIO");
                modelo.addColumn("CODICIÓN");
                modelo.addColumn("");

                int numero = (desde + 1);
                String[] datos = new String[16];

                while (rs.next()) {

                    //RANGO
                    switch (Integer.parseInt(rs.getString("Rango"))) {
                        case 0:
                            datos[1] = "OFICIAL";
                            break;
                        case 1:
                            datos[1] = "PRIMER OFICIAL";
                            break;
                        case 2:
                            datos[1] = "OFICIAL JEFE";
                            break;
                        case 3:
                            datos[1] = "INSPECTOR";
                            break;
                        case 4:
                            datos[1] = "PRIMER INSPECTOR";
                            break;
                        case 5:
                            datos[1] = "INSPECTOR JEFE";
                            break;
                        case 6:
                            datos[1] = "COMISARIO";
                            break;
                        case 7:
                            datos[1] = "PRIMER COMISARIO";
                            break;
                        case 8:
                            datos[1] = "COMISARIO JEFE";
                            break;
                    }

                    datos[0] = Integer.toString(numero);
                    datos[2] = rs.getString("PrimerNombre").toUpperCase();
                    datos[3] = rs.getString("SegundoNombre").toUpperCase();
                    datos[4] = rs.getString("PrimerApellido").toUpperCase();
                    datos[5] = rs.getString("SegundoApellido").toUpperCase();
                    datos[6] = rs.getString("Cedula");
                    datos[7] = fecha.getFecha(rs.getString("FechaNacimiento"));
                    datos[8] = rs.getString("Genero").toUpperCase();
                    datos[9] = fecha.getFecha(rs.getString("FechaIngreso").toUpperCase());
                    datos[10] = fecha.getFecha(rs.getString("FechaAscenso").toUpperCase());
                    datos[11] = rs.getString("NivelAcademico").toUpperCase();
                    datos[12] = rs.getString("CodigoCarnet").toUpperCase();
                    datos[13] = rs.getString("Servicio").toUpperCase();
                    datos[14] = rs.getString("Condicion").toUpperCase();
                    datos[15] = rs.getString("IDFuncionario").toUpperCase();
                    modelo.addRow(datos);
                    numero++;

                }

            } else {
                modelo.addColumn("N°");
                modelo.addColumn("RANGO");
                modelo.addColumn("PRIMER NOMBRE");
                modelo.addColumn("SEGUNDO NOMBRE");
                modelo.addColumn("PRIMER APELLIDO");
                modelo.addColumn("SEGUNDO APELLIDO");
                modelo.addColumn("CÉDULA");
                modelo.addColumn("FECHA DE NACIMIENTO");
                modelo.addColumn("GENERO");
                modelo.addColumn("FECHA INGRESO");
                modelo.addColumn("FECHA ASCENSO");
                modelo.addColumn("NIVEL ACEDEMICO");
                modelo.addColumn("CARNET");
                modelo.addColumn("SERVICIO");
                modelo.addColumn("CODICIÓN");
                modelo.addColumn("FECHA DE EGRESO");
                modelo.addColumn("MOTIVO DE EGRESO");
                modelo.addColumn("OBSERVACIÓN");
                modelo.addColumn("");

                int numero = (desde + 1);
                String[] datos = new String[19];

                while (rs.next()) {

                    //RANGO
                    switch (Integer.parseInt(rs.getString("Rango"))) {
                        case 0:
                            datos[1] = "OFICIAL";
                            break;
                        case 1:
                            datos[1] = "PRIMER OFICIAL";
                            break;
                        case 2:
                            datos[1] = "OFICIAL JEFE";
                            break;
                        case 3:
                            datos[1] = "INSPECTOR";
                            break;
                        case 4:
                            datos[1] = "PRIMER INSPECTOR";
                            break;
                        case 5:
                            datos[1] = "INSPECTOR JEFE";
                            break;
                        case 6:
                            datos[1] = "COMISARIO";
                            break;
                        case 7:
                            datos[1] = "PRIMER COMISARIO";
                            break;
                        case 8:
                            datos[1] = "COMISARIO JEFE";
                            break;
                    }

                    datos[0] = Integer.toString(numero);
                    datos[2] = rs.getString("PrimerNombre").toUpperCase();
                    datos[3] = rs.getString("SegundoNombre").toUpperCase();
                    datos[4] = rs.getString("PrimerApellido").toUpperCase();
                    datos[5] = rs.getString("SegundoApellido").toUpperCase();
                    datos[6] = rs.getString("Cedula");
                    datos[7] = fecha.getFecha(rs.getString("FechaNacimiento"));
                    datos[8] = rs.getString("Genero").toUpperCase();
                    datos[9] = fecha.getFecha(rs.getString("FechaIngreso").toUpperCase());
                    datos[10] = fecha.getFecha(rs.getString("FechaAscenso").toUpperCase());
                    datos[11] = rs.getString("NivelAcademico").toUpperCase();
                    datos[12] = rs.getString("CodigoCarnet").toUpperCase();
                    datos[13] = rs.getString("Servicio").toUpperCase();
                    datos[14] = rs.getString("Condicion").toUpperCase();
                    datos[15] = fecha.getFecha(rs.getString("FechaEgreso").toUpperCase());
                    datos[16] = rs.getString("MotivoEgreso").toUpperCase();
                    datos[17] = rs.getString("ObservacionEgreso").toUpperCase();
                    datos[18] = rs.getString("IDFuncionario").toUpperCase();
                    modelo.addRow(datos);
                    numero++;

                }
            }

            //Cerrar Base de Dato
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.modelo;
    }

    //TOTAL FUNCIONARIO
    public int TotalFuncionario(String consulta, int condicion) {

        String sql = "";

        switch (condicion) {
            case 0:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE Condicion != 'BAJA' AND "
                        + "(PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%') ORDER by Rango ";
                break;

            case 1:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE Condicion = 'SUSPENDIDO' AND"
                        + "(PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%') ORDER by Rango ";
                break;

            case 2:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE Condicion = 'IVSS' AND "
                        + "(PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%') ORDER by Rango ";
                break;

            case 3:
                sql = "SELECT * FROM Persona "
                        + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona WHERE Condicion = 'BAJA' AND "
                        + "(PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                        + "PrimerApellido like '" + consulta + "%' OR "
                        + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%') ORDER by Rango";
                break;
        }

        try {

            //Consultar si el Numero de Cedula existe.
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int total = 0;
            while (rs.next()) {
                total++;
            }

            totalFuncionario = total;

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalFuncionario;
    }

    public int getTotal() {
        return totalFuncionario;
    }

    //BUSCAR FUNCIONARIO POR CEDULA
    public String[] DatosFuncionario(String cedula) {
        String[] datos = new String[46];
        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Persona "
                    + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona "
                    + "WHERE cedula = ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("PrimerNombre");
                datos[1] = rs.getString("SegundoNombre");
                datos[2] = rs.getString("PrimerApellido");
                datos[3] = rs.getString("SegundoApellido");
                datos[4] = rs.getString("Cedula");
                datos[5] = rs.getString("FechaNacimiento");
                datos[6] = rs.getString("LugarNacimiento");
                datos[7] = rs.getString("EstadoCivil");
                datos[8] = rs.getString("Genero");
                datos[9] = rs.getString("NivelAcademico");
                datos[10] = rs.getString("TituloObtenido");
                datos[11] = rs.getString("OtroTitulo");
                datos[12] = rs.getString("Telefono");
                datos[13] = rs.getString("OtroTelefono");
                datos[14] = rs.getString("Correo");
                datos[15] = rs.getString("GrupoSanguineo");
                datos[16] = rs.getString("Estado");
                datos[17] = rs.getString("Municipio");
                datos[18] = rs.getString("Parroquia");
                datos[19] = rs.getString("Direccion");
                datos[20] = rs.getString("foto");
                datos[21] = rs.getString("IDFuncionario");
                datos[22] = rs.getString("Rango");
                datos[23] = rs.getString("FechaIngreso");
                datos[24] = rs.getString("FechaAscenso");
                datos[25] = rs.getString("CodigoCarnet");
                datos[26] = rs.getString("Condicion");
                datos[27] = rs.getString("Servicio");
                datos[28] = rs.getString("Municipio");
                datos[29] = rs.getString("TallaCamisa");
                datos[30] = rs.getString("TallaPantalon");
                datos[31] = rs.getString("TallaZapato");
                datos[32] = rs.getString("TallaGorra");
                datos[33] = rs.getString("Banco");
                datos[34] = rs.getString("NumeroCuenta");
                datos[35] = rs.getString("FechaEgreso");
                datos[36] = rs.getString("MotivoEgreso");
                datos[37] = rs.getString("ObservacionEgreso");
                datos[38] = rs.getString("Estatus");
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        return datos;
    }

    //BUSCAR FUNCIONARIO POR ID
    public String[] DatosFuncionarioID(int id) {
        String[] datos = new String[6];
        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Persona "
                    + "INNER JOIN Funcionario ON Persona.IDPersona = Funcionario.IDPersona "
                    + "WHERE IDFuncionario = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("PrimerNombre");
                datos[1] = rs.getString("SegundoNombre");
                datos[2] = rs.getString("PrimerApellido");
                datos[3] = rs.getString("SegundoApellido");
                datos[4] = rs.getString("Cedula");
                datos[5] = rs.getString("IDPersona");
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        return datos;
    }

    //ELIMINAR FUNCIONARIO
    public void EliminarFuncionario(int IDFucionario) {
        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Funcionario WHERE IDFuncionario = ?");
            ps.setInt(1, IDFucionario);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //TOTAL REGISTRO PIE DE FUERZA
    public int TotalRegistro(int Rango, String Genero, String Condicion) {

        /*
        Si la condicion esta vacia mostrara el general de los funcionarios que se
        encuentren activos, de lo contrario mostrara el general de las codiciones
         */
        int total = 0;

        try {

            if (Condicion.isEmpty()) {

                PreparedStatement ps = con.prepareStatement("SELECT count (*) as total FROM Funcionario "
                        + "INNER JOIN Persona on Funcionario.IDPersona = Persona.IDPersona "
                        + "WHERE Funcionario.Rango = ? AND Persona.Genero = ? AND Funcionario.Condicion != 'BAJA'");

                ps.setInt(1, Rango);
                ps.setString(2, Genero);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    total = rs.getInt("total");
                }

            } else {
                PreparedStatement ps = con.prepareStatement("SELECT count (*) AS total FROM Funcionario "
                        + "INNER JOIN Persona on Funcionario.IDPersona = Persona.IDPersona "
                        + "WHERE Persona.Genero = ? AND Funcionario.Condicion = ?");

                ps.setString(1, Genero);
                ps.setString(2, Condicion);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    total = rs.getInt("total");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return total;

    }

    public void Close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
