package ru.first.product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private  Map<String, Product> products = new HashMap<>();

    public ProductService() {

        products.put("Kitchen", new Product("Kitchen", 2000, "House"));
        products.put("morbius", new Product("morbius", 999, "morbius"));
        products.put("Table", new Product("Table", 9000, "House"));
        products.put("bon", new Product("bon", 66, "bon"));
    }


    public synchronized Map<String, Product> getAll() {
        return products;
    }

    public synchronized  Product get(String name) {
        return products.get(name);
    }


    public synchronized Map<String, Product> getByNameAndCategory(String name, String category) {
        return null;
    }


    public synchronized boolean delete(String name) {
        return false;
    }


    public  synchronized void add(Product product) {
        products.put(product.getName(), product);
    }

}
