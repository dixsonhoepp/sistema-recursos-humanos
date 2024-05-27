package model;

import myclass.ModificarFecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Persona {

    //Conexion
    private Conexion cc = new Conexion();
    private Connection con = cc.conectar();
    //total persona registradas
    private static int totalPersonas;
    //resultado de registro
    private boolean registro;

    private ModificarFecha fecha = new ModificarFecha();

    //crear DefaultTableModel y no dejar que sea aditado
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Registar Persona
    public boolean RegistrarPersona(String primernombre, String segundonombre,
            String primerapellido, String segundoapellido, String cedula,
            String fechanacimiento, String lugarnacimiento, String estadocivil,
            String genero, String nivelacademico, String tituloobtenido1,
            String tituloobtenido2, String telefono1, String telefono2,
            String correo, String gruposanguineo, String estado,
            String municipio, String parroquia, String direccion, String foto) {

        try {

            //Consultar si el Numero de Cedula existe.
            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Persona WHERE Cedula = ?");
            psconsultar.setString(1, cedula);
            ResultSet rs = psconsultar.executeQuery();

            if (rs.next() && !cedula.isEmpty()) {
                con.close();

                registro = false;

            } else {

                String sql = "INSERT INTO Persona (primernombre, segundonombre, primerapellido, segundoapellido, "
                        + "cedula, fechanacimiento, lugarnacimiento, estadocivil, genero, nivelacademico, "
                        + "tituloobtenido, otrotitulo, telefono, otrotelefono, correo, gruposanguineo, "
                        + "estado, municipio, parroquia, direccion, foto) "
                        + "VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, primernombre.toUpperCase());
                ps.setString(2, segundonombre.toUpperCase());
                ps.setString(3, primerapellido.toUpperCase());
                ps.setString(4, segundoapellido.toUpperCase());
                ps.setString(5, cedula.toUpperCase());
                ps.setString(6, fechanacimiento.toUpperCase());
                ps.setString(7, lugarnacimiento.toUpperCase());
                ps.setString(8, estadocivil.toUpperCase());
                ps.setString(9, genero.toUpperCase());
                ps.setString(10, nivelacademico.toUpperCase());
                ps.setString(11, tituloobtenido1.toUpperCase());
                ps.setString(12, tituloobtenido2.toUpperCase());
                ps.setString(13, telefono1.toUpperCase());
                ps.setString(14, telefono2.toUpperCase());
                ps.setString(15, correo.toUpperCase());
                ps.setString(16, gruposanguineo.toUpperCase());
                ps.setString(17, estado.toUpperCase());
                ps.setString(18, municipio.toUpperCase());
                ps.setString(19, parroquia.toUpperCase());
                ps.setString(20, direccion.toUpperCase());
                ps.setString(21, foto);
                ps.executeQuery();
                con.close();

                registro = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registro;

    }

    //EDITAR PERSONA
    public boolean EditarPersona(int ID, String primernombre, String segundonombre,
            String primerapellido, String segundoapellido, String cedula,
            String fechanacimiento, String lugarnacimiento, String estadocivil,
            String genero, String nivelacademico, String tituloobtenido1,
            String tituloobtenido2, String telefono1, String telefono2,
            String correo, String gruposanguineo, String estado,
            String municipio, String parroquia, String direccion, String foto) {

        try {

            PreparedStatement ps = con.prepareStatement("UPDATE Persona SET PrimerNombre = ?, "
                    + "SegundoNombre = ?, PrimerApellido = ?, SegundoApellido = ?, "
                    + "Cedula = ?, FechaNacimiento = ?, LugarNacimiento = ?, Genero = ?, "
                    + "EstadoCivil = ?, NivelAcademico = ?, TituloObtenido = ?, OtroTitulo = ?, "
                    + "Telefono = ?, OtroTelefono = ?, Correo = ?, GrupoSanguineo = ?, "
                    + "Estado = ?, Municipio = ?, Parroquia = ?, Direccion = ?, "
                    + "Foto = ? WHERE IDPersona = ?");
            ps.setString(1, primernombre.toUpperCase());
            ps.setString(2, segundonombre.toUpperCase());
            ps.setString(3, primerapellido.toUpperCase());
            ps.setString(4, segundoapellido.toUpperCase());
            ps.setString(5, cedula.toUpperCase());
            ps.setString(6, fechanacimiento.toUpperCase());
            ps.setString(7, lugarnacimiento.toUpperCase());
            ps.setString(8, genero.toUpperCase());
            ps.setString(9, estadocivil.toUpperCase());
            ps.setString(10, nivelacademico.toUpperCase());
            ps.setString(11, tituloobtenido1.toUpperCase());
            ps.setString(12, tituloobtenido2.toUpperCase());
            ps.setString(13, telefono1.toUpperCase());
            ps.setString(14, telefono2.toUpperCase());
            ps.setString(15, correo.toUpperCase());
            ps.setString(16, gruposanguineo.toUpperCase());
            ps.setString(17, estado.toUpperCase());
            ps.setString(18, municipio.toUpperCase());
            ps.setString(19, parroquia.toUpperCase());
            ps.setString(20, direccion.toUpperCase());
            ps.setString(21, foto);
            ps.setInt(22, ID);
            ps.executeUpdate();
            con.close();

            registro = true;

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registro;

    }

    //Consultar Listado de Persona
    public DefaultTableModel ListadoConsultarPersona(String consulta, int desde) {

        try {

            PreparedStatement psconsultar = con.prepareStatement("SELECT * FROM Persona WHERE "
                    + "PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                    + "PrimerApellido like '" + consulta + "%' OR "
                    + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' ORDER by Cedula "
                    + "DESC LIMIT " + desde + ",20");

            ResultSet rs = psconsultar.executeQuery();

            modelo.addColumn("N°");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("CÉDULA");
            modelo.addColumn("FECHA DE NACIMIENTO");
            modelo.addColumn("LUGAR DE NACIMIENTO");
            modelo.addColumn("ESTADO CIVIL");
            modelo.addColumn("GENERO");
            modelo.addColumn("NIVEL ACADEMICO");
            modelo.addColumn("TITULO OBTENIDO");
            modelo.addColumn("OTRO TITULO");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("OTRO TELEFONO");
            modelo.addColumn("CORREO");
            modelo.addColumn("GRUPO SANGUINEO");
            modelo.addColumn("ESTADO");
            modelo.addColumn("MUNICIPIO");
            modelo.addColumn("PARROQUIA");
            modelo.addColumn("DIRECCIÓN");
            modelo.addColumn("IDPersona");

            int numero = (desde + 1);
            String[] datos = new String[22];

            while (rs.next()) {

                datos[0] = Integer.toString(numero);
                datos[1] = rs.getString("PrimerNombre").toUpperCase();
                datos[2] = rs.getString("SegundoNombre").toUpperCase();
                datos[3] = rs.getString("PrimerApellido").toUpperCase();
                datos[4] = rs.getString("SegundoApellido").toUpperCase();
                datos[5] = rs.getString("Cedula");
                datos[6] = fecha.getFecha(rs.getString("FechaNacimiento"));
                datos[7] = rs.getString("LugarNacimiento").toUpperCase();
                datos[8] = rs.getString("EstadoCivil").toUpperCase();
                datos[9] = rs.getString("Genero").toUpperCase();
                datos[10] = rs.getString("NivelAcademico").toUpperCase();
                datos[11] = rs.getString("TituloObtenido").toUpperCase();
                datos[12] = rs.getString("OtroTitulo").toUpperCase();
                datos[13] = rs.getString("Telefono").toUpperCase();
                datos[14] = rs.getString("OtroTelefono").toUpperCase();
                datos[15] = rs.getString("Correo").toUpperCase();
                datos[16] = rs.getString("GrupoSanguineo").toUpperCase();
                datos[17] = rs.getString("Estado").toUpperCase();
                datos[18] = rs.getString("Municipio").toUpperCase();
                datos[19] = rs.getString("Parroquia").toUpperCase();
                datos[20] = rs.getString("Direccion").toUpperCase();
                datos[21] = rs.getString("IDpersona").toUpperCase();

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

    //Total Personas Registradas
    public int TotalPersonasRegistradas(String consulta) {

        try {
            String sql = "SELECT * FROM Persona WHERE "
                    + "PrimerNombre LIKE '" + consulta + "%' OR SegundoNombre like '" + consulta + "%' OR "
                    + "PrimerApellido like '" + consulta + "%' OR "
                    + "SegundoApellido like '" + consulta + "%' OR Cedula like '" + consulta + "%' ORDER by Cedula ";

            //Consultar si el Numero de Cedula existe.
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int total = 0;
            while (rs.next()) {
                total++;
            }

            totalPersonas = total;

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return totalPersonas;
    }

    public int getTotalPersonas() {
        return totalPersonas;
    }

    //BUSCAR PERSONA POR CEDULA
    public String[] DatosPersona(String cedula) {
        String[] datos = new String[22];
        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Persona WHERE cedula = ?");
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
                datos[21] = rs.getString("IDPersona");
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;
    }

    //BUSCAR PERSONA POR ID
    public String[] DatosPersonaID(String IDpersona) {
        String[] datos = new String[22];
        try {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Persona WHERE IDPersona = ?");
            ps.setString(1, IDpersona);
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
                datos[21] = rs.getString("IDPersona");
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;
    }

    //ELIMINAR PERSONA
    public void EliminarPersona(int id) {
        try {

            PreparedStatement ps = con.prepareStatement("DELETE FROM Persona WHERE IDPersona = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
