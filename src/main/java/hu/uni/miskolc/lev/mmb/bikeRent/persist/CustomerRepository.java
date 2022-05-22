package hu.uni.miskolc.lev.mmb.bikeRent.persist;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByCityContaining(@NonNull String city);

}