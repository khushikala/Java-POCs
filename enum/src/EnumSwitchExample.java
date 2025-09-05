//enum Day {
//    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//}

public class EnumSwitchExample {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Start of the week!");
                break;
            case FRIDAY:
                System.out.println("Weekend is near!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's weekend!");
                break;
            default:
                System.out.println("Midweek working days.");
        }
    }
}
