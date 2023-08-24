package guru.springframework.spring6webapp.repository;

import guru.springframework.spring6webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
