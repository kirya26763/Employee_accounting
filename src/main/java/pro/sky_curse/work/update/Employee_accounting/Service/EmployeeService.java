package pro.sky_curse.work.update.Employee_accounting.Service;

import pro.sky_curse.work.update.Employee_accounting.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Collection<Employee>findAll();
}
