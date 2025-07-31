class ThisExample {
    int x;

    ThisExample(int x) {
        this.x = x;  // 'this' refers to current instance variable
    }

    void display() {
        System.out.println("Value of x: " + this.x);
    }

    public static void main(String[] args) {
        ThisExample obj = new ThisExample(10);
        obj.display(); // Output: Value of x: 10
    }
}
