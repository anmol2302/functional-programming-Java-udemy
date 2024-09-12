import customFunctionalInterface.CustomValidator;
import model.User;

public class Validator {


    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setAge(90);
        user.setName("Anmol Gupta");

        validate(() -> {
                    if (user.getAge() < 18) {
                        throw new Exception("user age cant be less than 18");
                    }
                }
        );

        validate(() -> {
            if (user.getName().equalsIgnoreCase("")) {
                throw new Exception("user name cant be empty");
            }
        });
    }



    public static void validate(CustomValidator<User> customValidator) throws Exception {
        System.out.println("in Validate method");
        customValidator.validate();
    }


}
