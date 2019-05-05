package org.goafabric.skillz.service;

import org.goafabric.skillz.service.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    String RESOURCE = "/persons";

    @GetMapping("")
    String welcome();

    @GetMapping("getById/{id}")
    Mono<Person> getById(@PathVariable("id") String id);

    @GetMapping("findAll")
    Flux<Person> findAll();

    @GetMapping("findByFirstName")
    Flux<Person> findByFirstName(@RequestParam String firstName);

    @GetMapping("findByCity")
    Flux<Person> findByCity(@RequestParam String city);

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<Person> save(@RequestBody Person person);

    @DeleteMapping(value = "delete")
    void delete(@RequestBody String id);
}
