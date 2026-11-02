
        package onlineshop;

/**
 * Класс Покупатель интернет-магазина.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class Customer extends User {

    /** Поле для хранения массива истории заказов покупателя */
    private Order[] orderHistory;

    /**
     * Создает покупателя с заданными параметрами.
     * @param id идентификатор
     * @param name имя покупателя
     * @param email электронная почта
     */
    public Customer(int id, String name, String email) {
        super(id, name, email);
        this.orderHistory = new Order[0];
    }

    /**
     * Создает покупателя путем ввода данных с консоли.
     */
    public Customer() {
        super();
        this.orderHistory = new Order[0];
    }

    /**
     * Возвращает значение поля {@link Customer#orderHistory}.
     * @return массив заказов покупателя
     */
    public Order[] getOrderHistory() {
        return this.orderHistory;
    }

    /**
     * Устанавливает значение поля {@link Customer#orderHistory}.
     * @param orderHistory массив заказов
     */
    public void setOrderHistory(Order[] orderHistory) {
        if (orderHistory == null)
            System.out.println("Недопустимое значение!");
        else
            this.orderHistory = orderHistory;
    }

    /**
     * Добавляет оформленный заказ в историю заказов покупателя.
     * @param order новый заказ
     */
    public void addOrderToHistory(Order order) {
        if (order == null) {
            System.out.println("Недопустимое значение!");
            return;
        }
        Order[] temp = new Order[this.orderHistory.length + 1];
        for (int i = 0; i < this.orderHistory.length; i++) {
            temp[i] = this.orderHistory[i];
        }
        temp[this.orderHistory.length] = order;
        this.orderHistory = temp;
    }

    /**
     * Возвращает роль покупателя.
     * @return строка "Покупатель"
     */
    @Override
    public String getRole() {
        return "Покупатель";
    }

    /**
     * Возвращает строковое представление покупателя.
     * @return строка с данными покупателя и числом заказов
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" | Заказов в истории: %d", orderHistory.length);
    }
}