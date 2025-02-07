package pro.sky_curse.work.update.Employee_accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky_curse.work.update.Employee_accounting.Employee;
import pro.sky_curse.work.update.Employee_accounting.Service.EmployeeService;
import pro.sky_curse.work.update.Employee_accounting.Service.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
 private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return service.add(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return service.add(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return service.add(firstName,lastName);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return service.findAll();
    }
}