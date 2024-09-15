import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP06FlatMaps {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", " AWS", "PCF", "Azure", "Docker", "Kubernetes");

//        String course = courses.stream().collect(Collectors.joining(","));
//
//        System.out.println("courses are:" + course);

        System.out.println(courses.stream().map(ele -> ele.split(""))
                .flatMap(Arrays::stream).distinct().toList());

        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(ele -> List.of(ele, course))).collect(Collectors.toList()));

        System.out.println(courses.stream().flatMap(course -> courses2.stream().filter(cou -> cou.length() == course.length()).map(cou -> List.of(course, cou))).filter(li -> !li.get(0).equals(li.get(1))).toList());




    }

    //High order function
    public List<Course> getCourseFilterCriteria(List<Course> courses, int lenghtValue){
        return courses.stream().filter(course -> course.getName().length() > lenghtValue).toList();
    }

}
