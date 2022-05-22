package hu.uni.miskolc.lev.mmb.bikeRent.persist;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}