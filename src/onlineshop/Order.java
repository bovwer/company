
        package onlineshop;
/**
 * Класс Заказ покупателя в интернет-магазине.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class Order {
    /** Поле для хранения покупателя */
    private Customer customer;
    /** Поле для хранения массива позиций заказа */
    private OrderItem[] items;
    /** Поле для хранения способа оплаты */
    private IPayment payment;
    /**
     * Создает заказ для покупателя с выбранным способом оплаты.
     * @param customer покупатель
     * @param payment способ оплаты
     */
    public Order(Customer customer, IPayment payment) {
        this.setCustomer(customer);
        this.setPayment(payment);
        this.items = new OrderItem[0];
    }
    /**
     * Создает пустой заказ по умолчанию.
     */
    public Order() {
        this.items = new OrderItem[0];
    }
    /**
     * Возвращает значение поля {@link Order#customer}.
     * @return объект покупателя
     */
    public Customer getCustomer() {
        return this.customer;
    }
    /**
     * Устанавливает значение поля {@link Order#customer}.
     * @param customer объект покупателя
     */
    public void setCustomer(Customer customer) {
        if (customer == null)
            System.out.println("Недопустимое значение!");
        else
            this.customer = customer;
    }
    /**
     * Возвращает значение поля {@link Order#items}.
     * @return массив позиций заказа
     */
    public OrderItem[] getItems() {
        return this.items;
    }
    /**
     * Устанавливает значение поля {@link Order#items}.
     * @param items массив позиций заказа
     */
    public void setItems(OrderItem[] items) {
        if (items == null)
            System.out.println("Недопустимое значение!");
        else
            this.items = items;
    }
    /**
     * Возвращает значение поля {@link Order#payment}.
     * @return стратегия оплаты
     */
    public IPayment getPayment() {
        return this.payment;
    }
    /**
     * Устанавливает значение поля {@link Order#payment}.
     * @param payment стратегия оплаты
     */
    public void setPayment(IPayment payment) {
        if (payment == null)
            System.out.println("Недопустимое значение!");
        else
            this.payment = payment;
    }
    /**
     * Добавляет новую позицию товара в массив позиций заказа.
     * @param item позиция заказа
     */
    public void addItem(OrderItem item) {
        if (item == null) {
            System.out.println("Недопустимое значение!");
            return;
        }
        OrderItem[] temp = new OrderItem[this.items.length + 1];
        for (int i = 0; i < this.items.length; i++) {
            temp[i] = this.items[i];
        }
        temp[this.items.length] = item;
        this.items = temp;
    }
    /**
     * Вычисляет общую стоимость всех позиций заказа.
     * @return итоговая сумма заказа
     */
    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i].getTotalPrice();
        }
        return sum;
    }
    /**
     * Оформляет заказ, проводит оплату и сохраняет заказ в истории покупателя.
     */
    public void processOrder() {
        if (customer == null || payment == null || items.length == 0) {
            System.out.println("Невозможно оформить заказ: не заполнены данные или корзина пуста!");
            return;
        }
        double total = getTotal();
        System.out.println("\n--- Оформление заказа для: " + customer.getName() + " ---");
        payment.pay(total);
        customer.addOrderToHistory(this);
        System.out.println("Заказ успешно оформлен и добавлен в историю покупателя.");
    }
    /**
     * Возвращает строковое представление заказа.
     * @return полная информация о заказе
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Заказ покупателя: %s | Способ оплаты: %s%n",
                (customer != null ? customer.getName() : "Не указан"),
                (payment != null ? payment.toString() : "Не выбран")));
        for (int i = 0; i < items.length; i++) {
            sb.append("\t").append(i + 1).append(". ").append(items[i].toString()).append("\n");
        }
        sb.append(String.format("\tИТОГО: %8.2f руб.", getTotal()));
        return sb.toString();
    }
}