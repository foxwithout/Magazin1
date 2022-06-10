package ru.first.basket;

import ru.first.product.Product;

import java.util.List;

public class BasketService {


    public static void removeFromBasket(int id, List<Product> myBasket) {
        if(myBasket !=null) {
            myBasket.remove(id);
        }
    }
}
