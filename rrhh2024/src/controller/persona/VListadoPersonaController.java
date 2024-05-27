package controller.persona;

import controller.administrar.VAdministradorController;
import controller.funcionario.VEditarFuncionarioController;
import evento.buscador.btnBuscarPersonaVMiniatura;
import evento.paginacion.EVT_paginacion;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import popumenu.PopuMenuCrearFuncionario;
import popumenu.PopuMenuFuncionarios;
import popumenu.PopuMenuPersonasVMDIRECTOR;
import popumenu.PopuMenuPersonasVMFAMILIA;
import popumenu.PopuMenuPersonasVMUSUARIO;
import view.VPrincipal;
import view.personas.VListadoPersona;

public class VListadoPersonaController extends VListadoPersona {

    public static final int POPUMENU_FAMILIA = 0;
    public static final int POPUMENU_FUNCIONARIO = 1;
    public static final int POPUMENU_USUARIO = 2;
    public static final int POPUMENU_DIRECTORES = 3;

    private int opcionPopuMenu;
    private VEditarFuncionarioController ventanaEditarFuncionario;
    private VAdministradorController ventanaAdministrar;

    public VListadoPersonaController(VEditarFuncionarioController v, boolean modal) {
        super(v, modal);
        ventanaEditarFuncionario = v;
        evento();
        consultar();
    }

    public VListadoPersonaController(VAdministradorController v, boolean modal) {
        super(v, modal);
        ventanaAdministrar = v;
        evento();
        consultar();
    }

    public VListadoPersonaController(JFrame v, boolean modal) {
        super(v, modal);
        evento();
        consultar();
    }

    private void evento() {
        getBTN_BUSCAR().addMouseListener(new btnBuscarPersonaVMiniatura());
        getBTN_NUEVAPERSONAVM().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VRegistrarPersonaController frame = new VRegistrarPersonaController(new VPrincipal(), true);
                frame.setVisible(true);
            }

        });
        paginacion();

        getjTable_PERSONAS().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (getjTable_PERSONAS().getSelectedRow() != -1) {
                    popuMenu();
                }

            }

        });
    }

    private void paginacion() {

        //btn siguiente
        getBtnSiguiente().addMouseListener(new EVT_paginacion(getJLabel_Desde_Persona(),
                getJLabel_TotalPagina_Persona(), getjTable_PERSONAS(), getBtnSiguiente(), getBtnAtras(),
                EVT_paginacion.PERSONA_VENTANA_MINIATURA));

        //btn atras
        getBtnAtras().addMouseListener(new EVT_paginacion(getJLabel_Desde_Persona(),
                getJLabel_TotalPagina_Persona(), getjTable_PERSONAS(), getBtnSiguiente(), getBtnAtras(),
                EVT_paginacion.PERSONA_VENTANA_MINIATURA));
    }

    private void consultar() {
        consulta.listado.ventanapersonaminiatura.ConsultaListado consultar
                = new consulta.listado.ventanapersonaminiatura.ConsultaListado(this, this.getjTable_PERSONAS());
        //actualizar lista
        consultar.setConsulta("");
        consultar.MostrarListadoPersonas(1);
    }

    public void setOpcionPopuMenu(int opcion) {
        opcionPopuMenu = opcion;
    }

    public void popuMenu() {
        switch (opcionPopuMenu) {
            case POPUMENU_FAMILIA:
                popumenu.PopuMenuPersonasVMFAMILIA popuMenuFamilia = new PopuMenuPersonasVMFAMILIA(this, ventanaEditarFuncionario);
                break;

            case POPUMENU_FUNCIONARIO:
                popumenu.PopuMenuCrearFuncionario popuMenuCrearFuncionario = new PopuMenuCrearFuncionario(this);
                break;

            case POPUMENU_USUARIO:
                popumenu.PopuMenuPersonasVMUSUARIO popuMenuCrearUsuario = new PopuMenuPersonasVMUSUARIO(this);
                break;
                
            case POPUMENU_DIRECTORES:
                popumenu.PopuMenuPersonasVMDIRECTOR popuMenuCrearDirectores = new PopuMenuPersonasVMDIRECTOR(this, ventanaAdministrar);
                break;
            default:
                throw new AssertionError();
        }
    }

    public VAdministradorController getVentanaAdministrar() {
        return ventanaAdministrar;
    }

}
