import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        printAllNumberInList(List.of(12, 90, 15, 15, 5, 6, 90));
        printEvenNumbers(List.of(12, 90, 15, 15, 5, 6, 90));
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

}
