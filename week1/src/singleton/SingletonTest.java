package singleton;

class Singleton {
    private static Singleton instance = new Singleton();
    
    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instanceA = Singleton.getInstance();
        Singleton instanceB = Singleton.getInstance();
        System.out.println(instanceA == instanceB);
    }
}
