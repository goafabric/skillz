package org.goafabric.skillz.service;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.skillz.logic.PersonLogic;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/persons", produces = "application/json")
@RestController
@Slf4j
public class PersonServiceReactiveBean {
    @Autowired
    private PersonLogic personLogic;

    @GetMapping("")
    public String welcome () {
        return "welcome";
    }

    @GetMapping("getById/{id}")
    public Person getById(@PathVariable("id") String id) {
        return personLogic.getById(id);
    }

    @GetMapping("findAll")
    public List<Person> findAll() {
        return personLogic.findAll();
    }

    @GetMapping("findByFirstName")
    public Person findByIsoCode(@RequestParam("firstName") String firstName) {
        return personLogic.findByIsoCode(firstName);
    }


    @PostMapping(value = "save", consumes = "application/json")
    public Person save(@RequestBody Person person) {
        return personLogic.save(person);
    }

}
