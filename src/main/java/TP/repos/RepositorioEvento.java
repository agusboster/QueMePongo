package TP.repos;
import TP.Categoria;
import TP.Evento;
import TP.repos.Repositorio;
import TP.repos.daos.DAO;

import java.util.List;

public class RepositorioEvento extends Repositorio {
    private static RepositorioEvento instance;

    public static RepositorioEvento getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioEvento(dao);
        }
        return instance;
    }

    private RepositorioEvento(DAO dao){
        this.setDao(dao);
    }

    //le patea la pelota al dao
    public List<Evento> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Evento buscar(int id){
        return this.dao.buscar(id);
    }
}