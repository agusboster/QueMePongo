package TP.controllers;

import TP.*;
import TP.User.Usuario;
import TP.User.UsuarioDTO;
import TP.repos.RepositorioCategoria;
import TP.repos.RepositorioGuardarropas;
import TP.repos.RepositorioPrendas;
import TP.repos.RepositorioUsuario;
import TP.repos.factories.FactoryRepositorioCategoria;
import TP.repos.factories.FactoryRepositorioGuardarropas;
import TP.repos.factories.FactoryRepositorioPrendas;
import TP.repos.factories.FactoryRepositorioUsuario;
import db.EntityManagerHelper;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrendasController {

    private RepositorioPrendas repo;

    public PrendasController(){
        this.repo = FactoryRepositorioPrendas.get();
    }

    public ModelAndView mostrarTodas(Request request, Response response){
//TODO
        Map<String, Object> parametros = new HashMap<>();

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas unGuardarropas = repoGuardarropas.buscar(new Integer(request.params("id")));

        List<Prenda> prendas = unGuardarropas.getPrendas();

        parametros.put("prendas", prendas);

        return new ModelAndView(parametros, "prendas.hbs");
    }

    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        RepositorioCategoria repoCategoria = FactoryRepositorioCategoria.get();
        parametros.put("categorias", repoCategoria.buscarTodos());

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        parametros.put("usuario", repoUsuario.buscar(new Integer(request.params("id"))));

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        List<Guardarropas> guardarropas = repoGuardarropas.buscarTodos();
        parametros.put("guardarropas", guardarropas);

        return new ModelAndView(parametros, "prenda.hbs");
    }


    public ModelAndView mostrarEventos(Request request, Response response){

        //VERSION GENERICA

         Map<String, Object> parametros = new HashMap<>();

        Integer idGuardarropas = new Integer(request.params("idGuardarropas"));
        Integer idUser = new Integer(request.params("idUser"));

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(idGuardarropas);

        TypedQuery<Evento> query = (TypedQuery<Evento>) EntityManagerHelper.getEntityManager().createQuery("SELECT evento from EventoXUsuario WHERE user_ID = :idDelUser)" );
        query.setParameter("idDelUser", idUser);
        List<Evento> eventos = query.getResultList();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(idGuardarropas);


        parametros.put("eventos", eventos);
        parametros.put("guardarropas", guardarropas);
        parametros.put("usuario", user);

/*
        Integer userID = new Integer(request.params("id"));


        Map<String, Object> parametros = new HashMap<>();

        parametros.put("guardarropas", guardarropas);


        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();

        Guardarropas guardarropas = repoGuardarropas.buscar(idGuardarropas);

        List<Evento> eventos = EntityManagerHelper.createQuery("from Evento").getResultList();

        TypedQuery<Integer> query = (TypedQuery<Integer>) EntityManagerHelper.getEntityManager().createQuery("SELECT user_id from GuardarropasXUsuario WHERE guardarropas_ID = :idDelGuardarropas)" );
        query.setParameter("idDelGuardarropas", idGuardarropas);
        Integer userID = query.getSingleResult();

        TypedQuery<Evento> query2 = (TypedQuery<Evento>) EntityManagerHelper.getEntityManager().createQuery("from EventoXUsuario WHERE user_ID = :idDelUser)" );
        query2.setParameter("idDelUser", userID);
     //   Integer userID = query2.getResultList();


        parametros.put("eventos", eventos);
        parametros.put("guardarropas", guardarropas);
*/

        return new ModelAndView(parametros, "eventos.hbs");
    }

    public Response guardar(Request request, Response response){
        Prenda prenda = new Prenda();
        asignarAtributosA(prenda, request);
        this.repo.agregar(prenda);
        EntityManagerHelper.getEntityManager().refresh(prenda);

        String idUser = request.params("id");

        String location ="/guardarropas/";


        response.redirect(location.concat(idUser));
        return response;
    }

    /*
          unSugeridor = SugeridorDeAtuendos.get();
          commandAlto = new atuendoNivelAltoCommand(unSugeridor);

            //recuperar al usuario que tiene guardarropas del id

            //PANTALLA SELECCIONAR EVENTO //usar predefinido pa ver que funcionee

           //recuperar la clase guardarropas

            //query para recuperar las capas (rancio.. pero lo que hay)
            //query para recuperar las categorias (rancio.. pero lo que hay)
            //one to many.. categoria -> capas

           //recuperar las prendas que le corresponden a ESTE guardarropas

           //recuperar el guardarropas que le corresponde a este usuario


           sensibilidadSuperior = new Sensibilidad(superior, 0, userDto, "superior");
           sensibilidadInferior = new Sensibilidad(inferior, 0, userDto, "inferior");
           sensibilidadCalzado = new Sensibilidad(calzado, 0, userDto, "calzado");
           sensibilidadAccesorios = new Sensibilidad(accesorios, 0, userDto, "accesorio");

           userDto.getMedidores().add(sensibilidadSuperior);
           userDto.getMedidores().add(sensibilidadInferior);
           userDto.getMedidores().add(sensibilidadCalzado);
           userDto.getMedidores().add(sensibilidadAccesorios);

            Atuendo atuendo = user.pedirSugerencia(unGuardarropas, unEvento, unSugeridor);
            System.out.println(atuendo);


    */



    private void asignarAtributosA(Prenda prenda, Request request){
        if(request.queryParams("descripcion") != null){
            prenda.setDescripcion(request.queryParams("descripcion"));
        }

        if(request.queryParams("material") != null){
            prenda.setMaterial(request.queryParams("material"));
        }


        if((request.queryParams("numeroCapa") != null) &&  (request.queryParams("nivelAbrigo") != null)){
            int numeroCapa = new Integer(request.queryParams("numeroCapa"));
            double nivelAbrigo = new Double(request.queryParams("nivelAbrigo"));

            prenda.setearCapa(numeroCapa);
            prenda.setNivelDeAbrigo(nivelAbrigo);
            //          Capa nuevaCapa = new Capa(numeroCapa, nivelAbrigo);
            //        prenda.setearCapa(nuevaCapa);

        }

        if(request.queryParams("categoria") != null){

            RepositorioCategoria repoCategoria = FactoryRepositorioCategoria.get();
            Categoria unaCategoria = repoCategoria.buscar(new Integer(request.queryParams("categoria")));

            prenda.setCategoria(unaCategoria.getTipo());
            //      prenda.setearCategoria(unaCategoria);
        }

        if(request.queryParams("guardarropas") != null){
            RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
            Guardarropas unGuardarropas = repoGuardarropas.buscar(new Integer(request.queryParams("guardarropas")));
            prenda.setearGuardarropas(unGuardarropas);
        }
    }











  /*
    public Response guardar(Request request, Response response){
        Prenda prenda = new Prenda();
        asignarAtributosA(prenda, request);
        this.repo.agregar(prenda);
        response.redirect("/prendas");
        return response;
    }



    private void asignarAtributosA(Prenda usuario, Request request){

        if(request.queryParams("nombre") != null){
            usuario.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("email") != null){
            usuario.setEmail(request.queryParams("email"));
        }

        if(request.queryParams("nombreDeUsuario") != null){
            usuario.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
        }

        if(request.queryParams("apellido") != null){
            usuario.setApellido(request.queryParams("apellido"));
        }

        if(request.queryParams("legajo") != null){
            int legajo = new Integer(request.queryParams("legajo"));
            usuario.setLegajo(legajo);
        }

        if(request.queryParams("fechaDeNacimiento") != null && !request.queryParams("fechaDeNacimiento").isEmpty()){
            LocalDate fechaDeNacimiento = LocalDate.parse(request.queryParams("fechaDeNacimiento"));
            usuario.setFechaDeNacimiento(fechaDeNacimiento);
        }

        if(request.queryParams("rol") != null){
            RepositorioRol repoRol = FactoryRepositorioRol.get();
            Rol unRol = repoRol.buscar(new Integer(request.queryParams("rol")));
            usuario.setRol(unRol);
        }
    }

*/


}
