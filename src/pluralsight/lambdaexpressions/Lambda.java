package pluralsight.lambdaexpressions;

import java.util.ArrayList;
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
    }
}
