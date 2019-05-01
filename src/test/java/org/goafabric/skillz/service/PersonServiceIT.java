package org.goafabric.skillz.service;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.skillz.service.dto.Address;
import org.goafabric.skillz.service.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class PersonServiceIT {
    @Autowired
    private PersonService personService;

    @Test
    public void getById() {
        final Person person = personService.save(createPerson());
        final Person person2 = personService.getById(person.getId());
        assertThat(person2)
                .isNotNull();
    }

    @Test
    public void findAll() {
        personService.save(createPerson());
        assertThat(personService.findAll())
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void findByFirstName() {
        personService.save(createPerson());
        assertThat(personService.findByFirstName("Ralf"))
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void findByCity() {
        personService.save(createPerson());
        List<Person> persons = personService.findByCity("Springfield");
        log.info(persons.toString());
        assertThat(persons)
                .isNotNull()
                .isNotEmpty();
    }

    private Person createPerson() {
        return Person.builder()
                .firstName("Ralf").lastName("Wiggum")
                .address(Address.builder()
                        .street("Evergreen Terace 1").city("Springfield")
                        .build())
                .build();
    }
}