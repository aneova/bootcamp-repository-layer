package org.schwarz.bootcamp.spring.servicelayer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer numberOfEmployees;
    private String storeNum;
    private double square;
    @Builder.Default
    private Instant creationTime = Instant.now();
    @UpdateTimestamp
    private Instant lastUpdateTime;
    private String director;

    public Store() {
        creationTime = Instant.now();
    }

}
