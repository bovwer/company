
        package onlineshop;

import java.util.Scanner;

/**
 * Класс оплаты через платежную систему PayPal.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class PayPalPayment implements IPayment {

    /** Поле для хранения email аккаунта PayPal */
    private String accountEmail;

    /**
     * Создает способ оплаты PayPal с заданным email.
     * @param accountEmail электронная почта аккаунта PayPal
     */
    public PayPalPayment(String accountEmail) {
        this.setAccountEmail(accountEmail);
    }

    /**
     * Создает способ оплаты PayPal путем ввода с консоли.
     */
    public PayPalPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите email PayPal: ");
        this.setAccountEmail(sc.nextLine());
    }

    /**
     * Возвращает значение поля {@link PayPalPayment#accountEmail}.
     * @return email аккаунта PayPal
     */
    public String getAccountEmail() {
        return this.accountEmail;
    }

    /**
     * Устанавливает значение поля {@link PayPalPayment#accountEmail}.
     * @param accountEmail email аккаунта PayPal
     */
    public void setAccountEmail(String accountEmail) {
        if (accountEmail == null || accountEmail.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.accountEmail = accountEmail;
    }

    /**
     * Выполняет оплату через PayPal.
     * @param amount сумма платежа
     */
    @Override
    public void pay(double amount) {
        if (amount <= 0)
            System.out.println("Недопустимое значение!");
        else
            System.out.printf("Оплата %.2f руб. через PayPal [%s] успешно выполнена.%n", amount, accountEmail);
    }

    /**
     * Возвращает строковое представление способа оплаты.
     * @return описание оплаты PayPal
     */
    @Override
    public String toString() {
        return String.format("PayPal (%s)", accountEmail);
    }
}