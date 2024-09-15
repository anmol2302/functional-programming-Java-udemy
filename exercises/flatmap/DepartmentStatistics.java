package exercises.flatmap;

import exercises.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee1 {
    public String name;
    private int age;

    public Employee1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
}

class Department1 {
    private String name;
    private List<Employee1> employees;

    public Department1(String name, List<Employee1> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee1> getEmployee1() {
        return employees;
    }
}


public class DepartmentStatistics {

    public static Map<String, Double> getAverageAgeByDepartment1(List<Department1> departments) {

        return null;


//        return departments.stream()
//                .flatMap(department1 -> department1.getEmployee1().stream())
//                .collect(Collectors.groupingBy(Employee1::getAge, Collectors.collectingAndThen(Collectors.toList(), empList -> {
//                    return empList.stream().mapToDouble(Employee1::getAge).average();
//                })));

    }

    public static void main(String[] args) {

        Employee1 emp1 = new Employee1("Alice", 30);
        Employee1 emp2 = new Employee1("Bob", 25);
        Employee1 emp3 = new Employee1("Charlie", 35);
        Employee1 emp4 = new Employee1("David", 40);
        Employee1 emp5 = new Employee1("Alice", 30);


        // Create sample departments with lists of employees
        Department1 dept1 = new Department1("Engineering", Arrays.asList(emp1, emp2, emp5));
        Department1 dept2 = new Department1("HR", Arrays.asList(emp3, emp5));
        Department1 dept3 = new Department1("Marketing", Arrays.asList(emp4, emp5));
        Department1 dept4 = new Department1("Sales", Arrays.asList()); // No employees



        List<Department1> department1s = List.of(dept1, dept2, dept3, dept4);

        department1s.stream()
                .flatMap(dept -> dept.getEmployee1().stream())
                .forEach(emp -> System.out.println("employee name is:"+emp.name +"and age is"+emp.getAge()));

        System.out.println(department1s.stream().flatMap(dept -> dept.getEmployee1().stream())
                        .collect(Collectors.groupingBy(Employee1::getName, Collectors.mapping(emp -> emp.getAge(), Collectors.toList()))));


//        System.out.println(department1s.stream().flatMap(department1 -> department1.getEmployee1().stream())
//                .mapToDouble(Employee1::getAge).average());
//
//        System.out.println(department1s.stream().filter(dept -> !dept.getEmployee1().isEmpty())
//                .collect(Collectors.toMap(depts -> depts.getName(), department1 -> department1.getEmployee1().stream()
//                        .mapToDouble(Employee1::getAge).average())));



//        // Get average age by department
//        Map<String, Double> averageAgeByDepartment1 = DepartmentStatistics.getAverageAgeByDepartment1(departments);
//
//        // Print the result
//        System.out.println(averageAgeByDepartment1);


        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah");

        System.out.println(names.stream().filter(name -> name.length()>=5)
                .map(String::toUpperCase)
                .sorted()
                .limit(3)
                .collect(Collectors.toSet()));


    }
}
