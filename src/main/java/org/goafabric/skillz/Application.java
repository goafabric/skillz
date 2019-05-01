package org.goafabric.skillz;

import org.goafabric.skillz.persistence.PersonBo;
import org.goafabric.skillz.persistence.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by amautsch on 26.06.2015.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(PersonRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(PersonBo.builder()
                    .firstName("Homer").lastName("Simpson").build());
            repository.save(PersonBo.builder()
                    .firstName("Bart").lastName("Simpson").build());
            repository.save(PersonBo.builder()
                    .firstName("Monty").lastName("Burns").build());
        };
    }
}
