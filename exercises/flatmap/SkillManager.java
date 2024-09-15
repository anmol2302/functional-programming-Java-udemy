package exercises.flatmap;

import java.util.List;
import java.util.stream.Collectors;


import java.util.List;

class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Employee {
    private String name;
    private List<Skill> skills;

    public Employee(String name, List<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class SkillManager {
    public static List<String> getUniqueSkills(List<Department> departments) {
        return departments.stream().flatMap(department -> department.getEmployees().stream())
                .flatMap(emp -> emp.getSkills().stream())
                .map(skill -> skill.getName())
                .sorted()
                .distinct().toList();

    }
}

