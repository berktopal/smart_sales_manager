package com.example.smartsalesmanager.observer;

import com.example.smartsalesmanager.helper.LogHelper;
import com.example.smartsalesmanager.model.Product;

public class StockObserver {

    public static final int LOW_STOCK_THRESHOLD = 5;

    /** Stok kritik seviyenin altındaysa uyarı loglar ve true döner. */
    public boolean checkStock(Product product) {
        if (product.getQuantity() < LOW_STOCK_THRESHOLD) {
            LogHelper.warn("Stock of " + product.getName() + " is critically low (" + product.getQuantity() + ")");
            return true;
        }
        return false;
    }
}
