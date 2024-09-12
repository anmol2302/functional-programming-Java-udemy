import customFunctionalInterface.AddFunctionalInterface;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03Functional {


    public static void main(String[] args) {

        // extracted the variables.

        List<Integer> numbers = List.of(1, 2, 3, 4);
        Predicate<Integer> integerPredicate = ele -> ele % 2 == 0;
        Function<Integer, Integer> integerIntegerFunction = ele -> ele * ele;
        Function<Integer, Integer> func = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Consumer<Integer> println = System.out::println;

        numbers.stream()
                .filter(integerPredicate)
                .map(func)
                .forEach(println);

       int sum =  returnSumOfList(numbers);
        System.out.println(sum);
    }

    public static int returnSumOfList(List<Integer> number) {
        AddFunctionalInterface addIF = new AddFunctionalInterface() {
            @Override
            public Integer apply(Integer o, Integer o2) {
                return o+o2;
            }
        };
        return number.stream().reduce(0, addIF);
    }
}
