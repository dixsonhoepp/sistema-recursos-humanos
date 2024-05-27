package evento.funcionario;

import consulta.listado.informaciondefuncinario.ListadoFamiliares;
import controller.funcionario.VRegistrarFamiliarController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Familiares;
import myclass.Cargando;
import myclass.RegistroHistorial;
import view.funcionarios.VEditarFuncionario;
import view.ventanaemergente.VAprobado;
import view.ventanaemergente.VError;

public class RegistrarFamilia extends MouseAdapter {

    private VRegistrarFamiliarController frame;

    @Override
    public void mouseClicked(MouseEvent e) {

        frame = (VRegistrarFamiliarController) SwingUtilities.getWindowAncestor(e.getComponent());

        //REGISTRAR
        if (e.getSource() == frame.getBtn_registrar()) {

            Thread hilo = new Thread(() -> {

                Cargando loader = new Cargando();
                loader.mostrar(frame);

                //CONSULTAR SI YA ESTA AGREGADA LA FAMILIA
                int IDFuncionario = VEditarFuncionario.IDFuncionario;
                int IDPersona = frame.IDPersona;
                String parentesco = frame.getParentesco().getSelectedItem().toString();

                try {

                    //CONSULTAR SI EL FAMILIAR NO EXISTE
                    Familiares fconsultar = new Familiares();
                    int resultado = fconsultar.ConsultarFamiliares(IDPersona, IDFuncionario);

                    //CONSULTAR FUNCIONARIO
                    Familiares fcf = new Familiares();
                    int ID = fcf.ConsultarFuncionario(IDFuncionario);

                    //SI EL FAMILIAR YA EXISTE
                    if (resultado != 0) {
                        loader.ocultar();
                        VError error = new VError(frame, true);
                        error.texto.setText("FAMILIAR YA EXISTE");
                        error.setVisible(true);

                        //VERIFICAR QUE NO ES EL FUNCIONARIO
                    } else if (ID == IDPersona) {
                        loader.ocultar();
                        VError error = new VError(frame, true);
                        error.texto.setText("NO PUEDES AGREGAR AL FUNCIONARIO COMO FAMILIA");
                        error.setVisible(true);

                    } else {

                        Familiares f = new Familiares();
                        f.ReginstrarFamiliar(IDFuncionario, IDPersona, parentesco);

                        //HISTORIAL
                        RegistroHistorial h = new RegistroHistorial();
                        h.Funcionarios(8, VEditarFuncionario.IDFuncionario);

                        ListadoFamiliares listado = new ListadoFamiliares(frame.getVentanaEditarFuncionario());
                        listado.MostrarListadoEF(VEditarFuncionario.IDFuncionario);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(BTNFamilia.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loader.ocultar();

                        frame.dispose();

                        frame.getVentanaEditarFuncionario().getBTN_VERFAMILIA().setVisible(false);
                        frame.getVentanaEditarFuncionario().getBTN_ELIMINARFAMILIA().setVisible(false);
                        frame.getVentanaEditarFuncionario().getBTN_EDITARFAMILIA().setVisible(false);

                        //Ventana de exito
                        VAprobado ventanaExito = new VAprobado(frame.getVentanaEditarFuncionario(), true);
                        ventanaExito.setVisible(true);

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(BTNFamilia.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            hilo.start();

        }

    }

}
