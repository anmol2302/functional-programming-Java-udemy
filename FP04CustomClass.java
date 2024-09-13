import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Course {


    String name;
    String category;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    int reviewScore;
    int noOfStudents;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" + "name='" + name + '\'' + ", category='" + category + '\'' + ", reviewScore=" + reviewScore + ", noOfStudents=" + noOfStudents + '}';
    }


}


public class FP04CustomClass {


    public static void main(String[] args) {

        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));



        List<String>courseList = List.of("AWS","AWS", "AWS", "AZURE", "AZURE", "Microservices");

        System.out.println(courseList.stream().collect(Collectors.groupingBy(course -> course.length())));

        System.out.println(courses.stream().map(course -> course.getName()).collect(Collectors.toMap(Function.identity(), (course) -> course.length())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.category, Collectors.mapping(course -> course.getName(), Collectors.toList()))));



        //course review score greater than 90

//        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 95));
//
//        System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() < 90));
//
//        System.out.println(courses.stream().anyMatch(course -> course.getReviewScore() > 95));
//
//        List<Course> courseAscOrderByStudent = courses.stream()
//                .sorted(Comparator.comparing(Course::getNoOfStudents)).toList();
//
//        System.out.println("Course by asc order of students are:" + courseAscOrderByStudent);
//
//        List<Course> coursesByDescStudent = courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).reversed()).toList();
//
//        System.out.println("Course by desc order of students are:" + coursesByDescStudent);
//
//        List<Course> coursesByStudentAndRatings = courses.stream()
//                .sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed())
//                .skip(3) // skip first 3 result.
//                .limit(5)    //limiting number of results.
//                .toList();
//
//        System.out.println("Course by desc order top 5 of students and the ratings are:" + coursesByStudentAndRatings);
//
//
//
//        //take all elements until the predicate became false. review ratings comes 91
//
//        List<Course> coursesWithReview95 = courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed()).takeWhile(course -> course.getReviewScore()>=95).toList();
//
//        System.out.println("All courses with review rating 95:"+ coursesWithReview95);
//
//
//        //drop while are one which will pick all element until the provided predicate became false, after that it will pick all the elements.
//        List<Course> coursesWithReviewLessThan95 = courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed()).dropWhile(course -> course.getReviewScore()>=95).toList();
//
//        System.out.println("All courses with review rating 95:"+ coursesWithReviewLessThan95);
//
//        System.out.println(courses.stream().max(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed()));
//        System.out.println(courses.stream().min(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed())
//                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
//
//        System.out.println(courses.stream().filter(course -> course.reviewScore>95).findFirst());
//        System.out.println(courses.stream().filter(course -> course.reviewScore<95).findAny());
//
//        System.out.println(courses.stream().filter(course -> course.getReviewScore()>95).mapToInt(course -> course.getReviewScore()).max());
//
//
//        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore())))));
//
//        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));

    }

}
