package hu.tmx.model.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class ShoesTest {
    public static final double SMALLER_SIZE_PRICE = Shoes.SMALLER_SIZE_PRICE;
    public static final double BIGGER_SIZE_PRICE = Shoes.BIGGER_SIZE_PRICE;

    private static Shoes testShoes38Nike;
    private static Shoes testShoes40Reebok;
    private static Shoes testShoes44Adidas;

    @BeforeEach
    void setUp() {
        testShoes38Nike = new Shoes(38, "Nike");
        testShoes40Reebok = new Shoes(40, "Reebok");
        testShoes44Adidas = new Shoes(44, "Adidas");
    }

    @Test
    void GetSize_TestShoesWithSize44_Return44() {
        assertEquals(44, testShoes44Adidas.getSize());
    }

    @Test
    void GetBrandName_TestShoesWithBrandNameAdidas_ReturnAdidas() {
        assertEquals("Adidas", testShoes44Adidas.getBrandName());
    }

    @Test
    void GetPrice_TestShoesSizeSmallerThan40_ReturnSmallerSizePrice() {
        assertEquals(SMALLER_SIZE_PRICE, testShoes38Nike.getPrice());
    }

    @Test
    void GetPrice_TestShoesSizeExactly40_ReturnSmallerSizePrice() {
        assertEquals(SMALLER_SIZE_PRICE, testShoes40Reebok.getPrice());
    }

    @Test
    void GetPrice_TestShoesSizeGraterThan40_ReturnBiggerSizePrice() {
        assertEquals(BIGGER_SIZE_PRICE, testShoes44Adidas.getPrice());
    }

    @Test
    void GetRefundPrice_ElapsedDaysExactlyZero_ReturnFullPrice() {
        double fullPrice = testShoes44Adidas.getPrice();
        LocalDate dateOfSale = LocalDate.now().minus(Period.ofDays(0));
        double refundPrice = testShoes44Adidas.getRefundPrice(dateOfSale);
        assertEquals(fullPrice, refundPrice);
    }

    @Test
    void GetRefundPrice_ElapsedDaysIs1_ReturnHalfPrice() {
        double halfPrice = testShoes38Nike.getPrice() / 2;
        LocalDate dateOfSale = LocalDate.now().minus(Period.ofDays(1));
        double refundPrice = testShoes38Nike.getRefundPrice(dateOfSale);
        assertEquals(halfPrice, refundPrice);
    }

    @Test
    void GetRefundPrice_ElapsedDaysIs49_ReturnHalfPrice() {
        double halfPrice = testShoes40Reebok.getPrice() / 2;
        LocalDate dateOfSale = LocalDate.now().minus(Period.ofDays(49));
        double refundPrice = testShoes40Reebok.getRefundPrice(dateOfSale);
        assertEquals(halfPrice, refundPrice);
    }

    @Test
    void GetRefundPrice_ElapsedDaysExactly50_ReturnZero() {
        LocalDate dateOfSale = LocalDate.now().minus(Period.ofDays(50));
        double refundPrice = testShoes44Adidas.getRefundPrice(dateOfSale);
        assertEquals(0, refundPrice);
    }

    @Test
    void GetRefundPrice_ElapsedDaysGreaterThan50_ReturnZero() {
        LocalDate dateOfSale = LocalDate.now().minus(Period.ofDays(51));
        double refundPrice = testShoes38Nike.getRefundPrice(dateOfSale);
        assertEquals(0, refundPrice);
    }
}