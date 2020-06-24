package org.schwarz.bootcamp.spring.servicelayer.dao.base;

import java.util.List;

// DAO base interface
public interface BaseDAO<T> {

    T get(int id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void delete(T t);

}
