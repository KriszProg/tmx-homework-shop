package hu.tmx.model.abstraction;

import hu.tmx.model.MaintenanceType;

import java.time.LocalDate;

public interface Maintainable {
    boolean needMaintenance();
    MaintenanceType getMaintenanceType();
    void maintain(LocalDate dateOfMaintain);

}
