package TP.repos.factories;

import TP.models.GuardarropasModel;
import TP.models.PrendasModel;
import TP.repos.RepositorioGuardarropas;
import TP.Config.Config;
import TP.repos.RepositorioPrendas;
import TP.repos.daos.DAOMySQL;

public class FactoryRepositorioPrendas {
    private static RepositorioPrendas repo;

    public static RepositorioPrendas get(){
        //if(repo == null){
        boolean useDataBase = Config.useDataBase;
        //   if(useDataBase){
        repo = RepositorioPrendas.getInstance(new DAOMySQL(PrendasModel.getInstance()));
        // }
        // else{
        //       repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
        //}
        //}
        return repo;
    }
}