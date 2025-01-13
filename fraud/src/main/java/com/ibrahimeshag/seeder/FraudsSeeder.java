package com.ibrahimeshag.seeder;

import com.ibrahimeshag.model.FraudCheckHistory;
import com.ibrahimeshag.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class FraudsSeeder implements CommandLineRunner {

    @Autowired
    FraudRepository fraudRepository;

    @Override
    public void run(String... args) throws Exception {

        // saveAll() operation : saveAll() inserts more than one records at a time

        fraudRepository.saveAll(Arrays.asList(
                new FraudCheckHistory("501", "Core Java", "Kathy Sierra", false),
                new FraudCheckHistory("502", "Spring in Action", "Craig Walls", true)
        ));

        System.out.println("All Frauds Data saved into MongoDB");
    }
}