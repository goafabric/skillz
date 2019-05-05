package org.goafabric.skillz.logic;

import org.goafabric.skillz.mapper.PersonMapper;
import org.goafabric.skillz.persistence.PersonRepository;
import org.goafabric.skillz.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Person> getById(String id) {
        return personRepository.findById(id)
                .map(personMapper::map);
    }

    public Flux<Person> findAll() {
        return personRepository.findAll()
                    .map(personMapper::map);
    }

    public Flux<Person> findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName)
                .map(personMapper::map);
    }

    public Flux<Person> findByLastName(String lastName) {
        return personRepository.findByLastNameStartsWithIgnoreCase(lastName)
                .map(personMapper::map);
    }

    public Flux<Person> findByCity(String city) {
        return personRepository.findByAddress_City(city)
                .map(personMapper::map);
    }

    public Mono<Person> save(Person person) {
        return personRepository.save(
                personMapper.map(person))
                    .map(personMapper::map);
    }

    public void delete(String id) {
        personRepository.deleteById(id);

    }

}
