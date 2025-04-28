package pro.sky_curse.work.update.Employee_accounting.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;
import pro.sky_curse.work.update.Employee_accounting.Service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable String id) {
        return departmentService.employeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalarySumByDepartment(@PathVariable String id) {
        return departmentService.salarySumByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public Employee getMaxSalaryEmployee(@PathVariable String id) {
        return departmentService.employeeMaxSalaryDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMinSalaryEmployee(@PathVariable String id) {
        return departmentService.employeeMinSalaryDepartment(id);
    }

    @GetMapping("/employees")
    public Map<String, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return departmentService.allEmployeeDepartment();
    }
}
