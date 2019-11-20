package TP.Config;

public class WhatsappConfig {
    private String ACCOUNT_SID;
    private String AUTH_TOKEN;
    private String phoneNumber;

    public WhatsappConfig(){
        AUTH_TOKEN = "0716e60b04eb2f1c34005aa80c448f70";
        ACCOUNT_SID = "ACe6f03a00bd9803aa3533b5c7e8c198be";
        phoneNumber = "14155238886";
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getACCOUNT_SID(){
        return ACCOUNT_SID;
    }

    public String getAUTH_TOKEN() {
        return AUTH_TOKEN;
    }
}
