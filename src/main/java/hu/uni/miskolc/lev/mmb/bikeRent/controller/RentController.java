package hu.uni.miskolc.lev.mmb.bikeRent.controller;

import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.CloserEmployeeNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.exceptions.RentNotFoundException;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Rent;
import hu.uni.miskolc.lev.mmb.bikeRent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/readall")
    List<Rent> getRents() {
        return rentService.getAll();
    }

    @GetMapping("/readopnes")
    List<Rent> getOpenRents() {
        return rentService.getOpens();
    }

    @PostMapping(value = "/add", consumes = {"application/json"})
    void addRent(@RequestBody Rent rent){
        rentService.add(rent);
    }

    @PostMapping(value = "/close", consumes = {"application/json"})
    void closeRent(@RequestBody Rent rent){
        try {
            rentService.close(rent);
        } catch (RentNotFoundException | CloserEmployeeNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.I_AM_A_TEAPOT, "Foo Not Found", e);
        }
    }


    @DeleteMapping("/delete")
    @Transactional
    void deleteRent(@RequestBody Rent rent){

        rentService.delete(rent);
    }
}
