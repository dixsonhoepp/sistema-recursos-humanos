package evento.administrar;

import consulta.listado.informaciondefuncinario.ListadoDirectores;
import consulta.listado.informaciondefuncinario.ListadoHistorial;
import controller.administrar.VRegistrarDirectorController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Directores;
import myclass.Cargando;
import myclass.RegistroHistorial;
import view.ventanaemergente.VError;

public class RegistrarDirector extends MouseAdapter {

    private VRegistrarDirectorController director;
    private String cargo, rango, resolucion, fecha;
    private VError VError = new VError(director, true);

    @Override
    public void mouseClicked(MouseEvent e) {

        director = (VRegistrarDirectorController) SwingUtilities.getWindowAncestor(e.getComponent());

        //REGISTRAR DG
        if (e.getSource() == director.getBTN_REGISTRAR()
                && director.getCargo().getSelectedItem().toString().equals("DIRECTOR GENERAL")
                || director.getCargo().getSelectedItem().toString().equals("DIRECTORA GENERAL")) {

            Thread hilo = new Thread(() -> {
                //OBTENER VALOR DE LOS CAMPOS
                cargo = director.getCargo().getSelectedItem().toString();
                rango = director.getRango().getText();
                resolucion = director.getResolucion().getText();

                //fecha
                try {
                    Date date = director.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha1 = new java.sql.Date(d);
                    fecha = fecha1.toString();

                } catch (Exception ex) {

                }

                //VALIDAR QUE LOS CAMPOR NO ESTEN VACIOS
                if (cargo.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (rango.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (resolucion.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (fecha.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(director);

                    //REGISTRAR
                    try {

                        //CONSULTAR
                        Directores d = new Directores();
                        int num1 = d.Consultar("DIRECTOR GENERAL");
                        Directores d1 = new Directores();
                        int num2 = d1.Consultar("DIRECTORA GENERAL");

                        if (num1 > 0 || num2 > 0) {
                            loader.ocultar();
                            VError.texto.setText("YA EXISTE UN DIRECTOR GENERAL");
                            VError.setVisible(true);

                        } else {

                            //HISTORIAAAL
                            RegistroHistorial h = new RegistroHistorial();
                            h.Directores(1, director.IDPersona);

                            //REGISTRAR
                            Directores d2 = new Directores();
                            d2.Reginstrar(cargo, rango, fecha, resolucion, director.IDPersona);

                            //ACTUALIZAR LISTADO
                            ListadoDirectores ListadoD = new ListadoDirectores(director.getVentanaAdministrador());
                            ListadoD.MostrarListadoDG();

                            ListadoHistorial historial = new ListadoHistorial(director.getVentanaAdministrador());
                            historial.MostrarListado();

                            //Cargando.ocultar();
                            loader.ocultar();

                            //OCULTAR VENTANA DESPUES DE REGISTRAR
                            director.dispose();

                            //OCULTAR BTN DE ELIMINAR
                            director.getVentanaAdministrador().getBTN_ELIMINARUSUARIO().setVisible(false);
                            director.getVentanaAdministrador().getBTN_ELIMINARDIRECTORGENERAL().setVisible(false);
                            director.getVentanaAdministrador().getBTN_ELIMINARDIRECTORRRHH().setVisible(false);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(EventoDirector.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });

            hilo.start();

        }

        //REGISTRAR DRRHH
        if (e.getSource() == director.getBTN_REGISTRAR()
                && director.getCargo().getSelectedItem().toString().equals("DIRECTOR DE GESTIÓN HUMANA")
                || director.getCargo().getSelectedItem().toString().equals("DIRECTORA DE GESTIÓN HUMANA")) {

            Thread hilo = new Thread(() -> {

                //OBTENER VALOR DE LOS CAMPOS
                cargo = director.getCargo().getSelectedItem().toString();
                rango = director.getRango().getText();
                resolucion = director.getResolucion().getText();

                //fecha
                try {
                    Date date = director.getFecha().getDate();
                    long d = date.getTime();
                    java.sql.Date fecha1 = new java.sql.Date(d);
                    fecha = fecha1.toString();

                } catch (Exception ex) {
                    System.err.println(ex);
                }

                //VALIDAR QUE LOS CAMPOR NO ESTEN VACIOS
                if (cargo.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (rango.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (resolucion.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else if (fecha.isEmpty()) {
                    VError.texto.setText("NO PUEDE ESTAR VACIO NINGUN CAMPO");
                    VError.setVisible(true);

                } else {

                    Cargando loader = new Cargando();
                    loader.mostrar(director);

                    //REGISTRAR
                    try {

                        //CONSULTAR
                        Directores d = new Directores();
                        int num1 = d.Consultar("DIRECTOR DE GESTIÓN HUMANA");
                        Directores d1 = new Directores();
                        int num2 = d1.Consultar("DIRECTORA DE GESTIÓN HUMANA");

                        if (num1 > 0 || num2 > 0) {
                           
                            loader.ocultar();
                            
                            VError.texto.setText("YA EXISTE UN DIRECTOR DE RRHH");
                            VError.setVisible(true);
                            

                        } else {

                            //HISTORIAL
                            RegistroHistorial h = new RegistroHistorial();
                            h.Directores(2, director.IDPersona);

                            //REGISTRAR
                            Directores d2 = new Directores();
                            d2.Reginstrar(cargo, rango, fecha, resolucion, director.IDPersona);

                            //ACTUALIZAR LISTADO
                            ListadoDirectores ListadoD = new ListadoDirectores(director.getVentanaAdministrador());
                            ListadoD.MostrarListadoRRHH();

                            //ocultar cargando
                            loader.ocultar();

                            //OCULTAR VENTANA DESPUES DE REGISTRAR
                            director.dispose();

                            //OCULTAR BTN DE ELIMINAR
                            director.getVentanaAdministrador().getBTN_ELIMINARUSUARIO().setVisible(false);
                            director.getVentanaAdministrador().getBTN_ELIMINARDIRECTORGENERAL().setVisible(false);
                            director.getVentanaAdministrador().getBTN_ELIMINARDIRECTORRRHH().setVisible(false);

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(EventoDirector.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            hilo.start();

        }
    }

}
