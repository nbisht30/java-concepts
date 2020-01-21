package javaeight.intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Nikhil Bisht
 * @date 07-01-2020
 */
public class ImperativeVsDeclarativeExample2 {
    //Remove duplicates from list
    public static void main(String[] args) {
//        Imperative Style Of Programming

        List<Integer> integers = Arrays.asList(1,2,3,3,4,5,5,6,7,8,8,9,10);

        List<Integer> uniqueList = new ArrayList<>();
        for (Integer integer: integers){
            if(!uniqueList.contains(integer)){
                uniqueList.add(integer);
            }
        }
        System.out.println(uniqueList);

//        Declarative Style Of Programming
        List<Integer> uniqueList2 = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueList2);
    }
}
