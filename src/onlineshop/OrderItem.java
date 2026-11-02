
        package onlineshop;

import java.util.Scanner;

/**
 * Класс Позиция заказа (товар и его количество).
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class OrderItem {

    /** Поле для хранения товара */
    private Product product;

    /** Поле для хранения количества товара */
    private int quantity;

    /**
     * Создает позицию заказа с заданными товаром и количеством.
     * @param product товар
     * @param quantity количество единиц товара
     */
    public OrderItem(Product product, int quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    /**
     * Создает позицию заказа путем ввода с консоли.
     */
    public OrderItem() {
        Scanner sc = new Scanner(System.in);
        this.setProduct(new Product());
        System.out.print("\tКоличество: ");
        this.setQuantity(sc.nextInt());
    }

    /**
     * Возвращает значение поля {@link OrderItem#product}.
     * @return объект товара
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Устанавливает значение поля {@link OrderItem#product}.
     * @param product объект товара
     */
    public void setProduct(Product product) {
        if (product == null)
            System.out.println("Недопустимое значение!");
        else
            this.product = product;
    }

    /**
     * Возвращает значение поля {@link OrderItem#quantity}.
     * @return количество товара
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Устанавливает значение поля {@link OrderItem#quantity}.
     * @param quantity количество товара
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0)
            System.out.println("Недопустимое значение!");
        else
            this.quantity = quantity;
    }

    /**
     * Вычисляет общую стоимость позиции (цена * количество).
     * @return итоговая стоимость позиции
     */
    public double getTotalPrice() {
        if (product == null) return 0;
        return product.getPrice() * quantity;
    }

    /**
     * Возвращает строковое представление позиции заказа.
     * @return строка с информацией о позиции
     */
    @Override
    public String toString() {
        return String.format("%s | Кол-во: %d шт. | Сумма: %8.2f руб.",
                product.getName(), quantity, getTotalPrice());
    }
}