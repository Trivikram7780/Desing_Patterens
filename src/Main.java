import createpatters.abstractfactory.CheckoutService;
import createpatters.abstractfactory.IndiaFactory;
import createpatters.abstractfactory.USFactory;
import createpatters.factorypatters.LogisticService;
import createpatters.factorypatters.Logistics;
import createpatters.singleton.BellPushedSingleton;
import createpatters.singleton.EagerSingleton;
import createpatters.singleton.LazySynchronizedSingleton;

public class Main {
    enum Singleton {
        EAGER,
        LAZY,
        BELL_PUSHED
    }
    enum CreatePatternType {
        SINGLETON,
        FACTORY,
        ABSTRACT_FACTORY
    }
    private static void singleton(String type){

        //Eager singleton pattern
        if(type.equalsIgnoreCase(String.valueOf(Singleton.EAGER))) {
            EagerSingleton eagerSingleton = EagerSingleton.getInstance();
            EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
            System.out.println(eagerSingleton);
            System.out.println(eagerSingleton1);
        } else if (type.equalsIgnoreCase(String.valueOf(Singleton.LAZY))) {
            LazySynchronizedSingleton instance = LazySynchronizedSingleton.getInstance();
            System.out.println(instance);
        } else if (type.equalsIgnoreCase(String.valueOf(Singleton.BELL_PUSHED))) {
            BellPushedSingleton instance = BellPushedSingleton.getInstance();
            System.out.println(instance);
        }
    }

    private static void factoryPattern(){
        LogisticService logisticService = new LogisticService();
        logisticService.send("Air");
        logisticService.send("Road");
    }

    private static void abstractFactoryPattern(){
        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory() , "razorpay");
        indiaCheckout.completeOrder(2000);

        System.out.println("---");

        CheckoutService usCheckout = new CheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);

    }

    private static void decideCreatePattern(String type){
        if(type.equalsIgnoreCase(String.valueOf(CreatePatternType.SINGLETON))){
            singleton(String.valueOf(Singleton.BELL_PUSHED));
        }
        else if(type.equalsIgnoreCase(String.valueOf(CreatePatternType.FACTORY))){
            factoryPattern();
        }
        else if (type.equalsIgnoreCase(String.valueOf(CreatePatternType.ABSTRACT_FACTORY))){
            abstractFactoryPattern();
        }
    }


    public static void main(String[] args) {
        decideCreatePattern(String.valueOf(CreatePatternType.ABSTRACT_FACTORY));

    }
}