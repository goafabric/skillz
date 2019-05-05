package org.goafabric.skillz.persistence;

import org.goafabric.skillz.persistence.domain.AddressBo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveMongoRepository<AddressBo, String> {
}
