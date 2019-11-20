package TP.models;

import TP.Guardarropas;
import TP.Prenda;
import TP.User.Usuario;
import db.EntityManagerHelper;


import javax.persistence.Query;
import java.util.List;

public class PrendasModel extends Model {
    private static PrendasModel instance;

    public static PrendasModel getInstance() {
        if(instance == null){
            instance = new PrendasModel();
        }
        return instance;
    }

    @Override
    public List<Prenda> buscarTodas(int id) {

        Guardarropas guardarropas = EntityManagerHelper.getEntityManager().find(Guardarropas.class, id);
        List<Prenda> prendas = guardarropas.getPrendas();

        return prendas;
    }


    @Override
    public List<Prenda> buscarTodos(){
        return null;
    }

    @Override
    public Prenda buscar(int id){
       return null;
    }


}
