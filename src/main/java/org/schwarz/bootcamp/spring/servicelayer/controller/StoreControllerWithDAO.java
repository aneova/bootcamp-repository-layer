package org.schwarz.bootcamp.spring.servicelayer.controller;

import org.schwarz.bootcamp.spring.servicelayer.dto.StoreDTO;
import org.schwarz.bootcamp.spring.servicelayer.service.impl.StoreServiceWithDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/storesDAO")
public class StoreControllerWithDAO {

    @Autowired
    private StoreServiceWithDAO storeService;

    @PostMapping
    public ResponseEntity<StoreDTO> saveStore(@RequestBody StoreDTO storeDTO) {
        storeDTO = storeService.save(storeDTO);
        return ResponseEntity.ok(storeDTO);
    }

    @GetMapping("/director")
    public ResponseEntity<StoreDTO> getStoreByDirector(@RequestParam String director) {
        StoreDTO storeDTO = storeService.getStoreByDirector(director);
        return ResponseEntity.ok(storeDTO);
    }


}
