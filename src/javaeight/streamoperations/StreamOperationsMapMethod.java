package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsMapMethod {
    public static List<String> namesList() {
        List<String> names = StudentDataBase.getAllStudents().stream().
                map(Student::getName). //Stream<String>
                map(String::toUpperCase).
                collect(toList());
        return names;
    }

    public static Set<String> namesSet() {
        Set<String> names = StudentDataBase.getAllStudents().stream().
                map(Student::getName). //Stream<String>
                map(String::toUpperCase).
                collect(toSet());
        return names;
    }

    public static void main(String[] args) {
        //Use Case: Collect the names of all students in a list and print them on console.
        System.out.println(namesList());
    }
}
