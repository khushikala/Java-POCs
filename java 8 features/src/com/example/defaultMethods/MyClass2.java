package com.example.defaultMethods;

interface B {
    default void display() {
        System.out.println("Display method from interface B");
    }
}
interface C {
    default void display() {
        System.out.println("Display method from interface C");
    }
}
public class MyClass2 implements B, C{
    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        myClass2.display();
    }
    @Override
    public void display() {
        B.super.display(); // Call display method from interface B
        C.super.display(); // Call display method from interface C
         }
}
