package reportes;

import myclass.Edad;
import myclass.ModificarFecha;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class RGFuncionariosExcel {

    private Workbook libro = new HSSFWorkbook();
    private ModificarFecha fecha = new ModificarFecha();
    private Edad edad = new Edad();
    private File archivo;
    private ArrayList<DatosFuncionarioHM> datosFG = new ArrayList<>();
    private ArrayList<DatosFuncionarioHM> datosFH = new ArrayList<>();
    ArrayList<DatosHijosMenores> relacionHijos = new ArrayList<>();

    private Row rowRS;

    public RGFuncionariosExcel(File file) {
        this.archivo = file;

        hojaUno();
        hojaDos();

    }

    public void hojaUno() {

        try {

            //CREAR HOJA UNO
            Sheet sheetListadoGeneral = libro.createSheet("LISTADO GENERAL");
            sheetListadoGeneral.autoSizeColumn(0);

            //sheetListadoGeneral.setColumnWidth(0, 2000);
            /*
            for (int i = 1; i < 35; i++) {
            
            sheetListadoGeneral.setColumnWidth(i, 8000);
            }
             */
            //COMBINAR CELDA CABEZERA UNO
            sheetListadoGeneral.addMergedRegion(new CellRangeAddress(0, 0, 0, 16));
            sheetListadoGeneral.addMergedRegion(new CellRangeAddress(0, 0, 17, 20));
            sheetListadoGeneral.addMergedRegion(new CellRangeAddress(0, 0, 21, 31));
            sheetListadoGeneral.addMergedRegion(new CellRangeAddress(0, 0, 32, 33));

            //CREAR FILA CABEZERA UNO
            Row rowCabezeraUno = sheetListadoGeneral.createRow(0);
            rowCabezeraUno.setHeightInPoints(30);

            //CREAR FUENTE TITULO UNO
            Font fTituloUno = libro.createFont();

            fTituloUno.setBold(true);
            fTituloUno.setFontHeightInPoints((short) 12);
            fTituloUno.setFontName("Calibri Light");

            //CREAR ESTILO TITULO UNO
            CellStyle styleTituloUno = libro.createCellStyle();
            styleTituloUno.setFont(fTituloUno);
            styleTituloUno.setBorderBottom(BorderStyle.THIN);
            styleTituloUno.setBorderTop(BorderStyle.THIN);
            styleTituloUno.setBorderLeft(BorderStyle.THIN);
            styleTituloUno.setBorderRight(BorderStyle.THIN);
            styleTituloUno.setAlignment(HorizontalAlignment.CENTER);
            styleTituloUno.setVerticalAlignment(VerticalAlignment.CENTER);
            styleTituloUno.setFillForegroundColor(IndexedColors.GOLD.getIndex());
            styleTituloUno.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            //CREAR CELDA TITULO DEL LISTADO UNO
            Cell cellDatosPersonales = rowCabezeraUno.createCell(0);

            for (int i = 1; i < 17; i++) {
                rowCabezeraUno.createCell(i).setCellStyle(styleTituloUno);
            }

            for (int i = 18; i < 21; i++) {
                rowCabezeraUno.createCell(i).setCellStyle(styleTituloUno);
            }

            for (int i = 22; i < 32; i++) {
                rowCabezeraUno.createCell(i).setCellStyle(styleTituloUno);
            }

            for (int i = 33; i < 34; i++) {
                rowCabezeraUno.createCell(i).setCellStyle(styleTituloUno);
            }

            //CREAR CABEZERA UNO
            cellDatosPersonales.setCellValue("DATOS PERSONALES");
            cellDatosPersonales.setCellStyle(styleTituloUno);

            Cell cellDireccion = rowCabezeraUno.createCell(17);
            cellDireccion.setCellValue("DIRECCÓN");
            cellDireccion.setCellStyle(styleTituloUno);

            Cell cellDatosPolicial = rowCabezeraUno.createCell(21);
            cellDatosPolicial.setCellValue("DATOS POLICIAL");
            cellDatosPolicial.setCellStyle(styleTituloUno);

            Cell cellDatosBancario = rowCabezeraUno.createCell(32);
            cellDatosBancario.setCellValue("DATOS BANCARIO");
            cellDatosBancario.setCellStyle(styleTituloUno);

            //CREAR CABEZERA DOS
            String[] cb1 = {"N°", "PRIMER NOMBRE", "SEGUNDO NOMBRE", "PRIMER APELLIDO",
                "SEGUNDO APELLIDO", "CEDULA", "FECHA DE NACIMIENTO", "LUGAR DE NACIMIENTO",
                "ESTADO CIVIL", "GENERO", "NIVEL ACADEMICO", "TITULO OBTENIDO", "OTRO TITULO",
                "TELEFONO", "OTRO TELEFONO", "CORREO", "GRUPO SANGUINEO", "ESTADO", "MINICIPIO",
                "PARROQUIA", "LUGAR"};

            String[] cb2 = {"RANGO", "FECHA DE INGRESO", "FECHA DE ASCENSO",
                "CODIGO DEL CARNET", "CONDICIÓN", "SERVICIO", "MUNICIPIO", "TALLA DE CAMISA",
                "TALLA DE PANTALON", "TALLA DE CALZADO", "TALLA DE GORRA"};

            String[] cb3 = {"BANCO", "NUMERO DE CUENTA"};

            //CREAR ESTILO CABEZERA DOS
            CellStyle styledos = libro.createCellStyle();
            CellStyle styletres = libro.createCellStyle();
            CellStyle stylecuatro = libro.createCellStyle();

            //CREAR FUENTE
            Font fuenteDos = libro.createFont();
            fuenteDos.setBold(true);
            fuenteDos.setColor(IndexedColors.WHITE.getIndex());
            fuenteDos.setFontHeightInPoints((short) 12);
            fuenteDos.setFontName("Calibri Light");

            styledos.setFont(fuenteDos);
            styledos.setBorderBottom(BorderStyle.THIN);
            styledos.setBorderTop(BorderStyle.THIN);
            styledos.setBorderLeft(BorderStyle.THIN);
            styledos.setBorderRight(BorderStyle.THIN);
            styledos.setAlignment(HorizontalAlignment.CENTER);
            styledos.setVerticalAlignment(VerticalAlignment.CENTER);
            styledos.setFillForegroundColor(IndexedColors.DARK_TEAL.getIndex());
            styledos.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            styletres.setFont(fuenteDos);
            styletres.setBorderBottom(BorderStyle.THIN);
            styletres.setBorderTop(BorderStyle.THIN);
            styletres.setBorderLeft(BorderStyle.THIN);
            styletres.setBorderRight(BorderStyle.THIN);
            styletres.setAlignment(HorizontalAlignment.CENTER);
            styletres.setVerticalAlignment(VerticalAlignment.CENTER);
            styletres.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
            styletres.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            stylecuatro.setFont(fuenteDos);
            stylecuatro.setBorderBottom(BorderStyle.THIN);
            stylecuatro.setBorderTop(BorderStyle.THIN);
            stylecuatro.setBorderLeft(BorderStyle.THIN);
            stylecuatro.setBorderRight(BorderStyle.THIN);
            stylecuatro.setAlignment(HorizontalAlignment.CENTER);
            stylecuatro.setVerticalAlignment(VerticalAlignment.CENTER);
            stylecuatro.setFillForegroundColor(IndexedColors.DARK_GREEN.getIndex());
            stylecuatro.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            //CREAR FILA CABEZERA DOS
            Row rowCabezeraDos = sheetListadoGeneral.createRow(1);
            rowCabezeraDos.setHeightInPoints(25);

            for (int i = 0; i < cb1.length; i++) {
                Cell cabezeraDos = rowCabezeraDos.createCell(i);
                cabezeraDos.setCellStyle(styledos);
                cabezeraDos.setCellValue(cb1[i]);
            }

            for (int i = 0; i < cb2.length; i++) {
                Cell cabezeraTres = rowCabezeraDos.createCell(21 + i);
                cabezeraTres.setCellStyle(styletres);
                cabezeraTres.setCellValue(cb2[i]);
            }

            for (int i = 0; i < cb3.length; i++) {
                Cell cabezeraCuatro = rowCabezeraDos.createCell(32 + i);
                cabezeraCuatro.setCellStyle(stylecuatro);
                cabezeraCuatro.setCellValue(cb3[i]);
            }

            //CREAR ESTILO DE RESULTADO
            CellStyle styleResultado = libro.createCellStyle();

            //CREAR FUENTE
            Font fuenteResultado = libro.createFont();
            fuenteResultado.setFontHeightInPoints((short) 12);
            fuenteResultado.setFontName("Calibri Light");
            fuenteResultado.setColor(IndexedColors.GREY_80_PERCENT.getIndex());

            styleResultado.setFont(fuenteResultado);
            styleResultado.setBorderBottom(BorderStyle.THIN);
            styleResultado.setBorderTop(BorderStyle.THIN);
            styleResultado.setBorderLeft(BorderStyle.THIN);
            styleResultado.setBorderRight(BorderStyle.THIN);

            //CONSULTAR FUNCIONARIOS
            //Conexion
            Conexion cc = new Conexion();
            Connection con = cc.conectar();

            String SQL = "SELECT * FROM Persona INNER JOIN Funcionario "
                    + "on Persona.IDPersona = Funcionario.IDPersona WHERE Condicion != 'BAJA' "
                    + "ORDER by Rango DESC";

            PreparedStatement prepared = con.prepareStatement(SQL);
            ResultSet res = prepared.executeQuery();

            int NumFila = 2;
            int NumColum = 1;

            while (res.next()) {

                Row rowResultado = sheetListadoGeneral.createRow(NumFila);

                Cell cellResultado1 = rowResultado.createCell(0);
                cellResultado1.setCellStyle(styleResultado);
                cellResultado1.setCellValue(NumColum);

                Cell cellResultado2 = rowResultado.createCell(1);
                cellResultado2.setCellStyle(styleResultado);
                cellResultado2.setCellValue(res.getString("PrimerNombre"));

                Cell cellResultado3 = rowResultado.createCell(2);
                cellResultado3.setCellStyle(styleResultado);
                cellResultado3.setCellValue(res.getString("SegundoNombre"));

                Cell cellResultado4 = rowResultado.createCell(3);
                cellResultado4.setCellStyle(styleResultado);
                cellResultado4.setCellValue(res.getString("PrimerApellido"));

                Cell cellResultado5 = rowResultado.createCell(4);
                cellResultado5.setCellStyle(styleResultado);
                cellResultado5.setCellValue(res.getString("SegundoApellido"));

                Cell cellResultado6 = rowResultado.createCell(5);
                cellResultado6.setCellStyle(styleResultado);
                cellResultado6.setCellValue(res.getInt("Cedula"));

                Cell cellResultado7 = rowResultado.createCell(6);
                cellResultado7.setCellStyle(styleResultado);
                cellResultado7.setCellValue(fecha.getFecha(res.getString("FechaNacimiento")));

                Cell cellResultado8 = rowResultado.createCell(7);
                cellResultado8.setCellStyle(styleResultado);
                cellResultado8.setCellValue(res.getString("LugarNacimiento"));

                Cell cellResultado9 = rowResultado.createCell(8);
                cellResultado9.setCellStyle(styleResultado);
                cellResultado9.setCellValue(res.getString("EstadoCivil"));

                Cell cellResultado10 = rowResultado.createCell(9);
                cellResultado10.setCellStyle(styleResultado);
                cellResultado10.setCellValue(res.getString("Genero"));

                Cell cellResultado11 = rowResultado.createCell(10);
                cellResultado11.setCellStyle(styleResultado);
                cellResultado11.setCellValue(res.getString("NivelAcademico"));

                Cell cellResultado12 = rowResultado.createCell(11);
                cellResultado12.setCellStyle(styleResultado);
                cellResultado12.setCellValue(res.getString("TituloObtenido"));

                Cell cellResultado13 = rowResultado.createCell(12);
                cellResultado13.setCellStyle(styleResultado);
                cellResultado13.setCellValue(res.getString("OtroTitulo"));

                Cell cellResultado14 = rowResultado.createCell(13);
                cellResultado14.setCellStyle(styleResultado);
                cellResultado14.setCellValue(res.getString("Telefono"));

                Cell cellResultado15 = rowResultado.createCell(14);
                cellResultado15.setCellStyle(styleResultado);
                cellResultado15.setCellValue(res.getString("OtroTelefono"));

                Cell cellResultado16 = rowResultado.createCell(15);
                cellResultado16.setCellStyle(styleResultado);
                cellResultado16.setCellValue(res.getString("Correo"));

                Cell cellResultado17 = rowResultado.createCell(16);
                cellResultado17.setCellStyle(styleResultado);
                cellResultado17.setCellValue(res.getString("GrupoSanguineo"));

                Cell cellResultado18 = rowResultado.createCell(17);
                cellResultado18.setCellStyle(styleResultado);
                cellResultado18.setCellValue(res.getString("Estado"));

                Cell cellResultado19 = rowResultado.createCell(18);
                cellResultado19.setCellStyle(styleResultado);
                cellResultado19.setCellValue(res.getString("Municipio"));

                Cell cellResultado20 = rowResultado.createCell(19);
                cellResultado20.setCellStyle(styleResultado);
                cellResultado20.setCellValue(res.getString("Parroquia"));

                Cell cellResultado21 = rowResultado.createCell(20);
                cellResultado21.setCellStyle(styleResultado);
                cellResultado21.setCellValue(res.getString("Direccion"));

                //RANGO
                String rango = "";

                switch (Integer.parseInt(res.getString("Rango"))) {
                    case 0:
                        rango = "OFICIAL";
                        break;
                    case 1:
                        rango = "OFICIAL AGREGADO";
                        break;
                    case 2:
                        rango = "OFICIAL JEFE";
                        break;
                    case 3:
                        rango = "SUPERVISOR";
                        break;
                    case 4:
                        rango = "SUPERVISOR AGREGADO";
                        break;
                    case 5:
                        rango = "SUPERVISOR JEFE";
                        break;
                    case 6:
                        rango = "COMISIONADO";
                        break;
                    case 7:
                        rango = "COMISIONADO AGREGADO";
                        break;
                    case 8:
                        rango = "COMISIONADO JEFE";
                        break;
                }

                Cell cellResultado22 = rowResultado.createCell(21);
                cellResultado22.setCellStyle(styleResultado);
                cellResultado22.setCellValue(rango);

                Cell cellResultado23 = rowResultado.createCell(22);
                cellResultado23.setCellStyle(styleResultado);
                cellResultado23.setCellValue(fecha.getFecha(res.getString("FechaIngreso")));

                Cell cellResultado24 = rowResultado.createCell(23);
                cellResultado24.setCellStyle(styleResultado);
                cellResultado24.setCellValue(fecha.getFecha(res.getString("FechaAscenso")));

                Cell cellResultado25 = rowResultado.createCell(24);
                cellResultado25.setCellStyle(styleResultado);
                cellResultado25.setCellValue(res.getString("CodigoCarnet"));

                Cell cellResultado26 = rowResultado.createCell(25);
                cellResultado26.setCellStyle(styleResultado);
                cellResultado26.setCellValue(res.getString("Condicion"));

                Cell cellResultado27 = rowResultado.createCell(26);
                cellResultado27.setCellStyle(styleResultado);
                cellResultado27.setCellValue(res.getString("Servicio"));

                Cell cellResultado29 = rowResultado.createCell(27);
                cellResultado29.setCellStyle(styleResultado);
                cellResultado29.setCellValue(res.getString("Municipio"));

                Cell cellResultado30 = rowResultado.createCell(28);
                cellResultado30.setCellStyle(styleResultado);
                cellResultado30.setCellValue(res.getString("TallaCamisa"));

                Cell cellResultado31 = rowResultado.createCell(29);
                cellResultado31.setCellStyle(styleResultado);
                cellResultado31.setCellValue(res.getString("TallaPantalon"));

                Cell cellResultado32 = rowResultado.createCell(30);
                cellResultado32.setCellStyle(styleResultado);
                cellResultado32.setCellValue(res.getString("TallaZapato"));

                Cell cellResultado33 = rowResultado.createCell(31);
                cellResultado33.setCellStyle(styleResultado);
                cellResultado33.setCellValue(res.getString("TallaGorra"));

                Cell cellResultado34 = rowResultado.createCell(32);
                cellResultado34.setCellStyle(styleResultado);
                cellResultado34.setCellValue(res.getString("Banco"));

                Cell cellResultado35 = rowResultado.createCell(33);
                cellResultado35.setCellStyle(styleResultado);
                cellResultado35.setCellValue(res.getString("NumeroCuenta"));

                NumColum++;
                NumFila++;
            }

            //con.close();
            //AJUSTAR COLUMNA AL TEXTO
            for (int i = 0; i < 34; i++) {
                sheetListadoGeneral.autoSizeColumn(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RGFuncionariosExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hojaDos() {

        Sheet hoja = libro.createSheet("RELACIÓN DE HIJOS");

        //DEFINIR EL TAMAÑO DE LAS COLUMNAS
        hoja.setColumnWidth(0, 1500);
        hoja.setColumnWidth(1, 8000);
        hoja.setColumnWidth(2, 4500);
        hoja.setColumnWidth(3, 4500);
        hoja.setColumnWidth(4, 4500);
        hoja.setColumnWidth(5, 4500);
        hoja.setColumnWidth(6, 3000);
        hoja.setColumnWidth(7, 3000);
        hoja.setColumnWidth(8, 3000);

        hoja.setColumnWidth(9, 1500);
        hoja.setColumnWidth(10, 2000);
        hoja.setColumnWidth(11, 4500);
        hoja.setColumnWidth(12, 4500);
        hoja.setColumnWidth(13, 4500);
        hoja.setColumnWidth(14, 4500);
        hoja.setColumnWidth(15, 3000);
        hoja.setColumnWidth(16, 3000);

        //CREAR FILAS
        Row rowCabezeraUno = hoja.createRow(0);
        Row rowCabezeraDos = hoja.createRow(1);

        //CREAR ESTILO TITULO UNO
        CellStyle estilo1 = libro.createCellStyle();

        //CREAR FUENTE TITULO UNO
        Font fTituloUno = libro.createFont();
        fTituloUno.setBold(true);
        fTituloUno.setFontHeightInPoints((short) 12);
        fTituloUno.setFontName("Calibri Light");

        //ASIGNAR ESTILOS
        estilo1.setFont(fTituloUno);
        estilo1.setBorderBottom(BorderStyle.THIN);
        estilo1.setBorderTop(BorderStyle.THIN);
        estilo1.setBorderLeft(BorderStyle.THIN);
        estilo1.setBorderRight(BorderStyle.THIN);
        estilo1.setAlignment(HorizontalAlignment.CENTER);
        estilo1.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo1.setFillForegroundColor(IndexedColors.GOLD.getIndex());
        estilo1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //COMBINAR CELDA CABEZERA UNO
        hoja.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        hoja.addMergedRegion(new CellRangeAddress(0, 0, 9, 16));

        //ALTURA DEL TITULO UNO
        rowCabezeraUno.setHeightInPoints((short) 25);

        //TEXTO DEL TITULO UNO
        String[] cb1 = {"FUNCIONARIOS", "RELACIÓN DE HIJOS MENORES"};

        //GENERAR CABEZERA TITULO UNO 1
        for (int i = 0; i < 9; i++) {

            Cell c1 = rowCabezeraUno.createCell(i);
            c1.setCellStyle(estilo1);
            if (i == 0) {
                c1.setCellValue(cb1[0]);
            }
        }

        //GENERAR CABEZERA TITULO UNO 2
        for (int i = 9; i < 17; i++) {

            Cell c1 = rowCabezeraUno.createCell(i);
            c1.setCellStyle(estilo1);
            if (i == 9) {
                c1.setCellValue(cb1[1]);
            }
        }

        //CREAR ESTILO CABEZERA DOS
        CellStyle estilo2 = libro.createCellStyle();
        CellStyle estilo3 = libro.createCellStyle();

        //CREAR FUENTE TITULO DOS
        Font fTituloDos = libro.createFont();
        fTituloDos.setBold(true);
        fTituloDos.setFontHeightInPoints((short) 12);
        fTituloDos.setFontName("Calibri Light");
        fTituloDos.setColor(IndexedColors.WHITE.getIndex());

        //GENERAR ESTILOS CABEZERA DOS FUNCIONARIO
        estilo2.setFont(fTituloDos);
        estilo2.setBorderBottom(BorderStyle.THIN);
        estilo2.setBorderTop(BorderStyle.THIN);
        estilo2.setBorderLeft(BorderStyle.THIN);
        estilo2.setBorderRight(BorderStyle.THIN);
        estilo2.setAlignment(HorizontalAlignment.CENTER);
        estilo2.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo2.setFillForegroundColor(IndexedColors.DARK_TEAL.getIndex());
        estilo2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilo2.setWrapText(true);

        //GENERAR ESTILOS CABEZERA DOS RELACION DE HIJOS
        estilo3.setFont(fTituloDos);
        estilo3.setBorderBottom(BorderStyle.THIN);
        estilo3.setBorderTop(BorderStyle.THIN);
        estilo3.setBorderLeft(BorderStyle.THIN);
        estilo3.setBorderRight(BorderStyle.THIN);
        estilo3.setAlignment(HorizontalAlignment.CENTER);
        estilo3.setVerticalAlignment(VerticalAlignment.CENTER);
        estilo3.setFillForegroundColor(IndexedColors.DARK_RED.getIndex());
        estilo3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilo3.setWrapText(true);

        //GENERAR TEXTO CABEZERA DOS FUNCIONARIOS
        String[] cb2 = {"N°", "RANGO", "PRIMER NOMBRE", "SEGUNDO NOMBRE",
            "PRIMER APELLIDO", "SEGUNDO APELLIDO", "GENERO", "CEDULA", "N° HIJO"};

        for (int i = 0; i < cb2.length; i++) {
            Cell c1 = rowCabezeraDos.createCell(i);
            c1.setCellStyle(estilo2);
            c1.setCellValue(cb2[i]);
        }

        //GENERAR TEXTO CABEZERA DOS RELACION DE HIJOS
        String[] cb3 = {"N°", "EDAD", "PRIMER NOMBRE", "SEGUNDO NOMBRE",
            "PRIMER APELLIDO", "SEGUNDO APELLIDO", "GENERO", "CEDULA"};

        for (int i = 0; i < 8; i++) {
            Cell c1 = rowCabezeraDos.createCell(i + 9);
            c1.setCellStyle(estilo3);
            c1.setCellValue(cb3[i]);

        }

        //CREAR ESTILO PARA EL RESULTADO
        CellStyle styleResultado = libro.createCellStyle();

        //CREAR FUENTE
        Font fuenteResultado = libro.createFont();
        fuenteResultado.setFontHeightInPoints((short) 12);
        fuenteResultado.setFontName("Calibri Light");
        fuenteResultado.setColor(IndexedColors.GREY_80_PERCENT.getIndex());

        styleResultado.setFont(fuenteResultado);
        styleResultado.setBorderBottom(BorderStyle.THIN);
        styleResultado.setBorderTop(BorderStyle.THIN);
        styleResultado.setBorderLeft(BorderStyle.THIN);
        styleResultado.setBorderRight(BorderStyle.THIN);
        styleResultado.setAlignment(HorizontalAlignment.CENTER);
        styleResultado.setVerticalAlignment(VerticalAlignment.CENTER);
        styleResultado.setWrapText(true);

        //CONEXION A DATEBASE
        Conexion cc = new Conexion();
        Connection con = cc.conectar();

        String Sql1 = "SELECT * FROM Funcionario INNER JOIN Persona ON "
                + "Funcionario.IDPersona = Persona.IDPersona "
                + "WHERE Condicion != 'BAJA' ORDER BY Funcionario.Rango DESC, "
                + "Funcionario.IDFuncionario";

        try {
            PreparedStatement ps = con.prepareStatement(Sql1);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int id = res.getInt("IDFuncionario");
                int rango = res.getInt("Rango");
                String pn = res.getString("PrimerNombre");
                String sn = res.getString("SegundoNombre");
                String pa = res.getString("PrimerApellido");
                String sa = res.getString("SegundoApellido");
                String genero = res.getString("Genero");
                String cedula = res.getString("Cedula");
                int ch = 0;

                //GENERAR ARRAYLIST CON RESULTADO TOTAL
                datosFG.add(new DatosFuncionarioHM(id, rango, pn, sn, pa, sa, genero, cedula, ch));

            }

            //CONSULTAR HIJO
            for (int i = 0; i < datosFG.size(); i++) {

                String Sql2 = "SELECT * FROM Familiares INNER JOIN Persona "
                        + "ON Familiares.IDPersona = Persona.IDPersona "
                        + "INNER JOIN Funcionario ON "
                        + "Familiares.IDFuncionario = Funcionario.IDFuncionario "
                        + "WHERE Condicion != 'BAJA' AND Parentesco = 'HIJO(A)' "
                        + "AND Familiares.IDFuncionario = " + datosFG.get(i).getId()
                        + " ORDER BY Funcionario.Rango, Funcionario.IDFuncionario DESC";

                PreparedStatement ps2 = con.prepareStatement(Sql2);
                ResultSet res2 = ps2.executeQuery();

                int numH = 0;

                while (res2.next()) {

                    //OBTENER HIJOS MENORES
                    int edadHijo = edad.getEdad(res2.getString("FechaNacimiento"));

                    if (edadHijo < 18) {
                        numH++;
                    }

                }

                datosFG.get(i).ch = numH;

            }

        } catch (SQLException ex) {
            Logger.getLogger(RGFuncionariosExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CREAR UN ARRAYLIST SOLO CON LOS FUNCIONARIOS QUE TIENEN HIJOS MENORES
        for (int i = 0; i < datosFG.size(); i++) {

            if (datosFG.get(i).getCh() > 0) {

                datosFH.add(new DatosFuncionarioHM(
                        datosFG.get(i).getId(),
                        datosFG.get(i).getRango(),
                        datosFG.get(i).getPn(),
                        datosFG.get(i).getSn(),
                        datosFG.get(i).getPa(),
                        datosFG.get(i).getSa(),
                        datosFG.get(i).getGenero(),
                        datosFG.get(i).getCedula(),
                        datosFG.get(i).getCh()));
            }
        }

        //RELACION DE HIJOS
        String Sql3 = "SELECT * FROM Familiares INNER JOIN Persona "
                + "ON Familiares.IDPersona = Persona.IDPersona "
                + "INNER JOIN Funcionario ON "
                + "Familiares.IDFuncionario = Funcionario.IDFuncionario "
                + "WHERE Parentesco = 'HIJO(A)'"
                + "ORDER BY Funcionario.Rango DESC, Funcionario.IDFuncionario";

        //CONSULTAR MENORES
        try {
            PreparedStatement ps3 = con.prepareStatement(Sql3);
            ResultSet res3 = ps3.executeQuery();

            while (res3.next()) {

                if (edad.getEdad(res3.getString("FechaNacimiento")) < 18) {

                    relacionHijos.add(new DatosHijosMenores(
                            edad.getEdad(res3.getString("FechaNacimiento")),
                            res3.getString("PrimerNombre"),
                            res3.getString("SegundoNombre"),
                            res3.getString("PrimerApellido"),
                            res3.getString("SegundoApellido"),
                            res3.getString("Genero"),
                            res3.getString("Cedula"),
                            res3.getInt("IDFuncionario")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(RGFuncionariosExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

        int r = 0;
        int rc = 0;
        int num = 1;
        int fh = 0;

        //MOSTRAR RESULTADO DE LOS FUNCIONARIOS QUE TIENEN HIJOS MENORES
        for (int i = 0; i < datosFH.size(); i++) {

            num = 1;
            //FILA RESULTADO
            rc += r;
            rowRS = hoja.createRow((i + 2) + rc);

            Cell cResultado1 = rowRS.createCell(0);
            cResultado1.setCellStyle(styleResultado);
            cResultado1.setCellValue(i + 1);

            Cell cResultado2 = rowRS.createCell(1);
            cResultado2.setCellStyle(styleResultado);
            cResultado2.setCellValue(getRango(datosFH.get(i).getRango()));

            Cell cResultado3 = rowRS.createCell(2);
            cResultado3.setCellStyle(styleResultado);
            cResultado3.setCellValue(datosFH.get(i).getPn());

            Cell cResultado4 = rowRS.createCell(3);
            cResultado4.setCellStyle(styleResultado);
            cResultado4.setCellValue(datosFH.get(i).getSn());

            Cell cResultado5 = rowRS.createCell(4);
            cResultado5.setCellStyle(styleResultado);
            cResultado5.setCellValue(datosFH.get(i).getPa());

            Cell cResultado6 = rowRS.createCell(5);
            cResultado6.setCellStyle(styleResultado);
            cResultado6.setCellValue(datosFH.get(i).getSa());

            Cell cResultado7 = rowRS.createCell(6);
            cResultado7.setCellStyle(styleResultado);
            cResultado7.setCellValue(datosFH.get(i).getGenero());

            Cell cResultado8 = rowRS.createCell(7);
            cResultado8.setCellStyle(styleResultado);
            cResultado8.setCellValue(datosFH.get(i).getCedula());

            Cell cResultado9 = rowRS.createCell(8);
            cResultado9.setCellStyle(styleResultado);
            cResultado9.setCellValue(datosFH.get(i).getCh());

            //COMBINAR CELDA
            switch (datosFH.get(i).getCh()) {

                case 1:
                    //VALOR DE FILA
                    r = 0;
                    break;

                case 2:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 1, 8, 8));
                    //VALOR DE FILA
                    r = 1;

                    break;

                case 3:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 2, 8, 8));
                    //VALOR DE FILA
                    r = 2;

                    break;

                case 4:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 3, 8, 8));
                    //VALOR DE FILA
                    r = 3;

                    break;

                case 5:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 4, 8, 8));
                    //VALOR DE FILA
                    r = 4;

                    break;

                case 6:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 5, 8, 8));
                    //VALOR DE FILA
                    r = 5;

                    break;

                case 7:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 6, 8, 8));
                    //VALOR DE FILA
                    r = 6;

                    break;

                case 8:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 7, 8, 8));
                    //VALOR DE FILA
                    r = 7;

                    break;

                case 9:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 8, 8, 8));
                    //VALOR DE FILA
                    r = 8;

                    break;

                case 10:
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 0, 0));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 1, 1));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 2, 2));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 3, 3));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 4, 4));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 5, 5));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 6, 6));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 7, 7));
                    hoja.addMergedRegion(new CellRangeAddress((i + 2) + rc, (i + 2) + rc + 9, 8, 8));
                    //VALOR DE FILA
                    r = 9;

                    break;

            }

            //DATOS DE HIJOS
            for (int j = 0; j < datosFH.get(i).getCh(); j++) {

                Cell cResultado10 = rowRS.createCell(9);
                cResultado10.setCellStyle(styleResultado);
                cResultado10.setCellValue(num);

                Cell cResultado11 = rowRS.createCell(10);
                cResultado11.setCellStyle(styleResultado);
                cResultado11.setCellValue(relacionHijos.get(fh).getEdad());

                Cell cResultado12 = rowRS.createCell(11);
                cResultado12.setCellStyle(styleResultado);
                cResultado12.setCellValue(relacionHijos.get(fh).getPn());

                Cell cResultado13 = rowRS.createCell(12);
                cResultado13.setCellStyle(styleResultado);
                cResultado13.setCellValue(relacionHijos.get(fh).getSn());

                Cell cResultado14 = rowRS.createCell(13);
                cResultado14.setCellStyle(styleResultado);
                cResultado14.setCellValue(relacionHijos.get(fh).getPa());

                Cell cResultado15 = rowRS.createCell(14);
                cResultado15.setCellStyle(styleResultado);
                cResultado15.setCellValue(relacionHijos.get(fh).getSa());

                Cell cResultado16 = rowRS.createCell(15);
                cResultado16.setCellStyle(styleResultado);
                cResultado16.setCellValue(relacionHijos.get(fh).getGenero());

                Cell cResultado17 = rowRS.createCell(16);
                cResultado17.setCellStyle(styleResultado);
                cResultado17.setCellValue(relacionHijos.get(fh).getCedula());

                if (datosFH.get(i).getCh() > 1) {
                    rowRS = hoja.createRow((i + rc + 2) + j + 1);
                }

                num++;
                fh++;

                if (datosFH.get(i).getCh() != 1) {
                    if (fh < relacionHijos.size()) {

                        for (int k = 0; k < 9; k++) {
                            rowRS.createCell(k).setCellStyle(styleResultado);
                        }

                    }
                }

            }

        }

    }

    public void generarExcel() {
        try {

            //GENERAR LIBRO
            FileOutputStream archivo = new FileOutputStream(this.archivo);
            libro.write(archivo);
            archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RGFuncionariosExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RGFuncionariosExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getRango(int rango) {

        String mostrar = "";

        switch (rango) {
            case 0:
                mostrar = "OFICIAL";
                break;
            case 1:
                mostrar = "OFICIAL AGREGADO";
                break;
            case 2:
                mostrar = "OFICIAL JEFE";
                break;
            case 3:
                mostrar = "SUPERVISOR";
                break;
            case 4:
                mostrar = "SUPERVISOR AGREGADO";
                break;
            case 5:
                mostrar = "SUPERVISOR JEFE";
                break;
            case 6:
                mostrar = "COMISIONADO";
                break;
            case 7:
                mostrar = "COMISIONADO AGREGADO";
                break;
            case 8:
                mostrar = "COMISIONADO JEFE";
                break;
        }

        return mostrar;
    }

}
