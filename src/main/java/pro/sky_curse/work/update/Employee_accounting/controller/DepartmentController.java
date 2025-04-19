package pro.sky_curse.work.update.Employee_accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;
import pro.sky_curse.work.update.Employee_accounting.Service.DepartmentService;

import java.util.List;
import java.util.Map;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam String id) {
        return departmentService.employeeMaxSalaryDepartment(id);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam String id) {
        return departmentService.employeeMinSalaryDepartment(id);
    }

    @GetMapping("/employees")
    public Map<String, List<Employee>> getAllEmployeesInDepartment(@RequestParam String departmentId) {
        return departmentService.allEmployeeDepartment(departmentId);
    }
}
