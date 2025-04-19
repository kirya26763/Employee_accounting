package pro.sky_curse.work.update.Employee_accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;
import pro.sky_curse.work.update.Employee_accounting.Service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastName,
                                @RequestParam String firstName,
                                @RequestParam String middleName,
                                @RequestParam int salary,
                                @RequestParam String department) {
        return service.add(lastName, firstName, middleName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String lastName,
                                   @RequestParam String firstName,
                                   @RequestParam String middleName,
                                   @RequestParam int salary,
                                   @RequestParam String department) {
        return service.remove(lastName, firstName, middleName, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastName,
                                 @RequestParam String firstName,
                                 @RequestParam String middleName,
                                 @RequestParam int salary,
                                 @RequestParam String department) {
        return service.find(lastName, firstName, middleName, salary, department);
    }

    @GetMapping("/all")
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}