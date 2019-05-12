package org.goafabric.skillz.mapper;

import org.goafabric.skillz.persistence.domain.SkillBo;
import org.goafabric.skillz.service.dto.Skill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    List<SkillBo> map(List<Skill> skills);
    List<Skill> mapBos(List<SkillBo> skills);
}
