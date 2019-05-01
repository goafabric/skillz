package org.goafabric.skillz.mapper;

import org.goafabric.skillz.persistence.PersonBo;
import org.goafabric.skillz.service.dto.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "lastName", target = "lastName")
    Person toDto(PersonBo person);

    @Mapping(source = "lastName", target = "lastName")
    PersonBo toBo(Person person);

    List<Person> toDtos(List<PersonBo> person);
}
