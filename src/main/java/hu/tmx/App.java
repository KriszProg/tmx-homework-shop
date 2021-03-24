package hu.tmx;

import hu.tmx.controller.ShopController;
import hu.tmx.controller.service.StockService;
import hu.tmx.model.implementation.Flower;
import hu.tmx.model.implementation.Shoes;
import hu.tmx.view.Logger;

public class App {
    public static void main( String[] args ) {
        ShopController shopController = new ShopController(new StockService(), new Logger());

        shopController.addProductToStock(new Shoes(44, "Adidas"));
        shopController.addProductToStock(new Shoes(40.5, "Reebok"));
        shopController.addProductToStock(new Shoes(38, "Nike"));
        shopController.addProductToStock(new Flower("Lily", 8));
        shopController.addProductToStock(new Flower("Hyacinth", 1));
        shopController.displayProductInfoOfStock();
    }
}
