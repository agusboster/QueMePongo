package TP.repos.factories;

import TP.models.UsuarioModel;
import TP.Config.Config;
import TP.repos.RepositorioUsuario;
import TP.repos.daos.DAOMySQL;

public class FactoryRepositorioUsuario {
    private static RepositorioUsuario repo;

    public static RepositorioUsuario get(){
        //if(repo == null){
        boolean useDataBase = Config.useDataBase;
        //   if(useDataBase){
        repo = RepositorioUsuario.getInstance(new DAOMySQL(UsuarioModel.getInstance()));
        // }
        // else{
        //       repo = RepositorioGuardarropas.getInstance(new DAOMemoria(DataUsuario.getList()));
        //}
        //}
        return repo;
    }
}