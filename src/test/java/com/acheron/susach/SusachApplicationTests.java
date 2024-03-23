package com.acheron.susach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

class SusachApplicationTests {
    @Autowired
    private EntityRepo entityRepo;

    @Test
    void userTest() {

    }

}
