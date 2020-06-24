package org.schwarz.bootcamp.spring.servicelayer.service.impl;

import org.modelmapper.ModelMapper;
import org.schwarz.bootcamp.spring.servicelayer.dao.StoreDAOImpl;
import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;
import org.schwarz.bootcamp.spring.servicelayer.dto.StoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class StoreServiceWithDAO {

    @Autowired
    private StoreDAOImpl storeDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public StoreDTO save(StoreDTO storeDTO) {
        if (storeDTO.getName().length() < 3) {
            return null;
        }
        Store store = this.convertToEntity(storeDTO);
        store.setCreationTime(Instant.now());
        store.setLastUpdateTime(Instant.now());
        store = this.storeDAO.save(store);
        return this.convertToDTO(store);
    }

    public StoreDTO getStoreByDirector(String director) {
        return this.convertToDTO(storeDAO.findByDirector(director));
    }

    private StoreDTO convertToDTO(Store store) {
        StoreDTO storeDTO = this.modelMapper.map(store, StoreDTO.class);
        // place here if some logic needed.
        return storeDTO;
    }

    private Store convertToEntity(StoreDTO storeDTO) {
        Store store = this.modelMapper.map(storeDTO, Store.class);
        // place here if some logic needed.
        return store;
    }

}
