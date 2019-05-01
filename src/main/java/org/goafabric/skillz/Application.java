package org.goafabric.skillz;

import org.goafabric.skillz.persistence.domain.AddressBo;
import org.goafabric.skillz.persistence.AddressRepository;
import org.goafabric.skillz.persistence.domain.PersonBo;
import org.goafabric.skillz.persistence.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
            DataCreator dataCreator, PersonRepository repository, AddressRepository addressRepository) {
        return (args) -> {
            dataCreator.create(repository, addressRepository);
        };
    }


    @Component
    public class DataCreator {

        @Transactional
        public void create(PersonRepository repository, AddressRepository addressRepository) {
            repository.save(PersonBo.builder()
                    .firstName("Homer").lastName("Simpson")
                    .address(createAddress(addressRepository, "Evergreen Terace 1"))
                    .build());

            repository.save(PersonBo.builder()
                    .firstName("Bart").lastName("Simpson")
                    .address(createAddress(addressRepository, "Everblue Terace 1"))
                    .build());
            repository.save(PersonBo.builder()
                    .firstName("Monty").lastName("Burns")
                    .address(createAddress(addressRepository, "Monty Mansion"))
                    .build());
        }

        private AddressBo createAddress(AddressRepository addressRepository, String street) {
            return addressRepository.save(
                    AddressBo.builder()
                            .street(street).city("Springfield")
                            .build());
        }
    }
}
