package javaeight.streamoperations;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikhil Bisht
 * @date 25-02-2020
 */
public class StreamOperationsDistinctFoundSort {
    public static List<String> printDistinctStudentActivities() {
        List<String> collectedActivitiesUsingFlatMap = StudentDataBase.getAllStudents().stream().  //Stream<Student>
                map(Student::getActivities).  //Stream<List<String>>
                flatMap(List::stream).      //Flatten the List<String so this gives us Stream<String>
                distinct().
                collect(Collectors.toList());
        return collectedActivitiesUsingFlatMap;
    }

    public static List<String> printSortedDistinctStudentActivities() {
        List<String> collectedActivitiesUsingFlatMap = StudentDataBase.getAllStudents().stream().  //Stream<Student>
                map(Student::getActivities).  //Stream<List<String>>
                flatMap(List::stream).      //Flatten the List<String so this gives us Stream<String>
                distinct().
                sorted().
                collect(Collectors.toList());
        return collectedActivitiesUsingFlatMap;
    }

    public static Long printCountStudentActivities() {
        return StudentDataBase.getAllStudents().stream().  //Stream<Student>
                map(Student::getActivities).  //Stream<List<String>>
                flatMap(List::stream).      //Flatten the List<String so this gives us Stream<String>
                distinct().
                count();
    }

    public static void main(String[] args) {
        System.out.println(printDistinctStudentActivities());  //distinct()
        System.out.println(printCountStudentActivities());  //count()
        System.out.println(printSortedDistinctStudentActivities());  //sorted()
    }
}
