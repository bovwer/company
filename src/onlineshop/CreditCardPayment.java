
        package onlineshop;

import java.util.Scanner;

/**
 * Класс оплаты банковской картой.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class CreditCardPayment implements IPayment {

    /** Поле для хранения номера карты */
    private String cardNumber;

    /**
     * Создает способ оплаты картой с заданным номером.
     * @param cardNumber номер банковской карты
     */
    public CreditCardPayment(String cardNumber) {
        this.setCardNumber(cardNumber);
    }

    /**
     * Создает способ оплаты картой путем ввода с консоли.
     */
    public CreditCardPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер карты: ");
        this.setCardNumber(sc.nextLine());
    }

    /**
     * Возвращает значение поля {@link CreditCardPayment#cardNumber}.
     * @return номер карты
     */
    public String getCardNumber() {
        return this.cardNumber;
    }

    /**
     * Устанавливает значение поля {@link CreditCardPayment#cardNumber}.
     * @param cardNumber номер карты
     */
    public void setCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.cardNumber = cardNumber;
    }

    /**
     * Выполняет оплату банковской картой.
     * @param amount сумма платежа
     */
    @Override
    public void pay(double amount) {
        if (amount <= 0)
            System.out.println("Недопустимое значение!");
        else
            System.out.printf("Оплата %.2f руб. банковской картой [%s] успешно выполнена.%n", amount, cardNumber);
    }

    /**
     * Возвращает строковое представление способа оплаты.
     * @return описание оплаты картой
     */
    @Override
    public String toString() {
        return String.format("Банковская карта (%s)", cardNumber);
    }
}