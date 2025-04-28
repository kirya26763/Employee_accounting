package pro.sky_curse.work.update.Employee_accounting.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pro.sky_curse.work.update.Employee_accounting.Model.Employee;

class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employee1 = new Employee("Иванов", "Иван", "Иванович", 100_000, "1");
        employee2 = new Employee("Петров", "Петр", "Петрович", 150_000, "1");
        employee3 = new Employee("Сидоров", "Сидор", "Сидорович", 200_000, "2");
    }

    @Test
    void shouldReturnMaxSalaryEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(List.of(employee1, employee2, employee3));

        Employee result = departmentService.employeeMaxSalaryDepartment("1");

        assertEquals(employee2, result);
    }

    @Test
    void shouldReturnMinSalaryEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(List.of(employee1, employee2, employee3));

        Employee result = departmentService.employeeMinSalaryDepartment("1");

        assertEquals(employee1, result);
    }

    @Test
    void shouldReturnAllEmployeesGroupedByDepartment() {
        when(employeeService.findAll()).thenReturn(List.of(employee1, employee2, employee3));

        Map<String, List<Employee>> result = departmentService.allEmployeeDepartment();

        assertEquals(2, result.size());
        assertTrue(result.containsKey("1"));
        assertTrue(result.containsKey("2"));
        assertEquals(2, result.get("1").size());
        assertEquals(1, result.get("2").size());
    }

    @Test
    void shouldThrowExceptionIfNoEmployeesInDepartmentForMaxSalary() {
        when(employeeService.findAll()).thenReturn(List.of(employee3)); // Только отдел 2

        assertThrows(IllegalArgumentException.class, () -> departmentService.employeeMaxSalaryDepartment("1"));
    }

    @Test
    void shouldThrowExceptionIfNoEmployeesInDepartmentForMinSalary() {
        when(employeeService.findAll()).thenReturn(List.of(employee3)); // Только отдел 2

        assertThrows(IllegalArgumentException.class, () -> departmentService.employeeMinSalaryDepartment("1"));
    }
}