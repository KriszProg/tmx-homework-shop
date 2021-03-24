package hu.tmx.model.abstraction;

import java.time.LocalDate;

public interface Refundable {
    double getRefundPrice(LocalDate dateOfSale);
}
