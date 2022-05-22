package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.CloserEmployeeNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.RentNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.RentRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepo;

    @Override
    public void add(Rent rent) {
        rentRepo.save(rent);
    }

    @Override
    public void close(Rent rent) throws RentNotFoundException, CloserEmployeeNotFoundException {
        Optional<Rent> toClose = rentRepo.findById(rent.getId());

        if(toClose.isEmpty()) throw new RentNotFoundException();

        if(rent.getCloseTime()==null) rent.setCloseTime(LocalDateTime.now());

        if(rent.getCloserEmployee() == null) throw new CloserEmployeeNotFoundException();

        toClose.get().setCloseTime(rent.getCloseTime());
        toClose.get().setCloserEmployee(rent.getCloserEmployee());

        rentRepo.save(toClose.get());
    }

    @Override
    public List<Rent> getAll() {
        return (List<Rent>) rentRepo.findAll();
    }

    @Override
    public List<Rent> getOpens() {
        return rentRepo.findAllByCloseTimeIsNull();
    }

    @Override
    @Transactional
    public void delete(Rent rent) {
        //Optional<Rent> fromRepo = rentRepo.findById(rent.getId());

        rentRepo.deleteById(rent.getId());
    }
}
