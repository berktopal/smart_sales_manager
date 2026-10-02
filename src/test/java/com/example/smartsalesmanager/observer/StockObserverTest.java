package com.example.smartsalesmanager.observer;

import com.example.smartsalesmanager.factory.ProductFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockObserverTest {

    private final StockObserver observer = new StockObserver();

    @Test
    void flagsLowStock() {
        assertTrue(observer.checkStock(ProductFactory.createProduct("Cable", "Accessories", 50, 4)));
    }

    @Test
    void doesNotFlagSufficientStock() {
        assertFalse(observer.checkStock(ProductFactory.createProduct("Cable", "Accessories", 50, StockObserver.LOW_STOCK_THRESHOLD)));
    }
}
