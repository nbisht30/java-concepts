package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.Optional;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsReduceRealWorldExample {
    public static Optional<Student> highestGpaStudent() {
        return StudentDataBase.getAllStudents().stream().reduce((student, student2) ->
                (student.getGpa() > student2.getGpa()) ? student : student2);
    }

    public static void main(String[] args) {
        System.out.println(highestGpaStudent().get());
    }
}
