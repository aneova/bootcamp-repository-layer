package org.schwarz.bootcamp.spring.servicelayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer numberOfEmployees;
    private String storeNum;
    private double square;
    private Instant creationTime;
    private Instant lastUpdateTime;
    private String director;

}
