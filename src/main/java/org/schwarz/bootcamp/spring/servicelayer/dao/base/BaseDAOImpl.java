package org.schwarz.bootcamp.spring.servicelayer.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDAOImpl<E> implements BaseDAO<E> {

    protected Class entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public BaseDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public E get(int id) {
        return (E) entityManager.find(this.entityClass, id);
    }

    @Override
    public List<E> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM E e");
        return query.getResultList();
    }

    @Override
    public E save(E e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public E update(E e) {
        entityManager.merge(e);
        return e;
    }

    @Override
    public void delete(E e) {
        entityManager.remove(e);
    }

//    private void executeInsideTransaction(Consumer<EntityManager> action) {
//        EntityTransaction tx = entityManager.getTransaction();
//        try {
//            tx.begin();
//            action.accept(entityManager);
//            tx.commit();
//        } catch (RuntimeException e) {
//            tx.rollback();
//            throw e;
//        }
//    }
}
