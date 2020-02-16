package javaeight.methodandconstructorreferences;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;

import java.util.function.Supplier;

/**
 * @author Nikhil Bisht
 * @date 14-02-2020
 */
public class ConstructorReferences {
    static Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {
        Student student = studentSupplier.get();

        student.setName("Nikhil Bisht");

        System.out.println(student.getName());
    }
}
