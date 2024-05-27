package evento.paginacion;

import myclass.Cargando;
import consulta.listado.ventanaprincipal.ConsultaListado;
import controller.ventanaprincipal.VPrincipalController;
import controller.persona.VListadoPersonaController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class EVT_paginacion extends MouseAdapter {

    private VPrincipalController ventanaPrincipal;
    private VListadoPersonaController ventanaListadoPersona;
    private final JTable table;
    private final int opcionList;
    private int numPag;
    private int maxPag;
    private final JLabel lblPag;
    private final JLabel lblTotalPag;
    private final JLabel btnSiguiente;
    private final JLabel btnAtras;
    
    //Constante
    public static final int FUNCIONARIO_ACTIVO = 1;
    public static final int FUNCIONARIO_SUSPENDIDO = 2;
    public static final int FUNCIONARIO_BAJA = 3;
    public static final int FUNCIONARIO_IVSS = 4;
    public static final int PERSONA = 5;
    public static final int PERSONA_VENTANA_MINIATURA = 6;

    public EVT_paginacion(JLabel lblPag, JLabel lblTotalPag,
            JTable table, JLabel btnSiguiente, JLabel btnAtras, int opcionList) {

        this.lblPag = lblPag; //numero de pagina
        this.lblTotalPag = lblTotalPag; //total pagina
        this.table = table; //table
        this.btnSiguiente = btnSiguiente; //btn siguiente
        this.btnAtras = btnAtras; //btn atras
        this.opcionList = opcionList; //opcion de lista a mostrar

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        
        if (opcionList != PERSONA_VENTANA_MINIATURA) {
            
            ventanaPrincipal = (VPrincipalController) SwingUtilities.getWindowAncestor(e.getComponent());
            
        }else{
            ventanaListadoPersona = (VListadoPersonaController) SwingUtilities.getWindowAncestor(e.getComponent());
        }

        this.numPag = Integer.parseInt(lblPag.getText());
        this.maxPag = Integer.parseInt(lblTotalPag.getText());

        //funcionario activo btn siguiente
        if (btnSiguiente == e.getComponent()) {

            Thread hilo = new Thread(() -> {

                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);

                if (numPag < maxPag) {

                    //aumentar el numero de pagina
                    numPag++;

                    actualizarListado();

                    //OCULTAR POPUPMENU
                    table.setComponentPopupMenu(null);

                    //ocultar cargador
                    loader.ocultar();

                }
            });

            hilo.start();
        }

        //ATRAS
        if (btnAtras == e.getComponent()) {

            Thread hilo = new Thread(() -> {

                //Mostrar ventana cargando
                Cargando loader = new Cargando();
                loader.mostrar(ventanaPrincipal);
                if (numPag > 1) {

                    numPag--;

                    actualizarListado();

                    //OCULTAR POPUPMENU
                    table.setComponentPopupMenu(null);

                    loader.ocultar();
                }

            });

            hilo.start();

        }
    }

    private void actualizarListado() {
        //paginacion
        switch (opcionList) {

            case FUNCIONARIO_ACTIVO: //funcionarios activo

                ConsultaListado fa = new ConsultaListado(ventanaPrincipal, table);
                //actualizar lista
                fa.MostrarListadoFuncionariosActivos(numPag);
                break;

            case FUNCIONARIO_SUSPENDIDO: //funcionarios suspendido
                ConsultaListado fs = new ConsultaListado(ventanaPrincipal, table);
                //actualizar lista
                fs.MostrarListadoFuncionariosSuspendidos(numPag);
                break;

            case FUNCIONARIO_BAJA: //funcionarios de baja
                ConsultaListado fb = new ConsultaListado(ventanaPrincipal, table);
                //actualizar lista
                fb.MostrarListadoFuncionariosBaja(numPag);
                break;

            case FUNCIONARIO_IVSS: //funcionarios ivss
                ConsultaListado fivss = new ConsultaListado(ventanaPrincipal, table);
                //actualizar lista
                fivss.MostrarListadoFuncionariosIVSS(numPag);
                break;

            case PERSONA: //personas
                ConsultaListado persona = new ConsultaListado(ventanaPrincipal, table);
                //actualizar lista
                persona.MostrarListadoPersonas(numPag);
                break;

            case PERSONA_VENTANA_MINIATURA: //personas listado en ventana miniatura
                consulta.listado.ventanapersonaminiatura.ConsultaListado personavm = new consulta.listado.ventanapersonaminiatura.ConsultaListado(ventanaListadoPersona, table);
                //actualizar lista
                personavm.MostrarListadoPersonas(numPag);
                break;

            default:
                throw new AssertionError();
        }

    }

}
