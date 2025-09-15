package structuralpatterns.decorator;


// implements Pizza and holds a reference to a Pizza object
abstract public class PizzaDecorator implements Pizza{

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

}
