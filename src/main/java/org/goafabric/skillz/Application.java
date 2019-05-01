package org.goafabric.skillz;

import org.goafabric.skillz.persistence.AddressBo;
import org.goafabric.skillz.persistence.AddressRepository;
import org.goafabric.skillz.persistence.PersonBo;
import org.goafabric.skillz.persistence.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;

/**
 * Created by amautsch on 26.06.2015.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner loadData(
            PersonRepository repository, AddressRepository addressRepository) {
        return (args) -> {

            /*
            repository.save(PersonBo.builder()
                    .firstName("Homer").lastName("Simpson")
                    .address(addressRepository.save(
                            AddressBo.builder()
                                    .street("Evergreen Terace 1").city("Springfield")
                                    .build()))
                    .build());
             */

            repository.save(PersonBo.builder()
                    .firstName("Homer").lastName("Simpson")
                        .address(AddressBo.builder()
                            .street("Evergreen Terace 1").city("Springfield")
                            .build())
                    .build());

            repository.save(PersonBo.builder()
                    .firstName("Bart").lastName("Simpson")
                        .address(AddressBo.builder()
                                .street("Everblue Terace 1").city("Springfield")
                                .build())
                    .build());
            repository.save(PersonBo.builder()
                    .firstName("Monty").lastName("Burns")
                    .address(AddressBo.builder()
                            .street("Monty Mansion").city("Springfield")
                            .build())
                    .build());

        };
    }
}
