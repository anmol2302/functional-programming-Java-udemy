package exercises;

import java.util.List;

public class Department {
    private String name;
    private List<Employ> employees;

    public Department(String name, List<Employ> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employ> getEmployees() {
        return employees;
    }
}

