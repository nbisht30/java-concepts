/*
package javaeight.lambdaandlocalvar;

import java.util.function.Consumer;

*/
/**
 * @author Nikhil Bisht
 * @date 16-02-2020
 *//*

public class LambdaAndLocalVariables {
    public static void main(String[] args) {

        //Restriction #1
        int i = 2;
        Consumer<Integer> someConsumer = i -> {  //Gives "Variable i is already defined in scope error"
            int i = 10; //Also not allowed
        };

        //Restriction #2
        int value = 2;
        int val = 2;
        Consumer<Integer> someConsumer2 = x -> {
            System.out.println(val+1);
            value = 10;
        };
        val = 10;   //Not allowed, cannot modify value of a local variable that is used inside a lambda, even in the method body.

    }
}
*/
