package TP.server;

import TP.controllers.GuardarropasController;
import TP.controllers.PrendasController;
import TP.spark.utils.BooleanHelper;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import TP.spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure() {
        //Spark.get("/usuarios", (rec,res)->"hola");
        GuardarropasController guardarropasController = new GuardarropasController();
        PrendasController prendasController = new PrendasController();


        Spark.get("/login", guardarropasController::logearse, Router.engine);

        Spark.get("/guardarropas/:id", guardarropasController::mostrarTodos, Router.engine);

      //  Spark.get("/guardarropas", guardarropasController::mostrarTodos, Router.engine);

        Spark.get("/prendas/:id", prendasController::mostrarTodas, Router.engine);

        Spark.get("/evento/:id", prendasController::mostrarTodas, Router.engine);

        Spark.post("/evento/:id", guardarropasController::guardarEvento);

        Spark.post("/ingresar", guardarropasController::ingresoUser);

        Spark.get("/eventoNuevo/:id", guardarropasController::crearEvento, Router.engine);

        Spark.get("/prenda/:id", prendasController::crear, Router.engine);

        //EXPLICACION: si existe mandame a un post de modificar, si no existe mandame a un post de crear
        Spark.post("/prenda/:id", prendasController::guardar);

        Spark.get("/sugerencia/:idGuardarropas/:idUser", prendasController::mostrarEventos, Router.engine);

        Spark.get("/atuendo/:idEvento/:idGuardarropas/:idUser", guardarropasController::sugerirAtuendo, Router.engine);

        Spark.get("/calificacion/:id/:idGuardarropas", guardarropasController::calificarAtuendo, Router.engine);

        Spark.get("/calorSup/:id/:idGuardarropas", guardarropasController::calorSuperior, Router.engine);

        Spark.get("/frioSup/:id/:idGuardarropas", guardarropasController::frioSuperior, Router.engine);

        Spark.get("/nadaSup/:id/:idGuardarropas", guardarropasController::nadaSuperior, Router.engine);

        Spark.get("/calorInf/:id/:idGuardarropas", guardarropasController::calorInferior, Router.engine);

        Spark.get("/frioInf/:id/:idGuardarropas", guardarropasController::frioInferior, Router.engine);

        Spark.get("/nadaInf/:id/:idGuardarropas", guardarropasController::nadaInferior, Router.engine);


    }
}

