package javaeight.functionalinterfaces.consumer.realworldexample;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Nikhil Bisht
 * @date 25-01-2020
 */
public class Main {
    static Consumer<Student> consumer1 = (student) -> System.out.println(student.getName());
    static Consumer<Student> consumer2 = (student) -> System.out.println(student.getActivities());

    public static void printName() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(consumer1);
    }

    public static void printNameAndActivities() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(consumer1.andThen(consumer2));  //this is called consumer chaining
    }

    public static void printNameAndActivitiesForStudentAboveGrade(int grade) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if (student.getGpa() >= grade) {
                consumer1.andThen(consumer2).accept(student);
            }
        }));  //this is called consumer chaining
    }

    public static void main(String[] args) {
//        printName();
        printNameAndActivitiesForStudentAboveGrade(3);
    }
}
