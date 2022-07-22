package factory;

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
    public Car produceCar(String name) {
        Car car = null;
        if( name.equalsIgnoreCase("Sonata")) {
            car = new Sonata();
        }
        else if( name.equalsIgnoreCase("Grandeur")) {
            car = new Grandeur();
        }
        else if( name.equalsIgnoreCase("Genesis")) {
            car = new Genesis();
        }
        return car;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        CarTest test = new CarTest();
        Car car = test.produceCar("Sonata");
        Car car2 = test.produceCar("grandeur");
        Car car3 = test.produceCar("genesis");
        System.out.println(car);
        System.out.println(car2);
        System.out.println(car3);
    }
}
