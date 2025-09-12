package createpatters.factorypatters;

public class Road implements Logistics{
    @Override
    public void send() {
        System.out.println("Sending by the Road Logic");
    }
}
