package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoAscenso;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Ascenso;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarAscenso extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE ASCENSO
        if (ventanaEditarFuncionario.listadoAscenso == e.getSource() && ventanaEditarFuncionario.listadoAscenso.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarAscenso().setVisible(true);
        }

        //ASCENSO
        if (ventanaEditarFuncionario.getBtnEliminarAscenso() == e.getSource()) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoAscenso.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoAscenso.getSelectedRow(), 6).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Ascenso ascenso = new Ascenso();
                    ascenso.Eliminar(id);

                    ListadoAscenso listado = new ListadoAscenso(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarAscenso().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(ventanaEditarFuncionario, true);
                    exito.setVisible(true);

                });

                hilo.start();

            }

        }

    }

}
