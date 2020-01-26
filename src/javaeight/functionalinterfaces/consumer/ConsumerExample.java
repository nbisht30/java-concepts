package javaeight.functionalinterfaces.consumer;

import java.util.function.Consumer;

/**
 * @author Nikhil Bisht
 * @date 25-01-2020
 */
public class ConsumerExample {
    public static void main(String[] args) {
        //String is the input type of consumer
        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());

        consumer.accept( "java 8");  //to accept an input use accept()


    }
}
