package lesson5;

import java.util.Random;

/**
 * Класс Кот с наследованием от класса Животное.
 */
public class Cat extends Animal {
    /**
     * Переменная для формирования случайных ограничений для полей животного
     */
    private Random random = new Random();

    /**
     * Метод, формирующий конструктор Кота
     *
     * @param name  строковая переменная содержащая имя Кота.
     * @param color строковая переменная содержащая цвет шерстки Кота.
     */
    public Cat(String name, String color) {
        super(name, color);
        setJumpHeight(random.nextInt(2) + 1);
        setRunLength(random.nextInt(101) + 100);
    }

    /**
     * Метод, переопределяющий родительский метод животного.
     *
     * @param swimLengthValue параметр нигде не используется, потомучто кот не умеет плавать, он же Кот.
     */
    @Override
    protected boolean swim(int swimLengthValue) {
        System.out.printf("%s: я не умею плавать, я же кот!\n", this.getName());
        return false;
    }

    /**
     * Метод, формирующий полную информацию о сущности.
     *
     * @return Возвращает строковую переменную.
     */
    @Override
    public String fullInfo() {
        return "Меня заовут " +
                getName() + ", я - кот и я имею " +
                getColor() + " цвет шерстки, и я прыгаю на " +
                this.getJumpHeight() + " метра, а бегаю я на " +
                this.getRunLength() + " метров.";
    }
}
