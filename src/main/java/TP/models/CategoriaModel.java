package TP.models;

import TP.Categoria;
import db.EntityManagerHelper;

import java.util.List;

public class CategoriaModel extends Model {
    private static CategoriaModel instance;

    public static CategoriaModel getInstance() {
        if(instance == null){
            instance = new CategoriaModel();
        }
        return instance;
    }

    private CategoriaModel(){
    }

    @Override
    public List<Categoria> buscarTodos() {
        return EntityManagerHelper.getEntityManager().createQuery("from Categoria").getResultList();
    }

    @Override
    public List<Categoria> buscarTodas(int id) {
        return null;
    }

    @Override
    public Categoria buscar(int id) {
        return EntityManagerHelper.getEntityManager().find(Categoria.class, id);
    }
}
