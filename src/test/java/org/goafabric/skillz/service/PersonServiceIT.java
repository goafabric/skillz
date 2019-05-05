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
import java.util.NoSuchElementException;

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
        final Person person = createNewPerson();
        assertThat(personService.getById(person.getId()))
                .isNotNull();
    }

    @Test
    public void findAll() {
        createNewPerson();
        assertThat(personService.findAll()
                .collectList().block())
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void findByFirstName() {
        createNewPerson();
        assertThat(personService.findByFirstName("Ralf")
                .collectList().block())
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void findByCity() {
        createNewPerson();
        List<Person> persons = personService.findByCity("Springfield")
                .collectList().block();
        log.info(persons.toString());
        assertThat(persons)
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    public void update() {
        final Person person = createNewPerson();
        person.setFirstName("Chief");
        personService.save(person)
                .block();

        assertThat(personService.getById(person.getId()).block())
                .isEqualTo(person);
    }

    @Test
    public void delete() {
        final Person person = createNewPerson();
        personService.delete(person.getId());
        assertThatThrownBy( ()->
                personService.getById(person.getId()))
                .isInstanceOf(NoSuchElementException.class);
    }

    private Person createPerson() {
        return Person.builder()
                .firstName("Ralf").lastName("Wiggum")
                .address(Address.builder()
                        .street("Evergreen Terace 1").city("Springfield")
                        .build())
                .build();
    }
    private Person createNewPerson() {
        return personService.save(createPerson()).block();
    }


}