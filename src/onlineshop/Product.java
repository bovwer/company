
        package onlineshop;

import java.util.Scanner;

/**
 * Класс Товар для продажи в интернет-магазине.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class Product implements ISellable, IDiscountable {

    /** Поле для хранения названия товара */
    private String name;

    /** Поле для хранения цены товара */
    private double price;

    /** Поле для хранения категории товара */
    private String category;

    /**
     * Создает товар с заданными параметрами.
     * @param name название товара
     * @param price цена товара
     * @param category категория товара
     */
    public Product(String name, double price, String category) {
        this.setName(name);
        this.setPrice(price);
        this.setCategory(category);
    }

    /**
     * Создает товар путем ввода данных с консоли.
     */
    public Product() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Название товара: ");
        this.setName(sc.nextLine());
        System.out.print("\tКатегория: ");
        this.setCategory(sc.nextLine());
        System.out.print("\tЦена: ");
        this.setPrice(sc.nextDouble());
    }

    /**
     * Возвращает значение поля {@link Product#name}.
     * @return название товара
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Устанавливает значение поля {@link Product#name}.
     * @param value название товара
     */
    public void setName(String value) {
        if (value == null || value.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.name = value;
    }

    /**
     * Возвращает значение поля {@link Product#price}.
     * @return цена товара
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * Устанавливает значение поля {@link Product#price}.
     * @param price цена товара
     */
    public void setPrice(double price) {
        if (price <= 0)
            System.out.println("Недопустимое значение!");
        else
            this.price = price;
    }

    /**
     * Возвращает значение поля {@link Product#category}.
     * @return категория товара
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Устанавливает значение поля {@link Product#category}.
     * @param category категория товара
     */
    public void setCategory(String category) {
        if (category == null || category.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.category = category;
    }

    /**
     * Снижает цену товара на заданный процент.
     * @param percent процент скидки
     */
    @Override
    public void applyDiscount(double percent) {
        if (percent <= 0 || percent >= 100) {
            System.out.println("Недопустимое значение!");
        } else {
            this.price = this.price - (this.price * percent / 100.0);
        }
    }

    /**
     * Возвращает строковое представление товара.
     * @return форматированная строка с данными о товаре
     */
    @Override
    public String toString() {
        return String.format("Товар: %s ==> категория: %s \t цена = %8.2f руб.",
                name, category, price);
    }
}