import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 4, -1);
//        int sum = calcluateSumOfList(numbers);
//        System.out.println("the sum of list is:" + sum);
//
//        int min = returnMinValue(numbers);
//        System.out.println("the minimum value of list is:" + min);
//
//        int squareSum = squareNumAndSum(numbers);
//        System.out.println("the square of every number and their sum is:" + squareSum);
//
//        int cubeSum = cubeOfNumAndSum(numbers);
//        System.out.println("the cube of every number and their sum is:" + cubeSum);
//
//        int sumOfOddNumbers = sumOfOddNumbers(numbers);
//        System.out.println("the sum of odd numbers are:" + sumOfOddNumbers);
//
//        System.out.println("the sorted numbers are:"+ numbers.stream().sorted().collect(Collectors.toList()));
//
//        System.out.println("the distinct elements are:"+numbers.stream().distinct().collect(Collectors.toList()));

        List<String> courses = List.of("Spring", "Spring Boot", "API", "microservices", "AWS", "Docker", "Azure", "Kubernates");
        sortStringInLengthReverseOrder(courses);
    }


    public static int calcluateSumOfList(List<Integer> num) {
        //return num.stream().reduce(0, (a,b)->a+b);
        //return num.stream().reduce(0, FP02Functional::sum);
        return num.stream().reduce(0, Integer::sum);
    }

    public static int returnMinValue(List<Integer> number) {
        return number.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? y : x);

    }

    public static int sum(int a, int b) {
        System.out.println("int sum");
        return a + b;
    }

    public static int square(int a) {
        System.out.println("in square");
        return a * a;
    }

    /**
     * Find sum of square of each number in list.
     *
     * @param nums
     * @return
     */
    public static int squareNumAndSum(List<Integer> nums) {
        return nums.stream()
                .map(FP02Functional::square)
                .reduce(0, FP02Functional::sum);

        /**
         * (1, (0,1) -> 1
         * (4, (1, 4) -> 5
         * (9, (5, 9) -> 14
         * (16, (14,16) -> 30
         */
    }

    /**
     * Find sum of cube of each number in list
     *
     * @param num
     * @return
     */
    public static int cubeOfNumAndSum(List<Integer> num) {
        return num.stream().map(ele -> ele * ele * ele).reduce(0, Integer::sum);
    }

    /**
     * Find sum of odd number in list
     *
     * @param num
     * @return
     */
    public static int sumOfOddNumbers(List<Integer> num) {
        return num.stream().filter(ele -> ele % 2 != 0)
                .reduce(0, Integer::sum);  //terminal operation, doesn't return stream.
    }

    public static void sortStringInLengthReverseOrder(List<String> courses){
        List<String> sortedCourses = courses
                .stream()
                .sorted(Comparator.comparing(String::length).reversed()) //Intermediate Operation
                .collect(Collectors.toList());
        System.out.println(sortedCourses);



    }

}
