package pluralsight.lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Nikhil Bisht
 * @date 13-01-2020
 */
public class Lambda {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(4);
        items.add(5);
        items.add(6);
        items.add(7);

        //forEach() of java 8
        items.forEach(listItem -> System.out.println(listItem * listItem));  //print sq. of items

        String[] words = {"Bye", "Hi", "Adios", "Hola", "Aloha"};

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        Arrays.stream(words).forEach(System.out::println);
        System.out.println(words);
        //OR
        Arrays.sort(words, Comparator.comparingInt(String::length));
    }
}
