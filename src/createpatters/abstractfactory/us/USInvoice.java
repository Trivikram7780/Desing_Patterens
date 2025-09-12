package createpatters.abstractfactory.us;

import createpatters.abstractfactory.interfaces.Invoice;

public class USInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating Invoice as per US norms.");
    }
}
