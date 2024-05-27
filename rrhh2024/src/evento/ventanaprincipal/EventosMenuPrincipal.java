package evento.ventanaprincipal;

import consulta.listado.ListadoServiciosVP;
import consulta.listado.ventanaprincipal.ConsultaListado;
import controller.administrar.VAdministradorController;
import myclass.Cargando;
import myclass.Estadistica;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import view.VPrincipal;
import view.informacion.VInformacion;

public class EventosMenuPrincipal extends MouseAdapter {

    private VPrincipal ventanaPrincipal;

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaPrincipal = (VPrincipal) SwingUtilities.getWindowAncestor(e.getComponent());

        if (ventanaPrincipal.menu1.getComponents()[0] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[1] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[2] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[3] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[4] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[5] == e.getSource()
                || ventanaPrincipal.menu1.getComponents()[6] == e.getSource()) {

            for (int i = 0; i < ventanaPrincipal.menu1.getComponents().length; i++) {

                if (ventanaPrincipal.menu1.getComponents()[i] == e.getComponent()) {
                    ventanaPrincipal.menu1.getComponents()[i].setForeground(Color.WHITE);
                    ventanaPrincipal.menu1.getComponents()[i].setFont(new Font("Roboto", 1, 16));
                } else {
                    ventanaPrincipal.menu1.getComponents()[i].setForeground(new Color(204, 204, 204));
                    ventanaPrincipal.menu1.getComponents()[i].setFont(new Font("Roboto", 0, 14));
                }

            }
        }

        if (ventanaPrincipal.getBTN_FUNCIONARIOSACTIVOS() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //reiniciar información de la table
                ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                        ventanaPrincipal.jTable_FUNCIONARIOSACTIVOS);
                listado.setConsulta("");
                listado.MostrarListadoFuncionariosActivos(1);
                //vaciar buscador
                ventanaPrincipal.getBuscadorFuncionariosActivos().setText("");
                loader.ocultar();
                mostrarPanel(1);

            });

            hilo.start();

        }

        if (ventanaPrincipal.getBTN_FUNCIONARIOSSUSPENDIDOS() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //reiniciar información de la table
                ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                        ventanaPrincipal.jTable_FUNCIONARIOSSUSPENDIDOS);
                listado.setConsulta("");
                listado.MostrarListadoFuncionariosSuspendidos(1);
                //vaciar buscador
                ventanaPrincipal.getBuscadorFuncionariosSuspendidos().setText("");
                loader.ocultar();
                mostrarPanel(2);

            });

            hilo.start();
        }

        if (ventanaPrincipal.getBTN_FUNCIONARIOSIVSS() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //reiniciar información de la table
                ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                        ventanaPrincipal.jTable_FUNCIONARIOSIVSS);
                listado.setConsulta("");
                listado.MostrarListadoFuncionariosIVSS(1);
                //vaciar buscador
                ventanaPrincipal.getBuscadorFuncionariosIVSS().setText("");
                loader.ocultar();
                mostrarPanel(3);

            });

            hilo.start();
        }

        if (ventanaPrincipal.getBTN_FUNCIONARIOSBAJA() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //reiniciar información de la table
                ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                        ventanaPrincipal.jTable_FUNCIONARIOSBAJA);
                listado.setConsulta("");
                listado.MostrarListadoFuncionariosBaja(1);
                //vaciar buscador
                ventanaPrincipal.getBuscadorFuncionariosBAJA().setText("");
                loader.ocultar();
                mostrarPanel(4);

            });

            hilo.start();
        }

        if (ventanaPrincipal.getBTN_SERVICIOSPOLICIAL() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //vaciar buscador
                ventanaPrincipal.getBuscadorServicio().setText("");
                ListadoServiciosVP listado = new ListadoServiciosVP(ventanaPrincipal);
                listado.setConsulta(ventanaPrincipal.getBuscadorServicio().getText());
                listado.MostrarListado();
                loader.ocultar();
                mostrarPanel(5);

            });

            hilo.start();
        }

        if (ventanaPrincipal.getBTN_ESTADISTICA() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //Mostrar Estadisticas
                Estadistica estadistica = new Estadistica();
                estadistica.MostrarEstadistica(ventanaPrincipal);
                loader.ocultar();
                mostrarPanel(6);

            });

            hilo.start();

        }

        if (ventanaPrincipal.getBTN_PERSONASREGISTRADAS() == e.getSource()) {

            Thread hilo = new Thread(() -> {
                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                //reiniciar información de la table
                ConsultaListado listado = new ConsultaListado(ventanaPrincipal,
                        ventanaPrincipal.jTable_PERSONAS);
                listado.setConsulta("");
                listado.MostrarListadoPersonas(1);
                //vaciar buscador
                ventanaPrincipal.getBuscadorpersona().setText("");
                loader.ocultar();
                mostrarPanel(7);

            });

            hilo.start();
        }

        //ventana administrar
        if (ventanaPrincipal.getBTN_ADMINISTRAR() == e.getSource()) {
            Thread hilo = new Thread(() -> {
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                VAdministradorController ventanaAdministrar = new VAdministradorController(ventanaPrincipal, true);
                loader.ocultar();
                ventanaAdministrar.setVisible(true);
            });
            hilo.start();

        }

        //ventana informacion
        if (ventanaPrincipal.getBTN_INFORMACION1() == e.getSource()) {

            view.informacion.VInformacion informacion = new VInformacion(ventanaPrincipal, true);
            informacion.setVisible(true);

        }

    }

    private void mostrarPanel(int num) {

        switch (num) {
            case 1:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card1");

//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_funcionariosactivos);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

            case 2:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card2");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_funcionariossuspendidos);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

            case 3:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card3");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_funcionariosivss);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

            case 4:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card4");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_funcionariosbaja);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

            case 5:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card5");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_serviciospolicial);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

            case 6:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card6");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_estadistica);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();

                break;

            case 7:
                ventanaPrincipal.cardLayout.show(ventanaPrincipal.contenedor, "card7");
//                ventanaPrincipal.contenedor.removeAll();
//                ventanaPrincipal.contenedor.add(ventanaPrincipal.jPanel_personas);
//                ventanaPrincipal.revalidate();
//                ventanaPrincipal.repaint();
                break;

        }

    }

}
