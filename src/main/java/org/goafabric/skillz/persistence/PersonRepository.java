package org.goafabric.skillz.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<PersonBo, String> {
    List<PersonBo> findByFirstName(String firstName);
}
