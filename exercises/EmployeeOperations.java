package exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DepartmentData{
    double highestSalary;

    public DepartmentData(double highestSalary, double totalSalary) {
        this.highestSalary = highestSalary;
        this.totalSalary = totalSalary;
    }

    double totalSalary;


}


public class EmployeeOperations {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", 28, "HR", 50000),
                new Employee("Bob", 35, "IT", 70000),
                new Employee("Charlie", 40, "IT", 80000),
                new Employee("David", 25, "HR", 45000),
                new Employee("Eve", 30, "Finance", 60000),
                new Employee("Frank", 32, "Finance", 65000));


        /**
         *
         * 1) Sum of Salaries: Calculate the total sum of all employees' salaries.
         * 2) Average Salary: Calculate the average salary of all employees.
         * 3) Maximum Salary: Find the highest salary among all employees.
         * 4) Minimum Salary: Find the lowest salary among all employees.
         * 5) Group by Department: Group employees by their department and list all employees in each department.
         * 6) Filter by Age: Get a list of employees who are above 30 years old.
         * 7) Top 3 Salaries: Find the top 3 highest salaries.
         * 8) Employee Count by Department: Count the number of employees in each department.
         * 9) Calculate Total Salary per Department: For each department, calculate the total salary of all employees within that department.
         * 10) Find the Highest Salary in Each Department: Determine the highest salary within each department.
         * 11) Filter Departments with Total Salary Above a Certain Threshold: Filter out departments where the total salary is below a specified threshold.
         * 12) Generate a Report: Create a report in the form of a string listing each department, the total salary, and the highest salary in that department.
         */

        System.out.println("sum of salary total of all employee:"+ employees.stream().map(emp -> emp.getSalary()).reduce(0D,Double::sum));
        System.out.println("Average salary of employee:"+employees.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble());
        System.out.println("the max salary is:"+ employees.stream().mapToDouble(emp -> emp.getSalary()).max());
        System.out.println("the min salary is:"+ employees.stream().mapToDouble(emp -> emp.getSalary()).min());
        System.out.println("group by department:"+ employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList()))));
        System.out.println("Employee above 30 years old:"+ employees.stream().filter(ele -> ele.getSalary()>30).map(emp -> emp.getName()).collect(Collectors.toList()));
        System.out.println("The top 3 high salary:"+ employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(ele -> ele.getName()).limit(3).toList());
        System.out.println("Employee count in each department:"+ employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));


        System.out.println("Total salary per department:" + employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary))));

        System.out.println("Highest salary per department:" + employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .entrySet().stream().collect(Collectors.toMap(emp -> emp.getKey(), emp -> emp.getValue().get().getSalary())));

        System.out.println("Filter Departments with Total Salary above 100000:"+employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .entrySet().stream().filter(emp -> emp.getValue() > 100000).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)) + "\n");

        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), empList -> {
            double totalSal = empList.stream().mapToDouble(Employee::getSalary).sum();
            double highestSal = empList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
            return new DepartmentData(totalSal, highestSal);
        }))).entrySet().forEach(emp -> System.out.println(emp.getKey() + " highest salary is:"+emp.getValue().highestSalary + " and total salary is:"+emp.getValue().totalSalary));

    }
}
