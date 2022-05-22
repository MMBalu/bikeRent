package hu.uni.miskolc.lev.mmb.bikeRent.controller;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Customer;
import hu.uni.miskolc.lev.mmb.bikeRent.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/readall")
    List<Customer> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/readlocal")
    List<Customer> getLocalCustomers() {
        return customerService.getAllLocal();
    }

    @PostMapping(value = "/add", consumes = {"application/json"})
    void addCustomer(@RequestBody Customer customer){
        customerService.add(customer);
    }

    @DeleteMapping("/delete")
    void deleteCustomer(@RequestBody Customer customer){
        customerService.delete(customer);
    }
}
