package TP.Messages.Whatsapp;

import TP.Config.WhatsappConfig;
import TP.Messages.Email.EmailSender;
import TP.Messages.Sendable;
import TP.User.Usuario;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class WhatsappSender implements Sendable {
    private static WhatsappSender sender;
    private WhatsappConfig config;

    private WhatsappSender(){
        config = new WhatsappConfig();
    }
    public void avisarAtuendo(Usuario usuario){
        enviarMensaje(usuario, "Tu abrigo ya esta listo! Haz click aqui (link)!");
    }
    public void avisarAlerta(Usuario usuario, double diferencia)  {
        enviarMensaje(usuario, "Alerta Meteorologica! Nos equivocamos por " + diferencia + " grados!" +
                "\nEntre a QueMePongo para elegir una nueva sugerencia.");
    }
    public static Sendable get(){
        if (sender==null)
            sender = new WhatsappSender();
        return sender;
    }
    public void enviarMensaje(Usuario usuario, String mensaje){
        Twilio.init(config.getACCOUNT_SID(), config.getAUTH_TOKEN());
        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+"+usuario.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("whatsapp:+"+config.getPhoneNumber()),
                mensaje)
                .create();
    }
}
