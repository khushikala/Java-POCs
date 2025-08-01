// Base class
class Payment {
    protected final double TRANSACTION_FEE = 2.5; // final variable

    private String paymentId;

    public Payment(String paymentId) {
        this.paymentId = paymentId;
    }

    public final void calculateFee(double amount) { // final method
        double fee = amount * TRANSACTION_FEE / 100;
        System.out.println("Transaction fee: ₹" + fee);
    }

    public void printReceipt() {
        System.out.println("Generic payment receipt for ID: " + paymentId);
    }
}

// Subclass
class CreditCardPayment extends Payment {
    private String cardNumber;
    private double amount;

    public CreditCardPayment(String paymentId, String cardNumber, double amount) {
        super(paymentId); // calling parent constructor
        this.cardNumber = cardNumber;  // resolving shadowing
        this.amount = amount;
    }

    // Overriding method
    @Override
    public void printReceipt() {
        System.out.println("Receipt for credit card ending with " + cardNumber.substring(cardNumber.length() - 4));
        super.printReceipt(); // reuse parent logic
    }

    public void process() {
        System.out.println("Processing payment of ₹" + amount + " through credit card.");
        super.calculateFee(amount); // call final method
        printReceipt();
    }
}

// Transaction manager class using `this`
class TransactionProcessor {
    private CreditCardPayment payment;

    public TransactionProcessor(CreditCardPayment payment) {
        this.payment = payment; // `this` to resolve instance variable
    }

    public TransactionProcessor processAndReturn() {
        payment.process();
        return this; // enables method chaining
    }
}

public class OnlinePaymentSystem {
    public static void main(String[] args) {
        CreditCardPayment payment = new CreditCardPayment("TXN001", "1234567812345678", 1000.0);

        // Using 'this' to enable fluent API
        new TransactionProcessor(payment)
                .processAndReturn(); // method chaining using `this`
    }
}
