package exercises;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.List;

 class Department2 {
    private String name;
    private List<Employee2> employees;

    // Constructor
    public Department2(String name, List<Employee2> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee2> getEmployee2s() {
        return employees;
    }
}

 class Employee2 {
    private String name;
    private double performanceScore;
    private String department;

    // Constructor
    public Employee2(String name, double performanceScore, String department) {
        this.name = name;
        this.performanceScore = performanceScore;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public String getDepartment2() {
        return department;
    }
}

public class EmployeePerformanceAnalysis {
    public static void main(String[] args) {
        List<Department2> departments = Arrays.asList(
                new Department2("HR", Arrays.asList(
                        new Employee2("Alice", 85.0, "HR"),
                        new Employee2("Bob", 70.0, "HR"),
                        new Employee2("Charlie", 90.0, "HR")
                )),
                new Department2("Engineering", Arrays.asList(
                        new Employee2("Dave", 88.0, "Engineering"),
                        new Employee2("Eve", 72.0, "Engineering"),
                        new Employee2("Frank", 65.0, "Engineering")
                )),
                new Department2("Marketing", Arrays.asList(
                        new Employee2("Grace", 78.0, "Marketing"),
                        new Employee2("Heidi", 82.0, "Marketing")
                ))
        );

        double threshold = 75.0;

        /**
         *
         * Flatten the list of employees from all departments into a single stream.
         * Partition the employees into two groups based on their performance score (above or below 75).
         * Group the employees by department and calculate the average performance score for each department.
         * Sort the departments by their average performance score in descending order.
         * Print each department’s average performance score, the number of employees above the threshold, and the number of employees below the threshold.
         */

        System.out.println(departments.stream().flatMap(depart -> depart.getEmployee2s().stream())
                        .map(emp -> List.of(emp.getDepartment2(), emp.getName(), emp.getPerformanceScore()))
                .collect(Collectors.toList()));

        System.out.println("Above threshold employee"+departments.stream().flatMap(depart -> depart.getEmployee2s().stream())
                .collect(Collectors.partitioningBy(emp -> emp.getPerformanceScore()>=threshold)).get(true));


        System.out.println("Below threshold employee"+departments.stream().flatMap(depart -> depart.getEmployee2s().stream())
                .collect(Collectors.partitioningBy(emp -> emp.getPerformanceScore()>=threshold)).get(false));

        System.out.println(departments.stream().flatMap(dep -> dep.getEmployee2s().stream())
                .collect(Collectors.groupingBy(Employee2::getDepartment2, Collectors.averagingDouble(Employee2::getPerformanceScore)))
        );

        System.out.println(departments.stream().flatMap(dep -> dep.getEmployee2s().stream())
                .collect(Collectors.groupingBy(Employee2::getDepartment2, Collectors.averagingDouble(Employee2::getPerformanceScore))).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList()
        );

        departments.stream().flatMap(depart -> depart.getEmployee2s().stream())
                .collect(Collectors.groupingBy(Employee2::getDepartment2, Collectors.collectingAndThen(Collectors.toList(), empList -> {
                    List<Employee2> aboveThreshold  = empList.stream().collect(Collectors.partitioningBy(emp -> emp.getPerformanceScore()> threshold)).get(true);
                    List<Employee2> belowThreshold  = empList.stream().collect(Collectors.partitioningBy(emp -> emp.getPerformanceScore()> threshold)).get(false);
                    double averageScore = empList.stream().mapToDouble(Employee2::getPerformanceScore).average().getAsDouble();
                   return new DepartmentSummary(averageScore, aboveThreshold.size(), belowThreshold.size());
                }))).entrySet().stream().forEach(ent -> System.out.println(ent.getKey() + "and data is"+ ent.getValue().toString()));
    }
}

class DepartmentSummary {
    private final double averageScore;
    private final int aboveThreshold;
    private final int belowThreshold;

    public DepartmentSummary(double averageScore, int aboveThreshold, int belowThreshold) {
        this.averageScore = averageScore;
        this.aboveThreshold = aboveThreshold;
        this.belowThreshold = belowThreshold;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getAboveThreshold() {
        return aboveThreshold;
    }

    public int getBelowThreshold() {
        return belowThreshold;
    }

    @Override
    public String toString() {
        return "DepartmentSummary{" +
                "averageScore=" + averageScore +
                ", aboveThreshold=" + aboveThreshold +
                ", belowThreshold=" + belowThreshold +
                '}';
    }
}
