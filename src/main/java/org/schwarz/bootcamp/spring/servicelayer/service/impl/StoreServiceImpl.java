package org.schwarz.bootcamp.spring.servicelayer.service.impl;

import org.modelmapper.ModelMapper;
import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;
import org.schwarz.bootcamp.spring.servicelayer.dto.StoreDTO;
import org.schwarz.bootcamp.spring.servicelayer.repository.StoreRepository;
import org.schwarz.bootcamp.spring.servicelayer.service.StoreService;
import org.schwarz.bootcamp.spring.servicelayer.service.validation.exception.StoreDataInvalidException;
import org.schwarz.bootcamp.spring.servicelayer.utils.RandomIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private RandomIdGenerator randomIdGenerator;

    @Override
    public StoreDTO get(int id) {
        return this.convertToDTO(this.storeRepository.getOne(id));
    }

    @Override
    public List<StoreDTO> getAll() {
        return this.storeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        if (storeDTO.getName().length() < 3) {
            return null;
        }
        if (!this.validateStore(storeDTO)) {
            throw new StoreDataInvalidException();
        }
        Store store = this.convertToEntity(storeDTO);
        store.setCreationTime(Instant.now());
        store.setLastUpdateTime(Instant.now());
        store = this.storeRepository.save(store);
        return this.convertToDTO(store);
    }

    @Override
    public StoreDTO update(StoreDTO storeDTO) {
        Store store = this.convertToEntity(storeDTO);
        store.setLastUpdateTime(Instant.now());
        store = this.storeRepository.save(store);
        return this.convertToDTO(store);
    }

    @Override
    public void delete(int id) {
        this.storeRepository.delete(this.storeRepository.getOne(id));
    }

    // Stores with square lower than 250
    @Override
    public List<StoreDTO> getSmallStores() {
        return this.storeRepository.getAllBySquareLessThan(250.0).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<StoreDTO> getCustomQuery() {
        return this.storeRepository.getCustomersBySomeCustomQuery().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public StoreDTO findByDirector(String director) {
        return this.convertToDTO(this.storeRepository.findByDirector(director));
    }

    @Override
    public Integer countByNumberOfEmployeesGreaterThan(Integer minEmployees) {
        return this.storeRepository.countByNumberOfEmployeesGreaterThan(minEmployees);
    }

    @Override
    public Integer sumOfAllEmployees() {
        return this.storeRepository.getSumOfEmployees();
    }

    @Override
    public StoreDTO findByStoreNumAndNumberOfEmployeesGreaterThan(String storeNum, Integer employees) {
        return this.convertToDTO(this.storeRepository.findByStoreNumAndNumberOfEmployeesGreaterThan(storeNum, employees));
    }

    @Override
    public List<StoreDTO> findAllByNumberOfEmployeesGreaterThan(Integer employees, Integer page, Integer size) {
        return this.storeRepository.findAllByNumberOfEmployeesGreaterThan(employees, PageRequest.of(page, size, Sort.by("numberOfEmployees").descending())).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private boolean validateStore(StoreDTO storeDTO) {
        return isSquarePositive(storeDTO.getSquare()) && isStoreNumCorrect(storeDTO.getStoreNum());
    }

    private boolean isStoreNumCorrect(String storeNum) {
        return storeNum.length() == 5 || storeNum.length() == 6;
    }

    private boolean isSquarePositive(double square) {
        return square > 0;
    }

    //checking if the ID exists
    private int generateIdAndCheckIfExists() {
        int id = this.randomIdGenerator.generateRandomId(19, 1);
        System.out.println("Generated id: " + id);
//        if (this.storeDAO.get(id) == null)
        if (this.storeRepository.getOne(id) == null)
            return id;
        return generateIdAndCheckIfExists();
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
