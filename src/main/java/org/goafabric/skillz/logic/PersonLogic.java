package org.goafabric.skillz.logic;

import org.goafabric.skillz.mapper.PersonMapper;
import org.goafabric.skillz.persistence.PersonRepository;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonLogic {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public Person getById(String id) {
        return personMapper.toDto(
                personRepository.getById(id));
    }

    public List<Person> findAll() {
        return personRepository.findAll()
                .stream().map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public Person findByIsoCode(String firstName) {
        return personMapper.toDto(
                personRepository.findByIsoCode(firstName));
    }


    public Person save(Person person) {
        return personMapper.toDto(
                personRepository.save(
                        personMapper.toBo(person)));
    }


}
