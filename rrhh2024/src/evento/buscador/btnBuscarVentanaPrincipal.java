package evento.buscador;

import myclass.Cargando;
import consulta.listado.ventanaprincipal.ConsultaListado;
import consulta.listado.ListadoServiciosVP;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import view.VPrincipal;

public class btnBuscarVentanaPrincipal extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {

        VPrincipal vn = (VPrincipal) SwingUtilities.getWindowAncestor(e.getComponent());

        //BTN BUSCAR FUNCIONARIOS ACTIVOS
        if (vn.BTN_BUSCAR_FA == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {
                    //OCULTAR POPUPMENU
                    vn.getjTable_FUNCIONARIOSACTIVOS().setComponentPopupMenu(null);

                    //ventana cargando mostrar
                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    //ACTUALIZAR
                    ConsultaListado Listado = new ConsultaListado(vn, vn.jTable_FUNCIONARIOSACTIVOS);
                    Listado.setConsulta(vn.getBuscadorFuncionariosActivos().getText());
                    Listado.MostrarListadoFuncionariosActivos(1);

                    //ventana cargando ocultat
                    Thread.sleep(100);
                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

        //BTN BUSCAR FUNCIONARIOS SUSPENDIDOS
        if (vn.BTN_BUSCAR_SUSPENDIDOS == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {

                    //OCULTAR POPUPMENU
                    vn.getjTable_FUNCIONARIOSSUSPENDIDOS().setComponentPopupMenu(null);

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    //ACTUALIZAR LISTADO DE PERSONA
                    ConsultaListado listado = new ConsultaListado(vn, vn.jTable_FUNCIONARIOSSUSPENDIDOS);
                    listado.setConsulta(vn.getBuscadorFuncionariosSuspendidos().getText());
                    listado.MostrarListadoFuncionariosSuspendidos(1);

                    Thread.sleep(100);

                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

        //BTN BUSCAR FUNCIONARIOS IVSS
        if (vn.BTN_BUSCAR_IVSS == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {

                    //OCULTAR POPUPMENU
                    vn.getjTable_FUNCIONARIOSIVSS().setComponentPopupMenu(null);

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    //ACTUALIZAR LISTADO
                    ConsultaListado listado = new ConsultaListado(vn, vn.jTable_FUNCIONARIOSIVSS);
                    listado.setConsulta(vn.getBuscadorFuncionariosIVSS().getText());
                    listado.MostrarListadoFuncionariosIVSS(1);

                    Thread.sleep(100);

                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

        //BTN BUSCAR FUNCIONARIOS BAJA
        if (vn.BTN_BUSCAR_BAJAS == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {

                    //OCULTAR POPUPMENU
                    vn.getjTable_FUNCIONARIOSBAJA().setComponentPopupMenu(null);

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    //ACTUALIZAR LISTADO
                    ConsultaListado listado = new ConsultaListado(vn, vn.jTable_FUNCIONARIOSBAJA);
                    listado.setConsulta(vn.getBuscadorFuncionariosBAJA().getText());
                    listado.MostrarListadoFuncionariosBaja(1);

                    Thread.sleep(100);

                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

        //BTN BUSCAR PERSONAS
        if (vn.BTN_BUSCAR_PERSONA == e.getSource()) {

            Thread hilo = new Thread(() -> {

                try {

                    //OCULTAR POPUPMENU
                    vn.getjTable_PERSONAS().setComponentPopupMenu(null);

                    Cargando loader = new Cargando();
                    loader.mostrar(vn);

                    //ACTUALIZAR LISTADO
                    ConsultaListado listado = new ConsultaListado(vn, vn.jTable_PERSONAS);
                    listado.setConsulta(vn.getBuscadorpersona().getText());
                    listado.MostrarListadoPersonas(1);

                    Thread.sleep(100);

                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

        //BTN BUSCAR SERVICIOS
        if (vn.BTN_BUSCAR_SERVICIOS == e.getSource()) {

            Thread hilo = new Thread(() -> {

                Cargando loader = new Cargando();
                loader.mostrar(vn);

                try {

                    //ACTUALIZAR LISTADO
                    ListadoServiciosVP listado = new ListadoServiciosVP(vn);
                    listado.setConsulta(vn.getBuscadorServicio().getText());
                    listado.MostrarListado();

                    Thread.sleep(100);

                    loader.ocultar();
                } catch (InterruptedException ex) {
                    Logger.getLogger(btnBuscarVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

            hilo.start();
        }

    }

}
