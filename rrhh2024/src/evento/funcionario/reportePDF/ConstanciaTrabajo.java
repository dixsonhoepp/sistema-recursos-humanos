package evento.funcionario.reportePDF;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import myclass.Cargando;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import model.Directores;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import view.funcionarios.VVerFuncionario;
import view.funcionarios.reportePDF.VFechaReporte;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class ConstanciaTrabajo extends MouseAdapter {

    public static String nombre, rango, cedula, dependencia, nivelAcademico, ingreso, salario;

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            VVerFuncionario frame = (VVerFuncionario) SwingUtilities.getWindowAncestor(e.getComponent());

            //datos del funcionario
            nombre = frame.getPrimerapellido().getText() + " "
                    + frame.getSegundoapellido().getText() + " "
                    + frame.getPrimernombre().getText() + " "
                    + frame.getSegundonombre().getText();
            rango = frame.getRango().getText();
            cedula = frame.getCedula().getText();
            dependencia = frame.getServicio().getText();
            ingreso = frame.getFechaingreso().getText();
            nivelAcademico = nivelAcademico(frame.getNivelacademico().getText(), frame.getGenero().getText());

            //obtener salario de archivo txt
            Object object = new JSONParser().parse(new FileReader("salario.txt"));
            JSONObject JSON = (JSONObject) object;

            salario = JSON.get(rango).toString();

            VFechaReporte ventana = new VFechaReporte(frame, true);
            ventana.getBtn().addActionListener((evt) -> {

                if (ventana.getFecha().getDate() != null) {

                    JFileChooser file = new JFileChooser();

                    SimpleDateFormat fMes = new SimpleDateFormat("MMMM");
                    SimpleDateFormat fDia = new SimpleDateFormat("dd");
                    SimpleDateFormat fAno = new SimpleDateFormat("yyyy");

                    String mes = fMes.format(ventana.getFecha().getDate()).toUpperCase();
                    String dia = fDia.format(ventana.getFecha().getDate());
                    String ano = fAno.format(ventana.getFecha().getDate());

                    if (file.showSaveDialog(ventana) != JFileChooser.CANCEL_OPTION) {

                        Thread hilo = new Thread(() -> {
                            Cargando loader = new Cargando();
                            loader.mostrar(ventana);
                            try {

                                generarPDF(file.getSelectedFile().getPath(), dia, mes, ano);

                  

                            } catch (MalformedURLException ex) {
                                Logger.getLogger(ConstanciaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            loader.ocultar();
                            
                            VAprobado exito = new VAprobado(frame, true);
                            exito.setVisible(true);
                            
                        });

                        hilo.start();

                    }

                } else {
                    VError error = new VError(ventana, true);
                    error.texto.setText("Debe seleccionar una fecha");
                    error.setVisible(true);
                }

            });
            ventana.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ConstanciaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConstanciaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void generarPDF(String ruta, String dia, String mes, String ano) throws MalformedURLException {

        //Consutlar Direcotr de gestion humana
        Directores consultaRRHH = new Directores();
        List<model.list.Directores> listaRRHH = consultaRRHH.getInformacion("DIRECTOR DE GESTIÓN HUMANA");
        if (listaRRHH.size() < 1) {
            listaRRHH = consultaRRHH.getInformacion("DIRECTORA DE GESTIÓN HUMANA");
        }
        String nivelAcademicoRRHH = nivelAcademico(listaRRHH.get(0).getNivelAcademico(), listaRRHH.get(0).getGenero());

        try {
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(ruta + ".pdf"));
            pdfDocument.addNewPage();
            Document documentos = new Document(pdfDocument, PageSize.LETTER);
            documentos.setMargins(30, 60, 30, 60);
            Paragraph titulo = new Paragraph("REPÚBLICA BOLIVARIANA DE VENEZUELA\n"
                    + "MINISTERIO DEL P. P. PARA LA RELACIONES, INTERIORES, JUSTICIA Y PAZ\n"
                    + "VICE MINISTERIO DEL SISTEMA INTEGRADO DE POLICÍA\n"
                    + "GOBERNACIÓN DEL ESTADO DELTA AMACURO\n"
                    + "CUERPO DE POLICÍA DEL ESTADO DELTA AMACURO\n"
                    + "RIF G - 200019662\n"
                    + "DIRECCIÓN\n"
                    + "DIRECCIÓN DE GESTIÓN HUMANA\n\n\n")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(9);

            Paragraph asunto = new Paragraph()
                    .add(new Text("CONSTANCIA DE TRABAJO.\n\n"))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold()
                    .setUnderline();

            //contenido principal del codumento
            Paragraph contenido = new Paragraph()
                    .add(new Text("QUIEN SUSCRIBE "
                            + listaRRHH.get(0).getRango().toUpperCase() + " " + nivelAcademicoRRHH + " " + listaRRHH.get(0).getCargo().toUpperCase() + " "
                            + "DE LA POLICÍA DEL ESTADO DELTA AMACURO, "
                            + "POR MEDIO DE LA PRESENTE HACE CONSTAR QUE EL (A) CIUDADANO (A): "))
                    .add(new Text(rango + " (CPEDA) " + nombre + " ").setBold().setUnderline())
                    .add(new Text("TITULAR DE LA CEDULA DE IDENTIDAD N° V- "))
                    .add(new Text(cedula + " ").setBold().setUnderline())
                    .add(new Text("PRESTA SUS SERVICIOS EN  ESTA INSTITUCIÓN POLICIAL, DESDE EL: "))
                    .add(new Text(ingreso + " ").setBold().setUnderline())
                    .add(new Text("HASTA LA PRESENTE FECHA. DEVENGANDO UN SALARIO MENSUAL DE: Bs."))
                    .add(new Text(salario + ".\n").setBold().setUnderline())
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setFontSize(12)
                    .setMultipliedLeading(2f)
                    .setFirstLineIndent(50);

            //Fecha de la constancia 
            //contenido principal del codumento
            Paragraph contenido2 = new Paragraph()
                    .add(new Text("CONSTANCIA QUE SE EXPIDE EN LA CIUDAD DE TUCUPITA A LOS  "))
                    .add(new Text(dia).setBold().setUnderline())
                    .add(new Text(" DIAS DEL MES DE "))
                    .add(new Text(mes).setBold().setUnderline())
                    .add(new Text(" DEL AÑO "))
                    .add(new Text(ano + ". \n\n\n").setBold().setUnderline())
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setFontSize(12)
                    .setMultipliedLeading(2f)
                    .setFirstLineIndent(50);

            //director de gestion humana
            Paragraph rrhh = new Paragraph()
                    .add(new Text("ATENTAMENTE; \n\n\n\n"))
                    .add(new Text(listaRRHH.get(0).getRango().toUpperCase() + " "
                            + nivelAcademicoRRHH + " "
                            + listaRRHH.get(0).getPrimerApellido().toUpperCase() + " "
                            + listaRRHH.get(0).getSegundoApellido().toUpperCase() + " "
                            + listaRRHH.get(0).getPrimerNombre().toUpperCase() + " "
                            + listaRRHH.get(0).getSegundoNombre().toUpperCase() + "\n"))
                    .add(new Text(listaRRHH.get(0).getCargo().toUpperCase() + "\n"))
                    .add(new Text("DEL CUERPO DE POLICIA  DEL ESTADO DELTA AMACURO\n"))
                    .add(new Text("Nombrado según Resolución N°"))
                    .add(new Text(listaRRHH.get(0).getResolucion()).setUnderline())
                    .add(new Text("de fecha"))
                    .add(new Text(listaRRHH.get(0).getFecha()).setUnderline())
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setMultipliedLeading(1);

            ImageData imagedata1 = ImageDataFactory.create("img_pdf/logo2.png");
            Image image1 = new Image(imagedata1);
            image1.setFixedPosition(pdfDocument.getDefaultPageSize().getWidth() - 120,
                    pdfDocument.getDefaultPageSize().getHeight() - 60);
            image1.setWidth(80);
            image1.setHeight(80);

            ImageData imagedata2 = ImageDataFactory.create("img_pdf/logo1.png");
            Image image2 = new Image(imagedata2);
            image2.setFixedPosition(30,
                    pdfDocument.getDefaultPageSize().getHeight() - 60);
            image2.setWidth(70);
            image2.setHeight(70);

            //cargar elementos al docuemto
            documentos.add(titulo);
            documentos.add(asunto);
            documentos.add(contenido);
            documentos.add(contenido2);
            documentos.add(rrhh);
            documentos.add(image1);
            documentos.add(image2);
            documentos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConstanciaTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String nivelAcademico(String nivel, String genero) {

        String dato = "";

        //masculinos
        if (genero.equals("M") && nivel.equals("NO BACHILLER")) {
            dato = "";
        }
        if (genero.equals("M") && nivel.equals("BACHILLER")) {
            dato = "";
        }
        if (genero.equals("M") && nivel.equals("TÉCNICO SUPERIOR UNIVERSITARIO")) {
            dato = "TSU.";
        }
        if (genero.equals("M") && nivel.equals("LICENCIADO(A)")) {
            dato = "LCDO.";
        }
        if (genero.equals("M") && nivel.equals("INGENIERO(A)")) {
            dato = "ING.";
        }
        if (genero.equals("M") && nivel.equals("ABOGADO")) {
            dato = "ABOG.";
        }
        if (genero.equals("M") && nivel.equals("PROFESOR(A)")) {
            dato = "PROF.";
        }
        if (genero.equals("M") && nivel.equals("MEDICO")) {
            dato = "Dr.";
        }
        if (genero.equals("M") && nivel.equals("ESPECIALIDAD")) {
            dato = "ESP.";
        }
        if (genero.equals("M") && nivel.equals("MAGISTER")) {
            dato = "MSc.";
        }
        if (genero.equals("M") && nivel.equals("DOCTORADO")) {
            dato = "Dr.";
        }

        //femeninas
        if (genero.equals("F") && nivel.equals("NO BACHILLER")) {
            dato = "";
        }
        if (genero.equals("F") && nivel.equals("BACHILLER")) {
            dato = "";
        }
        if (genero.equals("F") && nivel.equals("TÉCNICO SUPERIOR UNIVERSITARIO")) {
            dato = "TSU.";
        }
        if (genero.equals("F") && nivel.equals("LICENCIADO(A)")) {
            dato = "LCDA.";
        }
        if (genero.equals("F") && nivel.equals("INGENIERO(A)")) {
            dato = "ING.";
        }
        if (genero.equals("F") && nivel.equals("ABOGADO")) {
            dato = "ABOG.";
        }
        if (genero.equals("F") && nivel.equals("PROFESOR(A)")) {
            dato = "PROF.";
        }
        if (genero.equals("F") && nivel.equals("MEDICO")) {
            dato = "Dra.";
        }
        if (genero.equals("F") && nivel.equals("ESPECIALIDAD")) {
            dato = "ESP.";
        }
        if (genero.equals("F") && nivel.equals("MAGISTER")) {
            dato = "MSc.";
        }
        if (genero.equals("F") && nivel.equals("DOCTORADO")) {
            dato = "Dra.";
        }

        return dato;

    }

}
