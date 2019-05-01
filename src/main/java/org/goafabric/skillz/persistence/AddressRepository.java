package org.goafabric.skillz.persistence;

import org.goafabric.skillz.persistence.domain.AddressBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressBo, String> {
}
