package javaeight.streams;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nikhil Bisht
 * @date 17-02-2020
 */
public class StreamsExample {
    public static void main(String[] args) {
        //Get students and their activities in a map
        Map<String, List<String>> studentAndActivities = StudentDataBase.getAllStudents().stream().collect(Collectors.toMap(Student::getName, Student::getActivities));
        studentAndActivities.forEach((name, activities) -> System.out.println(name + " : " + activities));
        System.out.println("=================================");

        //Just get students with certain conditions
        Predicate<Student> gradePred = student -> student.getGradeLevel() >= 3;
        Predicate<Student> gpaPred = student -> student.getGpa() >= 3;
        Map<String, List<String>> studentAndActivitiesGradeMoreThan3 = StudentDataBase.getAllStudents().stream().
                filter(gradePred).  //filter() for a condition
                filter(gpaPred).  //filter() for a condition
                collect(Collectors.toMap(Student::getName, Student::getActivities));
        studentAndActivitiesGradeMoreThan3.forEach((name, activities) -> System.out.println(name + " : " + activities));
        System.out.println("=================================");

        //Streams can be traversed only once.
        Stream<Student> streamOfStudents = StudentDataBase.getAllStudents().stream();
        streamOfStudents.forEach(student -> System.out.println(student.getName()));
        streamOfStudents.forEach(student -> System.out.println(student.getName())); //Exception in thread "main" java.lang.IllegalStateException:
        // stream has already been operated upon or closed
    }
}
