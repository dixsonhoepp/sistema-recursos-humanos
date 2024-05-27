package evento.funcionario;

import myclass.Cargando;
import evento.persona.EventoRegistrarPersona;
import consulta.listado.informaciondefuncinario.ListadoAscenso;
import controller.funcionario.VRegistrarAscensoController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Ascenso;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarAscenso extends MouseAdapter {
    
    private VRegistrarAscensoController frame;

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        frame = (VRegistrarAscensoController) SwingUtilities.getWindowAncestor(e.getComponent());
        
        
        if (frame.getBtn_registrar() == e.getSource()) {

            Thread hilo = new Thread(() -> {

                String tipo = frame.getTipo().getSelectedItem().toString();
                String rangoAnterior = frame.getRangoAnterior().getSelectedItem().toString();
                String rangoActual = frame.getRangoObternido().getSelectedItem().toString();
                String fechaAscenso = "";

                try {
                    Date date = frame.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha = new java.sql.Date(d);
                    fechaAscenso = fecha.toString();

                } catch (Exception ex) {
                }

                String orden = frame.getMerito().getText();
                int ID = frame.getVentanaEditarFuncionario().IDFuncionario;

                if (tipo.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (rangoAnterior.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else if (rangoActual.isEmpty()) {

                    VError error = new VError(frame, true);
                    error.texto.setText("Campos vacios");
                    error.setVisible(true);

                } else {

                    //Mostrar ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(frame);

                    Ascenso a = new Ascenso();

                    //registrar
                    int resultado = a.Registrar(ID, tipo, rangoAnterior, rangoActual, fechaAscenso, orden);

                    if (resultado > 0) {
                        //mostrar listado
                        ListadoAscenso listado = new ListadoAscenso(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(ID);

                        
                        //Ocultar btn ELiminar
                        frame.getVentanaEditarFuncionario().getBtnEliminarAscenso().setVisible(false);

                        loader.ocultar();

                        VAprobado ventana = new VAprobado(frame, true);
                        ventana.setVisible(true);
                    }

                }
            });

            hilo.start();
        }

    }

}
