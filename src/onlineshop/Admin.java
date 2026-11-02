
        package onlineshop;

import java.util.Scanner;

/**
 * Класс Администратор интернет-магазина.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public final class Admin extends User {

    /** Поле для хранения массива управляемых товаров (каталог) */
    private Product[] catalog;

    /**
     * Создает администратора с заданными данными и каталогом товаров.
     * @param id идентификатор
     * @param name имя администратора
     * @param email электронная почта
     * @param catalog массив товаров каталога
     */
    public Admin(int id, String name, String email, Product[] catalog) {
        super(id, name, email);
        this.setCatalog(catalog);
    }

    /**
     * Создает администратора путем ввода данных с консоли.
     */
    public Admin() {
        super();
        this.catalog = new Product[0];
    }

    /**
     * Возвращает значение поля {@link Admin#catalog}.
     * @return массив товаров каталога
     */
    public Product[] getCatalog() {
        return this.catalog;
    }

    /**
     * Устанавливает значение поля {@link Admin#catalog}.
     * @param catalog массив товаров
     */
    public void setCatalog(Product[] catalog) {
        if (catalog == null)
            System.out.println("Недопустимое значение!");
        else
            this.catalog = catalog;
    }

    /**
     * Возвращает роль администратора.
     * @return строка "Администратор"
     */
    @Override
    public String getRole() {
        return "Администратор";
    }

    /**
     * Управляет товарами (добавление, изменение цены, скидка, удаление).
     */
    public void manageProducts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nУправление товарами (Администратор " + getName() + "):");
        System.out.println("1. Добавить новый товар");
        System.out.println("2. Изменить цену товара");
        System.out.println("3. Применить скидку к товару");
        System.out.println("4. Удалить последний товар");
        System.out.print("Выберите действие (1..4): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Product newProduct = new Product();
                Product[] added = new Product[catalog.length + 1];
                for (int i = 0; i < catalog.length; i++) {
                    added[i] = catalog[i];
                }
                added[catalog.length] = newProduct;
                catalog = added;
                System.out.println("Товар успешно добавлен.");
                break;
            case 2:
                if (catalog.length == 0) {
                    System.out.println("Каталог пуст!");
                    break;
                }
                for (int i = 0; i < catalog.length; i++) {
                    System.out.println((i + 1) + ". " + catalog[i]);
                }
                System.out.print("Номер товара: ");
                int idxPrice = sc.nextInt() - 1;
                if (idxPrice >= 0 && idxPrice < catalog.length) {
                    System.out.print("Новая цена: ");
                    catalog[idxPrice].setPrice(sc.nextDouble());
                } else {
                    System.out.println("Недопустимое значение!");
                }
                break;
            case 3:
                if (catalog.length == 0) {
                    System.out.println("Каталог пуст!");
                    break;
                }
                for (int i = 0; i < catalog.length; i++) {
                    System.out.println((i + 1) + ". " + catalog[i]);
                }
                System.out.print("Номер товара для скидки: ");
                int idxDisc = sc.nextInt() - 1;
                if (idxDisc >= 0 && idxDisc < catalog.length) {
                    System.out.print("Процент скидки: ");
                    catalog[idxDisc].applyDiscount(sc.nextDouble());
                } else {
                    System.out.println("Недопустимое значение!");
                }
                break;
            case 4:
                if (catalog.length > 0) {
                    Product[] reduced = new Product[catalog.length - 1];
                    for (int i = 0; i < reduced.length; i++) {
                        reduced[i] = catalog[i];
                    }
                    catalog = reduced;
                    System.out.println("Последний товар удален.");
                } else {
                    System.out.println("Каталог уже пуст!");
                }
                break;
            default:
                System.out.println("Отмена операции.");
        }
    }
}