package org.example.cashbox.state;

import org.example.cashbox.CashBox;
import org.example.cashbox.exception.CashBoxException;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.Set;

/**
 * Состояние при котором осуществляется поиск оптимальной кассы для клиента и добавление его в очередь.
 */
public class PushCustomerCashBoxState extends CashBoxState {

    public PushCustomerCashBoxState(Set<CashBox> cashDesks, char eventCode) {
        super(cashDesks, eventCode);
    }

    @Override
    public void handle() {
        var cashBoxOptional = getCashBoxes()
                .stream()
                .filter(it -> it.getQueueSize() < CashBox.MAX_QUEUE_SIZE)
                .peek(it -> System.out.println(MessageFormat.format("Касса {0}, коэффициент загрузки {1}, размер очереди {2}.",
                        it.getCharNumber(), it.getLoadFactor(), it.getQueueSize())))
                .max(Comparator.comparingDouble(CashBox::getLoadFactor));

        if (cashBoxOptional.isEmpty()) {
            throw new CashBoxException("Очереди всех касс заполнены");
        }

        var cashBox = cashBoxOptional.get();
        System.out.println(MessageFormat.format("Клиенту рекомендуется касса: {0} -> {1}",
                getEventCode(), cashBox.getCharNumber()));
        cashBox.push();
        System.out.println(MessageFormat.format("Добавление клиента в очередь кассы: {0} -> {1}",
                getEventCode(), cashBox.getCharNumber()));
    }

}
