package createpatters.abstractfactory;

import createpatters.abstractfactory.india.GSTInvoice;
import createpatters.abstractfactory.india.PayUGateway;
import createpatters.abstractfactory.india.RazorpayGateway;
import createpatters.abstractfactory.interfaces.Invoice;
import createpatters.abstractfactory.interfaces.PaymentGateway;
import createpatters.abstractfactory.interfaces.RegionFactory;

public class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway();
        } else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}