interface MyInterface {
    void show();
}

public class Test4 {
    public void display() {
        // Anonymous Inner Class
        MyInterface obj1 = new MyInterface() {
            public void show() {
                System.out.println("this = " + this.getClass().getName());
            }
        };
        obj1.show();

        // Lambda
        MyInterface obj2 = () -> {
            System.out.println("this = " + this.getClass().getName());
        };
        obj2.show();
    }

    public static void main(String[] args) {
        new Test4().display();
    }
}
