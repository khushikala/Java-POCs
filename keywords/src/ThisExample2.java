class ThisExample2 {
    void method1(ThisExample2 obj) {
        System.out.println("Method called with current object.");
    }

    void method2() {
        method1(this);  // passing current object
    }

    public static void main(String[] args) {
        new ThisExample2().method2();
    }
}