package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoCursos;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Cursos;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarCursos extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE CURSO
        if (ventanaEditarFuncionario.listadoCursos == e.getSource() && ventanaEditarFuncionario.listadoCursos.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarCursos().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarCursos() == e.getSource()) {
            
            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoCursos.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoCursos.getSelectedRow(), 5).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Cursos cursos = new Cursos();
                    cursos.Eliminar(id);

                    ListadoCursos listado = new ListadoCursos(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarCursos().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(ventanaEditarFuncionario, true);
                    exito.setVisible(true);

                });

                hilo.start();
            }

        }

    }

}
