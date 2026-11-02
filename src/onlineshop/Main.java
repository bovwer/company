
        package onlineshop;
import java.util.Scanner;
/**
 * Главный класс программы для демонстрации работы интернет-магазина.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public class Main {
    /** Статический массив товаров каталога */
    private static Product[] products;
    /** Статический объект покупателя */
    private static Customer currentCustomer;
    /** Статический объект администратора */
    private static Admin currentAdmin;
    /** Текущий формируемый заказ */
    private static Order currentOrder;
    static {
        products = new Product[] {
                new Product("Процессор AMD Ryzen 5 7600", 18500.0, "Комплектующие ПК"),
                new Product("Оперативная память DDR5 32GB", 11200.0, "Комплектующие ПК"),
                new Product("Механическая клавиатура", 5400.0, "Периферия"),
                new Product("Игровая мышь", 3200.0, "Периферия")
        };
        currentCustomer = new Customer(1, "Александр", "alex@mail.ru");
        currentAdmin = new Admin(100, "Иван (Админ)", "admin@shop.ru", products);
        currentOrder = new Order(currentCustomer, new CreditCardPayment("4276-1111-2222-3333"));
    }
    /**
     * Выводит каталог товаров на экран.
     */
    public static void printCatalog() {
        System.out.println("\nКаталог товаров интернет-магазина:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }
    /**
     * Точка входа в программу.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cycle: while (true) {
            System.out.println("\n================ МЕНЮ ИНТЕРНЕТ-МАГАЗИНА ================");
            System.out.println("1. Показать каталог товаров");
            System.out.println("2. Добавить товар в текущий заказ (Покупатель)");
            System.out.println("3. Выбрать способ оплаты и оплатить заказ");
            System.out.println("4. Показать историю заказов покупателя");
            System.out.println("5. Управление товарами (Администратор)");
            System.out.println("6. Вывести информацию о пользователях (Полиморфизм User)");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт меню (1..7): ");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    printCatalog();
                    break;
                case 2:
                    printCatalog();
                    System.out.print("Введите номер товара для добавления в корзину: ");
                    int pIdx = sc.nextInt() - 1;
                    if (pIdx >= 0 && pIdx < products.length) {
                        System.out.print("Введите количество: ");
                        int qty = sc.nextInt();
                        currentOrder.addItem(new OrderItem(products[pIdx], qty));
                        System.out.println("Позиция добавлена! Текущая сумма заказа: " + currentOrder.getTotal() + " руб.");
                    } else {
                        System.out.println("Недопустимое значение!");
                    }
                    break;
                case 3:
                    System.out.println("Выберите способ оплаты: 1 - Карта, 2 - PayPal, 3 - Наличными при получении");
                    int payType = sc.nextInt();
                    IPayment paymentStrategy;
                    if (payType == 1) {
                        paymentStrategy = new CreditCardPayment();
                    } else if (payType == 2) {
                        paymentStrategy = new PayPalPayment();
                    } else {
                        paymentStrategy = new CashOnDeliveryPayment();
                    }

                    currentOrder.setPayment(paymentStrategy);
                    currentOrder.processOrder();
                    currentOrder = new Order(currentCustomer, paymentStrategy);
                    break;
                case 4:
                    System.out.println("\nИстория заказов (" + currentCustomer.getName() + "):");
                    Order[] history = currentCustomer.getOrderHistory();
                    if (history.length == 0) {
                        System.out.println("История заказов пуста.");
                    } else {
                        for (int i = 0; i < history.length; i++) {
                            System.out.println("Заказ №" + (i + 1) + ":\n" + history[i]);
                        }
                    }
                    break;
                case 5:
                    currentAdmin.setCatalog(products);
                    currentAdmin.manageProducts();
                    products = currentAdmin.getCatalog();
                    break;
                case 6:
                    User[] users = new User[] { currentCustomer, currentAdmin };
                    System.out.println("\nСписок пользователей системы:");
                    for (int i = 0; i < users.length; i++) {
                        System.out.println(users[i]);
                    }
                    break;
                default:
                    break cycle;
            }
        }
    }
}