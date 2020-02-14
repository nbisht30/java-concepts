package javaeight.methodandconstructorreferences;

import java.util.function.Function;

/**
 * @author Nikhil Bisht
 * @date 14-02-2020
 */
public class MethodReferenceFunctionExample {
    static Function<String, String> toUpperCaseLambda = s -> s.toUpperCase();
    static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUpperCaseLambda.apply("nikhil"));
        System.out.println(toUpperCaseMethodReference.apply("nikhil"));
    }
}
