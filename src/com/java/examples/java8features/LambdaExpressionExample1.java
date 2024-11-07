package com.java.examples.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaExpressionExample1 {

    public static void main(String[] args) {
        List<Product> productListlist = new ArrayList<Product>();
        productListlist.add(new Product(1, "Iphone 8", 17000f));
        productListlist.add(new Product(3, "Iphone 14", 65000f));
        productListlist.add(new Product(2, "Iphone 13", 25000f));
        productListlist.add(new Product(4, "Iphone X", 15000f));
        productListlist.add(new Product(5, "Iphone XI", 26000f));
        productListlist.add(new Product(6, "Iphone XI", 19000f));

        // using lambda to filter data
        List<Product> filteredList = productListlist.stream().filter(p -> p.price >= 20000).collect(Collectors.toList());

        filteredList.forEach(product -> System.out.println(product.name + " " + product.price));
    }

}
