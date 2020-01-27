package javaeight.functionalinterfaces.consumerandpredicate;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class PredicateAndConsumerExample {
    Predicate<Student> predicate1 = student -> student.getGradeLevel() >= 3;
    Predicate<Student> predicate2 = student -> student.getGpa() >= 3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) ->
            System.out.println(name + " : " + activities);

    Consumer<Student> consumer = student -> {
        if (predicate1.and(predicate2).test(student)) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new PredicateAndConsumerExample().printNameAndActivities(studentList);
    }

    public void printNameAndActivities(List<Student> studentList) {
        studentList.forEach(consumer);
    }
}
