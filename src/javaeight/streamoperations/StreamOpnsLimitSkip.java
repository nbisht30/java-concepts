package javaeight.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOpnsLimitSkip {
    public static List<Integer> limit(List<Integer> integerList) {
        return integerList.stream().limit(2).collect(Collectors.toList());
    }

    public static List<Integer> skip(List<Integer> integerList) {
        return integerList.stream().skip(2).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        System.out.println("Limit : " + limit(integerList));
        System.out.println("Skip : " + skip(integerList));
    }
}
