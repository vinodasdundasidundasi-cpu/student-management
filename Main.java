package com.api.example;

1

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", "BCA", 85));
        students.add(new Student(102, "Anjali", "BCA", 95));
        students.add(new Student(103, "Kiran", "BSc", 72));
        students.add(new Student(104, "Asha", "BCA", 67));
        students.add(new Student(105, "Ramesh", "BCom", 55));
        students.add(new Student(106, "Sneha", "BCA", 91));

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Result System =====");
            System.out.println("1. Display Students");
            System.out.println("2. Students Above 80 Marks");
            System.out.println("3. Sort by Marks");
            System.out.println("4. Count Students");
            System.out.println("5. Highest Marks");
            System.out.println("6. Lowest Marks");
            System.out.println("7. Student Names");
            System.out.println("8. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    students.forEach(System.out::println);

                    break;

                case 2:

                    students.stream()
                            .filter(s -> s.getMarks() > 80)
                            .forEach(System.out::println);

                    break;

                case 3:

                    students.stream()
                            .sorted((s1, s2) ->
                                    Double.compare(s2.getMarks(), s1.getMarks()))
                            .forEach(System.out::println);

                    break;

                case 4:

                    long count = students.stream().count();

                    System.out.println("Total Students = " + count);

                    break;

                case 5:

                    Student max = students.stream()
                            .max(Comparator.comparing(Student::getMarks))
                            .get();

                    System.out.println(max);

                    break;

                case 6:

                    Student min = students.stream()
                            .min(Comparator.comparing(Student::getMarks))
                            .get();

                    System.out.println(min);

                    break;

                case 7:

                    List<String> names = students.stream()
                            .map(Student::getName)
                            .collect(Collectors.toList());

                    System.out.println(names);

                    break;

                case 8:

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }

}