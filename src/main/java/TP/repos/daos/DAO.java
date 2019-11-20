package TP.repos.daos;
import TP.Categoria;

import java.util.List;
public interface DAO {
    public <T> List<T> buscarTodos();
    public <T> T buscar(int id);
    public <T> List<T> buscarTodas(int id);
    public void agregar(Object unObjeto);
    public void modificar(Object unObjeto);
    public void eliminar(Object unObjeto);
}


