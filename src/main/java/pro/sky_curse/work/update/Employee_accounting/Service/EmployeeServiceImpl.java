package pro.sky_curse.work.update.Employee_accounting.Service;

import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeAlreadyAddedException;
import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeNotFoundException;
import pro.sky_curse.work.update.Employee_accounting.Employee;

import java.util.Collection;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    public static final List<Employee> employeesList = List.of(
            new Employee("Дмитрий", "Иванов"),
            new Employee("Олег", "Дмитрев"),
            new Employee("Вадим", "Стрельников"),
            new Employee("Александр", "Рубинов"),
            new Employee("Данил", "Михаилов"),
            new Employee("Леонид", "Григорьев"),
            new Employee("Алексей", "Матросов"),
            new Employee("Михаил", "Берегов"),
            new Employee("Кирилл", "Артемьев"),
            new Employee("Никита", "Голубцов"));

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employeesList.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employeesList.add(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employeesList.contains(employee)){
         return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employeesList.contains(employee)){
            employeesList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return employeesList;
    }
}
