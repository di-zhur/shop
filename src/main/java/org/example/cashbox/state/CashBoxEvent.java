package org.example.cashbox.state;

/**
 * События работы кассы.
 */
public enum CashBoxEvent {

    PUSH_CUSTOMER,
    REMOVE_CUSTOMER;

    public static CashBoxEvent of(char eventCode) {
        switch (eventCode) {
            case 'A':
                return PUSH_CUSTOMER;
            case '1':
            case '2':
            case '3':
            case '4':
                return REMOVE_CUSTOMER;
            default:
                throw new IllegalArgumentException("Невалидное событие CashBoxEvent: " + eventCode);
        }
    }

}
