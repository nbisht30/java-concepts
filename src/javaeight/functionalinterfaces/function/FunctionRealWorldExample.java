package javaeight.functionalinterfaces.function;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;
import javaeight.functionalinterfaces.predicate.PredicateExample;
import javaeight.functionalinterfaces.predicate.PredicateRealWorldExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class FunctionRealWorldExample {
    //a function that takes list of students as input and returns a map fo student name and their gpas
    static Function<List<Student>, Map<String, Double>> studentFunction =
            students -> {
                Map<String, Double> studentGradeMap = new HashMap<>();
                students.forEach(student -> {
                    if(PredicateRealWorldExample.predicateGpa.test(student))  //only for above 3.9 gpa
                    studentGradeMap.put(student.getName(), student.getGpa());
                });
                return studentGradeMap;
            };

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));
    }
}
