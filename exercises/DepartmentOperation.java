package exercises;

import java.util.Arrays;
import java.util.List;

public class DepartmentOperation {
    public static void main(String[] args) {
        Project p1 = new Project("Project A");
        Project p2 = new Project("Project B");
        Project p3 = new Project("Project C");

        Employ e1 = new Employ("Alice", Arrays.asList(p1, p2));
        Employ e2 = new Employ("Bob", Arrays.asList(p2, p3));

        Department d1 = new Department("Engineering", Arrays.asList(e1, e2));

        Project p4 = new Project("Project D");
        Employ e3 = new Employ("Charlie", Arrays.asList(p3, p4));

        Department d2 = new Department("Marketing", Arrays.asList(e3));

        List<Department> departments = Arrays.asList(d1, d2);



        List<String> uniqueProjectNames = ProjectManager.getUniqueProjectNames(departments);

        System.out.println(uniqueProjectNames);
    }
}
