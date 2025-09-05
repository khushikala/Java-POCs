enum Season {
    WINTER("Cold"), SUMMER("Hot"), RAINY("Wet");

    private String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        for (Season s : Season.values()) {
            System.out.println(s + " -> " + s.getDescription());
        }
    }
}
