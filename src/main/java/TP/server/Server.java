package TP.server;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
    public static void main(String[] args) {
        //este el puerto donde se levanta el sitio
        Spark.port(9000);
        //que se levante el router
        Router.init();
        DebugScreen.enableDebugScreen();
    }
}








































