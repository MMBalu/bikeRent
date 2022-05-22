package hu.uni.miskolc.lev.mmb.bikeRent.persist;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {

}