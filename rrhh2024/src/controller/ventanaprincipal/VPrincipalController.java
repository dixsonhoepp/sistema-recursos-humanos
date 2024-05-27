package controller.ventanaprincipal;

import consulta.listado.ventanaprincipal.ConsultaListado;
import evento.buscador.btnBuscarVentanaPrincipal;
import evento.paginacion.EVT_paginacion;
import evento.servicio.EventoRegistrarServicio;
import evento.otro.EventoReporteExcel;
import evento.ventanaprincipal.EventosMenuPrincipal;
import evento.servicio.EventoEliminarServicio;
import evento.ventanaprincipal.EVT_abrirNuevaVentana;
import evento.ventanaprincipal.EVT_desconectar;
import view.VPrincipal;

public class VPrincipalController extends VPrincipal {

    public VPrincipalController() {
        addEventos();
        mostrarListado();
    }

    private void addEventos() {

        btnPrincipales();
        table();
        paginacion();
        menuPrincipal();

    }

    private void btnPrincipales() {
        //evento de los btn centrales o main
        getBTN_NUEVOFUNCIONARIO().addMouseListener(new EVT_abrirNuevaVentana());
        getBTN_NUEVOSERVICIO().addMouseListener(new EVT_abrirNuevaVentana());
        getBTN_ELIMINARSERVICIO().addMouseListener(new EventoEliminarServicio());
        getBTN_NUEVAPERSONA().addMouseListener(new EVT_abrirNuevaVentana());
        getBTN_DESCONECTAR().addMouseListener(new EVT_desconectar());
        getBTN_DescargarRGF().addMouseListener(new EventoReporteExcel(this));
        getBTN_DescargarRGP().addMouseListener(new EventoReporteExcel(this));
        
        //AGREGAR EVENTOS
        BTN_BUSCAR_FA.addMouseListener(new btnBuscarVentanaPrincipal());
        BTN_BUSCAR_SUSPENDIDOS.addMouseListener(new btnBuscarVentanaPrincipal());
        BTN_BUSCAR_IVSS.addMouseListener(new btnBuscarVentanaPrincipal());
        BTN_BUSCAR_BAJAS.addMouseListener(new btnBuscarVentanaPrincipal());
        BTN_BUSCAR_SERVICIOS.addMouseListener(new btnBuscarVentanaPrincipal());
        BTN_BUSCAR_PERSONA.addMouseListener(new btnBuscarVentanaPrincipal());
    }

