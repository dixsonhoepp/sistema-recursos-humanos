package evento.funcionario;

import controller.funcionario.VEditarFuncionarioController;
import controller.funcionario.VRegistrarAscensoController;
import controller.funcionario.VRegistrarCursosController;
import controller.funcionario.VRegistrarEstudiosController;
import controller.funcionario.VRegistrarExperienciaController;
import controller.funcionario.VRegistrarPermisosController;
import controller.funcionario.VRegistrarRepososController;
import controller.funcionario.VRegistrarSancionesController;
import controller.funcionario.VRegistrarVacacionesController;
import controller.persona.VListadoPersonaController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import myclass.Cargando;

public class AbrirVentanaNueva extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {

        VEditarFuncionarioController ventanaEditarFuncionario
                = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //Ventana Ascenso
        if (ventanaEditarFuncionario.getBtnRegistrarAscenso() == e.getSource()) {
            VRegistrarAscensoController frame = new VRegistrarAscensoController(ventanaEditarFuncionario, true);
            frame.setVisible(true);

        }

        //ventana curso
        if (ventanaEditarFuncionario.getBtnRegistrarCursos() == e.getSource()) {
            VRegistrarCursosController frame = new VRegistrarCursosController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Estudios
        if (ventanaEditarFuncionario.getBtnRegistrarEstudios() == e.getSource()) {
            VRegistrarEstudiosController frame = new VRegistrarEstudiosController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Experiencia Policial
        if (ventanaEditarFuncionario.getBtnRegistrarExp() == e.getSource()) {
            VRegistrarExperienciaController frame = new VRegistrarExperienciaController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Permisos
        if (ventanaEditarFuncionario.getBtnRegistrarPermisos() == e.getSource()) {
            VRegistrarPermisosController frame = new VRegistrarPermisosController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Reposos
        if (ventanaEditarFuncionario.getBtnRegistrarReposo() == e.getSource()) {
            VRegistrarRepososController frame = new VRegistrarRepososController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Vacaciones
        if (ventanaEditarFuncionario.getBtnRegistrarVacaciones() == e.getSource()) {
            VRegistrarVacacionesController frame = new VRegistrarVacacionesController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }

        //Ventana Familiares
        if (ventanaEditarFuncionario.getBTN_AGREGARFAMILIA() == e.getSource()) {
            
            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(ventanaEditarFuncionario);
                VListadoPersonaController frame = new VListadoPersonaController(ventanaEditarFuncionario, true);
                frame.setOpcionPopuMenu(VListadoPersonaController.POPUMENU_FAMILIA);
                loader.ocultar();
                frame.setVisible(true);
            });
            
            hilo.start();

        }

        //Ventana Medida Diciplinaria
        if (ventanaEditarFuncionario.getBTN_REGISTRARMD() == e.getSource()) {
            VRegistrarSancionesController frame = new VRegistrarSancionesController(ventanaEditarFuncionario, true);
            frame.setVisible(true);
        }
        

    }

}
