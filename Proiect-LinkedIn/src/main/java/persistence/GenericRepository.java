package persistence;

import java.util.ArrayList;

public interface GenericRepository<T> {
    public void add(T obj);
    public T get(int id);
    public ArrayList<T> getAll();
    public void update(T obj);
    public void delete(T obj);
}
