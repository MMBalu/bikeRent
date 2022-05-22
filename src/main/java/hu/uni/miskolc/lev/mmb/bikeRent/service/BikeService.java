package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Bike;

import java.util.List;


public interface BikeService {
    void add(Bike bike);

    void delete(Bike bike);

    List<Bike> getAll();
}
