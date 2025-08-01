import java.util.*;

class FinalRefExample {
    public static void main(String[] args) {
        final List<String> names = new ArrayList<>();
        names.add("Khushi"); // allowed
        names.add("Hrishika");

//         names = new ArrayList<>();

        System.out.println(names); // [Khushi, Hrishika]
    }
}
