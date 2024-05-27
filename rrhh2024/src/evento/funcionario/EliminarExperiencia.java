package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoExperiencia;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Experiencia;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarExperiencia extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE EXPERIENCIA
        if (ventanaEditarFuncionario.listadoExperiencia == e.getSource() && ventanaEditarFuncionario.listadoExperiencia.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarExp().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarExp() == e.getSource()) {
            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoExperiencia.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoExperiencia.getSelectedRow(), 3).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Experiencia buscar = new Experiencia();
                    buscar.Eliminar(id);

                    ListadoExperiencia listado = new ListadoExperiencia(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                   //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarExp().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(new VPrincipal(), true);
                    exito.setVisible(true);

                });

                hilo.start();
            }

        }

    }

}
