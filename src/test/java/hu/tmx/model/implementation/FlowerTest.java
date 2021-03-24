package hu.tmx.model.implementation;

import hu.tmx.model.MaintenanceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private static final double BASIC_PRICE = Flower.BASIC_PRICE;
    private static final double PRICE_MULTIPLIER = Flower.PRICE_MULTIPLIER;
    private static Flower testFlowerLily;
    private static Flower testFlowerPalm155WeeksOld;
    private static Flower testFlowerCactus156WeeksOld;
    private static Flower testFlowerJapaneseMaple200WeeksOld;

    @BeforeEach
    void setUp() {
        testFlowerLily = new Flower("Lily", 8);
        testFlowerPalm155WeeksOld = new Flower("Palm", 155);
        testFlowerCactus156WeeksOld = new Flower("Cactus", 156);
        testFlowerJapaneseMaple200WeeksOld = new Flower("Japanese Maple", 200);
    }

    @Test
    void GetAgeInWeeks_TestFlowerAgeIs8Weeks_Return8() {
        assertEquals(8, testFlowerLily.getAgeInWeeks());
    }

    @Test
    void GetLastMaintenanceDate_TestFlowerNeverMaintainedBefore_ReturnNull() {
        assertNull(testFlowerLily.getLastMaintenanceDate());
    }

    @Test
    void GetLastMaintenanceDate_TestFlowerMaintainedOnSpecificDate_ReturnSpecificDate() {
        LocalDate maintenanceDate = LocalDate.now().minus(Period.ofWeeks(52));
        testFlowerLily.maintain(maintenanceDate);
        assertEquals(maintenanceDate, testFlowerLily.getLastMaintenanceDate());
    }

    @Test
    void GetPrice_CalculatePriceOfTestFlowerInPlace_CalculateInPlaceMatchesWithGetPriceMethod() {
        int ageInWeeks = testFlowerLily.getAgeInWeeks();
        double price = BASIC_PRICE + ageInWeeks * PRICE_MULTIPLIER;

        assertEquals(price, testFlowerLily.getPrice());
    }

    @Test
    void NeedMaintenance_TestFlowerHasNoMaintenanceDayAndHasAge155Weeks_ReturnFalse() {
        assertFalse(testFlowerPalm155WeeksOld.needMaintenance());
    }

    @Test
    void NeedMaintenance_TestFlowerHasNoMaintenanceDayAndHasAge156Weeks_ReturnTrue() {
        assertTrue(testFlowerCactus156WeeksOld.needMaintenance());
    }

    @Test
    void NeedMaintenance_TestFlowerMaintained155WeeksAgoAndHasAge200Weeks_ReturnFalse() {
        LocalDate dateOfMaintenance = LocalDate.now().minus(Period.ofWeeks(155));
        testFlowerJapaneseMaple200WeeksOld.maintain(dateOfMaintenance);
        assertFalse(testFlowerJapaneseMaple200WeeksOld.needMaintenance());
    }

    @Test
    void NeedMaintenance_TestFlowerMaintained156WeeksAgoAndHasAge200Weeks_ReturnTrue() {
        LocalDate dateOfMaintenance = LocalDate.now().minus(Period.ofWeeks(156));
        testFlowerJapaneseMaple200WeeksOld.maintain(dateOfMaintenance);
        assertTrue(testFlowerJapaneseMaple200WeeksOld.needMaintenance());
    }

    @Test
    void GetMaintenanceType_TestFlowerWithMaintenanceTypeOfWATERING_MatchesWithMaintenanceTypeOfWATERING() {
        Assertions.assertEquals(MaintenanceType.WATERING, testFlowerLily.getMaintenanceType());
    }

}