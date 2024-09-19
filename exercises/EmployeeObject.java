package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeObject {
    private int id;
    private String name;
    private List<String> department;
    private double salary;

    // Constructor
    public EmployeeObject(int id, String name, List<String> department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {

        List<EmployeeObject> employees = Arrays.asList(
                new EmployeeObject(1, "Alice", List.of("HR", "IT"), 70000),
                new EmployeeObject(2, "Bob", List.of("HR", "IT", "finance"), 90000),
                new EmployeeObject(3, "Charlie", List.of("IT", "finance"), 85000),
                new EmployeeObject(4, "David", List.of("HR", "finance"), 60000),
                new EmployeeObject(5, "Eve", List.of("HR", "ADMIN", "finance"), 75000),
                new EmployeeObject(6, "Frank", List.of("ADMIN"), 62000)
        );

       //GROUP BY EMPLOYEE BY DEPARTMENT

        System.out.println(employees.stream().flatMap(emp -> emp.getDepartment().stream()
                .map(dept -> List.of(dept,emp.name)))
                .collect(Collectors.groupingBy(entry -> entry.get(0), Collectors.mapping(entry -> entry.get(1), Collectors.toList()))));


    }
}
