package TP;

import TP.Messages.Email.EmailSender;
import TP.Messages.Sendable;
import TP.User.Usuario;
import TP.Messages.Whatsapp.WhatsappSender;
import TP.User.UsuarioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MessageTester {
    public static Usuario pablo;
    public static Usuario tamara;
    public static Usuario dario;
    public static Usuario agustin;


    @BeforeAll
    public static void fixture(){
        ArrayList<Sensibilidad> unMedidor = new ArrayList<Sensibilidad>();

        UsuarioDTO tamaradto = new UsuarioDTO("tamara.m94@hotmail.com", "5491159753115", "tam", "1234");
        UsuarioDTO pablodto = new UsuarioDTO("pablooib81@gmail.com", "5491139473695", "pabli", "1234");
        UsuarioDTO dariodto =  new UsuarioDTO("dariokozicki@gmail.com", "5491126816082", "dario", "1234");
        pablo = new Usuario(pablodto);
        tamara = new Usuario(tamaradto);
        dario = new Usuario(dariodto);

    }


    @Test
    public void probarMail(){
        Sendable emailsender = EmailSender.get();
        try {
            emailsender.avisarAtuendo(pablo);
        }catch (Exception e){
            e.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void probarWhatsapp(){
        WhatsappSender.get().avisarAtuendo(pablo);
    }

    @Test
    public void alertaMeteorologica(Usuario usuario){
        Evento evento = new Evento("Trabajo", 1,new Frecuencia(false,0));
        evento.setAbrigoPronosticado(-10);
        evento.avanzarUnDia(usuario);
    }
    @Test
    public void avisoUsuario(Usuario usuario){
        Evento evento = new Evento("Trabajo", 1,new Frecuencia(false,0));
        evento.actualizarAbrigoPronosticado();
        evento.avanzarUnDia(usuario);
    }

}
