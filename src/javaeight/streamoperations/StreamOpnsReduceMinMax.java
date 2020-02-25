package javaeight.streamoperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOpnsReduceMinMax {
    public static Optional<Integer> findMax(List<Integer> integerList){
        return integerList.stream().reduce((Integer::max));
    }

    public static Optional<Integer> findMin(List<Integer> integerList){
        return integerList.stream().reduce((Integer::min));
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        System.out.println("Max : "+ findMax(integerList).get());
        System.out.println("Min : "+ findMin(integerList).get());
    }
}
