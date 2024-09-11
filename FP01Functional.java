import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP01Functional {


    public static void main(String[] args) {
        List<Integer> num = List.of(12, 90, 15, 15, 5, 6, 90);
        printAllNumberInList(List.of(12, 90, 15, 15, 5, 6, 90));
        printEvenNumbers(List.of(12, 90, 15, 15, 5, 6, 90));
        printOddNumbers(List.of(1,2,3,4,5));
        List<String> courses = List.of("Spring", "Spring Boot", "API", "microservices", "AWS", "Docker", "Azure", "Kubernates");
        printCourses(courses);
        printSquareOfEvenNumber(num);
        printCubesOfOddNumber(num);

    }

    public void print(int num) {
        System.out.print(num + ",");
    }

    public static void printNum(int num) {
        System.out.print(num + ",");
    }

    public static void printAllNumberInList(List<Integer> numbers) {

        FP01Functional obj = new FP01Functional();
      //  numbers.stream().forEach(obj::print); //method reference
        numbers.stream().forEach(FP01Functional::printNum);
        System.out.println("\n Below printing even numbers: \n");
    }

    public static void printEvenNumbers(List<Integer> number) {
        number.stream().filter(ele -> ele % 2 == 0).forEach(System.out::println);
    }

    //Exercise 1.1 print odd numbers

    public static void printOddNumbers(List<Integer> numbers){
        List<Integer>  filteredOddNumbers= numbers.stream().filter((ele) -> ele%2!=0).collect(Collectors.toList());
        System.out.println("Odd number list is:" + filteredOddNumbers);

    }

    public static void printCourses(List<String> courses) {
        courses.forEach(ele -> System.out.println(ele));

        //print courses containing spring.
        System.out.println("Course releated to springs are below:");
        String result = courses.stream().filter(ele -> ele.contains("Spring")).collect(Collectors.joining(", "));
        System.out.println(result);
        //print name atleast 4 chars
        String filteredResult = courses.stream().filter(ele -> ele.length() >=4).collect(Collectors.joining(", "));
        System.out.println(String.format("Courses with 4 chars atleast: %s", filteredResult));

        //print the number of character in each course name
        courses.stream().forEach(ele -> System.out.println(ele.length()));
        courses.stream().map(ele -> ele.length()).forEach(System.out::println);
        Map<String, Integer> courseDetails = courses.stream().collect(Collectors.toMap(Function.identity(), n -> n.length()));
        System.out.println("course and course name length mapping is:"+ courseDetails);

    }

    public static void printSquareOfEvenNumber(List<Integer> numbers){
        numbers.stream().filter(num -> num%2==0).map(num -> num * num).forEach(System.out::print);
    }

    public static void printCubesOfOddNumber(List<Integer> num) {
        num.stream().filter(ele-> ele%2!=0).map(ele -> ele*ele*ele).forEach(System.out::println);
    }
}
