package org.example.cashbox;

/**
 * Интерфейс объекта 'Касса'.
 */
public interface CashBox {

    /**
     * Максимальный размер очереди кассы
     */
    int MAX_QUEUE_SIZE = 20;

    /**
     * Получить номер кассы в формете типа char
     *
     * @return номер кассы в формете типа char
     */
    char getCharNumber();

    /**
     * Получить коэффициент загрузки кассы
     *
     * @return коэффициент загрузки кассы
     */
    double getLoadFactor();

    /**
     * Добавить клиента в очередь кассы
     */
    void push();

    /**
     * Удалить клиента из очереди
     *
     * @return идентификатор клиента
     */
    Long poll();

    /**
     * Получить размер очереди
     *
     * @return размер очереди
     */
    int getQueueSize();

}
