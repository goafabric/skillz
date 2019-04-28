package org.goafabric.skillz.persistence;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonRepository {
    public PersonBo getById(String id) {
        return
                createPerson("one");
    }

    public List<PersonBo> findAll() {
        return
                Arrays.asList(
                        createPerson("one"),
                        createPerson("two"),
                        createPerson("three"));
    }

    public PersonBo findByIsoCode(String firstName) {
        return
                createPerson("one");
    }


    public PersonBo save(PersonBo person) {
        return
                createPerson("one");
    }

    private PersonBo createPerson(String lastName) {
        return PersonBo.builder()
                .firstName("john")
                .lastName(lastName)
                .build();
    }

    private static void spin(int milliseconds) {
        long sleepTime = milliseconds*1000000L; // convert to nanoseconds
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {}
    }

}
