package com.example.smartsalesmanager.manager;

import com.example.smartsalesmanager.factory.ProductFactory;
import com.example.smartsalesmanager.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void isSingleton() {
        assertSame(ProductManager.getInstance(), ProductManager.getInstance());
    }

    @Test
    void deleteDoesNotFailWhenListContainsUnsavedProducts() {
        ProductManager manager = ProductManager.getInstance();
        Product unsaved = ProductFactory.createProduct("Keyboard", "Accessories", 900, 10); // id == null
        manager.addProduct(unsaved);
        int before = manager.getProducts().size();

        // Eskiden p.getId().equals(id) -> NullPointerException
        assertDoesNotThrow(() -> manager.deleteProduct(42L));
        assertEquals(before, manager.getProducts().size());
    }

    @Test
    void productListCannotBeModifiedFromOutside() {
        ProductManager manager = ProductManager.getInstance();
        assertThrows(UnsupportedOperationException.class,
                () -> manager.getProducts().add(ProductFactory.createProduct("X", "Y", 1, 1)));
    }
}
