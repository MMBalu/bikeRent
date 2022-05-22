package hu.uni.miskolc.lev.mmb.bikeRent.service;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void hireEmployee(Employee employee);

    void fireEmployee(Employee employee);

    List<Employee> getAllEmployee();
}
