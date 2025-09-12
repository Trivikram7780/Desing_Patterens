package createpatters.factorypatters;

public class Air implements Logistics{
    @Override
    public void send() {
        System.out.println("Sending by the Air Logic");
    }
}
