class Room {
    private String name;

    Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class House {
    private Room bedroom;
    private Room kitchen;

    // Composition: Rooms are created inside House
    House() {
        this.bedroom = new Room("Bedroom");
        this.kitchen = new Room("Kitchen");
    }

    public void showRooms() {
        System.out.println("House has: " + bedroom.getName() + " and " + kitchen.getName());
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        House house = new House();
        house.showRooms();

        // If house is destroyed -> rooms also destroyed
    }
}
