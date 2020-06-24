package org.schwarz.bootcamp.spring.servicelayer.utils;

import org.springframework.stereotype.Component;

@Component
public class RandomIdGenerator {

    public int generateRandomId(int max, int min) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
