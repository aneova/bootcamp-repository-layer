package org.schwarz.bootcamp.spring.servicelayer.repository;

import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    Store findByDirector(String director);

    Integer countByNumberOfEmployeesGreaterThan(Integer employees);

    List<Store> getAllBySquareLessThan(Double maxSquare);

    Store findByStoreNumAndNumberOfEmployeesGreaterThan(String storeNum, Integer employees);

    List<Store> findAllByNumberOfEmployeesGreaterThan(Integer employees, Pageable pageable);

    @Query("select sum(s.numberOfEmployees) from Store s")
    Integer getSumOfEmployees();

    @Query("select s from Store s where s.director LIKE '%an'")
    List<Store> getCustomersBySomeCustomQuery();

}
