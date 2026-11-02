
        package onlineshop;

import java.util.Scanner;

/**
 * Абстрактный класс Пользователь системы.
 * @author Ярлынский А.В.
 * @version 1.0
 */
public abstract class User {

    /** Поле для хранения идентификатора пользователя */
    private int id;

    /** Поле для хранения имени пользователя */
    private String name;

    /** Поле для хранения электронной почты */
    private String email;

    /**
     * Создает пользователя с заданными данными.
     * @param id идентификатор
     * @param name имя пользователя
     * @param email электронная почта
     */
    public User(int id, String name, String email) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
    }

    /**
     * Создает пользователя путем ввода данных с консоли.
     */
    public User() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID пользователя: ");
        this.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Имя: ");
        this.setName(sc.nextLine());
        System.out.print("Email: ");
        this.setEmail(sc.nextLine());
    }

    /**
     * Возвращает значение поля {@link User#id}.
     * @return идентификатор пользователя
     */
    public int getId() {
        return this.id;
    }

    /**
     * Устанавливает значение поля {@link User#id}.
     * @param id идентификатор пользователя
     */
    public void setId(int id) {
        if (id <= 0)
            System.out.println("Недопустимое значение!");
        else
            this.id = id;
    }

    /**
     * Возвращает значение поля {@link User#name}.
     * @return имя пользователя
     */
    public String getName() {
        return this.name;
    }

    /**
     * Устанавливает значение поля {@link User#name}.
     * @param name имя пользователя
     */
    public void setName(String name) {
        if (name == null || name.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.name = name;
    }

    /**
     * Возвращает значение поля {@link User#email}.
     * @return электронная почта
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Устанавливает значение поля {@link User#email}.
     * @param email электронная почта
     */
    public void setEmail(String email) {
        if (email == null || email.isEmpty())
            System.out.println("Недопустимое значение!");
        else
            this.email = email;
    }

    /**
     * Возвращает роль пользователя в системе.
     * @return название роли
     */
    public abstract String getRole();

    /**
     * Возвращает строковое представление пользователя.
     * @return форматированная строка с данными пользователя
     */
    @Override
    public String toString() {
        return String.format("ID: %d | Имя: %s | Email: %s | Роль: %s",
                id, name, email, getRole());
    }
}