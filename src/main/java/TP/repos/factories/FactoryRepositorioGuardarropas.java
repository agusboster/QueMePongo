package TP.repos.factories;

import TP.Guardarropas;
import TP.models.GuardarropasModel;
import TP.repos.RepositorioGuardarropas;
import TP.Config.Config;
import TP.repos.daos.DAOMySQL;

public class FactoryRepositorioGuardarropas {
    private static RepositorioGuardarropas repo;

    public static RepositorioGuardarropas get(){
        //if(repo == null){
        boolean useDataBase = Config.useDataBase;
        //   if(useDataBase){
        repo = RepositorioGuardarropas.getInstance(new DAOMySQL(GuardarropasModel.getInstance()));
        // }
        // else{
        //       repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
        //}
        //}
        return repo;
    }
}