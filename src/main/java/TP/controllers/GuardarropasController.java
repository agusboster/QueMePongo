package TP.controllers;

import TP.*;
import TP.User.Usuario;
import TP.User.UsuarioDTO;
import TP.repos.RepositorioCategoria;
import TP.repos.RepositorioEvento;
import TP.repos.RepositorioGuardarropas;
import TP.repos.RepositorioUsuario;
import TP.repos.factories.FactoryRepositorioCategoria;
import TP.repos.factories.FactoryRepositorioEvento;
import TP.repos.factories.FactoryRepositorioGuardarropas;
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

public class GuardarropasController {
    private RepositorioGuardarropas repo;

    public GuardarropasController(){
        this.repo = FactoryRepositorioGuardarropas.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {

        Integer userID = new Integer(request.params("id"));

        TypedQuery<Guardarropas> query = (TypedQuery<Guardarropas>) EntityManagerHelper.getEntityManager().createQuery("SELECT guardarropas from GuardarropasXUsuario WHERE user_ID = :idDelUser)" );
        query.setParameter("idDelUser", userID);
        List<Guardarropas> guardarropas = query.getResultList();

        RepositorioUsuario repoUser = FactoryRepositorioUsuario.get();
        Usuario user = repoUser.buscar(userID);

        Map<String, Object> parametros = new HashMap<>();

        parametros.put("guardarropas", guardarropas);
        parametros.put("usuario", user);

        return new ModelAndView(parametros, "guardarropas.hbs");
    }


    public ModelAndView sugerirAtuendo(Request request, Response response) {

        SugeridorDeAtuendos unSugeridor = SugeridorDeAtuendos.get();

        RepositorioEvento repoEvento = FactoryRepositorioEvento.get();
        Evento evento = repoEvento.buscar(new Integer(request.params("idEvento")));

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("idUser")));

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        Atuendo unAtuendo = unSugeridor.sugerirAtuendo(evento, guardarropas.getPrendas(), user);

        List<Prenda> prendas = unAtuendo.getPrendas();

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("prendas", prendas);
        parametros.put("guardarropas", guardarropas);
        parametros.put("usuario", user);

        return new ModelAndView(parametros, "atuendo.hbs");
    }

    public ModelAndView calificarAtuendo(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);
        parametros.put("usuario", user);

        return new ModelAndView(parametros, "calificarSuperior.hbs");
    }

    public ModelAndView calorSuperior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        user.getMedidores().get(0).tuvoCalor();



        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);
        parametros.put("usuario", user);


        return new ModelAndView(parametros, "calificarInferior.hbs");
    }

    public ModelAndView frioSuperior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        user.getMedidores().get(0).tuvoCalor();

        parametros.put("usuario", user);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);


        return new ModelAndView(parametros, "calificarInferior.hbs");
    }

    public ModelAndView nadaSuperior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        parametros.put("usuario", user);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);


        return new ModelAndView(parametros, "calificarInferior.hbs");
    }

    public ModelAndView calorInferior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        user.getMedidores().get(1).tuvoCalor();

        List<Evento> eventos = EntityManagerHelper.createQuery("from Evento").getResultList();

        parametros.put("eventos", eventos);
        parametros.put("usuario", user);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);

        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView crearEvento(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        parametros.put("usuario", user);

        return new ModelAndView(parametros, "evento.hbs");
    }


    public ModelAndView frioInferior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        user.getMedidores().get(1).tuvoFrio();

        List<Evento> eventos = EntityManagerHelper.createQuery("from Evento").getResultList();

        parametros.put("eventos", eventos);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);

        parametros.put("usuario", user);

        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView nadaInferior(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        List<Evento> eventos = EntityManagerHelper.createQuery("from Evento").getResultList();

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        parametros.put("usuario", user);

        parametros.put("eventos", eventos);

        RepositorioGuardarropas repoGuardarropas = FactoryRepositorioGuardarropas.get();
        Guardarropas guardarropas = repoGuardarropas.buscar(new Integer(request.params("idGuardarropas")));

        parametros.put("guardarropas", guardarropas);

        return new ModelAndView(parametros, "eventos.hbs");
    }

    public ModelAndView logearse(Request request, Response response) {

        Map<String, Object> parametros = new HashMap<>();

        return new ModelAndView(parametros, "login.hbs");
    }


    public Response guardarEvento(Request request, Response response){
        Evento evento = new Evento();
        Frecuencia frecuencia = new Frecuencia();

        asignarAtributosA(evento, frecuencia, request);

        String idUser = request.params("id");

        RepositorioUsuario repoUsuario = FactoryRepositorioUsuario.get();
        Usuario user = repoUsuario.buscar(new Integer(request.params("id")));

        String location ="/guardarropas/";

        EntityManagerHelper.beginTransaction();


        EntityManagerHelper.getEntityManager().persist(frecuencia);

        evento.setFrecuencia(frecuencia);
        EntityManagerHelper.getEntityManager().persist(evento);

        EventoXUsuario eventoUser = new EventoXUsuario(evento, user.getUsuarioDTO());
        EntityManagerHelper.getEntityManager().persist(eventoUser);


        EntityManagerHelper.commit();

        response.redirect(location.concat(idUser));
        return response;
    }

    private void asignarAtributosA(Evento evento, Frecuencia frecuencia, Request request){
        if(request.queryParams("descripcion") != null){
            evento.setDescripcion(request.queryParams("descripcion"));
        }

        if(request.queryParams("diasQueFaltan") != null){
            evento.setDiasQueFaltan(new Integer(request.queryParams("diasQueFaltan")));
        }

        if(request.queryParams("cadaCuanto") != null){
            frecuencia.setCadaCuanto(new Integer(request.queryParams("cadaCuanto")));
        }

    }

    public Response ingresoUser(Request request, Response response){

//TODO: TIRAR MJE DE ERROR SI NO EXISTE

        String username = request.queryParams("username");
        String password = request.queryParams("password");

        TypedQuery <UsuarioDTO>  query = (TypedQuery <UsuarioDTO>) EntityManagerHelper.getEntityManager().createQuery("from UsuarioDTO WHERE Username = :nomUser AND Password= :nomPas)" );
        query.setParameter("nomUser", username);
        query.setParameter("nomPas", password);
        UsuarioDTO user = query.getSingleResult();

        String location ="/guardarropas/";

        response.redirect(location.concat(user.getId().toString()));
        return response;
    }




}
