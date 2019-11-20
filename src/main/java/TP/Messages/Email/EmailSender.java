package TP.Messages.Email;

import TP.Config.EmailConfig;
import TP.Messages.Sendable;
import TP.User.Usuario;
import com.sun.mail.smtp.SMTPTransport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EmailSender implements Sendable {
    private static EmailSender sender;
    private EmailConfig config;
    private Session session;
    private EmailSender(){
        config = new EmailConfig();
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", config.getSMTP_SERVER());
        prop.put("mail.smtp.auth", config.isAUTH());
        prop.put("mail.smtp.port", config.getPORT());

        session = Session.getInstance(prop, null);

    }
    public static Sendable get(){
        if (sender==null)
            sender = new EmailSender();
        return sender;
    }
    public void avisarAtuendo(Usuario usuario)  {
        enviarMensaje(usuario, "Tu atuendo ya está listo! Miralo acá (link)!");
    }
    public void avisarAlerta(Usuario usuario, double diferencia)  {
        enviarMensaje(usuario, "Alerta Meteorologica! Nos equivocamos por " + diferencia + " grados!" +
                "\nEntre a QueMePongo para elegir una nueva sugerencia.");
    }
    public void enviarMensaje(Usuario usuario, String EMAIL_TEXT) {
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(config.getEMAIL_FROM()));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(usuario.getEmail(), false));
            msg.setSubject(config.getEMAIL_SUBJECT());
            msg.setText(EMAIL_TEXT);
            msg.setSentDate(new Date());
            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
            t.connect(config.getSMTP_SERVER(), config.getUSERNAME(), config.getPASSWORD());
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
        }catch(Exception e){e.printStackTrace();};
    }
}