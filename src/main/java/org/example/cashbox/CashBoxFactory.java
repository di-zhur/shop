package org.example.cashbox;

import java.util.Set;

/**
 * Интерфейс фабрики создания касс.
 */
public interface CashBoxFactory {

    /**
     * Создать кассы
     *
     * @return кассы
     */
    Set<CashBox> createCashBoxes();

}
