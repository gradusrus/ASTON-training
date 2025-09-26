package task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Иванов", "A1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Петров", "A1", 2, Arrays.asList(2, 2, 3)));
        students.add(new Student("Сидоров", "B2", 1, Arrays.asList(3, 3, 4)));

        System.out.println("Все студенты:");
        for (Student s : students) {
            System.out.println(s);
        }

        StudentUtils.removeLowGrades(students);
        StudentUtils.promoteStudents(students);

        System.out.println("\nПосле обработки:");
        for (Student s : students) {
            System.out.println(s);
        }

        StudentUtils.printStudents(students, 2);
    }
}
