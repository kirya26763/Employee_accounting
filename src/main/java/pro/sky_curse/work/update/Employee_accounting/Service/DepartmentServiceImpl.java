package pro.sky_curse.work.update.Employee_accounting.Service;

import org.springframework.stereotype.Service;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeMaxSalaryDepartment(String departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee employeeMinSalaryDepartment(String departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<String, List<Employee>> allEmployeeDepartment(String departmentId) {
        return employeeService.findAll().stream()
                .filter(employee -> employee.getDepartment().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}