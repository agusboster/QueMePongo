package TP;

import TP.Prenda;
import db.EntityManagerHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmTest{

    Prenda nuevaPrenda;
    Frecuencia nuevaFrecuencia;
    Evento nuevoEvento;

    @BeforeEach
    public void fixture() {

     //   nuevaPrenda = new Prenda("remera", null,"tela",null,null);
        nuevaFrecuencia = new Frecuencia(true, 2);
        nuevoEvento = new Evento("Casamiento", 5102019, nuevaFrecuencia);
    }

    @Test
    public void persistir1PrendaTest(){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(nuevaPrenda);
        EntityManagerHelper.commit();
    }

    @Test
    public void persistir1EventoTest(){


        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(nuevoEvento);
        EntityManagerHelper.commit();
    }

    @Test
    public void persistir1AtuendoTest(){

        Frecuencia nuevaFrecuencia = new Frecuencia(true, 2);
     //   Evento nuevoEvento = new Evento("Casamiento", 5102019, nuevaFrecuencia, null);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(nuevoEvento);
        EntityManagerHelper.commit();
    }

}
