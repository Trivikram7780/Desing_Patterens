package structuralpatterns.adaptor;

public class RazorpayAdaptor implements  PaymentGateway{

    private RazorpayAPI razorpayAPI;

    public RazorpayAdaptor(){
        this.razorpayAPI = new RazorpayAPI();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorpayAPI.makePayment(orderId , amount);
    }
}
