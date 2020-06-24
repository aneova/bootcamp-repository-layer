package org.schwarz.bootcamp.spring.servicelayer.service;

import org.schwarz.bootcamp.spring.servicelayer.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO get(int id);

    List<StoreDTO> getAll();

    StoreDTO save(StoreDTO StoreDTO);

    StoreDTO update(StoreDTO StoreDTO);

    void delete(int id);

    List<StoreDTO> getSmallStores();

    List<StoreDTO> getCustomQuery();

    StoreDTO findByDirector(String director);

    Integer countByNumberOfEmployeesGreaterThan(Integer minEmployees);

    Integer sumOfAllEmployees();

    StoreDTO findByStoreNumAndNumberOfEmployeesGreaterThan(String storeNum, Integer employees);

    //limit
    List<StoreDTO> findAllByNumberOfEmployeesGreaterThan(Integer employees, Integer page, Integer size);


}
