package structuralpatterns.decorator;

public class ExtraCheese extends PizzaDecorator{

    public ExtraCheese(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0;
    }
}
