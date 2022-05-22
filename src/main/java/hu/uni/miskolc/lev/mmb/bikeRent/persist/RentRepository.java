package hu.uni.miskolc.lev.mmb.bikeRent.persist;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    List<Rent> findAllByCloseTimeIsNull();

    @Override
    void deleteById(Long aLong);
}