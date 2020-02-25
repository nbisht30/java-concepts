package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsMapReduceExample {
    public static Integer totalNotebooks() {
        return StudentDataBase.getAllStudents().stream().
                filter(student -> student.getGradeLevel() >= 3).
                map(Student::getNotebooks).
//                reduce(0, (r, r2) -> r + r2);  //Or use the one below
        reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        // Use Case: Get total number of notebooks all students have
        System.out.println(totalNotebooks());
    }
}
