package javaeight.functionalinterfaces.predicate;

import java.util.function.Predicate;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class PredicateExample {
    public static Predicate<Integer> predicate1 = (i) -> i % 2 == 0;
    public static Predicate<Integer> predicate2 = (i) -> i % 5 == 0;

    public static void predicateAnd(){
        System.out.println(predicate1.and(predicate1).test(10));
    }

    public static void predicateOr(){
        System.out.println(predicate1.or(predicate1).test(8));
    }

    public static void predicateNegate(){
        System.out.println(predicate1.or(predicate1).negate().test(8));
    }

    public static void main(String[] args) {
        System.out.println(predicate1.test(5));

        predicateAnd();
        //Main advantage of predicate: Code reusability
        predicateOr();

        predicateNegate();
    }
}
