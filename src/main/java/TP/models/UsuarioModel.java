package TP.models;

import TP.Guardarropas;
import TP.Prenda;
import TP.User.Usuario;
import db.EntityManagerHelper;


import javax.persistence.Query;
import java.util.List;

public class UsuarioModel extends Model {
    private static UsuarioModel instance;

    public static UsuarioModel getInstance() {
        if(instance == null){
            instance = new UsuarioModel();
        }
        return instance;
    }

    @Override
    public List<Usuario> buscarTodas(int id) {
        return null;
    }


    @Override
    public List<Usuario> buscarTodos(){
        return null;
    }

    @Override
    public Usuario buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Usuario.class, id);
    }
}
