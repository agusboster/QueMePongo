package TP.models;

import TP.Guardarropas;
import TP.User.Usuario;
import db.EntityManagerHelper;


import java.util.List;

public class GuardarropasModel extends Model {
    private static GuardarropasModel instance;

    public static GuardarropasModel getInstance() {
        if(instance == null){
            instance = new GuardarropasModel();
        }
        return instance;
    }

    @Override
    public List<Guardarropas> buscarTodos(){
        return EntityManagerHelper.getEntityManager().createQuery("from Guardarropas").getResultList();
    }

    @Override
    public Guardarropas buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Guardarropas.class, id);
    }

    public List<Usuario> buscarTodas(int id){
        return null;
    }


}


