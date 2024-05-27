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
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import model.Directores;
import view.funcionarios.VVerFuncionario;
import view.funcionarios.reportePDF.VFechaReporte;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class ConstanciaUbicacion extends MouseAdapter {

    public static String nombre, rango, cedula, dependencia, nivelAcademico;

    @Override
    public void mouseClicked(MouseEvent e) {

        VVerFuncionario frame = (VVerFuncionario) SwingUtilities.getWindowAncestor(e.getComponent());

        //datos del funcionario
        nombre = frame.getPrimerapellido().getText() + " "
                + frame.getSegundoapellido().getText() + " "
                + frame.getPrimernombre().getText() + " "
                + frame.getSegundonombre().getText();
        rango = frame.getRango().getText();
        cedula = frame.getCedula().getText();
        dependencia = frame.getServicio().getText();
        nivelAcademico = nivelAcademico(frame.getNivelacademico().getText(), frame.getGenero().getText());

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
                            Logger.getLogger(ConstanciaUbicacion.class.getName()).log(Level.SEVERE, null, ex);
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

    }

    public static void generarPDF(String ruta, String dia, String mes, String ano) throws MalformedURLException {

        //Consutlar Director Genetal
        Directores consultaDG = new Directores();
        List<model.list.Directores> listaDG = consultaDG.getInformacion("DIRECTOR GENERAL");
        if (listaDG.size() < 1) {
            listaDG = consultaDG.getInformacion("DIRECTORA GENERAL");
        }
        String nivelAcademicoDG = nivelAcademico(listaDG.get(0).getNivelAcademico(), listaDG.get(0).getGenero());

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
            Paragraph titulo = new Paragraph("REPÚBLICA BOLIVARIANA DE VENEZUELA\n"
                    + "MINISTERIO DEL P. P. PARA LA RELACIONES, INTERIORES, JUSTICIA Y PAZ\n"
                    + "VICE MINISTERIO DEL SISTEMA INTEGRADO DE POLICÍA\n"
                    + "GOBERNACIÓN DEL ESTADO DELTA AMACURO\n"
                    + "CUERPO DE POLICÍA DEL ESTADO DELTA AMACURO\n"
                    + "DIRECCIÓN\n"
                    + "DIRECCIÓN DE GESTION HUMANA\n")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(9);

            //fecha del documento
            Paragraph fecha = new Paragraph()
                    .add(new Text("Tucupita, "))
                    .add(new Text(dia))
                    .add(new Text(" de "))
                    .add(new Text(mes))
                    .add(new Text(" de "))
                    .add(new Text(ano))
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(11);

            Paragraph nombramiento = new Paragraph()
                    .add(new Text("N O M B R A M I E N T O.\n\n"))
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(11)
                    .setBold()
                    .setUnderline();

            //datos del director del cuerpo de policia
            Paragraph cddno = new Paragraph()
                    .add(new Text("DEL CDDNO: "))
                    .add(new Text(listaDG.get(0).getRango().toUpperCase() + " "
                            + nivelAcademicoDG + " "
                            + listaDG.get(0).getPrimerApellido().toUpperCase() + " "
                            + listaDG.get(0).getSegundoApellido().toUpperCase() + " "
                            + listaDG.get(0).getPrimerNombre().toUpperCase() + " "
                            + listaDG.get(0).getSegundoNombre().toUpperCase() + "\n").setBold())
                    .add(new Text(listaDG.get(0).getCargo().toUpperCase() + " DEL CUERPO DE POLICÍA DEL ESTADO DELTA AMACURO.").setBold())
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(11);

            //datos del funcionario
            Paragraph al = new Paragraph()
                    .add(new Text("AL CDDNO: "))
                    .add(new Text(rango.toUpperCase() + " (CPEDA) " + nivelAcademico + " " + nombre.toUpperCase()).setBold())
                    .add(new Text("\nCI V-" + cedula))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(11);

            Paragraph ref = new Paragraph("REF:")
                    .add(new Text("P……A……V.\n"))
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(11)
                    .setBold();

            //contenido principal del codumento
            Paragraph contenido = new Paragraph()
                    .add(new Text("Tengo el agrado de dirigirme "
                            + "a usted, en la oportunidad de extenderle un cordial y "
                            + "afectuoso saludo institucional; sea propicia la ocasión"
                            + " para informarle que en cumplimiento a las funciones del"
                            + " Servicio de Policía que desempeña en jurisdicción del "
                            + "Estado Delta Amacuro, a partir de la presente fecha será"
                            + " transferido del servicio  que viene desempeñando "
                            + "para continuar cumpliendo con sus labores policiales "
                            + "en la siguiente dependencia: "))
                    .add(new Text(dependencia).setBold().setUnderline())
                    .add(new Text(" debiendo abocarse al cumplimiento de precitada "
                            + "asignación en un plazo no mayor  de 48 horas, respetando "
                            + "los parámetros Vigentes de la Ley de Estatuto de la "
                            + "Función Policial en Venezuela.\n"
                            + "Conforme:"))
                    .setTextAlignment(TextAlignment.JUSTIFIED)
                    .setFontSize(12)
                    .setMultipliedLeading(1.5f)
                    .setFirstLineIndent(50);

            //director de gestion humana
            Paragraph rrhh = new Paragraph()
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
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(11)
                    .setMultipliedLeading(1);

            //director general
            Paragraph director = new Paragraph()
                    .add(new Text("\n\n\nVto. Bno.\n\n"))
                    .add(new Text(listaDG.get(0).getRango().toUpperCase() + " "
                            + nivelAcademicoDG + " "
                            + listaDG.get(0).getPrimerApellido().toUpperCase() + " "
                            + listaDG.get(0).getSegundoApellido().toUpperCase() + " "
                            + listaDG.get(0).getPrimerNombre().toUpperCase() + " "
                            + listaDG.get(0).getSegundoNombre().toUpperCase() + "\n"
                            + listaDG.get(0).getCargo().toUpperCase()))
                    .add(new Text(" DEL CUERPO DE POLICIA\n"))
                    .add(new Text("DEL ESTADO DELTA AMACURO\n"))
                    .add(new Text("Nombrado según Resolución N°"))
                    .add(new Text(listaDG.get(0).getResolucion()).setUnderline())
                    .add(new Text("de fecha"))
                    .add(new Text(listaDG.get(0).getFecha()).setUnderline())
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(11)
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
            documentos.add(fecha);
            documentos.add(nombramiento);
            documentos.add(cddno);
            documentos.add(al);
            documentos.add(ref);
            documentos.add(contenido);
            documentos.add(rrhh);
            documentos.add(director);
            documentos.add(image1);
            documentos.add(image2);
            documentos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConstanciaUbicacion.class.getName()).log(Level.SEVERE, null, ex);
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
