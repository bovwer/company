
        package onlineshop;

/**
 * Интерфейс применения скидки к объекту.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public interface IDiscountable {

    /**
     * Применяет скидку в процентах.
     * @param percent процент скидки (от 0 до 100)
     */
    void applyDiscount(double percent);
}