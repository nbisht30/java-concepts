package javaeight.methodandconstructorreferences;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Nikhil Bisht
 * @date 14-02-2020
 */
public class RefractorLambdaToMethodReference {
    public static Predicate<Student> predicateGpa = student -> student.getGpa() >= 3.9;

    /*
    The above lambda cannot be written directly as a method ref.
    To write the above lambda expression in form of a method reference. We can simply convert the lambda code
    to a method then use that method.
    */

    public static Predicate<Student> predicateGpaMethodRef = RefractorLambdaToMethodReference::greaterThanGpaLevel;

    public static void main(String[] args) {
        System.out.println(predicateGpa.test(StudentDataBase.studentSupplier.get()));
        System.out.println(predicateGpaMethodRef.test(StudentDataBase.studentSupplier.get()));
    }

    public static boolean greaterThanGpaLevel(Student student) {
        return student.getGpa() >= 3.9;
    }
}
