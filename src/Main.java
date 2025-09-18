import createpatters.abstractfactory.CreateCheckoutService;
import createpatters.abstractfactory.IndiaFactory;
import createpatters.abstractfactory.USFactory;
import createpatters.factorypatters.LogisticService;
import createpatters.prototype.EmailTemplate;
import createpatters.prototype.EmailTemplateRegistry;
import createpatters.singleton.BellPushedSingleton;
import createpatters.singleton.EagerSingleton;
import createpatters.singleton.LazySynchronizedSingleton;
import structuralpatterns.adaptor.CheckoutService;
import structuralpatterns.adaptor.RazorpayAdaptor;
import structuralpatterns.composite.CartItem;
import structuralpatterns.composite.Product;
import structuralpatterns.composite.ProductBundle;
import structuralpatterns.decorator.*;
import structuralpatterns.proxy.CachedVideoDownloader;
import structuralpatterns.proxy.VideoDownloader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    enum Singleton {
        EAGER,
        LAZY,
        BELL_PUSHED
    }
    enum CreatePatternType {
        SINGLETON,
        FACTORY,
        ABSTRACT_FACTORY,
        PROTOTYPE
    }

    enum StructuralPatternType {
        ADAPTOR,
        DECORATIVE,
        FACADE,
        COMPOSITE,
        PROXY
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
        CreateCheckoutService indiaCheckout = new CreateCheckoutService(new IndiaFactory() , "razorpay");
        indiaCheckout.completeOrder(2000);

        System.out.println("---");

        CreateCheckoutService usCheckout = new CreateCheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);

    }

    private static void adaptorPatteren(){
        CheckoutService checkoutService = new CheckoutService(new RazorpayAdaptor());
        checkoutService.checkout("12" , 1780);
    }

    private static void prototypePattern(){
        EmailTemplate welcomeEmail1 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail1.setContent("Hi Alice, welcome to TUF Premium!");
        welcomeEmail1.send("alice@example.com");
    }

    private static void decorativePattern(){
        Pizza myPizza = new MargheritaPizza();
        myPizza = new ExtraCheese(myPizza);
        myPizza = new Olives(myPizza);
        myPizza = new StuffedCrust(myPizza);

        System.out.println("Pizza  Description: " + myPizza.getDescription());
        System.out.println("Total cost: $" + myPizza.getCost());
    }

    private static void compositePatter(){
        // Individual Products
        CartItem book = new Product("Atomic Habits", 499);
        CartItem phone = new Product("iPhone 15", 79999);
        CartItem earbuds = new Product("AirPods", 15999);
        CartItem charger = new Product("20W Charger", 1999);

        // Combo Deal
        ProductBundle iphoneCombo = new ProductBundle("iPhone Essentials Combo");
        iphoneCombo.addItem(phone);
        iphoneCombo.addItem(earbuds);
        iphoneCombo.addItem(charger);

        // Back to School Kit
        ProductBundle schoolKit = new ProductBundle("Back to School Kit");
        schoolKit.addItem(new Product("Notebook Pack", 249));
        schoolKit.addItem(new Product("Pen Set", 99));
        schoolKit.addItem(new Product("Highlighter", 149));

        // Add everything to cart
        List<CartItem> cart = new ArrayList<>();
        cart.add(book);
        cart.add(iphoneCombo);
        cart.add(schoolKit);

        // Display cart
        System.out.println("Your Amazon Cart:");
        double total = 0;
        for (CartItem item : cart) {
            item.display("  ");
            total += item.getPrice();
        }

        System.out.println("\nTotal: ₹" + total);
    }

    private static void proxyPattern(){
        VideoDownloader cacheVideoDownloader = new CachedVideoDownloader();
        System.out.println("User 1 tries to download the video.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");

        System.out.println();

        System.out.println("User 2 tries to download the same video again.");
        cacheVideoDownloader.downloadVideo("https://video.com/proxy-pattern");
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
        else if(type.equalsIgnoreCase(String.valueOf(CreatePatternType.PROTOTYPE))){
            prototypePattern();
        }
    }

    private static void decideStructuralPattern(String type){
        if(type.equalsIgnoreCase(String.valueOf(StructuralPatternType.ADAPTOR))){
            adaptorPatteren();
        }
        if(type.equalsIgnoreCase(String.valueOf(StructuralPatternType.DECORATIVE))){
            decorativePattern();
        }
        if(type.equalsIgnoreCase(String.valueOf(StructuralPatternType.COMPOSITE))){
            compositePatter();
        }else if(type.equalsIgnoreCase(String.valueOf(StructuralPatternType.PROXY))){
            proxyPattern();
        }
    }


    public static void main(String[] args) {
        //decideCreatePattern(String.valueOf(CreatePatternType.PROTOTYPE));
        decideStructuralPattern(String.valueOf(StructuralPatternType.PROXY));
    }
}