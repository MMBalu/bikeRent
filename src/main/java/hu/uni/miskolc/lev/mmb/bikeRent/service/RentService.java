package hu.uni.miskolc.lev.mmb.bikeRent.service;


import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.CloserEmployeeNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.RentNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Rent;

import javax.transaction.Transactional;
import java.util.List;


public interface RentService {
    void add(Rent rent);

    void close(Rent rent) throws RentNotFoundException, CloserEmployeeNotFoundException;

    List<Rent> getAll();

    List<Rent> getOpens();


    @Transactional
    void delete(Rent rent);
}
