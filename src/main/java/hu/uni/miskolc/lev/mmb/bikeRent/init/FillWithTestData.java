package hu.uni.miskolc.lev.mmb.bikeRent.init;


import hu.uni.miskolc.lev.mmb.bikeRent.persist.BikeRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.CustomerRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.EmployeeRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.RentRepository;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Bike;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Customer;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Employee;
import hu.uni.miskolc.lev.mmb.bikeRent.persist.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class FillWithTestData {

    private final boolean autoFillEnabled = true;

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final BikeRepository bikeRepository;
    private final RentRepository rentRepository;

    private final List<Employee> employees = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Bike> bikes = new ArrayList<>();
    private final List<Rent> rents = new ArrayList<>();

    @Autowired
    FillWithTestData(
            EmployeeRepository employeeRepository,
            CustomerRepository customerRepository,
            BikeRepository bikeRepository,
            RentRepository rentRepository
    ){
        this.employeeRepository = employeeRepository;
        this.customerRepository = customerRepository;
        this.bikeRepository = bikeRepository;
        this.rentRepository = rentRepository;

        if(autoFillEnabled){
            LoadEmployees();
            LoadCustomers();
            LoadBikes();
            LoadRents();
        }

    }



    private void LoadEmployees() {
        employees.add(new Employee());
        employees.get(employees.size() - 1).setName("Béla");
        employees.get(employees.size() - 1).setSalary(159990);
        employeeRepository.save(employees.get(employees.size() - 1));

        employees.add(new Employee());
        employees.get(employees.size() - 1).setName("Sándor");
        employees.get(employees.size() - 1).setSalary(180867);
        employeeRepository.save(employees.get(employees.size() - 1));
    }

    private void LoadCustomers() {
        customers.add(new Customer());

        customers.get(customers.size() - 1).setName("Kis Pista");
        customers.get(customers.size() - 1).setCity("Miskolc");
        customers.get(customers.size() - 1).setStreet("Csermőkei");
        customers.get(customers.size() - 1).setHouseNumber("12/A");
        customerRepository.save(customers.get(customers.size() - 1));

        customers.add(new Customer());
        customers.get(customers.size() - 1).setName("Nagy Ádám");
        customers.get(customers.size() - 1).setCity("Makkoshogyka");
        customers.get(customers.size() - 1).setStreet("Fő");
        customers.get(customers.size() - 1).setHouseNumber("5");
        customerRepository.save(customers.get(customers.size() - 1));

    }

    private void LoadBikes() {
        bikes.add(new Bike());
        bikes.get(bikes.size() - 1).setName("Caprine MountainBike");
        bikes.get(bikes.size() - 1).setFrameSize(20);
        bikes.get(bikes.size() - 1).setDailyFee(8990);
        bikeRepository.save(bikes.get(bikes.size() - 1));

        bikes.add(new Bike());
        bikes.get(bikes.size() - 1).setName("Corelli Rave Up Gyermek kerékpár");
        bikes.get(bikes.size() - 1).setFrameSize(13);
        bikes.get(bikes.size() - 1).setDailyFee(4490);
        bikeRepository.save(bikes.get(bikes.size() - 1));
    }

    private void LoadRents(){
        rents.add(new Rent());
        Set<Bike> bikeHashSet = new HashSet<>();
        bikeHashSet.add(bikes.get(0));
        rents.get(rents.size() - 1).setBikes(bikeHashSet);
        rents.get(rents.size() - 1).setCustomer(customers.get(0));
        rents.get(rents.size() - 1).setStarterEmployee(employees.get(0));
        rents.get(rents.size() - 1).setStartTime(LocalDateTime.now()
                .minusDays(1L)
                .withHour(8)
                .withMinute(30)
                .withSecond(0)
                .withNano(0)
        );
        rents.get(rents.size() - 1).setCloserEmployee(employees.get(0));
        rents.get(rents.size() - 1).setCloseTime(LocalDateTime.now());
        rentRepository.save(rents.get(rents.size() - 1));

        rents.add(new Rent());
        bikeHashSet = new HashSet<>();
        bikeHashSet.add(bikes.get(1));
        rents.get(rents.size() - 1).setBikes(bikeHashSet);
        rents.get(rents.size() - 1).setCustomer(customers.get(1));
        rents.get(rents.size() - 1).setStarterEmployee(employees.get(1));
        rents.get(rents.size() - 1).setStartTime(LocalDateTime.now()
                .minusDays(2L)
                .withHour(15)
                .withMinute(10)
                .withSecond(0)
                .withNano(0)
        );
        rentRepository.save(rents.get(rents.size() - 1));

    }
}
