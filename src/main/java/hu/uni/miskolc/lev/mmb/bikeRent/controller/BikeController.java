package hu.uni.miskolc.lev.mmb.bikeRent.controller;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Bike;
import hu.uni.miskolc.lev.mmb.bikeRent.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;


    @GetMapping("/readall")
    List<Bike> getEmployees() {
        return bikeService.getAll();
    }

    @PostMapping(value = "/add", consumes = {"application/json"})
    void hireEmployee(@RequestBody Bike bike){
        bikeService.add(bike);
    }

    @DeleteMapping("/delete")
    void fireEmployee(@RequestBody Bike bike){
        bikeService.delete(bike);
    }
}
