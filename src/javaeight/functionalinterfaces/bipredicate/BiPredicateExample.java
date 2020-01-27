package javaeight.functionalinterfaces.bipredicate;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * @author Nikhil Bisht
 * @date 27-01-2020
 */
public class BiPredicateExample {
    /*
        Predicate<Student> predicate1 = student -> student.getGradeLevel() >= 3;
        Predicate<Student> predicate2 = student -> student.getGpa() >= 3.9;
    */
    //Instead of creating the above two predicates, we can create a single predicate
    BiPredicate<Integer, Double> biPredicate = (a, b) -> a >= 3 && b >= 3.9;

    BiConsumer<String, List<String>> studentBiConsumer = (name, activities) ->
            System.out.println(name + " : " + activities);

    Consumer<Student> consumer = student -> {
        if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
            studentBiConsumer.accept(student.getName(), student.getActivities());
        }
    };

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        new BiPredicateExample().printNameAndActivities(studentList);
    }

    public void printNameAndActivities(List<Student> studentList) {
        studentList.forEach(consumer);
    }
}
