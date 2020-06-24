package org.schwarz.bootcamp.spring.servicelayer.dao;

import org.schwarz.bootcamp.spring.servicelayer.dao.base.BaseDAO;
import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;

public interface StoreDAO extends BaseDAO<Store> {

    Store findByDirector(String director);

}
