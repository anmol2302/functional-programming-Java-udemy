import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP03BehaviourInterfaces {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<Integer> evenNum = filterAndPrint(numbers, (x) -> x % 2 == 0);
        System.out.println("All even numbers are:"+ evenNum);
        int result = doOperation(numbers, (a,b) -> a*a + b*b);
        System.out.println("the square of number and their results are:"+result);
        List<Integer> squaredList = doSquare(numbers, (x) -> x*x);
        System.out.println("the squared List is:"+squaredList);
        UnaryOperator<Integer> unaryOperator = (x) -> x*2;
        Supplier<String> supplier = () -> "Hello I am supplier , I dont have params, I only return value";
    }

    public static Set<Integer> filterAndPrint(List<Integer> number, Predicate<Integer> filterFunc){
       return number.stream().filter(filterFunc).collect(Collectors.toSet());
    }

    public static int doOperation(List<Integer> numbers, BinaryOperator<Integer> operateFunction){
        return numbers.stream().reduce(0,operateFunction);
    }


    public static List<Integer> doSquare(List<Integer> numbers, Function<Integer, Integer> squareFunc){
        return numbers.stream().map(squareFunc).collect(Collectors.toList());
    }
}
