package org.goafabric.skillz.mapper;

import org.goafabric.skillz.persistence.PersonBo;
import org.goafabric.skillz.service.dto.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "familyName", target = "lastName")
    Person toDto(PersonBo person);

    @Mapping(source = "lastName", target = "familyName")
    PersonBo toBo(Person person);
}
