package javaeight;

import java.util.stream.IntStream;

/**
 * @author Nikhil Bisht
 * @date 07-01-2020
 */
public class ImperativeVsDeclarativeExample2 {
    public static void main(String[] args) {
//        Imperative Style Of Programming

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

//        Declarative Style Of Programming
        System.out.println(IntStream.rangeClosed(0,100).sum());
    }
}
