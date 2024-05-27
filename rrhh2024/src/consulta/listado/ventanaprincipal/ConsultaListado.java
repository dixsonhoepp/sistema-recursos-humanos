package consulta.listado.ventanaprincipal;

import consulta.listado.Listado;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.Funcionario;
import model.Persona;
import view.VPrincipal;

public class ConsultaListado extends Listado {

    public ConsultaListado(VPrincipal ventanaPrincipal, JTable table) {
        super(ventanaPrincipal, table);

    }
    

    public void MostrarListadoFuncionariosActivos(int numPag) {
        //numero de pagina
        pagina = numPag;

        //Consultar
        Funcionario funcionarios = new Funcionario();

        //Consultar Total Registro
        funcionarios.TotalFuncionario(consulta, 0);

        //Paginación
        totalPagina = (int) Math.round(Math.ceil(funcionarios.getTotal() / 20F));
        desde = (pagina - 1) * 20;

        //asignar numero de pagina al jlabel
        ventanaPrincipal.JLabel_Desde_FA.setText(Integer.toString(pagina));

        //TotalPagina
        ventanaPrincipal.JLabel_TotalPagina_FA.setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaPrincipal.JLabel_Desde_FA.getText()),
                Integer.parseInt(ventanaPrincipal.JLabel_TotalPagina_FA.getText()), 
                ventanaPrincipal.jLabel_Siguiente_FA, 
                ventanaPrincipal.jLabel_Atras_FA);

        //Asignar Total
        ventanaPrincipal.CantidadFA.setText("TOTAL: " + Integer.toString(funcionarios.getTotal()));

        //obtener modelo
        modelo = funcionarios.ListadoConsultarFuncionarios(consulta, desde, 0);

        //asignar modelo a la table
        jtable.setModel(modelo);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(11).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(12).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(13).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(14).setPreferredWidth(100);

        //ocultar ID
        jtable.getColumnModel().getColumn(15).setMinWidth(0);
        jtable.getColumnModel().getColumn(15).setMaxWidth(0);
        jtable.getColumnModel().getColumn(15).setPreferredWidth(0);

        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

    public void MostrarListadoFuncionariosSuspendidos(int numPag) {

        //numero de pagina
        pagina = numPag;

        Funcionario funcionarios = new Funcionario();
        //Consultar Total Registro
        funcionarios.TotalFuncionario(consulta, 1);

        //Paginación
        totalPagina = (int) Math.round(Math.ceil(funcionarios.getTotal() / 20F));
        desde = (pagina - 1) * 20;

        //asignar numero de pagina al jlabel
        ventanaPrincipal.Desde_FS.setText(Integer.toString(pagina));

        //TotalPagina
        ventanaPrincipal.TotalPagina_FS.setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaPrincipal.Desde_FS.getText()),
                Integer.parseInt(ventanaPrincipal.TotalPagina_FS.getText()), 
                ventanaPrincipal.Siguiente_FS, 
                ventanaPrincipal.Atras_FS);

        //Asignar Total Personas
        ventanaPrincipal.CantidadFS.setText("TOTAL: " + Integer.toString(funcionarios.getTotal()));

        modelo = funcionarios.ListadoConsultarFuncionarios(consulta, desde, 1);

        jtable.setModel(modelo);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(11).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(12).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(13).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(14).setPreferredWidth(100);

        //OCUTAR ID
        jtable.getColumnModel().getColumn(15).setMinWidth(0);
        jtable.getColumnModel().getColumn(15).setMaxWidth(0);
        jtable.getColumnModel().getColumn(15).setPreferredWidth(0);

        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

    }

    public void MostrarListadoFuncionariosIVSS(int numPag) {

        //numero de pagina
        pagina = numPag;

        Funcionario funcionarios = new Funcionario();

        //Consultar Total Registro
        funcionarios.TotalFuncionario(consulta, 2);

        //Paginación
        totalPagina = (int) Math.round(Math.ceil(funcionarios.getTotal() / 20F));
        desde = (pagina - 1) * 20;

        //asignar numero de pagina al jlabel
        ventanaPrincipal.Desde_IVSS.setText(Integer.toString(pagina));

        //TotalPagina
        ventanaPrincipal.TotalPagina_IVSS.setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaPrincipal.Desde_IVSS.getText()),
                Integer.parseInt(ventanaPrincipal.TotalPagina_IVSS.getText()), 
                ventanaPrincipal.Siguiente_IVSS, 
                ventanaPrincipal.Atras_IVSS);

        //Asignar Total Funcionario
        ventanaPrincipal.Cantidad_IVSS.setText("TOTAL: " + Integer.toString(funcionarios.getTotal()));

        modelo = funcionarios.ListadoConsultarFuncionarios(consulta, desde, 2);

        jtable.setModel(modelo);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(11).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(12).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(13).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(14).setPreferredWidth(100);

        //OCUTAR ID
        jtable.getColumnModel().getColumn(15).setMinWidth(0);
        jtable.getColumnModel().getColumn(15).setMaxWidth(0);
        jtable.getColumnModel().getColumn(15).setPreferredWidth(0);

        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }

    public void MostrarListadoFuncionariosBaja(int numPag) {

        //numero de pagina
        pagina = numPag;

        Funcionario funcionarios = new Funcionario();

        //Consultar Total Registro
        funcionarios.TotalFuncionario(consulta, 3);

        //Paginación
        totalPagina = (int) Math.round(Math.ceil(funcionarios.getTotal() / 20F));
        desde = (pagina - 1) * 20;

        //asignar numero de pagina al jlabel
        ventanaPrincipal.Desde_BAJA.setText(Integer.toString(pagina));

        //TotalPagina
        ventanaPrincipal.TotalPagina_BAJA.setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaPrincipal.Desde_BAJA.getText()),
                Integer.parseInt(ventanaPrincipal.TotalPagina_BAJA.getText()), 
                ventanaPrincipal.Siguiente_BAJA, 
                ventanaPrincipal.Atras_BAJA);

        //Asignar Total Funcionario
        ventanaPrincipal.Cantidad_BAJA.setText("TOTAL: " + Integer.toString(funcionarios.getTotal()));

        modelo = funcionarios.ListadoConsultarFuncionarios(consulta, desde, 3);

        jtable.setModel(modelo);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(11).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(12).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(13).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(14).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(15).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(16).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(17).setPreferredWidth(400);

        //OCUTAR ID
        jtable.getColumnModel().getColumn(18).setMinWidth(0);
        jtable.getColumnModel().getColumn(18).setMaxWidth(0);
        jtable.getColumnModel().getColumn(18).setPreferredWidth(0);

        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
    
    public void MostrarListadoPersonas(int numPag) {

        //numero de pagina
        pagina = numPag;
        
        Persona persona = new Persona();
        
        //Consultar Total Registro
        persona.TotalPersonasRegistradas(consulta);

        //Paginación
        totalPagina = (int) Math.round(Math.ceil(persona.getTotalPersonas() / 20F));
        desde = (pagina - 1) * 20;
        
        //asignar numero de pagina al jlabel
        ventanaPrincipal.JLabel_Desde_Persona.setText(Integer.toString(pagina));

        //TotalPagina
        ventanaPrincipal.JLabel_TotalPagina_Persona.setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaPrincipal.JLabel_Desde_Persona.getText()),
                Integer.parseInt(ventanaPrincipal.JLabel_TotalPagina_Persona.getText()), 
                ventanaPrincipal.jLabel_Siguiente_Persona, 
                ventanaPrincipal.jLabel_Atras_Persona);


        //Asignar Total Personas
        ventanaPrincipal.CantidadPersona.setText(Integer.toString(persona.getTotalPersonas()));

        modelo = persona.ListadoConsultarPersona(consulta, desde);

        jtable.setModel(modelo);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(6).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(7).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(9).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(10).setPreferredWidth(150);
        jtable.getColumnModel().getColumn(11).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(12).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(13).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(14).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(15).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(16).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(17).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(18).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(19).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(20).setPreferredWidth(300);
        
        //OCULTAR ID
        jtable.getColumnModel().getColumn(21).setMinWidth(0);
        jtable.getColumnModel().getColumn(21).setMaxWidth(0);
        jtable.getColumnModel().getColumn(21).setPreferredWidth(0);
        
        
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }
    

}
