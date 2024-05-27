package evento.funcionario;

import controller.funcionario.VRegistrarFuncionarioController;
import myclass.Cargando;
import myclass.RegistroHistorial;
import evento.persona.EventoRegistrarPersona;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Funcionario;
import view.VPrincipal;
import view.funcionarios.VRegistrarFuncionario;
import view.personas.VListadoPersona;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarFuncionario extends MouseAdapter {

    private VRegistrarFuncionario ventanaRegistrarFuncionario;
    private VError error = new VError(new VPrincipal(), true);

    @Override
    public void mouseClicked(MouseEvent e) {

        ventanaRegistrarFuncionario = (VRegistrarFuncionarioController) SwingUtilities.getWindowAncestor(e.getComponent());

        if (ventanaRegistrarFuncionario.getBTN_REGISTRAR() == e.getSource()) {

            Thread hilo = new Thread(() -> {

                int rango = ventanaRegistrarFuncionario.getRango().getSelectedIndex();

                //FECHA INGRESO y ASCENSO
                String FechaIngreso = "";
                String FechaAscenso = "";

                //Fecha Ingreso
                try {
                    Date date1 = ventanaRegistrarFuncionario.getFechaIngreso().getDate();
                    long d1 = date1.getTime();
                    java.sql.Date fecha1 = new java.sql.Date(d1);
                    FechaIngreso = fecha1.toString();
                } catch (Exception ex) {
                }

                //Fecha Ascenso
                try {

                    Date date2 = ventanaRegistrarFuncionario.getFechaAscenso().getDate();
                    long d2 = date2.getTime();
                    java.sql.Date fecha2 = new java.sql.Date(d2);
                    FechaAscenso = fecha2.toString();

                } catch (Exception ex) {
                }

                String CodigoCarnet = ventanaRegistrarFuncionario.getCodigoCarnet().getText();
                String Condicion = (String) ventanaRegistrarFuncionario.getCodicion().getSelectedItem();
                String Servicio = (String) ventanaRegistrarFuncionario.getServicio().getSelectedItem();
                String Municipio = (String) ventanaRegistrarFuncionario.getMunicipioTrabajo().getSelectedItem();
                String TallaCamisa = ventanaRegistrarFuncionario.getTallaCamisa().getText();
                String TallaPantalon = ventanaRegistrarFuncionario.getTallaPantalon().getText();
                String TallaZapato = ventanaRegistrarFuncionario.getTallaZapato().getText();
                String TallaGorra = ventanaRegistrarFuncionario.getTallaGorra().getText();
                String Banco = ventanaRegistrarFuncionario.getBanco().getText();
                String NumeroCuenta = ventanaRegistrarFuncionario.getNumeroCuenta().getText();
                String Estatus = ventanaRegistrarFuncionario.getEstatus().getSelectedItem().toString();

                int IDPersona = ventanaRegistrarFuncionario.getIDPersona();

                Funcionario funcionario = new Funcionario();

                if (FechaIngreso.isEmpty()) {
                    error.texto.setText("DEBE COLOCAR LA FECHA DE INGRESO");
                    error.setVisible(true);
                } else if (FechaAscenso.isEmpty()) {
                    error.texto.setText("DEBE COLOCAR LA FECHA DE ASCENSO");
                    error.setVisible(true);
                } else {

                    //ventana cargando
                    Cargando loader = new Cargando();
                    loader.mostrar(ventanaRegistrarFuncionario);

                    if (funcionario.RegistrarFuncionario(IDPersona, rango, FechaIngreso,
                            FechaAscenso, CodigoCarnet, Condicion, Servicio, Municipio,
                            TallaCamisa, TallaPantalon, TallaZapato, TallaGorra, Banco,
                            NumeroCuenta, Estatus)) {

                        //HISTORIAL 
                        RegistroHistorial r = new RegistroHistorial();
                        r.Funcionarios(1, IDPersona);

                        loader.ocultar();
                        
                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(new VPrincipal(), true);
                        ventanaExito.setVisible(true);
                        
                        //Cerrar Ventana
                        ventanaRegistrarFuncionario.dispose();


                    } else {

                        loader.ocultar();

                        VError VentanaError = new VError(new VPrincipal(), true);
                        VentanaError.texto.setText("EL FUNCIONARIO YA EXISTE");
                        VentanaError.setVisible(true);
                    }

                }

            });

            hilo.start();

        }

    }

}
