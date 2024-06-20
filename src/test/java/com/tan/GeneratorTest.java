package com.tan;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneratorTest {

    @Autowired
    private Generator generator;

    @Autowired
    private GeneratorJyb generatorJyb;

    @Test
    public void generate(){
        generator.generate();
    }

    @Test
    public void generateJyb(){
        generatorJyb.generate();
    }
}
