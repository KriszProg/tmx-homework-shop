package hu.tmx.controller;

import hu.tmx.controller.service.StockService;
import hu.tmx.model.abstraction.Maintainable;
import hu.tmx.model.abstraction.Product;
import hu.tmx.model.abstraction.Refundable;
import hu.tmx.view.Logger;

import java.time.LocalDate;
import java.util.List;

public class ShopController {
    private final StockService stockService;
    private final Logger logger;

    public ShopController(StockService stockService, Logger logger) {
        this.stockService = stockService;
        this.logger = logger;
    }

    public void addProductToStock(Product product) {
        stockService.addProduct(product);
    }

    public void displayProductInfoOfStock() {
        List<Product> productList = stockService.getStockList();
        for (Product product : productList) {
            logger.displayProductInfo(product);
        }
    }

    public void displayRefundPriceOfProduct(Product product, LocalDate dateOfSale) {
        if (product instanceof Refundable) {
            double refundPrice = ((Refundable) product).getRefundPrice(dateOfSale);
            logger.displayRefundInfo(product, refundPrice, dateOfSale);
        } else {
            logger.displayNotRefundable(product, dateOfSale);
        }
    }

    public void displayMaintenanceReport() {
        for (Product product : stockService.getStockList() ) {
            if (product instanceof Maintainable) {
                logger.displayMaintenanceInfo(product, ((Maintainable) product).needMaintenance());
            }
        }
    }
}
