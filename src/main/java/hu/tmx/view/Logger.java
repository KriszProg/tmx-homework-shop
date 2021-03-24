package hu.tmx.view;

import hu.tmx.model.abstraction.Maintainable;
import hu.tmx.model.abstraction.Product;

import java.time.LocalDate;

public class Logger {

    public void displayProductInfo(Product product) {
        System.out.println(product);
    }

    public void displayRefundInfo(Product product, double refundPrice, LocalDate dateOfSale) {
        String basicRefundInfo = getBasicRefundInfo(product, dateOfSale);
        System.out.println(basicRefundInfo + refundPrice);
    }

    public void displayNotRefundable(Product product, LocalDate dateOfSale) {
        String basicRefundInfo = getBasicRefundInfo(product, dateOfSale);
        System.out.println(basicRefundInfo + "Product is not refundable!");
    }

    private String getBasicRefundInfo(Product product, LocalDate dateOfSale) {
        return "Product: " + product + " | Date of sale: " + dateOfSale + " | Refund price on " + LocalDate.now() + ": ";
    }

    public void displayMaintenanceInfo(Product product, boolean needMaintenance) {
        String basicMaintenanceInfo = getBasicMaintenanceInfo(product, needMaintenance);
        if (needMaintenance) {
            System.out.println(basicMaintenanceInfo + " | Maintenance Type: " + ((Maintainable) product).getMaintenanceType());
        } else {
            System.out.println(basicMaintenanceInfo);
        }
    }

    private String getBasicMaintenanceInfo(Product product, boolean needMaintenance) {
        return "Product: " + product + " | Need maintenance: " + needMaintenance;
    }
}
