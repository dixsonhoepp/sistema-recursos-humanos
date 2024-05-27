package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoReposos;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Reposos;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarReposos extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE REPOSOS
        if (ventanaEditarFuncionario.listadoReposo == e.getSource() && ventanaEditarFuncionario.listadoReposo.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarReposo().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarReposo() == e.getSource()) {
            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoReposo.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoReposo.getSelectedRow(), 7).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Reposos buscar = new Reposos();
                    buscar.Eliminar(id);

                    ListadoReposos listado = new ListadoReposos(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarReposo().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(new VPrincipal(), true);
                    exito.setVisible(true);
                });

                hilo.start();
            }

        }

    }

}
