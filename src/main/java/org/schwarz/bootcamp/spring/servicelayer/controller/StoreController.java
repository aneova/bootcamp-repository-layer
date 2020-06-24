package org.schwarz.bootcamp.spring.servicelayer.controller;

import org.schwarz.bootcamp.spring.servicelayer.dto.StoreDTO;
import org.schwarz.bootcamp.spring.servicelayer.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getStores() {
        List<StoreDTO> storeDTOS = storeService.getAll();
        return ResponseEntity.ok(storeDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable int id) {
        StoreDTO storeDTO = storeService.get(id);
        return ResponseEntity.ok(storeDTO);
    }

    @PostMapping
    public ResponseEntity<StoreDTO> saveStore(@RequestBody StoreDTO storeDTO) {
        storeDTO = storeService.save(storeDTO);
        return ResponseEntity.ok(storeDTO);
    }

    @PutMapping
    public ResponseEntity<StoreDTO> updateStore(@RequestBody StoreDTO storeDTO) {
        storeDTO = storeService.update(storeDTO);
        return ResponseEntity.ok(storeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStore(@PathVariable int id) {
        storeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/small")
    public ResponseEntity<List<StoreDTO>> getSmallStores() {
        List<StoreDTO> storeDTOS = storeService.getSmallStores();
        return ResponseEntity.ok(storeDTOS);
    }

    @GetMapping("/customQuery")
    public ResponseEntity<List<StoreDTO>> getCustomQuery() {
        return ResponseEntity.ok(storeService.getCustomQuery());
    }

    @GetMapping("/sum")
    public ResponseEntity<Integer> getSumOfAllEmployees() {
        return ResponseEntity.ok(storeService.sumOfAllEmployees());
    }

    @GetMapping("/director/{director}")
    public ResponseEntity<StoreDTO> getByDirector(@PathVariable String director) {
        return ResponseEntity.ok(storeService.findByDirector(director));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> greaterThanNumberOfEmployees(@RequestParam int employees) {
        return ResponseEntity.ok(storeService.countByNumberOfEmployeesGreaterThan(employees));
    }

    @GetMapping("/storeNumAndSquare")
    public ResponseEntity<StoreDTO> findByStoreNumAndNumberOfEmployeesGreaterThan(@RequestParam String storeNum, @RequestParam Integer employees) {
        return ResponseEntity.ok(storeService.findByStoreNumAndNumberOfEmployeesGreaterThan(storeNum, employees));
    }

    @GetMapping("/limits")
    public ResponseEntity<List<StoreDTO>> findAllByNumberOfEmployeesGreaterThan(@RequestParam Integer employees, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(storeService.findAllByNumberOfEmployeesGreaterThan(employees, page, size));
    }
}
