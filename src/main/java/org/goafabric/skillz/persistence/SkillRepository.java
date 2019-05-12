package org.goafabric.skillz.persistence;

import org.goafabric.skillz.persistence.domain.SkillBo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<SkillBo, String> {
}
