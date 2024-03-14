package lk.ijse.dao;

import org.hibernate.Session;

import java.util.List;

public interface CrudDao <T, ID>{
    T add(T t, Session session);
    void update(T t, Session session);
    void delete(ID id, Session session);
    T get(ID id, Session session);
    List<T> getAll( Session session);

}
