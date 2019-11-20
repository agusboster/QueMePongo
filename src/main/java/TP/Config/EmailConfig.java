package TP.Config;

public class EmailConfig {
    private String SMTP_SERVER;
    private String USERNAME;
    private String PASSWORD;
    private String EMAIL_FROM;
    private String EMAIL_SUBJECT;
    private String PORT;
    private boolean AUTH;
    public EmailConfig(){
        init();
    }
    private void init(){
        SMTP_SERVER = "smtp.mailgun.org";
        USERNAME = "postmaster@sandbox55ad93ffa00344f6abc8709547f25090.mailgun.org";
        PASSWORD = "59dbd7ed26d662597f9186bbb6b7ccb8-39bc661a-d9f2f3ec";
        EMAIL_FROM = "quemepongo@gmail.com";
        EMAIL_SUBJECT = "Alerta QueMePongo";
        PORT = "587";
        AUTH = true;
    }
    public String getSMTP_SERVER() {
        return SMTP_SERVER;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getEMAIL_FROM() {
        return EMAIL_FROM;
    }

    public String getEMAIL_SUBJECT() {
        return EMAIL_SUBJECT;
    }
    public String getPORT(){
        return PORT;
    }
    public boolean isAUTH(){
        return AUTH;
    }
}
