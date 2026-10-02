package com.example.smartsalesmanager.factory;

import com.example.smartsalesmanager.model.Product;

public class ProductFactory {

    public static Product createProduct(String name, String category, double price, int quantity) {
        return new Product(name, category, price, quantity);
    }
}
