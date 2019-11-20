package TP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Guard;
import java.util.ArrayList;

public class GuardarropasTest {
    /*
    Categoria superior;
    Categoria inferior;
    Categoria calzado;
    Categoria accesorios;
    Material seda;
    Material cuero;
    Material polyester;
    Prenda remeraDeMickey;
    Prenda bandana;
    Prenda medias;
    Prenda pantalonJean;
    Prenda camisa;
    Prenda shortcito;
    Guardarropas guardarropas;
    Guardarropas otroGuardarropas;
    ArrayList<Prenda> prendas;
    ArrayList<Categoria> categorias;

    @BeforeEach
    public void fixture(){
        superior = new Categoria("Superior",true,new ArrayList<String>() {{
            add("Remera");
            add("Camisa");
            add("Campera");
        }});
        inferior = new Categoria("Inferior",true,new ArrayList<String>() {{
            add("Pantalon");
            add("Short");
        }});
        calzado = new Categoria("Calzado",true,new ArrayList<String>() {{
            add("Medias");
            add("Crocs");
            add("Zapatos");
        }});
        accesorios = new Categoria("Accesorios",false,new ArrayList<String>() {{
            add("Bandana");
            add("Anteojos");
            add("Gorro");
        }});
        seda = new Material("Seda",new ArrayList<String>() {{
            add("Remera");
            add("Bandana");
            add("Pantalon");
        }});
        cuero = new Material("Cuero",new ArrayList<String>() {{
            add("Campera");
            add("Cinturon");
            add("Zapatos");
            add("Pantalon");
        }});
        polyester = new Material("Polyester",new ArrayList<String>() {{
            add("Remera");
            add("Camisa");
            add("Medias");
            add("Short");
        }});
        try {
            remeraDeMickey = new Prenda("Remera de Mickey Mouse", superior, null, polyester);
            bandana = new Prenda("Bandana de pirata", accesorios, null, seda);
            medias = new Prenda("Medias de diseñador",calzado,null,polyester);
            pantalonJean = new Prenda("Pantalon de Jean",inferior,null,cuero);
            camisa = new Prenda("Camisa de cheto",superior,null,polyester);
            shortcito = new Prenda("Short revelador",inferior,null,polyester);

        }catch(Prenda.excepcionPrendaNoValida error){
            Assertions.fail();
        }
        prendas = new ArrayList<Prenda>(){{
            add(remeraDeMickey);
            add(pantalonJean);
            add(bandana);
            add(medias);
            add(camisa);
            add(shortcito);
        }};
        categorias = new ArrayList<Categoria>(){{
            add(superior);
            add(inferior);
            add(calzado);
            add(accesorios);
        }};


        try{
            guardarropas = new Guardarropas(prendas,categorias);
        } catch (Exception e) {
            System.out.println("Error: No fue valido el atuendo.");
        }
    }
    @Test
    public void atuendoRandom(){


        try{
            System.out.println(guardarropas.sugerirAtuendo());
        } catch (Exception e) {
            System.out.println("Error: No fue valido el atuendo.");
        }
    }
    @Test
    public void usuarioPideSugerencia(){

        ArrayList<Guardarropas> listaGuardarropas = new ArrayList<Guardarropas>(){{
            add(guardarropas);
        }};

        try{
            otroGuardarropas = new Guardarropas(prendas,categorias);
        } catch (Guardarropas.excepcionGuardarropasNoValido error) {
            System.out.println(error.getMessage());
        }

        Usuario nuevoUsuario = new Usuario(listaGuardarropas);

        try{
            System.out.println(nuevoUsuario.pedirSugerencia(otroGuardarropas));
        } catch (Usuario.excepcionGuardarropasNoSeEncuentraEnElConjunto error) {
            System.out.println(error.getMessage());
        }
    }
    @Test
    public void sugerirSinAccesorio(){
        guardarropas.removerPrenda(bandana);
        try{
            Atuendo atuendo = guardarropas.sugerirAtuendo();
            System.out.println(atuendo);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }

     */
}
