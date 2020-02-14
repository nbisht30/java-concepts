package javaeight.functionalinterfaces.bifunction;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;
import javaeight.functionalinterfaces.predicate.PredicateRealWorldExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class BiFunctionRealWorldExample {
    //a function that takes list of students as input and returns a map fo student name and their gpas
    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> studentFunction =
            (students, studentPredicate) -> {
                Map<String, Double> studentGradeMap = new HashMap<>();
                students.forEach(student -> {
                    if (studentPredicate.test(student))  //only for above 3.9 gpa
                        studentGradeMap.put(student.getName(), student.getGpa());
                });
                return studentGradeMap;
            };

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents(), PredicateRealWorldExample.predicateGpa));
    }
}
