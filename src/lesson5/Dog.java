package lesson5;

import java.util.Random;

/**
 * Класс Собака с наследованием от класса Животное.
 */
public class Dog extends Animal {
    private Random random = new Random();
    /**
     * Метод, формирующий конструктор Пса
     *
     * @param name - строковая переменная содержащая имя Пса.
     * @param color - строковая переменная содержащая цвет шерстки Пса.
     */
    public Dog(String name, String color) {

        super(name, color);
        setJumpHeight((random.nextInt(5) + 1) * 0.1f);
        setRunLength(random.nextInt(201) + 400);
        setSwimLength(random.nextInt(10) + 1);
    }

    /**
     * Метод, формирующий полную информацию о сущности.
     *
     * @return - Возвращает строковую переменную.
     */
    @Override
    protected String fullInfo() {
        return "Меня заовут " +
                getName() + ", я - пёс и я имею " +
                getColor() + " цвет шерстки, и я прыгаю на " +
                this.getJumpHeight() + " метра, а бегаю я на " +
                this.getRunLength() + " метра";
    }
}
