package createpatters.abstractfactory;

import createpatters.abstractfactory.interfaces.Invoice;
import createpatters.abstractfactory.interfaces.PaymentGateway;
import createpatters.abstractfactory.interfaces.RegionFactory;
import createpatters.abstractfactory.us.PayPalGateway;
import createpatters.abstractfactory.us.StripeGateway;
import createpatters.abstractfactory.us.USInvoice;

public class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        } else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}
