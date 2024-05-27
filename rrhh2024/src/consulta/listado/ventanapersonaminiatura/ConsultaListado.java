package consulta.listado.ventanapersonaminiatura;

import consulta.listado.Listado;
import controller.persona.VListadoPersonaController;
import javax.swing.JTable;
import model.Persona;

public class ConsultaListado extends Listado {

    public ConsultaListado(VListadoPersonaController vListadoPersona, JTable table) {
        super(vListadoPersona, table);
        

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
        ventanaListadoPersona.getJLabel_Desde_Persona().setText(Integer.toString(pagina));

        //TotalPagina
        ventanaListadoPersona.getJLabel_TotalPagina_Persona().setText(Integer.toString(totalPagina));
        
        //btn paginacion
        btnPaginacion(Integer.parseInt(ventanaListadoPersona.getJLabel_Desde_Persona().getText()),
                Integer.parseInt(ventanaListadoPersona.getJLabel_TotalPagina_Persona().getText()), 
                ventanaListadoPersona.getBtnSiguiente(), 
                ventanaListadoPersona.getBtnAtras());


        //Asignar Total Personas
        ventanaListadoPersona.getCantidadPersona().setText(Integer.toString(persona.getTotalPersonas()));

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
