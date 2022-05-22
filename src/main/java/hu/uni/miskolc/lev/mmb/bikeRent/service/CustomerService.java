package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Customer;

import java.util.List;


public interface CustomerService {
    void add(Customer customer);

    void delete(Customer customer);

    List<Customer> getAll();

    List<Customer> getAllLocal();
}
