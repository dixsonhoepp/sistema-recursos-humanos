package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoVacaciones;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Vacaciones;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarVacaciones extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE VACACIONES
        if (ventanaEditarFuncionario.listadoVacaciones == e.getSource() && ventanaEditarFuncionario.listadoVacaciones.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarVacaciones().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarVacaciones() == e.getSource()) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoVacaciones.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoVacaciones.getSelectedRow(), 7).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Vacaciones buscar = new Vacaciones();
                    buscar.Eliminar(id);

                    ListadoVacaciones listado = new ListadoVacaciones(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarVacaciones().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(new VPrincipal(), true);
                    exito.setVisible(true);
                });

                hilo.start();

            }

        }

    }

}
