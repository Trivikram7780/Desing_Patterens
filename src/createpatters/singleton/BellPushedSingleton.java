package createpatters.singleton;

public class BellPushedSingleton {

    //private constructor
    private BellPushedSingleton(){}

    //Static inner class to hold the singleton instance
    private static class Holder{
        private static final BellPushedSingleton INSTANCE = new BellPushedSingleton();
    }

    //public method to return the singleton instance
    public static BellPushedSingleton getInstance(){
        return Holder.INSTANCE;
    }
}
