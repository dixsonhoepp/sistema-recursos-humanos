package myclass;

import consulta.listado.informaciondefuncinario.ListadoHistorial;
import controller.administrar.VAdministradorController;
import javax.swing.JFrame;
import model.Directores;
import model.Funcionario;
import model.Historial;
import model.Persona;
import model.Usuario;
import view.VPrincipal;

public class RegistroHistorial {

    private String id;
    private String informacion;
    private String nombre;
    private String[] datos;

    public RegistroHistorial() {

    }

    public void Directores(int opcion, int id) {

        switch (opcion) {
            case 1:
                //REGISTRAR DIRECTOR GENERAL

                this.id = Integer.toString(id);
                this.informacion = "Ha registrado al (la) Director(a) General ";

                //Consultar
                Persona p1 = new Persona();
                datos = p1.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 2:
                //REGISTRAR DIRECTOR RRHH

                this.id = Integer.toString(id);
                this.informacion = "Ha registrado al (la) Director(a) de Recursos Humanos ";

                //Consultar
                Persona p2 = new Persona();
                datos = p2.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 3:

                //ELIMINAR DIRECTOR GENERAL
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al (la) Director(a) General ";

                //Consultar
                Directores d1 = new Directores();
                datos = d1.ConsultarH(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h3 = new Historial();
                h3.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 4:

                //ELIMINAR DIRECTOR DE RRHH
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al (la) Director(a) de Recursos Humanos ";

                //Consultar
                Directores d2 = new Directores();
                datos = d2.ConsultarH(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h4 = new Historial();
                h4.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    public void Funcionarios(int opcion, int id) {

        switch (opcion) {
            case 1:
                //REGISTRAR FUNCIONARIO

                this.id = Integer.toString(id);
                this.informacion = "Ha registrado al (la) Funcionario(a) ";

                //Consultar
                Persona p1 = new Persona();
                datos = p1.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 2:
                //ELIMINAR FUNCIONARIO

                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al (la) Funcionario(a) ";

                //Consultar
                Funcionario f1 = new Funcionario();
                datos = f1.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 3:

                //EDITAR
                this.id = Integer.toString(id);
                this.informacion = "Ha editado informacion del (la) Funcionario(a) ";

                //Consultar
                Funcionario f2 = new Funcionario();
                datos = f2.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h3 = new Historial();
                h3.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 4:

                //FOTO
                this.id = Integer.toString(id);
                this.informacion = "Ha cambiado la foto del (la) Funcionario(a) ";

                //Consultar
                Funcionario f3 = new Funcionario();
                datos = f3.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h4 = new Historial();
                h4.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 5:

                //REGISTRAR SANCION
                this.id = Integer.toString(id);
                this.informacion = "Ha registrado sancion del (la) Funcionario(a) ";

                //Consultar
                Funcionario f4 = new Funcionario();
                datos = f4.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h5 = new Historial();
                h5.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 6:

                //ELIMINAR SANCION
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado sancion del (la) Funcionario(a) ";

                //Consultar
                Funcionario f5 = new Funcionario();
                datos = f5.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h6 = new Historial();
                h6.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 7:

                //ELIMINAR FAMILIAR
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado familiar del (la) Funcionario(a) ";

                //Consultar
                Funcionario f6 = new Funcionario();
                datos = f6.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h7 = new Historial();
                h7.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 8:

                //REGISTRAR FAMILIAR
                this.id = Integer.toString(id);
                this.informacion = "Ha registrado familiar del (la) Funcionario(a) ";

                //Consultar
                Funcionario f7 = new Funcionario();
                datos = f7.DatosFuncionarioID(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h8 = new Historial();
                h8.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    public void Servicio(int opcion) {

        switch (opcion) {
            case 1:
                //REGISTRAR SEVICIO

                this.informacion = "Ha registrado un servicio";

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion);

                ActualizarListado();

                break;

            case 2:

                //ELIMINAR SEVICIO
                this.informacion = "Ha registrado un servicio";

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    public void Usuario(int opcion, int id, String usuario) {

        switch (opcion) {
            case 1:
                //REGISTRAR USUARIO

                this.id = Integer.toString(id);
                this.informacion = "Ha registrado el usuario @";

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion + usuario);

                ActualizarListado();

                break;

            case 2:
                //ELIMINAR USUARIO

                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al usuario @";

                //Consultar
                Usuario u = new Usuario();
                this.nombre = u.ConsultarUsuarioID(id);

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 3:

                //ELIMINAR DIRECTOR GENERAL
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al (la) Director(a) General ";

                //Consultar
                Directores d1 = new Directores();
                datos = d1.ConsultarH(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h3 = new Historial();
                h3.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 4:

                //ELIMINAR DIRECTOR DE RRHH
                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado al (la) Director(a) de RRRHH ";

                //Consultar
                Directores d2 = new Directores();
                datos = d2.ConsultarH(id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h4 = new Historial();
                h4.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    public void Persona(int opcion, int id, String nombre) {

        switch (opcion) {
            case 1:
                //REGISTRAR PERSONA

                this.id = Integer.toString(id);
                this.informacion = "Ha registrado la persona ";

                this.nombre = nombre;

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 2:
                //ELIMINAR PERSONA

                this.id = Integer.toString(id);
                this.informacion = "Ha eliminado la persona ";

                //Consultar
                Persona p2 = new Persona();
                datos = p2.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 3:

                //EDITAR PERSONA
                this.id = Integer.toString(id);
                this.informacion = "Ha editado información de la persona ";

                //Consultar
                Persona p3 = new Persona();
                datos = p3.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h3 = new Historial();
                h3.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            case 4:

                //FOTO
                //EDITAR PERSONA
                this.id = Integer.toString(id);
                this.informacion = "Ha cambiado foto de ";

                //Consultar
                Persona p4 = new Persona();
                datos = p4.DatosPersonaID(this.id);
                this.nombre = datos[0] + " " + datos[2] + " " + datos[4];

                //Registrar 
                Historial h4 = new Historial();
                h4.Registrar("@" + VPrincipal.login, this.informacion + this.nombre);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    public void Login(int opcion) {

        switch (opcion) {
            case 1:
                //Inicio de LOGIN
                this.informacion = "ha ingresado al sistema";

                //Registrar 
                Historial h1 = new Historial();
                h1.Registrar("@" + VPrincipal.login, this.informacion);

                ActualizarListado();

                break;

            case 2:
                //salio del sistema PERSONA

                //Inicio de LOGIN
                this.informacion = "ha salido del sistema";

                //Registrar 
                Historial h2 = new Historial();
                h2.Registrar("@" + VPrincipal.login, this.informacion);

                ActualizarListado();

                break;

            default:
                throw new AssertionError();
        }

    }

    private void ActualizarListado() {
        ListadoHistorial listadoHistorial = new ListadoHistorial(new VAdministradorController(new JFrame(), true));
        listadoHistorial.MostrarListado();
    }

}
