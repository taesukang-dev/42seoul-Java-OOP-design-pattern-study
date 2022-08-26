package composite;

import java.util.ArrayList;

abstract class ProductCategory {
    int id;
    String name;
    int price;
    public ProductCategory(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract void addProduct(ProductCategory product);
    public abstract void removeProduct(ProductCategory product);
    public abstract int getCount();
    public abstract String getName();
    public abstract int getPrice();
    public abstract int getId();
}

class Category extends ProductCategory {

    ArrayList<ProductCategory> store = new ArrayList<ProductCategory>();
    int cnt;

    public Category(int id, String name, int price) {
        super(id, name, price);
        cnt = 0;
    }

    @Override
    public void addProduct(ProductCategory product) {
        store.add(product);
    }

    @Override
    public void removeProduct(ProductCategory product) {
        if (cnt == 0)
            return ;
        store.remove(product);
    }

    @Override
    public int getCount() {
        for (ProductCategory productCategory : store) {
            cnt += productCategory.getCount();
        }
        return cnt;
    }

    @Override
    public String getName() {
        return store.toString();
    }

    @Override
    public int getPrice() {
        for (ProductCategory productCategory : store) {
            price += productCategory.getPrice();
        }
        return price;
    }

    @Override
    public int getId() {
        return id;
    }
}

class Product extends ProductCategory {

    public Product(int id, String name, int price) {
        super(id, name, price);
    }

    @Override
    public void addProduct(ProductCategory product) {
        return;
    }

    @Override
    public void removeProduct(ProductCategory product) {
        return;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getId() {
        return id;
    }
}


public class CompositeImpl {
    public static void main(String[] args) {
        ProductCategory womanCategory = new Category(1234, "Woman", 0);
        ProductCategory manCategory = new Category(5678, "Man", 0);

        ProductCategory clothesCategoryW = new Category(2345, "Clothes", 0);
        ProductCategory bagCategoryW = new Category(3456, "Bag", 0);
        ProductCategory shoesCategoryW = new Category(9876, "Shoes", 0);
        womanCategory.addProduct(clothesCategoryW);
        womanCategory.addProduct(bagCategoryW);
        womanCategory.addProduct(shoesCategoryW);

        ProductCategory clothesCategoryM = new Category(23450, "Clothes", 0);
        ProductCategory bagCategoryM = new Category(34560, "Bag", 0);
        ProductCategory shoesCategoryM = new Category(98760, "Shoes", 0);
        manCategory.addProduct(clothesCategoryM);
        manCategory.addProduct(bagCategoryM);
        manCategory.addProduct(shoesCategoryM);

        ProductCategory shoes1 = new Product(121, "Nike", 100000);
        ProductCategory shoes2 = new Product(122, "ADIDAS", 200000);
        ProductCategory shoes3 = new Product(123, "GUCCI", 300000);
        ProductCategory shoes4 = new Product(124, "BALENCIA", 400000);
        ProductCategory shoes5 = new Product(125, "PRADA", 500000);
        ProductCategory shoes6 = new Product(126, "BALLY", 600000);
        shoesCategoryW.addProduct(shoes1);
        shoesCategoryW.addProduct(shoes2);
        shoesCategoryW.addProduct(shoes3);
        shoesCategoryM.addProduct(shoes4);
        shoesCategoryM.addProduct(shoes5);
        shoesCategoryM.addProduct(shoes6);

        ProductCategory bag1 = new Product(121, "HERMES", 500000);
        ProductCategory bag2 = new Product(122, "LOUISVUITTON", 500000);
        ProductCategory bag3 = new Product(123, "GUCCI", 500000);
        ProductCategory bag4 = new Product(124, "BALENCIA", 500000);
        ProductCategory bag5 = new Product(125, "PRADA", 500000);
        ProductCategory bag6 = new Product(126, "MULBERRY", 500000);
        bagCategoryW.addProduct(bag1);
        bagCategoryW.addProduct(bag2);
        bagCategoryW.addProduct(bag3);
        bagCategoryM.addProduct(bag4);
        bagCategoryM.addProduct(bag5);
        bagCategoryM.addProduct(bag6);

        System.out.println(womanCategory.getCount());
        System.out.println(womanCategory.getPrice());
        System.out.println(manCategory.getCount());
        System.out.println(manCategory.getPrice());
    }
}
