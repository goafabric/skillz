package org.goafabric.skillz.service;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.skillz.service.dto.Address;
import org.goafabric.skillz.service.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Slf4j
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
        assertThat(personService.findByFirstName("Ralf"))
                .isNotNull()
                .isNotEmpty();
    }

    /*
    @Test
    public void findByCity() {
        personService.save(createPerson());
        List<Person> persons = personService.findByCity("Springfield");
        log.info(persons.toString());
        assertThat(persons)
                .isNotNull()
                .isNotEmpty();
    }
     */

    @Test
    public void update() {
        final Person person = personService.save(createPerson());
        person.setFirstName("Chief");
        personService.save(person);

        assertThat(personService.getById(person.getId()))
                .isEqualTo(person);
    }

    @Test
    public void delete() {
        final Person person = personService.save(createPerson());
        personService.delete(person.getId());
        assertThatThrownBy( ()->
                personService.getById(person.getId()))
                .isInstanceOf(Exception.class);

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