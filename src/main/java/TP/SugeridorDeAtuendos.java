package TP;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import TP.*;
import TP.User.Usuario;
import db.EntityManagerHelper;

import javax.persistence.TypedQuery;

public class SugeridorDeAtuendos {
    private static SugeridorDeAtuendos sugeridorDeAtuendos;
    ArrayList<Prenda> prendas = new ArrayList<Prenda>();
//    ArrayList<CategoriaCapa> categorias = new ArrayList<CategoriaCapa>();
    ArrayList<String> categorias = new ArrayList<String>();
   // Double nivelActual;
    ArrayList<Integer> capasAUtilizar = new ArrayList<Integer>();
    ArrayList<Prenda> conjunto = new ArrayList<Prenda>();

    private String categoriaRandom(ArrayList<String> categorias) {
        Random rand = new Random();
        if (categorias.size()!=0) {
            return categorias.get(
                    rand.nextInt(categorias.size())
            );
        }
        return null;
    }

    private Integer capaRandom(ArrayList<Integer> capasRandom) {
        Random rand = new Random();
        if (capasRandom.size()!=0) {
            return capasRandom.get(
                    rand.nextInt(capasRandom.size())
            );
        }
        return null;
    }

    //TODO, funcion que haga el promedio?
    public Atuendo sugerirAtuendo(Evento unEvento, List<Prenda> unasPrendas, Usuario unUsuario){

        Atuendo nuevoAtuendo = new Atuendo();
        Double acumulador = 0.0;

        Double nivelNecesario = unEvento.nivelDeAbrigoNecesario();
//guarda esto no se si me podrá afectar
        List<Prenda> prendasLibres = unasPrendas.stream().filter(prenda -> !(prenda.estaEnUso)).collect(Collectors.toCollection(ArrayList::new));
        if (unEvento.esFormal())
            prendasLibres = prendasLibres.stream().filter(prenda->prenda.esFormal()).collect(Collectors.toCollection(ArrayList::new));


        llenarLoMinimoNecesario(nivelNecesario, nuevoAtuendo, prendasLibres);

        unUsuario.getMedidores().stream().forEach(medidor -> this.rellenarCapas(medidor.getCategoria(), (nivelNecesario/2), medidor.getModificador(), nuevoAtuendo, unasPrendas));


//        unUsuario.agregarAtuendo(nuevoAtuendo);

        return (nuevoAtuendo);
    }

    public void rellenarCapas(Categoria categoria, Double nivelNecesario, Integer modificador, Atuendo atuendo, List<Prenda> prendas){

        Double R = nivelNecesario + modificador;
        nivelNecesario = 3.0;
        List<Capa> capas = categoria.getCapas();
        ArrayList<Integer> capasAUtilizar = capas.stream().map(capa -> capa.getNumeroCapa()).collect(Collectors.toCollection(ArrayList::new));
        capasAUtilizar.remove(0);
        //delegar a una funcion booleana
        while ((nivelActual(atuendo) > (R - 6) ) && (nivelActual(atuendo) <= (R + 6))) {

            Integer dameUnaCapaRandom = capaRandom(capasAUtilizar);

            Prenda nuevaPrenda = sugerirPrendaRandomConNivelMenorA(nivelNecesario, categoria.getTipo(), dameUnaCapaRandom, prendas);
            if(existeYaUnaPrendaDeCapaYCategoria(nuevaPrenda, atuendo)){
                continue;
            }
            atuendo.getPrendas().add(nuevaPrenda);

        }

    }

    public Double nivelActual(Atuendo atuendo){
        return atuendo.getPrendas().stream()
                .map(prenda->prenda.getNivelDeAbrigo())
                .reduce(0.0,(subtotal,elem)->subtotal+elem);
    }

    boolean existeYaUnaPrendaDeCapaYCategoria(Prenda unaPrenda, Atuendo atuendo){

        return (atuendo.getPrendas().contains(unaPrenda));
     // return  (this.conjunto.stream().anyMatch(prenda -> ((prenda.esDe(categoria)) && prenda.esDeCapa(capa))));
    }

    public Prenda sugerirPrendaRandomConNivelMenorA(Double nivelNecesario, String categoria, Integer capa, List<Prenda> prendas){
        //como hacemos aca con las capas? una random?
        return prendaRandomDeCategoria( categoria,capa,nivelNecesario, prendas);
    }



    private void llenarLoMinimoNecesario(Double nivel, Atuendo atuendo, List<Prenda> prendas){
        nivel = 5.0;
        Prenda prendaFiltrada0 =sugerirPrendaRandomConNivelMenorA(nivel,"superior",0,prendas);
        Prenda prendaFiltrada1 =sugerirPrendaRandomConNivelMenorA(nivel,"inferior",1,prendas);
        Prenda prendaFiltrada2 =sugerirPrendaRandomConNivelMenorA(nivel,"calzado",0,prendas);


        atuendo.getPrendas().add(prendaFiltrada0);
        atuendo.getPrendas().add(prendaFiltrada1);
        atuendo.getPrendas().add(prendaFiltrada2);
    }


    public Prenda prendaRandomDeCategoria(String categoria, Integer capa, Double nivel, List <Prenda> prendas) {

        TypedQuery<Prenda> query = (TypedQuery<Prenda>) EntityManagerHelper.getEntityManager().createQuery("from Prenda WHERE categoria = :cat AND capa = :cap AND (Nivel_de_abrigo < :num)" );
        query.setParameter("cat", categoria);
        query.setParameter("cap",capa);
        query.setParameter("num",nivel);
        List<Prenda> prendasFiltradas = query.getResultList();

        Random rand = new Random();
        Prenda prendaFiltrada0 = prendasFiltradas.get(rand.nextInt(prendasFiltradas.size()));

        return prendaFiltrada0;

        /*
        List<Prenda> prendasFiltradas = new ArrayList<>();
        for (Prenda prenda : prendas){
            if (prenda.getDescripcion() == "Remera "){
                prendasFiltradas.add(prenda);
            }
        }
*/
        // filtrarPorCategoria(categoria, capa, nivel, prendas);
  //      return prendaRandom(prendasFiltradas);
    }

    public List<Prenda> filtrarPorCategoria(String categoria, Integer capa, Double nivel, List<Prenda> prendas) {
        return prendas.stream()
                .filter(p -> ((p.esDe(categoria)) /*&& (p.esDeCapa(capa)) && (p.suNivelEsMenorA(nivel))*/))
                .collect(Collectors.toList());
    }

    public Prenda prendaRandom(List<Prenda> unasPrendas) {
        Random rand = new Random();
        if (unasPrendas.size()!=0) {
            return unasPrendas.get(
                    rand.nextInt(unasPrendas.size())
            );
        }
        return null;
    }



    private SugeridorDeAtuendos(/*Guardarropas unGuardarropas*/) {
    //    this.guardarropas = unGuardarropas;
    }
    public static SugeridorDeAtuendos get(){
        if(sugeridorDeAtuendos==null)
            sugeridorDeAtuendos = new SugeridorDeAtuendos();
        return sugeridorDeAtuendos;
    }

}