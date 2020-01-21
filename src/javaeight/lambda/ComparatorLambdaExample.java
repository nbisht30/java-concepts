package javaeight.lambda;

import java.util.Comparator;

/**
 * @author Nikhil Bisht
 * @date 22-01-2020
 */
public class ComparatorLambdaExample {
    public static void main(String[] args) {
        /*
        * Prior Java 8
        * */

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);  //using default compareTo method of Comparable interface just for a demo
                //returns 0 if o1 == o2, 1 if o1>o2, -1 if o1<o2
            }
        };

        System.out.println("Result of normal comparator is: "+ comparator.compare(3,2));

        /*
        * Using lambdas
        * */

        Comparator<Integer> comparator1 = (a,b)-> a.compareTo(b);

        System.out.println("Result of lambda comparator: " + comparator1.compare(3,2));
    }
}
