package org.goafabric.skillz.persistence;

import org.goafabric.skillz.persistence.domain.PersonBo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<PersonBo, String> {
    Flux<PersonBo> findByFirstName(String firstName);

    Flux<PersonBo> findByLastNameStartsWithIgnoreCase(String lastName);

    //@Query("SELECT p from PersonBo p JOIN FETCH p.address as address WHERE address.city = :city")
    //@Query("SELECT p from PersonBo p JOIN p.address as address WHERE address.city = :city")
    Flux<PersonBo> findByAddress_City(@Param("city") String city);
}
