package evento.otro;

import myclass.Cargando;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import reportes.RGFuncionariosExcel;
import reportes.RGPersonasExcel;
import view.VPrincipal;
import view.ventanaemergente.VAprobado;

public class EventoReporteExcel extends MouseAdapter {

    private VPrincipal vn;

    public EventoReporteExcel(VPrincipal vn) {
        this.vn = vn;
    }

    public void mouseClicked(MouseEvent e) {

        //LISTADO GENERAL FUNCIONARIOS
        if (e.getSource() == vn.getBTN_DescargarRGF()) {

            JFileChooser save = new JFileChooser();

            int selecccion = save.showSaveDialog(vn);

            if (selecccion != JFileChooser.CANCEL_OPTION) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    File archivo = new File(save.getSelectedFile().getPath() + ".xls");
                    RGFuncionariosExcel reporte = new RGFuncionariosExcel(archivo);
                    reporte.generarExcel();

                    loader.ocultar();

                    VAprobado exito = new VAprobado(vn, true);
                    exito.setVisible(true);
                });

                hilo.start();

            }

        }

        //LISTADO GENERAL PERSONA
        if (e.getSource() == vn.getBTN_DescargarRGP()) {

            JFileChooser save = new JFileChooser();

            int selecccion = save.showSaveDialog(vn);

            if (selecccion != JFileChooser.CANCEL_OPTION) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);
                    File archivo = new File(save.getSelectedFile().getPath() + ".xls");
                    RGPersonasExcel reporte = new RGPersonasExcel(archivo);
                    reporte.GenerarExcel();
                    loader.ocultar();

                    VAprobado exito = new VAprobado(vn, true);
                    exito.setVisible(true);
                });

                hilo.start();

            }

        }

    }

}
