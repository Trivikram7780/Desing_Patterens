package structuralpatterns.decorator;

public class PlainPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 150.00 ;    }
}
