package javaeight.methodandconstructorreferences;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Nikhil Bisht
 * @date 14-02-2020
 */
public class MethodReferenceConsumerExample {
    static Consumer<Student> consumerLambda = s -> System.out.println(s);
    static Consumer<Student> consumerMethodRef = System.out::println;
    static Consumer<Student> consumerGetAllStudentsMethodRef = Student::printListActivities;

    public static void main(String[] args) {
        System.out.println("Consumer Lambda");
        StudentDataBase.getAllStudents().forEach(consumerLambda);
        System.out.println("Consumer Method Ref");
        StudentDataBase.getAllStudents().forEach(consumerMethodRef);
        System.out.println("List of activities:-");
        StudentDataBase.getAllStudents().forEach(consumerGetAllStudentsMethodRef);
    }
}