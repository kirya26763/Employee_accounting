package pro.sky_curse.work.update.Employee_accounting;

import java.util.List;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return " Сотрудник - " + firstName + ' ' + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
    public static final List<Employee> employees = List.of(
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
}
