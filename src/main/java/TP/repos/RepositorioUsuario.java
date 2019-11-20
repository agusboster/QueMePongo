package TP.repos;

import TP.User.Usuario;
import TP.repos.daos.DAO;

import java.util.List;

public class RepositorioUsuario extends Repositorio {
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioUsuario(dao);
        }
        return instance;
    }

    private RepositorioUsuario(DAO dao){
        this.setDao(dao);
    }

    //le patea la pelota al dao
    public List<Usuario> buscarTodas(int id){
        return this.dao.buscarTodas(id);
    }

    public Usuario buscar(int id){
        return this.dao.buscar(id);
    }
}
