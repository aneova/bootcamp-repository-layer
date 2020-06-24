package org.schwarz.bootcamp.spring.servicelayer.dao;

import org.schwarz.bootcamp.spring.servicelayer.dao.base.BaseDAOImpl;
import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;
import org.springframework.stereotype.Component;

import javax.persistence.Query;

@Component
public class StoreDAOImpl extends BaseDAOImpl<Store> implements StoreDAO {

    //additional methods could be presented here

    @Override
    public Store findByDirector(String director) {
        Query q = entityManager.createQuery(
                "SELECT e FROM " + entityClass.getName() + " e WHERE e.director=:director"
        );
        q.setParameter("director", director);
        q.setMaxResults(1);
        return (Store) q.getSingleResult();
    }

}
