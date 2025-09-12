package createpatters.factorypatters;


//Factory class taking care of Logistics
public class LogisticsFactory {
    public static Logistics getLogistics(String mode){
        if (mode.equalsIgnoreCase("Air")) {
            return new Air();
        } else if (mode.equalsIgnoreCase("Road")) {
            return new Road();
        }
        throw new IllegalArgumentException("Unknown logistics mode: " + mode);
    }
}

