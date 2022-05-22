package hu.uni.miskolc.lev.mmb.bikeRent.controller;

import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Employee;
import hu.uni.miskolc.lev.mmb.bikeRent.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/readall")
    List<Employee> getEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping(value = "/hire", consumes = {"application/json"})
    void hireEmployee(@RequestBody Employee employee){
        employeeService.hireEmployee(employee);
    }

    @DeleteMapping("/fire")
    void fireEmployee(@RequestBody Employee employee){
        employeeService.fireEmployee(employee);
    }
}
