package createpatters.abstractfactory.us;

import createpatters.abstractfactory.interfaces.PaymentGateway;

public class StripeGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}
