package javaeight.functionalinterfaces.biconsumer;

import javaeight.functionalinterfaces.consumer.realworldexample.Student;
import javaeight.functionalinterfaces.consumer.realworldexample.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * @author Nikhil Bisht
 * @date 26-01-2020
 */
public class BiConsumerExample {
    public static void nameAndActivities() {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
            System.out.println(name);
            activities.forEach(act -> System.out.println("Activity: " + act));
        };

        List<Student> studentList = StudentDataBase.getAllStudents();

        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        /*BiConsumer<String, String> biConsumer = (a,b)-> System.out.println(a+"-"+b);
        biConsumer.accept("hello","world");
        */
        nameAndActivities();
    }
}
