package pro.sky_curse.work.update.Employee_accounting.Service;

import org.springframework.stereotype.Service;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {

    Employee add(String firstName, String lastName, String middleName, int salary, String department);

    Employee find(String firstName, String lastName, String middleName, int salary, String department);

    Employee remove(String firstName, String lastName, String middleName, int salary, String department);

    Collection<Employee> findAll();
}