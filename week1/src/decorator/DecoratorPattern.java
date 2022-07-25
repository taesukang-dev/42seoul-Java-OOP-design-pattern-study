package decorator;

abstract class Americano {
    String productName = "Americano";
    public String getName() {
        return productName;
    }
}

class Kenya extends Americano{
    public String getName() {
        productName = "Kenya" + productName;
        return productName;
    }
}

class Ethiopia extends Americano {
    public String getName() {
        productName = "Ethiopia" + productName;
        return productName;
    }
}

abstract class Decorations extends Americano {
    public abstract String getName();
}

class Milk extends Decorations{
    Americano americano;
    String name = "Milk";
    public Milk(Americano americano) {
        this.americano = americano;
    }
    public String getName() {
        return americano.getName() + " adding " + name;
    }
}
class MochaSyrup extends Decorations {
    Americano americano;
    String name = "Mocha Syrup ";

    public MochaSyrup(Americano americano) {
        this.americano = americano;
    }

    public String getName() {
        return americano.getName() + " adding " + name;
    }
}

class WhippedCream extends Decorations {

    String name = "Whipped Cream";
    Decorations decorations;

    public WhippedCream(Decorations decorations) {
        this.decorations = decorations;
    }

    public String getName() {
        return decorations.getName() + " adding " + name;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // KenyaAmericano
        // KenyaAmericano Adding Milk
        // KenyaAmericano Adding Milk Adding Mocha Syrup
        // EtiopiaAmericano Adding Milk Adding Mocha Syrup Adding WhippedCream
        Kenya k = new Kenya();
        Ethiopia e = new Ethiopia();
        Milk m = new Milk(k);
        WhippedCream wc = new WhippedCream(m);
        MochaSyrup ms = new MochaSyrup(m);
        System.out.println(ms.getName());
    }
}
