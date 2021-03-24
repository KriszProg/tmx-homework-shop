package hu.tmx.controller.service;

import hu.tmx.model.abstraction.Product;

import java.util.ArrayList;
import java.util.List;

public class StockService {
    private final List<Product> stockList;

    public StockService() {
        stockList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        stockList.add(product);
    }

    public List<Product> getStockList() {
        return stockList;
    }

}
