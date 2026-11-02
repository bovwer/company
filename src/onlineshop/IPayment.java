
        package onlineshop;

/**
 * Интерфейс стратегии оплаты заказа.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public interface IPayment {

    /**
     * Выполняет оплату указанной суммы.
     * @param amount сумма к оплате
     */
    void pay(double amount);
}