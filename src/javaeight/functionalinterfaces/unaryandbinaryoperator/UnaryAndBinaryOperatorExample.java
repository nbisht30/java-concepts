package javaeight.functionalinterfaces.unaryandbinaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class UnaryAndBinaryOperatorExample {
    static UnaryOperator<String> concatSomething = string -> string.concat("| After String");

    static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    static BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);  //gives max by using the comparator logic

    static BinaryOperator<String> doSomethingWithtwoOperands = (str1, str2) -> str1.concat("| Middle String | ").concat(str2);

    public static void main(String[] args) {
        System.out.println(concatSomething.apply("Before String "));
        System.out.println(doSomethingWithtwoOperands.apply("Before String ", "After String"));

        System.out.println("Result of maxBy is: " + maxBy.apply(4, 5));
    }
}
