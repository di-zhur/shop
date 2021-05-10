package org.example.cashbox;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Реализация объекта 'Касса'.
 */
public class SimpleCashBox implements CashBox {
    private static final AtomicLong customerIdAtomicLong = new AtomicLong(0);
    private final char charNumber;
    private final int bandwidth;
    private final Queue<Long> queue;

    /**
     * Конструктор объекта 'Касса'
     *
     * @param charNumber номер кассы
     * @param bandwidth  пропускная способность чел/час
     */
    public SimpleCashBox(char charNumber, int bandwidth) {
        this.charNumber = charNumber;
        this.bandwidth = bandwidth;
        this.queue = new ArrayDeque<>(CashBox.MAX_QUEUE_SIZE);
    }

    /**
     * Получить номер кассы в формете типа char
     *
     * @return номер кассы в формете типа char
     */
    @Override
    public char getCharNumber() {
        return this.charNumber;
    }

    /**
     * Получить коэффициент загрузки кассы
     *
     * @return коэффициент загрузки кассы
     */
    @Override
    public double getLoadFactor() {
        var queueSize = queue.size();
        return (double) bandwidth / (queueSize == 0 ? 1 : queueSize);
    }

    /**
     * Добавить клиента в очередь кассы
     */
    @Override
    public void push() {
        var customerId = customerIdAtomicLong.incrementAndGet();
        queue.add(customerId);
    }

    /**
     * Удалить клиента из очереди
     *
     * @return идентификатор клиента
     */
    @Override
    public Long poll() {
        return queue.poll();
    }

    /**
     * Получить размер очереди
     *
     * @return размер очереди
     */
    @Override
    public int getQueueSize() {
        return queue.size();
    }

}