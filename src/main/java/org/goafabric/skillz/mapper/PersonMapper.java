package org.goafabric.skillz.mapper;

import org.goafabric.skillz.persistence.domain.PersonBo;
import org.goafabric.skillz.service.dto.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "lastName", target = "lastName")
    Person map(PersonBo person);

    @Mapping(source = "lastName", target = "lastName")
    PersonBo map(Person person);

    List<Person> map(List<PersonBo> person);
}
