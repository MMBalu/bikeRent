package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.BikeRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository bikeRepo;

    @Override
    public void add(Bike bike) {
        bikeRepo.save(bike);
    }

    @Override
    public void delete(Bike bike) {
        bikeRepo.delete(bike);
    }

    @Override
    public List<Bike> getAll() {
        return (List<Bike>) bikeRepo.findAll();
    }
}
