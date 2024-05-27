package controller.administrar;

import evento.administrar.EventoTableVentanaAdministrar;
import consulta.listado.informaciondefuncinario.ListadoDirectores;
import consulta.listado.informaciondefuncinario.ListadoHistorial;
import consulta.listado.informaciondefuncinario.ListadoUsuario;
import evento.administrar.EventoDirector;
import evento.administrar.EventoUsuario;
import javax.swing.JFrame;
import view.administrar.VAdministrador;

public class VAdministradorController extends VAdministrador {

    public VAdministradorController(JFrame v, boolean modal) {
        super(v, modal);
        listado();
        evento();
    }
    
    private void evento(){
        //evento table
        getjTable_USUARIOS().addMouseListener(new EventoTableVentanaAdministrar());
        getjTable_DIRECTORRRHH().addMouseListener(new EventoTableVentanaAdministrar());
        getjTable_DIRECTORGENERAL().addMouseListener(new EventoTableVentanaAdministrar());
        
        //evento btn ELiminar
        getBTN_ELIMINARUSUARIO().addMouseListener(new EventoUsuario());
        getBTN_ELIMINARDIRECTORGENERAL().addMouseListener(new EventoDirector(this));
        getBTN_ELIMINARDIRECTORRRHH().addMouseListener(new EventoDirector(this));
        
        //evento btn abrir listado
        getBTN_NUEVOUSUARIO().addMouseListener(new EventoUsuario());
        getBTN_NUEVODIRECTORGENERAL().addMouseListener(new EventoDirector(this));
        getBTN_NUEVODIRECTORRRHH().addMouseListener(new EventoDirector(this));
        
        
    }

    private void listado() {
        //MOSTRAR LISTADO DE USUARIO
        ListadoUsuario ListadoUsuario = new ListadoUsuario(this);
        ListadoUsuario.MostrarListado();

        //MOSTRAR LISTADO DE DIRECTORES
        ListadoDirectores listadoDirectores1 = new ListadoDirectores(this);
        listadoDirectores1.MostrarListadoDG();

        ListadoDirectores listadoDirectore2 = new ListadoDirectores(this);
        listadoDirectore2.MostrarListadoRRHH();

        ListadoHistorial listadoH = new ListadoHistorial(this);
        listadoH.MostrarListado();
    }

}
