package interfaces;

public interface GenericService<T> {
    T read();
    void update(T obj);
}