    private void paginacion() {

        //BTN PAGINACION FUNCIONARIO ACTIVOS
        jLabel_Siguiente_FA
                .addMouseListener(new EVT_paginacion(
                        JLabel_Desde_FA,
                        JLabel_TotalPagina_FA,
                        jTable_FUNCIONARIOSACTIVOS,
                        jLabel_Siguiente_FA,
                        jLabel_Atras_FA,
                        EVT_paginacion.FUNCIONARIO_ACTIVO));

        jLabel_Atras_FA
                .addMouseListener(new EVT_paginacion(
                        JLabel_Desde_FA,
                        JLabel_TotalPagina_FA,
                        jTable_FUNCIONARIOSACTIVOS,
                        jLabel_Siguiente_FA,
                        jLabel_Atras_FA,
                         EVT_paginacion.FUNCIONARIO_ACTIVO));

        //BTN PAGINACION FUNCIONARIO SUSPENDIDO
        Siguiente_FS
                .addMouseListener(new EVT_paginacion(
                        Desde_FS,
                        TotalPagina_FS,
                        jTable_FUNCIONARIOSSUSPENDIDOS,
                        Siguiente_FS,
                        Atras_FS,
                         EVT_paginacion.FUNCIONARIO_SUSPENDIDO));
        Atras_FS
                .addMouseListener(new EVT_paginacion(
                        Desde_FS,
                        TotalPagina_FS,
                        jTable_FUNCIONARIOSSUSPENDIDOS,
                        Siguiente_FS,
                        Atras_FS,
                         EVT_paginacion.FUNCIONARIO_SUSPENDIDO));

        //BTN PAGINACION FUNCIONARIO BAJA
        Siguiente_BAJA
                .addMouseListener(new EVT_paginacion(
                        Desde_BAJA,
                        TotalPagina_BAJA,
                        jTable_FUNCIONARIOSBAJA,
                        Siguiente_BAJA,
                        Atras_BAJA,
                         EVT_paginacion.FUNCIONARIO_BAJA));
        Atras_BAJA
                .addMouseListener(new EVT_paginacion(
                        Desde_BAJA,
                        TotalPagina_BAJA,
                        jTable_FUNCIONARIOSBAJA,
                        Siguiente_BAJA,
                        Atras_BAJA,
                         EVT_paginacion.FUNCIONARIO_BAJA));

        //BTN PAGINACION FUNCIONARIO IVSS
        Siguiente_IVSS
                .addMouseListener(new EVT_paginacion(
                        Desde_IVSS,
                        TotalPagina_IVSS,
                        jTable_FUNCIONARIOSIVSS,
                        Siguiente_IVSS,
                        Atras_IVSS,
                         EVT_paginacion.FUNCIONARIO_IVSS));
        Atras_IVSS
                .addMouseListener(new EVT_paginacion(
                        Desde_IVSS,
                        TotalPagina_IVSS,
                        jTable_FUNCIONARIOSIVSS,
                        Siguiente_IVSS,
                        Atras_IVSS,
                         EVT_paginacion.FUNCIONARIO_IVSS));

        //BTN PAGINACION PERSONAS
        jLabel_Siguiente_Persona
                .addMouseListener(new EVT_paginacion(
                        JLabel_Desde_Persona,
                        JLabel_TotalPagina_Persona,
                        jTable_PERSONAS,
                        jLabel_Siguiente_Persona,
                        jLabel_Atras_Persona,
                         EVT_paginacion.PERSONA));
        jLabel_Atras_Persona
                .addMouseListener(new EVT_paginacion(
                        JLabel_Desde_Persona,
                        JLabel_TotalPagina_Persona,
                        jTable_PERSONAS,
                        jLabel_Siguiente_Persona,
                        jLabel_Atras_Persona,
                        EVT_paginacion.PERSONA));

    }

    private void table() {

        //JTABLE FUNCIONARIO ACTIVOS
        getjTable_FUNCIONARIOSACTIVOS().addMouseListener(new EventoTableVentanaPrincipal());

        //JTABLE FUNCIONARIO SUSPENDIDO
        getjTable_FUNCIONARIOSSUSPENDIDOS().addMouseListener(new EventoTableVentanaPrincipal());

        //JTABLE FUNCIONARIO IVSS
        getjTable_FUNCIONARIOSIVSS().addMouseListener(new EventoTableVentanaPrincipal());

        //JTABLE FUNCIONARIO BAJA
        getjTable_FUNCIONARIOSBAJA().addMouseListener(new EventoTableVentanaPrincipal());

        //JTABLE PERSONA
        getjTable_PERSONAS().addMouseListener(new EventoTableVentanaPrincipal());
        
        //JTABLE SERVICIO
        getjTable_SERVICIO().addMouseListener(new EventoTableVentanaPrincipal());
    }

    private void mostrarListado() {
        ConsultaListado listado = new ConsultaListado(this, jTable_FUNCIONARIOSACTIVOS);
        listado.setConsulta("");
        listado.MostrarListadoFuncionariosActivos(1);

    }

    private void menuPrincipal() {

        getBTN_FUNCIONARIOSACTIVOS().addMouseListener(new EventosMenuPrincipal());
        getBTN_FUNCIONARIOSSUSPENDIDOS().addMouseListener(new EventosMenuPrincipal());
        getBTN_FUNCIONARIOSIVSS().addMouseListener(new EventosMenuPrincipal());
        getBTN_FUNCIONARIOSBAJA().addMouseListener(new EventosMenuPrincipal());
        getBTN_SERVICIOSPOLICIAL().addMouseListener(new EventosMenuPrincipal());
        getBTN_ESTADISTICA().addMouseListener(new EventosMenuPrincipal());

        getBTN_PERSONASREGISTRADAS().addMouseListener(new EventosMenuPrincipal());
        getBTN_ADMINISTRAR().addMouseListener(new EventosMenuPrincipal());
        getBTN_INFORMACION1().addMouseListener(new EventosMenuPrincipal());
    }

}
