package hu.tmx.controller.service;

import hu.tmx.model.abstraction.Product;
import hu.tmx.model.implementation.Flower;
import hu.tmx.model.implementation.Shoes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {
    public static StockService testStockService;

    @BeforeEach
    void setUp() {
        testStockService = new StockService();
        testStockService.addProduct(new Shoes(44, "Adidas"));
        testStockService.addProduct(new Shoes(40.5, "Reebok"));
        testStockService.addProduct(new Shoes(38, "Nike"));
        testStockService.addProduct(new Flower("Lily", 8));
        testStockService.addProduct(new Flower("Hyacinth", 1));
    }

    @Test
    void AddProduct_TestStockListSizeIs6AfterAdding_TestStockListSizeMatchesWith6() {
        testStockService.addProduct(new Flower("Palm", 2));
        List<Product> testStockList = testStockService.getStockList();
        assertEquals(6, testStockList.size());
    }

    @Test
    void GetStockList_TestStockListWith5Products_TestStockListSizeMatchesWith5() {
        List<Product> testStockList = testStockService.getStockList();
        assertEquals(5, testStockList.size());
    }
}