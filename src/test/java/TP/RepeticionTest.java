package TP;

import TP.User.Usuario;
import TP.User.UsuarioDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RepeticionTest {
    static Usuario dario;

    @BeforeAll
    public static void fixture(){
        UsuarioDTO dariodto = new UsuarioDTO("dariokozicki@gmail.com","5491126816082", "dario", "1234");
        dario = new Usuario(dariodto);
        Evento laburo = new Evento("Trabajo",0,new Frecuencia(true,1));
        dario.agregarEvento(laburo);
        Evento salida = new Evento("Ir al cine",0,new Frecuencia(false,2));
        dario.agregarEvento(salida);
    }
    @Test
    public void eventosRepetitivos(){
        System.out.println("Hoy:");
        imprimirEventos();
        System.out.println("Mañana:");
        dario.actualizarEventos(dario);
        imprimirEventos();
    }
    public void imprimirEventos(){
        dario.getEventos().stream().forEach(evento->System.out.println(evento.toString()));
    }


}
