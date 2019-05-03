package org.goafabric.skillz;

import org.goafabric.skillz.persistence.AddressRepository;
import org.goafabric.skillz.persistence.PersonRepository;
import org.goafabric.skillz.persistence.domain.AddressBo;
import org.goafabric.skillz.persistence.domain.PersonBo;
import org.goafabric.skillz.persistence.domain.SkillBo;
import org.joda.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

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
            DataCreator dataCreator, PersonRepository repository, AddressRepository addressRepository) {
        return (args) -> {
            dataCreator.create(repository, addressRepository);
        };
    }


    @Component
    public class DataCreator {

        @Transactional
        public void create(PersonRepository repository, AddressRepository addressRepository) {
            if (true) {
                return;
            }
            repository.save(PersonBo.builder()
                    .firstName("Homer").lastName("Simpson")
                    .address(
                            createAddress(addressRepository, "Evergreen Terace 1"))
                    .skills(Arrays.asList(
                        SkillBo.builder().name("java").description("functional").build(),
                        SkillBo.builder().name("go").description("gopher").build()))
                    .build());

            repository.save(PersonBo.builder()
                    .firstName("Bart").lastName("Simpson")
                    .address(
                            createAddress(addressRepository, "Everblue Terace 1"))
                    .skills(Arrays.asList(
                            SkillBo.builder().name("java").description("functional").build(),
                            SkillBo.builder().name("go").description("gopher").build()))
                    .build());

            repository.save(PersonBo.builder()
                    .firstName("Monty").lastName("Burns")
                    .address(
                            createAddress(addressRepository, "Monty Mansion"))
                    .skills(Arrays.asList(
                            SkillBo.builder().name("java").description("functional").build(),
                            SkillBo.builder().name("go").description("gopher").build()))
                    .birthDay(LocalDateTime.now())
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
