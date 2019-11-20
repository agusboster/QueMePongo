package TP.repos.factories;

import TP.models.CategoriaModel;

import TP.models.EventoModel;

import TP.Config.Config;
import TP.repos.RepositorioEvento;
import TP.repos.daos.DAOMySQL;

public class FactoryRepositorioEvento {
    private static RepositorioEvento repo;

    public static RepositorioEvento get(){
        //if(repo == null){
        boolean useDataBase = Config.useDataBase;
        //   if(useDataBase){
        repo = RepositorioEvento.getInstance(new DAOMySQL(EventoModel.getInstance()));
        // }
        // else{
        //       repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
        //}
        //}
        return repo;
    }
}