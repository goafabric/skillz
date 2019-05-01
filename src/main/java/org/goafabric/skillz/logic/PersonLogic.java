package org.goafabric.skillz.logic;

import org.goafabric.skillz.mapper.PersonMapper;
import org.goafabric.skillz.persistence.PersonRepository;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonLogic {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public String welcome() {
        return "welcome";
    }

    public Person getById(String id) {
        return personMapper.toDto(
                personRepository.getOne(id));
    }

    public List<Person> findAll() {
        return personMapper.toDtos(
                personRepository.findAll());
    }

    public List<Person> findByFirstName(String firstName) {
        return personMapper.toDtos(
                personRepository.findByFirstName(firstName));
    }

    public List<Person> findByCity(String city) {
        return personMapper.toDtos(
                personRepository.findByCity(city));
    }

    public Person save(Person person) {
        return personMapper.toDto(
                personRepository.save(
                        personMapper.toBo(person)));
    }


}
