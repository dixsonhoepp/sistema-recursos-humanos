package controller.funcionario;

import evento.funcionario.AbrirVentanaNueva;
import evento.funcionario.EditarFuncionario;
import evento.funcionario.EliminarAscenso;
import evento.funcionario.EliminarCursos;
import evento.funcionario.EliminarEstudios;
import evento.funcionario.EliminarExperiencia;
import evento.funcionario.EliminarPermisos;
import evento.funcionario.EliminarReposos;
import evento.funcionario.EliminarSanciones;
import evento.funcionario.EliminarVacaciones;
import evento.funcionario.BTNFamilia;
import evento.otro.EventoITEM;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import myclass.Cargando;
import view.funcionarios.VEditarFuncionario;

public class VEditarFuncionarioController extends VEditarFuncionario {

    private VEditarFuncionarioController ventanaEditarFuncionario = this;

    public VEditarFuncionarioController(JFrame v, boolean modal) {
        super(v, modal);
        eventos();
        ocultarBTN();
    }

    private void eventos() {

        btnAbrirVentana();
        btnEliminar();
        listados();

        //EDITAR FUNCIONARIO
        getBTN_GUARDAR().addMouseListener(new EditarFuncionario());
        getBTN_FOTO().addMouseListener(new EditarFuncionario());

        //ITEM COMBOX
        getCondicion().addItemListener(new EventoITEM());

        //FAMILIARES
        getBTN_VERFAMILIA().addMouseListener(new BTNFamilia());
        getBTN_EDITARFAMILIA().addMouseListener(new BTNFamilia());
        getBTN_ELIMINARFAMILIA().addMouseListener(new BTNFamilia());

        //Agregar Servicio
        getBtnAgregarServicio().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread hilo = new Thread(() -> {
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaEditarFuncionario);
                    VServiciosController VServicio = new VServiciosController(ventanaEditarFuncionario);
                    loader.ocultar();
                    VServicio.mostrar();
                });
                hilo.start();

            }

        });

    }

    private void btnEliminar() {

        getBtnEliminarAscenso().addMouseListener(new EliminarAscenso());
        getBtnEliminarCursos().addMouseListener(new EliminarCursos());
        getBtnEliminarEstudios().addMouseListener(new EliminarEstudios());
        getBtnEliminarExp().addMouseListener(new EliminarExperiencia());
        getBtnEliminarPermisos().addMouseListener(new EliminarPermisos());
        getBtnEliminarReposo().addMouseListener(new EliminarReposos());
        getBtnEliminarVacaciones().addMouseListener(new EliminarVacaciones());
        getBTN_ELIMINARMD().addMouseListener(new EliminarSanciones());
    }

    private void btnAbrirVentana() {

        //ABRIR VENTANA DE REGISTRAR ASCENSO
        getBtnRegistrarAscenso().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR EXPERIENCIA
        getBtnRegistrarExp().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR VACACIONES
        getBtnRegistrarVacaciones().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR PERMISO
        getBtnRegistrarPermisos().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR REPOSO
        getBtnRegistrarReposo().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR ESTUDIOS
        getBtnRegistrarEstudios().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE REGISTRAR CURSOS
        getBtnRegistrarCursos().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE SANCIONES
        getBTN_REGISTRARMD().addMouseListener(new AbrirVentanaNueva());
        //ABRIR VENTANA DE FAMILIA
        getBTN_AGREGARFAMILIA().addMouseListener(new AbrirVentanaNueva());
    }

    private void listados() {
        ListadoSanciones.addMouseListener(new EliminarSanciones());
        listadoAscenso.addMouseListener(new EliminarAscenso());
        listadoCursos.addMouseListener(new EliminarCursos());
        listadoEstudios.addMouseListener(new EliminarEstudios());
        listadoExperiencia.addMouseListener(new EliminarExperiencia());
        listadoPermisos.addMouseListener(new EliminarPermisos());
        listadoReposo.addMouseListener(new EliminarReposos());
        listadoVacaciones.addMouseListener(new EliminarVacaciones());
        ListadoFamilia.addMouseListener(new BTNFamilia());
    }

    private void ocultarBTN() {

        getBTN_ELIMINARFAMILIA().setVisible(false);
        getBTN_VERFAMILIA().setVisible(false);
        getBTN_EDITARFAMILIA().setVisible(false);
        getBtnEliminarExp().setVisible(false);
        getBtnEliminarAscenso().setVisible(false);
        getBTN_ELIMINARMD().setVisible(false);
        getBtnEliminarVacaciones().setVisible(false);
        getBtnEliminarReposo().setVisible(false);
        getBtnEliminarPermisos().setVisible(false);
        getBtnEliminarEstudios().setVisible(false);
        getBtnEliminarCursos().setVisible(false);
    }

}
