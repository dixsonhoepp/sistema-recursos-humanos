package controller.servicio;

import controller.ventanaprincipal.VPrincipalController;
import evento.servicio.EventoRegistrarServicio;
import javax.swing.JFrame;
import view.servicios.VNuevoServicio;


public class VNuevoServicioController extends VNuevoServicio{
    
    VPrincipalController ventanaPrincipal;
    
    public VNuevoServicioController(JFrame v, boolean modal) {
        super(v, modal);
        ventanaPrincipal = (VPrincipalController) v;
        evento();
    }
    
    private void evento(){
        getBtn_registrarservicio().addMouseListener(new EventoRegistrarServicio(ventanaPrincipal, this));
    }
    
}
