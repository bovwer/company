
        package onlineshop;

/**
 * Интерфейс продаваемого объекта.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public interface ISellable {

    /**
     * Возвращает цену товара.
     * @return цена товара
     */
    double getPrice();

    /**
     * Возвращает название товара.
     * @return название товара
     */
    String getName();
}