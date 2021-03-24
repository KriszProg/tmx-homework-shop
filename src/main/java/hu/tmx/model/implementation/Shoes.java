package hu.tmx.model.implementation;

import hu.tmx.model.abstraction.Product;
import hu.tmx.model.abstraction.Refundable;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Shoes extends Product implements Refundable {
    public static final String NAME = "Shoes";
    public static final double SMALLER_SIZE_PRICE = 14000;
    public static final double BIGGER_SIZE_PRICE = 15000;

    private final double size;
    private final String brandName;

    public Shoes(double size, String brandName) {
        super(NAME);
        this.size = size;
        this.brandName = brandName;
    }

    public double getSize() {
        return size;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public double getPrice() {
        if (this.size > 40) {
            return BIGGER_SIZE_PRICE;
        } else {
            return SMALLER_SIZE_PRICE;
        }
    }

    @Override
    public double getRefundPrice(LocalDate dateOfSale) {
        int nrOfDaysElapsed = (int) DAYS.between(dateOfSale, LocalDate.now());
        if (nrOfDaysElapsed == 0) {
            return getPrice();
        }
        if (nrOfDaysElapsed < 50) {
            return getPrice()/2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Shoes {" +
                "size=" + getSize() +
                ", brandName=" + getBrandName() +
                ", name=" + getName() +
                ", price=" + getPrice() +
                '}';
    }
}
