import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05Streams {

    public static void main(String[] args) {
        String result = Stream.of(1,2,3,4,5,5,6).map(ele -> ele+"").collect(Collectors.joining(", "));
        System.out.println("result:"+result);
        int[] array = {1,2,3,4,54,5,56,4,2};
        System.out.println(Arrays.stream(array).sum());
        System.out.println(IntStream.range(1,11).sum());

        //print first 10 even numbers

        IntStream.iterate(2, e-> e+2).limit(10).peek(System.out::println).sum();


        System.out.println(IntStream.iterate(2, e-> e+2).limit(10).boxed().toList());

        List<Integer> numberList = List.of(1,2,3,4,5);

        System.out.println(numberList.stream().reduce(0, (x,y) -> x+y));


        //working with large numbers

        System.out.println(IntStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));



    }

}
