package controller;

import evento.otro.EventoLogin;
import view.VLogin;

public class VLoginController extends VLogin{
    
    public VLoginController(){
        setAlwaysOnTop(true);
        getBTN_INGRESAR().addMouseListener(new EventoLogin());
    }
    
}
