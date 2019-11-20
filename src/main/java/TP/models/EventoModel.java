package TP.models;
import TP.Evento;
import db.EntityManagerHelper;

import java.util.List;

public class EventoModel extends Model {
    private static EventoModel instance;

    public static EventoModel getInstance() {
        if(instance == null){
            instance = new EventoModel();
        }
        return instance;
    }

    private EventoModel(){
    }

    @Override
    public List<Evento> buscarTodos() {
        return EntityManagerHelper.getEntityManager().createQuery("from Evento").getResultList();
    }

    @Override
    public List<Evento> buscarTodas(int id) {
        return null;
    }

    @Override
    public Evento buscar(int id) {
        return EntityManagerHelper.getEntityManager().find(Evento.class, id);
    }
}