package org.goafabric.skillz.logic;

import org.goafabric.skillz.mapper.PersonMapper;
import org.goafabric.skillz.persistence.PersonRepository;
import org.goafabric.skillz.persistence.domain.PersonBo;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PersonLogic {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public String welcome() {
        return "welcome";
    }

    public Person getById(String id) {
        return personMapper.map(
                personRepository.findById(id).get());
    }

    public List<Person> findAll() {
        //List<PersonBo> persons = personRepository.findAll();
        //persons.get(0).getSkills().get(0).getName(); //lazy initalisation example
        return personMapper.map(
                personRepository.findAll());
    }

    public List<Person> findByFirstName(String firstName) {
        return personMapper.map(
                personRepository.findByFirstName(firstName));
    }

    public List<Person> findByLastName(String lastName) {
        return personMapper.map(
                personRepository.findByLastNameStartsWithIgnoreCase(lastName));
    }

    public List<Person> findByCity(String city) {
        //List<PersonBo> persons = personRepository.findByAddress_City(city); //join fetch example
        //persons.get(0).getAddress().getCity();
        return personMapper.map(
                personRepository.findByAddress_City(city));
    }

    public Person save(Person person) {
        return personMapper.map(
                personRepository.save(
                        personMapper.map(person)));
    }

    public void delete(String id) {
        personRepository.deleteById(id);

    }

}
