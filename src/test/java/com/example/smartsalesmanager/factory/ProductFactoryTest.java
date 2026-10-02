package com.example.smartsalesmanager.factory;

import com.example.smartsalesmanager.model.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductFactoryTest {

    @Test
    void createsProductWithGivenFieldsAndTodaysDate() {
        Product p = ProductFactory.createProduct("Mouse", "Accessories", 499.9, 12);
        assertEquals("Mouse", p.getName());
        assertEquals("Accessories", p.getCategory());
        assertEquals(499.9, p.getPrice());
        assertEquals(12, p.getQuantity());
        assertEquals(LocalDate.now(), p.getTransactionDate());
    }
}
