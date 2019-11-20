package TP.repos.factories;

import TP.Guardarropas;
import TP.models.CategoriaModel;
import TP.models.GuardarropasModel;
import TP.repos.RepositorioCategoria;
import TP.repos.RepositorioGuardarropas;
import TP.Config.Config;
import TP.repos.daos.DAOMySQL;

public class FactoryRepositorioCategoria {
    private static RepositorioCategoria repo;

    public static RepositorioCategoria get(){
        //if(repo == null){
        boolean useDataBase = Config.useDataBase;
        //   if(useDataBase){
        repo = RepositorioCategoria.getInstance(new DAOMySQL(CategoriaModel.getInstance()));
        // }
        // else{
        //       repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
        //}
        //}
        return repo;
    }
}