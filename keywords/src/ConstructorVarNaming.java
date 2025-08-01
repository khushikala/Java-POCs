class Person {
    String name;

    Person(String name) {
        this.name = name; // distinguishes parameter from instance variable
    }
}

public class ConstructorVarNaming {
    public static void main(String[] args) {
        Person person = new Person("Alice");
        System.out.println("Person's name is: " + person.name);
    }
}
