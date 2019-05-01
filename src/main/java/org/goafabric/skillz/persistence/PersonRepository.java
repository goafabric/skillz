package org.goafabric.skillz.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonBo, String> {
    List<PersonBo> findByFirstName(String firstName);

    @Query("SELECT p from PersonBo p JOIN p.address as address WHERE address.city = :city")
    List<PersonBo> findByCity(@Param("city") String city);
}
