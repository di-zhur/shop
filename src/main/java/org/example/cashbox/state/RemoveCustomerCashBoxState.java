package org.example.cashbox.state;

import org.example.cashbox.CashBox;

import java.text.MessageFormat;
import java.util.Set;

/**
 * Состояние при котором осуществляется удаление клиента из очереди кассы.
 */
public class RemoveCustomerCashBoxState extends CashBoxState {

    private final char eventCode;

    public RemoveCustomerCashBoxState(Set<CashBox> cashBoxes, char eventCode) {
        super(cashBoxes, eventCode);
        this.eventCode = eventCode;
    }

    @Override
    public void handle() {
        var cashBox = getCashBoxes()
                .stream()
                .filter(it -> it.getCharNumber() == eventCode)
                .findAny()
                .orElseThrow();

        System.out.println(MessageFormat.format("На кассе {0} очередь {1} клиент.",
                cashBox.getCharNumber(), cashBox.getQueueSize()));
        var customerId = cashBox.poll();
        System.out.println(MessageFormat.format("Кассу {0} покинул клиент {1}. Размер очереди {2}.",
                cashBox.getCharNumber(), customerId, cashBox.getQueueSize()));
    }

}
