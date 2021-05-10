package org.example.cashbox;

import org.example.cashbox.state.CashBoxEvent;
import org.example.cashbox.state.CashBoxState;
import org.example.cashbox.state.PushCustomerCashBoxState;
import org.example.cashbox.state.RemoveCustomerCashBoxState;

/**
 * Обработчик для взаимодействия с кассами.
 */
public class CashBoxHandler {

    private CashBoxState state;
    private final CashBoxFactory cashBoxFactory;

    public CashBoxHandler(CashBoxFactory cashBoxFactory) {
        this.cashBoxFactory = cashBoxFactory;
    }

    /**
     * Инициализировать состояние по коду события
     *
     * @param eventCode код события
     */
    public void initState(char eventCode) {
        var event = CashBoxEvent.of(eventCode);
        var cashBoxes = cashBoxFactory.createCashBoxes();
        if (event == CashBoxEvent.PUSH_CUSTOMER) {
            this.state = new PushCustomerCashBoxState(cashBoxes, eventCode);
        } else if (event == CashBoxEvent.REMOVE_CUSTOMER) {
            this.state = new RemoveCustomerCashBoxState(cashBoxes, eventCode);
        }
        this.state.setHandler(this);
    }

    /**
     * Запустить обработку события
     */
    public void handle() {
        if (this.state == null) {
            throw new IllegalStateException("Состояние не инициализировано");
        }
        this.state.handle();
    }

}
