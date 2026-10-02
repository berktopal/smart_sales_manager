package com.example.smartsalesmanager.manager;

import com.example.smartsalesmanager.model.Product;
import com.example.smartsalesmanager.observer.StockObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductManager {

    private static ProductManager instance;
    private final List<Product> products = new ArrayList<>();
    private final StockObserver stockObserver;

    private ProductManager() {
        this.stockObserver = new StockObserver();
    }

    public static synchronized ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        stockObserver.checkStock(product);
    }

    public void deleteProduct(Long id) {
        // Objects.equals: henüz kaydedilmemiş (id'si null) ürünlerde NullPointerException olmaz
        products.removeIf(p -> Objects.equals(p.getId(), id));
    }

    // Dışarıya salt-okunur görünüm: liste sadece add/delete ile değişebilir
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
