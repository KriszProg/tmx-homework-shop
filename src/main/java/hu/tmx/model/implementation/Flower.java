package hu.tmx.model.implementation;

import hu.tmx.model.MaintenanceType;
import hu.tmx.model.abstraction.Maintainable;
import hu.tmx.model.abstraction.Product;

import java.time.LocalDate;
import java.time.Period;

import static java.time.temporal.ChronoUnit.WEEKS;

public class Flower extends Product implements Maintainable {
    public static final double BASIC_PRICE = 1000;
    public static final double PRICE_MULTIPLIER = 2;
    public static final int MAINTENANCE_PERIOD_IN_WEEKS = 156;
    public static final MaintenanceType MAINTENANCE_TYPE = MaintenanceType.WATERING;

    private final LocalDate plantingDate;
    private LocalDate lastMaintenanceDate;

    public Flower(String name, int ageInWeeks) {
        super(name);
        this.plantingDate = LocalDate.now().minus(Period.ofWeeks(ageInWeeks));
    }

    public int getAgeInWeeks() {
        return (int) WEEKS.between(plantingDate, LocalDate.now());
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    private void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    @Override
    public double getPrice() {
        return BASIC_PRICE + getAgeInWeeks() * PRICE_MULTIPLIER;
    }

    @Override
    public boolean needMaintenance() {
        if (lastMaintenanceDate != null) {
            return (WEEKS.between(lastMaintenanceDate, LocalDate.now()) / MAINTENANCE_PERIOD_IN_WEEKS) >= 1;
        }
        return (getAgeInWeeks() / MAINTENANCE_PERIOD_IN_WEEKS) >= 1;
    }

    @Override
    public MaintenanceType getMaintenanceType() {
        return MAINTENANCE_TYPE;
    }

    @Override
    public void maintain(LocalDate dateOfMaintain) {
        setLastMaintenanceDate(dateOfMaintain);
    }

    @Override
    public String toString() {
        return "Flower {" +
                "ageInWeeks=" + getAgeInWeeks() + " week(s)" +
                ", name=" + getName() +
                ", price=" + getPrice() +
                '}';
    }
}
