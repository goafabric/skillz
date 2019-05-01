package org.goafabric.skillz.service;

import org.goafabric.skillz.service.dto.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonService {
    static final String RESOURCE = "/persons";

    @GetMapping("")
    String welcome();

    @GetMapping("getById/{id}")
    Person getById(@PathVariable("id") String id);

    @GetMapping("findAll")
    List<Person> findAll();

    @GetMapping("findByFirstName")
    List<Person> findByFirstName(@RequestParam String firstName);

    @GetMapping("findByCity")
    List<Person> findByCity(@RequestParam String city);

    @PostMapping(value = "save", consumes = "application/json")
    Person save(@RequestBody Person person);
}
