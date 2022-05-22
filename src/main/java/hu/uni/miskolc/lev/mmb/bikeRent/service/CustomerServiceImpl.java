package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.CustomerRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public void add(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) customerRepo.findAll();
    }

    @Override
    public List<Customer> getAllLocal() {
        return customerRepo.findByCityContaining("Miskolc");
    }
}
