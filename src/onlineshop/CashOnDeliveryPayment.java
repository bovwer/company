
        package onlineshop;

import java.util.Scanner;

/**
 * Класс оплаты наличными при получении.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class CashOnDeliveryPayment implements IPayment {

    /** Поле для хранения адреса доставки */
    private String deliveryAddress;

    /**
     * Создает способ оплаты при получении с заданным адресом.
     * @param deliveryAddress адрес доставки
     */
    public CashOnDeliveryPayment(String deliveryAddress) {
        this.setDeliveryAddress(deliveryAddress);
    }

    /**
     * Создает способ оплаты при получении путем ввода с консоли.
     */
    public CashOnDeliveryPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите адрес доставки: ");
        this.setDeliveryAddress(sc.nextLine());
    }

    /**
     * Возвращает значение поля {@link CashOnDeliveryPayment#deliveryAddress}.
     * @return адрес доставки
     */
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    /**
     * Устанавливает значение поля {@link CashOnDeliveryPayment#deliveryAddress}.
     * @param deliveryAddress адрес доставки
     */
    public void setDeliveryAddress(String deliveryAddress) {
        if (deliveryAddress == null || deliveryAddress.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.deliveryAddress = deliveryAddress;
    }

    /**
     * Регистрирует оплату наличными курьеру при получении.
     * @param amount сумма платежа
     */
    @Override
    public void pay(double amount) {
        if (amount <= 0)
            System.out.println("Недопустимое значение!");
        else
            System.out.printf("Оплата %.2f руб. наличными при доставке по адресу [%s] подтверждена.%n",
                    amount, deliveryAddress);
    }

    /**
     * Возвращает строковое представление способа оплаты.
     * @return описание оплаты наличными
     */
    @Override
    public String toString() {
        return String.format("Наличными при получении (адрес: %s)", deliveryAddress);
    }
}