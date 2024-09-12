package customFunctionalInterface;


import java.util.function.BinaryOperator;

@FunctionalInterface
public interface AddFunctionalInterface extends BinaryOperator<Integer> {

    @Override
    Integer apply(Integer o, Integer o2);
}
