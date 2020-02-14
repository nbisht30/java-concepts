package javaeight.functionalinterfaces.supplier;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Nikhil Bisht
 * @date 14-02-2020
 */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = () -> new Student("Jenny", 2, 3.8, "female", Arrays.asList("swimming", "gymnastics", "soccer"));
        Supplier<List<Student>> studentListSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println(studentSupplier.get().getName());
        System.out.println(studentListSupplier.get());

    }
}
