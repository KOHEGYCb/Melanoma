package by.bntu.dmitry.dao;

import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public interface AbstractDAO<T> {
    
    public ArrayList<T> findAll();
    public T getEntityById(int id);
    public void createEntity(T t);
    public void updateEntity(T t);
    public void deleteEntity(T t);
    
    
}
