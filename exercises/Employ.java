package exercises;

import java.util.List;

public class Employ {
    private String name;
    private List<Project> projects;

    public Employ(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
