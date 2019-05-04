package org.goafabric.skillz.persistence;

import org.goafabric.skillz.persistence.domain.AddressBo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<AddressBo, String> {
}
