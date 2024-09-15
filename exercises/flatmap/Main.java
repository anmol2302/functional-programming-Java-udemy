package exercises.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create sample offices
        Office office1 = new Office("New York");
        Office office2 = new Office("San Francisco");
        Office office3 = new Office("Chicago");
        Office office4 = new Office("San Francisco"); // Duplicate city
        Office office5 = new Office("Los Angeles");

        // Create sample companies with lists of offices
        Company company1 = new Company("TechCorp", Arrays.asList(office1, office2));
        Company company2 = new Company("InnoSoft", Arrays.asList(office3, office4));
        Company company3 = new Company("CreativeWorks", Arrays.asList(office5, office1));

        // Create a list of companies
        List<Company> companies = Arrays.asList(company1, company2, company3);

        // Get unique cities
        List<String> uniqueCities = CityManager.getUniqueCities(companies);

        // Print the result
        System.out.println(uniqueCities);


        Skill skill1 = new Skill("Java");
        Skill skill2 = new Skill("Python");
        Skill skill3 = new Skill("JavaScript");
        Skill skill4 = new Skill("SQL");
        Skill skill5 = new Skill("Python"); // Duplicate skill

        // Create sample employees with lists of skills
        Employee emp1 = new Employee("Alice", Arrays.asList(skill1, skill2));
        Employee emp2 = new Employee("Bob", Arrays.asList(skill2, skill3));
        Employee emp3 = new Employee("Charlie", Arrays.asList(skill4, skill5));

        // Create sample departments with lists of employees
        Department dept1 = new Department("Engineering", Arrays.asList(emp1, emp2));
        Department dept2 = new Department("Data Science", Arrays.asList(emp3));

        // Create a list of departments
        List<Department> departments = Arrays.asList(dept1, dept2);

        // Get unique skills
        List<String> uniqueSkills = SkillManager.getUniqueSkills(departments);

        System.out.println(departments.stream().flatMap(department -> department.getEmployees().stream())
                .flatMap(emp -> emp.getSkills().stream())
                .collect(Collectors.groupingBy(skill -> skill.getName(), Collectors.counting())));

        System.out.println(departments.stream()                      // Stream<Department>
                .flatMap(department -> department.getEmployees().stream())   // Stream<Employee>
                .flatMap(employee -> employee.getSkills().stream())           // Stream<Skill>
                .map(Skill::getName)             // Stream<String> (skill names)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting())));  // Group by skill and count occurrences



        // Print the result
        System.out.println(uniqueSkills);

    }
}
