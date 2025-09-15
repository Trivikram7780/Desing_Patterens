package createpatters.abstractfactory;

import createpatters.abstractfactory.interfaces.Invoice;
import createpatters.abstractfactory.interfaces.PaymentGateway;
import createpatters.abstractfactory.interfaces.RegionFactory;

public class CreateCheckoutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CreateCheckoutService(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}
