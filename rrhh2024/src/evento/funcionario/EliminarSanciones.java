package evento.funcionario;

import consulta.listado.informaciondefuncinario.ListadoSanciones;
import controller.funcionario.VEditarFuncionarioController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Sanciones;
import myclass.Cargando;
import myclass.RegistroHistorial;
import view.VPrincipal;
import view.ventanaemergente.VConfirmar;

public class EliminarSanciones extends MouseAdapter {

    VEditarFuncionarioController ventanaEditarFuncionario;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaEditarFuncionario = (VEditarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        //SELECCIONAR TABLET DE SANCIONES
        if (ventanaEditarFuncionario.ListadoSanciones == e.getSource() && ventanaEditarFuncionario.ListadoSanciones.getSelectedRow() != -1) {
            ventanaEditarFuncionario.getBTN_ELIMINARMD().setVisible(true);
        }

        //BTN ELIMINAR
        if (e.getSource() == ventanaEditarFuncionario.getBTN_ELIMINARMD()) {

            Thread hilo = new Thread(() -> {
                if (ventanaEditarFuncionario.ListadoSanciones.getSelectedRow() !=  -1) {

                    DefaultTableModel modelo = (DefaultTableModel) ventanaEditarFuncionario.ListadoSanciones.getModel();
                    int ID = Integer.parseInt(modelo.getValueAt(ventanaEditarFuncionario.ListadoSanciones.getSelectedRow(), 5).toString());

                    //ventana de confirmacion
                    VConfirmar vc = new VConfirmar(new VPrincipal(), true);
                    boolean confirmar = vc.confirmacion;

                    if (confirmar) {

                        Cargando loader = new Cargando();
                        loader.mostrar(ventanaEditarFuncionario);

                        Sanciones sanciones1 = new Sanciones();
                        sanciones1.EliminarSanciones(ID);

                        //HISTORIAL 
                        RegistroHistorial r = new RegistroHistorial();
                        r.Funcionarios(6, VEditarFuncionarioController.IDFuncionario);

                        //MOSTRAR LISTADO DE SANCIONES
                        ListadoSanciones listado = new ListadoSanciones(ventanaEditarFuncionario);
                        listado.MostrarListadoEF(VEditarFuncionarioController.IDFuncionario);
                        
                        ventanaEditarFuncionario.getBTN_ELIMINARMD().setVisible(false);

                        loader.ocultar();
                    }

                    try {
                        //Quitar Seleccion del JTABLET
                        ventanaEditarFuncionario.ListadoSanciones.removeRowSelectionInterval(ventanaEditarFuncionario.ListadoSanciones.getSelectedRow(), 0);
                    } catch (Exception ex) {
                    }

                }
            });

            hilo.start();

        }

    }

}
