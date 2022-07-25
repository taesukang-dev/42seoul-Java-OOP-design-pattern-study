package decorator;

interface Car {
    String name = null;
    public String getName();
}

class Hyundai implements Car{
    String name = "Hyundai";

    @Override
    public String getName() {
        return name;
    }
}

class Lexus implements Car{
    String name = "Lexus";

    @Override
    public String getName() {
        return name;
    }
}

interface Decorator {
    String name = null;
    public String getName();
}

class Color implements Decorator{
    String name = "Color";
    public Car car;

    public Color(Car car) {
        this.car = car;
    }

    @Override
    public String getName() {
        return car + " adding " + name;
    }
}

class Wheel implements Decorator{
    String name = "Wheel";
    public Car car;

    public Wheel(Car car) {
        this.car = car;
    }

    @Override
    public String getName() {
        return car.getName() + " adding " + name;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}

public class DecoratorUsingInterface {
    public static void main(String[] args) {
        Wheel w = new Wheel(new Hyundai());
        System.out.println(w.getName());
    }
}
