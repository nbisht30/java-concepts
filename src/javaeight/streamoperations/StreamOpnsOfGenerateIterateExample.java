package javaeight.streamoperations;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOpnsOfGenerateIterateExample {

    public static void main(String[] args) {
        //of()
        Stream<String> stringStream = Stream.of("adam", "nick", "john");
        stringStream.forEach(System.out::println);
        //iterate()
        Stream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);
        //generate()
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier).limit(5).forEach(System.out::println);
    }
}
