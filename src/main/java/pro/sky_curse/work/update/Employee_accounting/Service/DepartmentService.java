package pro.sky_curse.work.update.Employee_accounting.Service;

import pro.sky_curse.work.update.Employee_accounting.Model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> employeesByDepartment (String departmentId);

    int salarySumByDepartment (String departmentId);

    Employee employeeMaxSalaryDepartment(String departmentId);

    Employee employeeMinSalaryDepartment(String departmentId);

    Map<String, List<Employee>> allEmployeeDepartment();
}
