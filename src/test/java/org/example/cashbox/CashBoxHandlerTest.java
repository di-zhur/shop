package org.example.cashbox;

import org.example.cashbox.exception.CashBoxException;
import org.junit.Test;

public class CashBoxHandlerTest {
    private final CashBoxFactory cashBoxFactory = new CashBoxFactoryImpl();

    private static final char EVENT_CODE_A = 'A';
    private static final char EVENT_CODE_1 = '1';
    private static final char EVENT_CODE_2 = '2';
    private static final char EVENT_CODE_3 = '3';
    private static final char EVENT_CODE_4 = '4';

    @Test
    public void testPushCustomerCashBox() {
        CashBoxHandler cashBoxHandler = new CashBoxHandler(cashBoxFactory);
        pushCustomersCashBox(cashBoxHandler);
    }

    @Test
    public void testRemoveCustomerCashBox() {
        CashBoxHandler cashBoxHandler = new CashBoxHandler(cashBoxFactory);
        pushCustomersCashBox(cashBoxHandler);

        cashBoxHandler.initState(EVENT_CODE_1);
        cashBoxHandler.handle();

        cashBoxHandler.initState(EVENT_CODE_2);
        cashBoxHandler.handle();

        cashBoxHandler.initState(EVENT_CODE_3);
        cashBoxHandler.handle();

        cashBoxHandler.initState(EVENT_CODE_4);
        cashBoxHandler.handle();

        cashBoxHandler.initState(EVENT_CODE_1);
        cashBoxHandler.handle();
    }

    @Test(expected = CashBoxException.class)
    public void testOverflowCashBoxes() {
        CashBoxHandler cashBoxHandler = new CashBoxHandler(cashBoxFactory);
        cashBoxHandler.initState(EVENT_CODE_A);
        for (int i = 0; i <= 100; i++) {
            cashBoxHandler.handle();
        }
    }

    private void pushCustomersCashBox(CashBoxHandler cashBoxHandler) {
        cashBoxHandler.initState(EVENT_CODE_A);
        for (int i = 0; i < 80; i++) {
            cashBoxHandler.handle();
        }
    }
}
