package org.goafabric.skillz;

import org.goafabric.skillz.logic.PersonLogic;
import org.goafabric.skillz.service.dto.Address;
import org.goafabric.skillz.service.dto.Person;
import org.joda.time.LocalDateTime;
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
    public CommandLineRunner loadData(
            PersonLogic personLogic) {
        return (args) -> {
            personLogic.save(Person.builder()
                    .firstName("Homer").lastName("Simpson")
                    .address(createAddress("Evergreen Terace 1"))
                    .build()).block();

            personLogic.save(Person.builder()
                    .firstName("Bart").lastName("Simpson")
                    .address(createAddress("Everblue Terace 1"))
                    .build()).block();

            personLogic.save(Person.builder()
                    .firstName("Monty").lastName("Burns")
                    .address(createAddress("Monty Mansion"))
                    .birthDay(LocalDateTime.now())
                    .build()).block();
        };

    }

    private Address createAddress(String street) {
        return Address.builder()
                .street(street).city("Springfield")
                .build();
    }

}
