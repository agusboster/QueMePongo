package TP;

import TP.SugeridorDeAtuendos;
import TP.Weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.security.Guard;
import java.util.ArrayList;

public class TestWeather {
    @Test
    public void recibirTemperatura(){
        try{
            System.out.println(Weather.getTemperaturaAhora());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void recibirTemperaturaEn2Dias(){
        try{
            System.out.println(Weather.getTemperaturaDia(2));
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }
    @Test
    public void recibirTemperaturaEn7DiasYFallar(){
            System.out.println(Weather.getTemperaturaDia(6));

    }
    @Test
    public void nivelDeAbrigoDeAtuendo(){
        /*
        Categoria superior = new Categoria("superior",true);
        CategoriaCapa superior0 = new CategoriaCapa(superior,0,7);
        CategoriaCapa superior1 = new CategoriaCapa(superior,1,10);
        DTOPrenda dtoBuzo = new DTOPrenda("buzo",superior1,null,null);
        DTOPrenda dtoRemera = new DTOPrenda("remera",superior0,null,"seda");
        Prenda buzo = new Prenda(dtoBuzo);
        Prenda remera = new Prenda(dtoRemera);
        ArrayList<Prenda> prendas = new ArrayList<>();
        prendas.add(remera);
        prendas.add(buzo);
        Atuendo atuendo = new Atuendo(prendas);
        Assertions.assertEquals(17,atuendo.nivelDeAbrigo());
         */
    }
}
