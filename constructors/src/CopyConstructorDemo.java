import javax.print.attribute.standard.Copies;

class Address {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}

class Person {
    String name;
    Address address;

    // Regular constructor
    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Copy Constructor
    Person(Person other) {
        System.out.println(this);
        this.name = other.name;
        this.address = other.address; // just copying the reference
    }

    // Deep Copy Constructor
    Person(Person other, boolean deepCopy) {
        this.name = other.name;
        if (deepCopy) {
            this.address = new Address(other.address.city, other.address.state); // new Address object
        } else {
            this.address = other.address;
        }
    }

    void display() {
        System.out.println("Name: " + name + ", City: " + address.city + ", State: " + address.state);
    }
}

public class CopyConstructorDemo {
    public static void main(String[] args) {
        System.out.println("=== Original Person ===");
        Person original = new Person("Alice", new Address("Delhi", "Delhi"));
        original.display();

        System.out.println("\n=== Shallow Copy ===");
        Person shallowCopy = new Person(original); // shallow copy
        shallowCopy.address.city = "Mumbai"; // modifying shallowCopy's address
        shallowCopy.display();

        System.out.println("After modifying shallow copy:");
        original.display(); // original is affected!

        System.out.println("\n=== Deep Copy ===");
        Person deepCopy = new Person(original, true); // deep copy
        deepCopy.address.city = "Bangalore"; // modifying deepCopy's address
        deepCopy.display();

        System.out.println("After modifying deep copy:");
        original.display(); // original remains unaffected
    }
}


//NOTES:
//
//What Is Copying in Java?
//When you create a new object using another object (often in a copy constructor), copying can happen in two ways:
//
//1. Shallow Copy
//Copies field values as-is.
//If a field is a reference (object), both original and copy will point to the same object in memory.
//
//2. Deep Copy
//Copies field values.
//If a field is a reference (object), it creates a new object with the same values, so changes don't affect each other.