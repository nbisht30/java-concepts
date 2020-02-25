package javaeight.streamoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsReduce {
    public static int performMultiplicationUsingReduce(List<Integer> integers) {
        //1, 3, 5, 7
        //i. a = default value = 1; b = first value = 1 => result = a * b = 1;
        //ii. a = result from previous opn = 1, b = second value = 3 => result = a * b = 3;
        //iii. a = result from previous opn = 3, b = third value = 5 => result = a * b = 15;
        //iv. a = result from previous opn = 15, b = fourth value = 7 => result = a * b = 105;
        return integers.stream().reduce(1, (integer, integer2) -> integer * integer2); //identity is the initial/default value
    }

    public static Optional<Integer> performMultiplicationUsingReduceWithoutIdentity(List<Integer> integers) {
        //Optional is used to handle null values
        //1, 3, 5, 7
        //i. a = default value = 1; b = first value = 1 => result = a * b = 1;
        //ii. a = result from previous opn = 1, b = second value = 3 => result = a * b = 3;
        //iii. a = result from previous opn = 3, b = third value = 5 => result = a * b = 15;
        //iv. a = result from previous opn = 15, b = fourth value = 7 => result = a * b = 105;
        return integers.stream().reduce((integer, integer2) -> integer * integer2); //identity is the initial/default value
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        System.out.println(performMultiplicationUsingReduce(integers));
        Optional<Integer> integer = performMultiplicationUsingReduceWithoutIdentity(integers);
        System.out.println(integer.isPresent());
        System.out.println(integer.get());
        System.out.println("With an empty list:- ");
        List<Integer> integers2 = new ArrayList<>();
        Optional<Integer> integer2 = performMultiplicationUsingReduceWithoutIdentity(integers2);
        System.out.println(integer2.isPresent());
        System.out.println(integer2.get());  //gives an exception
    }
}
