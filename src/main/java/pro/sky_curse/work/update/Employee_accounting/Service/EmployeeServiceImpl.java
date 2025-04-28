package pro.sky_curse.work.update.Employee_accounting.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;
import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeAlreadyAddedException;
import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeNotFoundException;
import pro.sky_curse.work.update.Employee_accounting.exception.InvalidEmployeeNameException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Иванов Дмитрий Александрович", new Employee("Иванов", "Дмитрий", "Александрович", 152100, "1"),
            "Дмитрев Олег Евгеневич", new Employee("Дмитрев", "Олег", "Евгеневич", 152000, "1"),
            "Стрельников Вадим Никитич", new Employee("Стрельников", "Вадим", "Никитич", 100020, "2"),
            "Рубинов Александр Леонидович", new Employee("Рубинов", "Александр", "Леонидович", 100000, "2"),
            "Михаилов Данил Генадьевич", new Employee("Михаилов", "Данил", "Генадьевич", 80007, "3"),
            "Григорьев Леонид Артемович", new Employee("Григорьев", "Леонид", "Артемович", 55000, "3"),
            "Матросов Алексей Михаилович", new Employee("Матросов", "Алексей", "Михаилович", 60001, "4"),
            "Берегов Михаил Алексеевич", new Employee("Берегов", "Михаил", "Алексеевич", 60000, "4"),
            "Артемьев Кирилл Владимирович", new Employee("Артемьев", "Кирилл", "Владимирович", 45097, "5"),
            "Голубцов Никита Григорьевичь", new Employee("Голубцов", "Никита", "Григорьевичь", 45000, "5")
    ));

    @Override
    public Employee add(String firstName, String lastName, String middleName, int salary, String department) {
        validateInput(firstName, lastName, middleName);
        Employee employee = new Employee(firstName, lastName, middleName, salary, department);
        String key = getFullName(employee);

        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует.");
        }

        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, String middleName, int salary, String department) {
        validateInput(firstName, lastName, middleName);
        String key = getFullName(firstName, lastName, middleName);
        Employee employee = employees.get(key);
        if (employee != null) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    @Override
    public Employee remove(String firstName, String lastName, String middleName, int salary, String department) {
        validateInput(firstName, lastName, middleName);
        String key = getFullName(firstName, lastName, middleName);
        Employee removedEmployee = employees.remove(key);
        if (removedEmployee != null) {
            return removedEmployee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден.");
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private void validateInput(String firstName, String lastName, String middleName) {
        validateNamePart(firstName, "Имя");
        validateNamePart(lastName, "Фамилия");
        validateNamePart(middleName, "Отчество");
    }

    private void validateNamePart(String value, String fieldName) {
        if (StringUtils.isBlank(value)) {
            throw new InvalidEmployeeNameException(fieldName + " не должно быть пустым или содержать только пробелы.");
        }

        if (!StringUtils.isAlpha(value.replaceAll(" ", ""))) {
            throw new InvalidEmployeeNameException(fieldName + " должно содержать только буквы.");
        }

        if (!Character.isUpperCase(value.charAt(0))) {
            throw new InvalidEmployeeNameException(fieldName + " должно начинаться с заглавной буквы.");
        }
    }

    private String getFullName(Employee employee) {
        return String.format("%s %s %s", employee.getFirstName(), employee.getLastName(), employee.getMiddleName());
    }

    private String getFullName(String firstName, String lastName, String middleName) {
        return String.format("%s %s %s", firstName, lastName, middleName);
    }
}