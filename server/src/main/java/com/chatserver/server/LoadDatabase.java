package com.chatserver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Account("Bilbo Baggins", "burglar","bogollo123","12345")));
            log.info("Preloading " + repository.save(new Account("Frodo Baggins", "thief","frogollo98","9870")));
        };
    }
}