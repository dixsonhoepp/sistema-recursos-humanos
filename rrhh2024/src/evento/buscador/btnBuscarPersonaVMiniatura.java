package evento.buscador;

import controller.persona.VListadoPersonaController;
import myclass.Cargando;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class btnBuscarPersonaVMiniatura extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
       
        VListadoPersonaController frame = (VListadoPersonaController) SwingUtilities.getWindowAncestor(e.getComponent());

        Thread hilo = new Thread(() -> {

            Cargando loader = new Cargando();
            loader.mostrar(frame);
            consulta
                    .listado
                    .ventanapersonaminiatura
                    .ConsultaListado personavm = new consulta
                            .listado
                            .ventanapersonaminiatura
                            .ConsultaListado(frame, frame.getjTable_PERSONAS());
            //actualizar lista
            personavm.setConsulta(frame.getBuscadorpersona().getText());
            personavm.MostrarListadoPersonas(1);
            
            loader.ocultar();

        });

        hilo.start();

    }

}
