package org.goafabric.skillz.service;

import org.goafabric.skillz.service.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class PersonServiceIT {
    @Autowired
    private PersonService personService;

    @Test
    public void getById() {
        final Person person = personService.save(createPerson());
        assertThat(personService.getById(person.getId()))
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
        assertThat(personService.findByFirstName("Margedff"))
                .isNotNull()
                .isNotEmpty();
    }

    private Person createPerson() {
        return Person.builder()
                .firstName("Marge")
                .lastName("Simpson")
                .build();
    }
}