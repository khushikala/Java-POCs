package com.comparatorwithlambdaexpr;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        // Without Lambda Expression
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
//        list.add(3);
//        list.add(2);
//        list.add(4);
//        Collections.sort(list, new MyClass2());
////        System.out.println("Sorted List in Ascending Order: " + list);
//        System.out.println("Sorted List in Descending Order: " + list);
//
//        // With Lambda Expression
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(5);
//        list2.add(1);
//        list2.add(3);
//        list2.add(2);
//        list2.add(4);
//        Collections.sort(list2, (a, b) -> b - a); // For descending order
//        System.out.println("Sorted List in Descending Order: " + list2);

        //TreeSet
//        Set<Integer> set1 = new TreeSet<>();
//        set1.add(23);
//        set1.add(5);
//        set1.add(89);
//        set1.add(1);
//        System.out.println("Before Sorting: " + set1);
//        Set<Integer> set2 = new TreeSet<>((a, b) -> b - a); // For descending order
//        set2.add(23);
//        set2.add(5);
//        set2.add(89);
//        set2.add(1);
//        System.out.println("After Sorting in Descending Order: " + set2);

//        //TreeMap
//        Map<Integer, String> map1 = new TreeMap<>();
//        map1.put(23, "John");
//        map1.put(5, "Alice");
//        map1.put(89, "Bob");
//        map1.put(1, "Charlie");
//        System.out.println("Before Sorting: " + map1);
//        Map<Integer, String> map2 = new TreeMap<>((a, b) -> b - a); // For descending order
//        map2.put(23, "John");
//        map2.put(5, "Alice");
//        map2.put(89, "Bob");
//        map2.put(1, "Charlie");
//        System.out.println("After Sorting in Descending Order: " + map2);

        //Sorting custom objects
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "John"));
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        System.out.println("Before Sorting: " + students);
        Collections.sort(students, (s1, s2) -> s2.id - s1.id); // Sort by id in descending order
        System.out.println("After Sorting by ID in Descending Order: " + students);
        Collections.sort(students, (s1, s2) -> s2.name.compareTo(s1.name)); // Sort by name in descending order
        System.out.println("After Sorting by Name in Descending Order: " + students);
    }

    static class Student {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}