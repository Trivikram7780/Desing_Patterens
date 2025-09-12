package createpatters.abstractfactory.india;

import createpatters.abstractfactory.interfaces.Invoice;

public class GSTInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}
