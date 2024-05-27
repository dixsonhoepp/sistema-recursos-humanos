package evento.funcionario;

import myclass.Cargando;
import consulta.listado.informaciondefuncinario.ListadoPermisos;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Permisos;
import view.VPrincipal;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VConfirmar;
import view.ventanaemergente.VAprobado;

public class EliminarPermisos extends MouseAdapter {

    private VEditarFuncionario ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE PERMISO
        if (ventanaEditarFuncionario.listadoPermisos == e.getSource() && ventanaEditarFuncionario.listadoPermisos.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBtnEliminarPermisos().setVisible(true);
        }

        if (ventanaEditarFuncionario.getBtnEliminarPermisos() == e.getSource()) {
            
            System.out.println("hola 2");
            DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.listadoPermisos.getModel();
            int id = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.listadoPermisos.getSelectedRow(), 7).toString());

            VConfirmar con = new VConfirmar(new VPrincipal(), true);

            if (con.confirmacion) {

                Thread hilo = new Thread(() -> {

                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);

                    //eliminar
                    Permisos buscar = new Permisos();
                    buscar.Eliminar(id);

                    ListadoPermisos listado = new ListadoPermisos(ventanaEditarFuncionario);
                    listado.MostrarListadoEF(ventanaEditarFuncionario.IDFuncionario);

                    //Ocultar btn ELiminar
                    ventanaEditarFuncionario.getBtnEliminarPermisos().setVisible(false);
                    loader.ocultar();

                    VAprobado exito = new VAprobado(new VPrincipal(), true);
                    exito.setVisible(true);
                });

                hilo.start();
            }

        }

    }

}
