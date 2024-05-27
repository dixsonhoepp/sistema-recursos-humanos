package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoEstudios;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Estudios;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarEstudios extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE ESTUDIOS
        if (ventanaEditarFuncionario.listadoEstudios == e.getSource() && ventanaEditarFuncionario.listadoEstudios.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarEstudios().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarEstudios() == e.getSource()) {
            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoEstudios.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoEstudios.getSelectedRow(), 5).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);
                    //eliminar
                    Estudios buscar = new Estudios();
                    buscar.Eliminar(id);

                    ListadoEstudios listado = new ListadoEstudios(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarEstudios().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(new VPrincipal(), true);
                    exito.setVisible(true);
                });

                hilo.start();
            }

        }

    }

}
