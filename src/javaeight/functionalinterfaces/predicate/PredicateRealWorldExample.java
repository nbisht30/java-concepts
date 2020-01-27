package javaeight.functionalinterfaces.predicate;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class PredicateRealWorldExample {
    public static Predicate<Student> predicateGrade = student -> student.getGradeLevel() >= 3;
    public static Predicate<Student> predicateGpa = student -> student.getGpa() >= 3.9;

    public static void printStudentsAboveCertainGrade() {
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(student -> {
            if (predicateGrade.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void printStudentsAboveCertainGradeAndGpa() {
        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(student -> {
            if (predicateGrade.and(predicateGpa).test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        printStudentsAboveCertainGradeAndGpa();
    }
}
