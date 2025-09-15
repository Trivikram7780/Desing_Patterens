package structuralpatterns.adaptor;
// Concrete implementation of PaymentGateway for PayU
public class PayUGateway implements PaymentGateway {

    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid Rs." + amount + " using PayU for order: " + orderId);
    }
}
