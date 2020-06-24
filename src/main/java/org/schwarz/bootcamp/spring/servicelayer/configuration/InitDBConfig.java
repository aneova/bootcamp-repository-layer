package org.schwarz.bootcamp.spring.servicelayer.configuration;

import org.schwarz.bootcamp.spring.servicelayer.domain.model.Store;
import org.schwarz.bootcamp.spring.servicelayer.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDBConfig {

    @Autowired
    private StoreRepository storeRepository;

    @PostConstruct
    public void initDB() {
        List<Store> stores = new ArrayList<>();
        stores.add(Store.builder().storeNum("KU-SF").name("Kaufland Sofia").numberOfEmployees(123).square(502.10).director("Dimitar").build());
        stores.add(Store.builder().storeNum("KU-KN").name("Kaufland Kyustendil").numberOfEmployees(44).square(231.10).director("Stefan").build());
        stores.add(Store.builder().storeNum("KU-RU").name("Kaufland Ruse").numberOfEmployees(67).square(427.10).director("Georgi").build());
        stores.add(Store.builder().storeNum("KU-LV").name("Kaufland Lovech").numberOfEmployees(55).square(198.10).director("Milan").build());
        stores.add(Store.builder().storeNum("LD-SF").name("Lidl Sofia").numberOfEmployees(111).square(341.10).director("Nikola").build());
        stores.add(Store.builder().storeNum("LD-PK").name("Lidl Pernik").numberOfEmployees(48).square(245.10).director("Asen").build());
        stores.add(Store.builder().storeNum("LD-TR").name("Lidl Troyan").numberOfEmployees(25).square(122.10).director("Kiril").build());
        stores.add(Store.builder().storeNum("LD-NN").name("Lidl Nikade").numberOfEmployees(0).square(0).director("Lubomira").build());
        this.storeRepository.saveAll(stores);
    }

}
