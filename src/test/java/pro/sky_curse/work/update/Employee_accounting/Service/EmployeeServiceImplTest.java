package pro.sky_curse.work.update.Employee_accounting.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky_curse.work.update.Employee_accounting.Model.Employee;
import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeAlreadyAddedException;
import pro.sky_curse.work.update.Employee_accounting.exception.EmployeeNotFoundException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployee_successfullyAddsNewEmployee() {
        Employee added = employeeService.add("Иванов", "Иван", "Иванович", 100000, "1");

        assertNotNull(added);
        assertEquals("Иванов", added.getFirstName());
    }

    @Test
    void addEmployee_throwsIfEmployeeAlreadyExists() {
        employeeService.add("Смирнов", "Петр", "Алексеевич", 95000, "2");

        assertThrows(EmployeeAlreadyAddedException.class, () ->
                employeeService.add("Смирнов", "Петр", "Алексеевич", 95000, "2"));
    }

    @Test
    void findEmployee_successfullyFindsExistingEmployee() {
        employeeService.add("Петров", "Алексей", "Сергеевич", 87000, "3");

        Employee found = employeeService.find("Петров", "Алексей", "Сергеевич", 87000, "3");

        assertEquals("Петров", found.getFirstName());
    }

    @Test
    void findEmployee_throwsIfNotFound() {
        assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.find("Несуществующий", "Сотрудник", "Пустой", 0, "0"));
    }

    @Test
    void removeEmployee_successfullyRemovesEmployee() {
        employeeService.add("Кузнецов", "Вадим", "Михайлович", 75000, "1");

        Employee removed = employeeService.remove("Кузнецов", "Вадим", "Михайлович", 75000, "1");

        assertEquals("Кузнецов", removed.getFirstName());
        assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.find("Кузнецов", "Вадим", "Михайлович", 75000, "1"));
    }

    @Test
    void removeEmployee_throwsIfNotFound() {
        assertThrows(EmployeeNotFoundException.class, () ->
                employeeService.remove("Иванов", "Неизвестный", "Тестович", 12345, "5"));
    }

    @Test
    void findAllEmployees_returnsAllEmployees() {
        employeeService.add("Иванов", "Иван", "Иванович", 100000, "1");
        employeeService.add("Петров", "Петр", "Петрович", 110000, "1");

        Collection<Employee> all = employeeService.findAll();

        assertEquals(2, all.size());
    }
}