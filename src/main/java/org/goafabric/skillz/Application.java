package org.goafabric.skillz;

import org.goafabric.skillz.logic.PersonLogic;
import org.goafabric.skillz.service.dto.Address;
import org.goafabric.skillz.service.dto.Person;
import org.goafabric.skillz.service.dto.Skill;
import org.joda.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

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
                    .skills(createSkills())
                    .build());

            personLogic.save(Person.builder()
                    .firstName("Bart").lastName("Simpson")
                    .address(createAddress("Everblue Terace 1"))
                    .skills(createSkills())
                    .build());

            personLogic.save(Person.builder()
                    .firstName("Monty").lastName("Burns")
                    .address(createAddress("Monty Mansion"))
                    .birthDay(LocalDateTime.now())
                    .skills(createSkills())
                    .build());
        };

    }

    private Address createAddress(String street) {
        return Address.builder()
                .street(street).city("Springfield")
                .build();
    }

    private List<Skill> createSkills() {
        return Arrays.asList(
                Skill.builder()
                        .name("java")
                        .description("functional")
                        .build(),
                Skill.builder()
                        .name("go")
                        .description("gopher")
                        .build());
    }


}
