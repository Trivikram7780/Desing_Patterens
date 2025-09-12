package createpatters.factorypatters;

public class Train implements Logistics{
    @Override
    public void send() {
        System.out.println("Sending by the Train Logic");
    }
}
