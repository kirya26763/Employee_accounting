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
    public List<Employee> employeesByDepartment(String departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public int salarySumByDepartment(String departmentId) {
        return employeesByDepartment(departmentId).stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee employeeMaxSalaryDepartment(String departmentId) {
        return employeesByDepartment(departmentId).stream()
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Нет сотрудников в отделе"));
    }

    @Override
    public Employee employeeMinSalaryDepartment(String departmentId) {
        return employeesByDepartment(departmentId).stream()
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Нет сотрудников в отделе"));
    }

    @Override
    public Map<String, List<Employee>> allEmployeeDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}