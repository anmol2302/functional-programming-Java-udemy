package customFunctionalInterface;

@FunctionalInterface
public interface CustomValidator<T> {
    public void validate() throws Exception;
}
