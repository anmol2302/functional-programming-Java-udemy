package exercises;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectManager {

    public static List<String> getUniqueProjectNames(List<Department> departments) {
        // Implement this method using Java Streams and flatMap

        return departments.stream().flatMap(department -> department.getEmployees().stream())
                .flatMap(emp -> emp.getProjects().stream())
                .map(pro -> pro.getName()).distinct().toList();

    }

}
