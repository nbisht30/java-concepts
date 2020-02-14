package javaeight.functionalinterfaces.function;

import java.util.function.Function;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class FunctionExample {
    static Function<String, String> function = name -> name.toUpperCase();
    static Function<String, String> functionAndThen = name -> name.concat("Concatenated");


    public static void main(String[] args) {
        System.out.println("Result is : " + function.andThen(functionAndThen).apply("java 8"));
        System.out.println("Result is : " + function.compose(functionAndThen).apply("java 8")); //performs functionAndThen first
        //and passes the result to function
    }
}
