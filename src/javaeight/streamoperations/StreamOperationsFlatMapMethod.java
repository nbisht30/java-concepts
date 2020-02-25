package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsFlatMapMethod {
    public static List<String> printStudentActivities(){
        List<List<String>> collectedActivitiesUsingMap = StudentDataBase.getAllStudents().stream().  //Stream<Student>
                map(Student::getActivities).  //Stream<List<String>>
                collect(Collectors.toList());

        List<String> collectedActivitiesUsingFlatMap = StudentDataBase.getAllStudents().stream().  //Stream<Student>
                map(Student::getActivities).  //Stream<List<String>>
                flatMap(List::stream).      //Flatten the List<String so this gives us Stream<String>
                collect(Collectors.toList());
        return collectedActivitiesUsingFlatMap;
    }

    public static void main(String[] args) {
        System.out.println(printStudentActivities());
    }
}
