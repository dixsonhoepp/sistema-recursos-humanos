package myclass;

import model.Funcionario;
import view.VPrincipal;

public class Estadistica {
    
    private Funcionario f = new Funcionario();

    public void MostrarEstadistica(VPrincipal vn) {

        

        //ACTIVOS
        //COMISIONADOS JEFE 
        int CJM = f.TotalRegistro(8, "M", "");
        int CJF = f.TotalRegistro(8, "F", "");
        int CJTOTAL = CJM + CJF;

        vn.COMISIONADOJEFEMASCULINO.setText(Integer.toString(CJM));
        vn.COMISIONADOJEFEFEMENINAS.setText(Integer.toString(CJF));
        vn.TOTALCOMISIONADOJEFE.setText(Integer.toString(CJTOTAL));

        //COMISIONADOS AGREGADO
        int CAM = f.TotalRegistro(7, "M", "");
        int CAF = f.TotalRegistro(7, "F", "");
        int CATOTAL = CAM + CAF;

        vn.COMISIONADOAGREGADOMASCULINO.setText(Integer.toString(CAM));
        vn.COMISIONADOAGREGADOFEMENINAS.setText(Integer.toString(CAF));
        vn.TOTALCOMISIONADOAGREGADO.setText(Integer.toString(CATOTAL));

        //COMISIONADOS
        int CM = f.TotalRegistro(6, "M", "");
        int CF = f.TotalRegistro(6, "F", "");
        int CTOTAL = CM + CF;

        vn.COMISIONADOMASCULINOS.setText(Integer.toString(CM));
        vn.COMISIONADOFEMENINAS.setText(Integer.toString(CF));
        vn.TOTALCOMISIONADO.setText(Integer.toString(CTOTAL));

        //SUPERVISOR JEFE
        int SJM = f.TotalRegistro(5, "M", "");
        int SJF = f.TotalRegistro(5, "F", "");
        int SJTOTAL = SJM + SJF;

        vn.SUPERVISORJEFEMASCULINOS.setText(Integer.toString(SJM));
        vn.SUPERVISORJEFEFEMENINAS.setText(Integer.toString(SJF));
        vn.TOTALSUPERVISORJEFE.setText(Integer.toString(SJTOTAL));

        //SUPERVISOR AGREGADO
        int SAM = f.TotalRegistro(4, "M", "");
        int SAF = f.TotalRegistro(4, "F", "");
        int SATOTAL = SAM + SAF;

        vn.SUPERVISORAGREGADOMASCULINO.setText(Integer.toString(SAM));
        vn.SUPERVISORAGREGADOFEMENINAS.setText(Integer.toString(SAF));
        vn.TOTALSUPERVISORAGREGADO.setText(Integer.toString(SATOTAL));

        //SUPERVISOR 
        int SM = f.TotalRegistro(3, "M", "");
        int SF = f.TotalRegistro(3, "F", "");
        int STOTAL = SM + SF;

        vn.SUPERVISORMASCULINO.setText(Integer.toString(SM));
        vn.SUPERVISORFEMENINAS.setText(Integer.toString(SF));
        vn.TOTALSUPERVISOR.setText(Integer.toString(STOTAL));

        //OFICIAL JEFE
        int OJM = f.TotalRegistro(2, "M", "");
        int OJF = f.TotalRegistro(2, "F", "");
        int OJTOTAL = OJM + OJF;

        vn.OFICIALJEFEMASCULINO.setText(Integer.toString(OJM));
        vn.OFICIALJEFEFEMENINA.setText(Integer.toString(OJF));
        vn.TOTALOFICIALJEFE.setText(Integer.toString(OJTOTAL));

        //OFICIAL AGREGADO
        int OAM = f.TotalRegistro(1, "M", "");
        int OAF = f.TotalRegistro(1, "F", "");
        int OATOTAL = OAM + OAF;

        vn.OFICIALAGREGADOMASCULINO.setText(Integer.toString(OAM));
        vn.OFICIALAGREGADOFEMENINA.setText(Integer.toString(OAF));
        vn.TOTALOFICIALAGREGADO.setText(Integer.toString(OATOTAL));

        //OFICIAL
        int OM = f.TotalRegistro(0, "M", "");
        int OF = f.TotalRegistro(0, "F", "");
        int OTOTAL = OM + OF;

        vn.OFICIALMASCULINO.setText(Integer.toString(OM));
        vn.OFICIALFEMENINA.setText(Integer.toString(OF));
        vn.TOTALOFICIAL.setText(Integer.toString(OTOTAL));

        //TOTAL
        int TotalM = CJM + CAM + CM + SJM + SAM + SM + OJM + OAM + OM;
        int TotalF = CJF + CAF + CF + SJF + SAF + SF + OJF + OAF + OF;
        int TotalFuncionarios = TotalM + TotalF;

        vn.TOTALFUNCIONARIOSMASCULINOS.setText(Integer.toString(TotalM));
        vn.TOTALFUNCIONARIOSFEMENINAS.setText(Integer.toString(TotalF));
        vn.TOTALFUNCIONARIOS.setText(Integer.toString(TotalFuncionarios));
        
        
        
        
        
        
        //VACACIONES
        
        int VM = f.TotalRegistro(0, "M", "VACACIONES");
        int VF = f.TotalRegistro(0, "F", "VACACIONES");
        int VTOTAL = VM + VF;
        
        vn.VACACIONESMASCULINOS.setText(Integer.toString(VM));
        vn.VACACIONESFEMENINAS.setText(Integer.toString(VF));
        vn.TOTALVACACIONES.setText(Integer.toString(VTOTAL));
        
        
        //REPOSO
        
        int RM = f.TotalRegistro(0, "M", "REPOSO");
        int RF = f.TotalRegistro(0, "F", "REPOSO");
        int RTOTAL = RM + RF;
        
        vn.REPOSOMASCULINO.setText(Integer.toString(RM));
        vn.REPOSOFEMENINAS.setText(Integer.toString(RF));
        vn.TOTALREPOSO.setText(Integer.toString(RTOTAL));
        
        //PERMISO
        
        int PM = f.TotalRegistro(0, "M", "PERMISO");
        int PF = f.TotalRegistro(0, "F", "PERMISO");
        int PTOTAL = PM + PF;
        
        vn.PERMISIOMASCULINOS.setText(Integer.toString(PM));
        vn.PERMISOFEMENINAS.setText(Integer.toString(PF));
        vn.TOTALPERMISO.setText(Integer.toString(PTOTAL));
        
        
        //IVSS
        
        int IVSSM = f.TotalRegistro(0, "M", "IVSS");
        int IVSSF = f.TotalRegistro(0, "F", "IVSS");
        int IVSSTOTAL = IVSSM + IVSSF;
        
        vn.IVSSMASCULINOS.setText(Integer.toString(IVSSM));
        vn.IVSSFEMENINAS.setText(Integer.toString(IVSSF));
        vn.TOTALIVSS.setText(Integer.toString(IVSSTOTAL));
        
        
        //SUSPENDIDOS
        
        int SUM = f.TotalRegistro(0, "M", "SUSPENDIDO");
        int SUF = f.TotalRegistro(0, "F", "SUSPENDIDO");
        int SUTOTAL = SUM + SUF;
        
        vn.SUSPENDIDOSMASCULINOS.setText(Integer.toString(SUM));
        vn.SUSPENDIDOSFEMENINAS.setText(Integer.toString(SUF));
        vn.TOTALSUSPENDIDOS.setText(Integer.toString(SUTOTAL));
        
        
        
        //ABANDONO
        
        int AM = f.TotalRegistro(0, "M", "ABANDONO");
        int AF = f.TotalRegistro(0, "F", "ABANDONO");
        int ATOTAL = AM + AF;
        
        vn.ABANDONOSMASCULINO.setText(Integer.toString(AM));
        vn.ABANDONOSFEMENINAS.setText(Integer.toString(AF));
        vn.TOTALABANDONO.setText(Integer.toString(ATOTAL));
        
        
        
        //PRIVADO DE LIBERTAD
        
        int PRIVADOM = f.TotalRegistro(0, "M", "PRIVADO DE LIBERTAD");
        int PRIVADOF = f.TotalRegistro(0, "F", "PRIVADO DE LIBERTAD");
        int PRIVADOTOTAL = PRIVADOM + PRIVADOF;
        
        vn.PRIVADOSDELIBERTADMASCULINOS.setText(Integer.toString(PRIVADOM));
        vn.PRIVADOSDELIBERTADFEMENINAS.setText(Integer.toString(PRIVADOF));
        vn.TOTALPRIVADOSDELIBERTAD.setText(Integer.toString(PRIVADOTOTAL));
        
        
        //COMISION DE SERVICIO
        
        int CSM = f.TotalRegistro(0, "M", "COMISION DE SERVICIO");
        int CSF = f.TotalRegistro(0, "F", "COMISION DE SERVICIO");
        int CSTOTAL = CSM + CSF;
        
        vn.COMISIONDESERVICIOMASCULINO.setText(Integer.toString(CSM));
        vn.COMISIONDESERVICIOFEMENINA.setText(Integer.toString(CSF));
        vn.TOTALCOMISIONDESERVICIO.setText(Integer.toString(CSTOTAL));
        
        
        //ACTIVO
        
        int ATM = f.TotalRegistro(0, "M", "ACTIVO");
        int ATF = f.TotalRegistro(0, "F", "ACTIVO");
        int ATTOTAL = ATM + ATF;
        
        vn.ACTIVOMASCULINO.setText(Integer.toString(ATM));
        vn.ACTIVOFEMENINAS.setText(Integer.toString(ATF));
        vn.TOTALACTIVOS.setText(Integer.toString(ATTOTAL));
        
        
        
        
        //TOTAL
        
        
        int TOTALMESTATUS = VM + RM + PM + IVSSM + SUM + AM + PRIVADOM + ATM;
        int TOTALFESTATUS = VF + RF + PF + IVSSF + SUF + AF + PRIVADOF + ATF;
        int TOTALESTATUS = TOTALMESTATUS + TOTALFESTATUS;
        
        vn.TOTALESTATUSMASCULINO.setText(Integer.toString(TOTALMESTATUS));
        vn.TOTALESTATUDFEMENINAS.setText(Integer.toString(TOTALFESTATUS));
        vn.TOTALESTATUS.setText(Integer.toString(TOTALESTATUS));
        
        
        f.Close();
        
        

    }

}
