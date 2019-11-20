package TP.repos;


import TP.Prenda;
import TP.repos.daos.DAO;

import java.util.List;

public class RepositorioPrendas extends Repositorio {
    private static RepositorioPrendas instance;

    public static RepositorioPrendas getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioPrendas(dao);
        }
        return instance;
    }

    private RepositorioPrendas(DAO dao){
        this.setDao(dao);
    }

    //le patea la pelota al dao
    public List<Prenda> buscarTodas(int id){
        return this.dao.buscarTodas(id);
    }

    public Prenda buscar(int id){
        return this.dao.buscar(id);
    }
}
