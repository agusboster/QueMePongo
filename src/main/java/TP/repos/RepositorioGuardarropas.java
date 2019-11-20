package TP.repos;

import TP.Guardarropas;
import TP.repos.daos.DAO;


import java.util.List;

public class RepositorioGuardarropas extends Repositorio {
    private static RepositorioGuardarropas instance;

    public static RepositorioGuardarropas getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioGuardarropas(dao);
        }
        return instance;
    }

    private RepositorioGuardarropas(DAO dao){
        this.setDao(dao);
    }

    public List<Guardarropas> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Guardarropas buscar(int id){
        return this.dao.buscar(id);
    }
}
