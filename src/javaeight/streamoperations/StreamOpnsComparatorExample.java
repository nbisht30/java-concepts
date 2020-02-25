package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOpnsComparatorExample {
    public static List<Student> sortedStudentsByName(){
        return StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getName)).
                collect(Collectors.toList());
    }

    public static List<Student> sortedStudentsByGpa(){
        return StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getGpa).reversed()).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Use Case: Print all student details in sorted order of their names : Use Comparator
        sortedStudentsByName().forEach(System.out::println);
        System.out.println("Sorted by GPA from greatest to smallest: -");
        sortedStudentsByGpa().forEach(System.out::println);
    }
}
