package dao.interfaces;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> find(long id);
    ArrayList<T> findAll();
    void add(T t);
    void update(T t);
    void delete(T t);
}
