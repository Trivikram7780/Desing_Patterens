package createpatters.singleton;

public class LazySynchronizedSingleton {

    //Volatile object declaration
    public static volatile LazySynchronizedSingleton instance;

    //private constructor
    private LazySynchronizedSingleton(){}


    //Thread-safe method using double-checked locking
    public static LazySynchronizedSingleton getInstance(){
        if(instance == null){
            synchronized (LazySynchronizedSingleton.class){
                if(instance == null){
                    instance = new LazySynchronizedSingleton();
                }
            }
        }
        return instance;
    }

}
