package exercises.functionalInterfaces;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionClass {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        System.out.println(names.stream().reduce(new HashMap<String, Integer>(),(a,b) -> {
               a.put(b, b.length());
               return a;
                }, (li,li2) -> li
        ));

        IntStream.of(0,10).boxed().forEach(n -> System.out.println(n));
       // System.out.println(names.stream().map(FunctionClass.captalise()).toList());
        //System.out.println(names.stream().map(FunctionClass::capatalise).toList());

        // Define the BiFunction to generate Fibonacci series
        BiFunction<Integer, Integer, List<Integer>> fibonacciSeries = (start, length) -> {
            if (length <= 0) {
                return Collections.emptyList();
            }

            // Initialize the series with the starting number
            List<Integer> series = new ArrayList<>();
            series.add(start);
            series.add(start); // First element is the starting number

            if (length == 1) {
                return series;
            }

            int first = start;
            int second = start; // Second number is also the starting number

            // Generate the series
            for (int i = 1; i < length - 1; i++) {
                int next = first + second;
                series.add(next);
                first = second;
                second = next;
            }

            return series;
        };


        // Example usages
        List<Integer> series1 = fibonacciSeries.apply(1, 5);
        List<Integer> series2 = fibonacciSeries.apply(3, 6);

        // Print the results
        // System.out.println(fib(1, 5)); // [1, 1, 2, 3, 5]
        //System.out.println(fib(3, 6)); // [3, 3, 6, 9, 15, 24]


    }


    public static Function<Integer, Integer> squared() {
        return ele -> ele * ele;
    }

    public static Function<String, String> captalise() {
        Function<String, String> func = str -> str.toUpperCase();
        return func;
    }

    public static String capatalise(String str) {
        return str.toUpperCase();
    }

    public static List<Integer> fib(int start, int length) {
        return IntStream.range(1, length - 1)
                .boxed() // Convert IntStream to Stream<Integer>
                .reduce(new ArrayList<>(Arrays.asList(start, start)),
                        (series, index) -> {
                            if (length == 1) return series;
                            int next = series.get(series.size() - 1) + series.get(series.size() - 2);
                            series.add(next);
                            return series;
                        }, (list1, list2) -> list2
                );
    }

}
