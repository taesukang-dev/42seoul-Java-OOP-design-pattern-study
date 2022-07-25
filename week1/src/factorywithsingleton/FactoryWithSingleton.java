package factorywithsingleton;

abstract class Car {
    String productName;
    public String toString() {
        return productName;
    }
}

class Sonata extends Car {
    public Sonata() {
        productName = "Sonata";
    }
}

class Grandeur extends Car {
    public Grandeur() {
        productName = "Grandeur";
    }
}

class Genesis extends Car {

    public Genesis() {
        productName = "Genesis";
    }
}
class CarTest {
    private static Car instance;

    private static Car sonata = new Sonata();
    private static Car grandeur = new Grandeur();
    private static Car genesis = new Genesis();

    public Car getInstance(String name) { // prototype
        if( name.equalsIgnoreCase("Sonata")) {
            if (instance instanceof Sonata)
                return instance;
            else
                instance = new Sonata();
        }
        else if( name.equalsIgnoreCase("Grandeur")) {
            if (instance instanceof Grandeur)
                return instance;
            else
                instance = new Grandeur();
        }
        else if( name.equalsIgnoreCase("Genesis")) {
            if (instance instanceof Genesis)
                return instance;
            else
                instance = new Genesis();
        }
        return instance;
    }

    public Car getInstance2(String name) { // singleton
        if( name.equalsIgnoreCase("Sonata")) {
            return sonata;
        }
        else if( name.equalsIgnoreCase("Grandeur")) {
            return grandeur;
        }
        else if( name.equalsIgnoreCase("Genesis")) {
            return genesis;
        }
        return null;
    }
}

public class FactoryWithSingleton {
    public static void main(String[] args) {
        CarTest test = new CarTest();
        Car car = test.getInstance2("Sonata");
        Car car2 = test.getInstance2("grandeur");
        Car car3 = test.getInstance2("genesis");
        Car car4 = test.getInstance2("sonata");
        System.out.println(car);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car == car4);
    }
}
