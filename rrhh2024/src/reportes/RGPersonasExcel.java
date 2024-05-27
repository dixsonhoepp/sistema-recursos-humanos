package reportes;

import myclass.ModificarFecha;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class RGPersonasExcel {

    private ModificarFecha fecha = new ModificarFecha();
    private File archivo;

    public RGPersonasExcel(File file) {
        this.archivo = file;
        
    }
    
    

    public void GenerarExcel() {

        try {

            //CREAR LIBRO EXCEL
            Workbook libro = new HSSFWorkbook();

            //CREAR HOJA UNO
            Sheet sheetListadoGeneral = libro.createSheet("LISTADO DE PERSONAS");
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



            //CREAR CABEZERA UNO
            cellDatosPersonales.setCellValue("DATOS PERSONALES");
            cellDatosPersonales.setCellStyle(styleTituloUno);

            Cell cellDireccion = rowCabezeraUno.createCell(17);
            cellDireccion.setCellValue("DIRECCÓN");
            cellDireccion.setCellStyle(styleTituloUno);


            //CREAR CABEZERA DOS
            String[] cb1 = {"N°", "PRIMER NOMBRE", "SEGUNDO NOMBRE", "PRIMER APELLIDO",
                "SEGUNDO APELLIDO", "CEDULA", "FECHA DE NACIMIENTO", "LUGAR DE NACIMIENTO",
                "ESTADO CIVIL", "GENERO", "NIVEL ACADEMICO", "TITULO OBTENIDO", "OTRO TITULO",
                "TELEFONO", "OTRO TELEFONO", "CORREO", "GRUPO SANGUINEO", "ESTADO", "MINICIPIO",
                "PARROQUIA", "LUGAR"};

            

            //CREAR ESTILO CABEZERA DOS
            CellStyle styledos = libro.createCellStyle();


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
            styledos.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            styledos.setFillPattern(FillPatternType.SOLID_FOREGROUND);


            //CREAR FILA CABEZERA DOS
            Row rowCabezeraDos = sheetListadoGeneral.createRow(1);
            rowCabezeraDos.setHeightInPoints(25);

            for (int i = 0; i < cb1.length; i++) {
                Cell cabezeraDos = rowCabezeraDos.createCell(i);
                cabezeraDos.setCellStyle(styledos);
                cabezeraDos.setCellValue(cb1[i]);
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

            String SQL = "SELECT * FROM Persona";

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
                cellResultado6.setCellValue(res.getString("Cedula"));

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

                NumColum++;
                NumFila++;
            }
            
             con.close();

            //AJUSTAR COLUMNA AL TEXTO
            for (int i = 0; i < 34; i++) {
                sheetListadoGeneral.autoSizeColumn(i);
            }

            try {
                //GENERAR LIBRO
                FileOutputStream archivo = new FileOutputStream(this.archivo);
                libro.write(archivo);
                archivo.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(RGPersonasExcel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RGPersonasExcel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RGPersonasExcel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
