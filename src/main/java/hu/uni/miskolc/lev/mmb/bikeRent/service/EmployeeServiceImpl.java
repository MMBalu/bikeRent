package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.EmployeeRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public void hireEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void fireEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepo.findAll();
    }
}
