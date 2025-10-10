package com.example.staticMethods;

interface A {
    static void display() {
        System.out.println("Static method from interface A");
    }
}
public class MyClass implements A {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        // myClass.display(); // Error: Cannot call static method on instance
//        MyClass.display(); // Error: Cannot call static method on class
        A.display(); // Calling static method from interface A
    }
}
