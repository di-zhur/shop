package org.example.cashbox.state;

import org.example.cashbox.CashBox;
import org.example.cashbox.CashBoxHandler;

import java.util.Set;

/**
 * Состояние работы кассы.
 */
public abstract class CashBoxState {

    private final Set<CashBox> cashBoxes;
    private final char eventCode;
    private CashBoxHandler cashBoxHandler;

    public CashBoxState(Set<CashBox> cashBoxes, char eventCode) {
        this.cashBoxes = cashBoxes;
        this.eventCode = eventCode;
    }

    public void setHandler(CashBoxHandler cashBoxHandler) {
        this.cashBoxHandler = cashBoxHandler;
    }

    public abstract void handle();

    protected Set<CashBox> getCashBoxes() {
        return cashBoxes;
    }

    protected char getEventCode() {
        return eventCode;
    }

    protected CashBoxHandler getCashBoxHandler() {
        return cashBoxHandler;
    }

}
