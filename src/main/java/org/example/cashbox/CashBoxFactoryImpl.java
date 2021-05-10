package org.example.cashbox;

import java.util.Set;

/**
 * Реализация фабрики создания касс.
 */
public class CashBoxFactoryImpl implements CashBoxFactory {

    /**
     * Создать кассы
     *
     * @return кассы
     */
    @Override
    public Set<CashBox> createCashBoxes() {
        return Set.of(
                CashBoxDirs.SIMPLE_CASH_BOX_FIRST,
                CashBoxDirs.SIMPLE_CASH_BOX_SECOND,
                CashBoxDirs.SIMPLE_CASH_BOX_THIRD,
                CashBoxDirs.SIMPLE_CASH_BOX_FOURTH
        );
    }


    private static class CashBoxDirs {

        /**
         * Касса №1, работает стажер и он способен обслужить только 10 покупателей в час.
         */
        static final SimpleCashBox SIMPLE_CASH_BOX_FIRST = new SimpleCashBox('1', 10);

        /**
         * Касса №2, специалист со скоростью 13 покупателей в час.
         */
        static final SimpleCashBox SIMPLE_CASH_BOX_SECOND = new SimpleCashBox('2', 13);

        /**
         * Касса №3, 15 покупателей в час.
         */
        static final SimpleCashBox SIMPLE_CASH_BOX_THIRD = new SimpleCashBox('3', 15);

        /**
         * Касса №4, 15 покупателей в час.
         */
        static final SimpleCashBox SIMPLE_CASH_BOX_FOURTH = new SimpleCashBox('4', 17);

        private CashBoxDirs() {
        }

    }
}