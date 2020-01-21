package javaeight.lambda;

/**
 * @author Nikhil Bisht
 * @date 22-01-2020
 */
public class RunnableLambdaExample {
    public static void main(String[] args) {
        /*
        * Prior to Java 8
        * */
        Runnable runnable = new Runnable() {  //Implemented as an anonymous inner class
            @Override
            public void run() {
                System.out.println("Inside runnable 1");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        /*
        * Using lambda expressions
        * */
        Runnable runnable1 = () -> {
            System.out.println("Inside runnable 2.");
        };
        new Thread(runnable1).start();
        //Shorter Version: As there is only a single line of statement to be executed we can remove braces
        Runnable runnable2 = () -> System.out.println("Inside runnable 3.");
        new Thread(runnable2).start();
        //Even Shorter Version
        new Thread(() -> System.out.println("Inside runnable 4")).start();
    }
}

