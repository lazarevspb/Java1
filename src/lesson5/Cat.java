package lesson5;

import java.util.Random;

public class Cat extends Animal {
    private Random random = new Random();

    public Cat(String name, String color) {
        super(name, color);
        setJumpHeight(random.nextInt(2) + 1);
        setRunLength(random.nextInt(101) + 100);
    }

    @Override
    protected void run() {
        System.out.printf("%s бежит на %d метров.\n", this.getName(), this.getRunLength());
    }

    @Override
    protected void jump() {
        System.out.printf("%s прыгает на %.1f метра.\n", this.getName(), this.getJumpHeight());
    }

    @Override
    protected void swim() {
        System.out.println("Я не умею плавать, я же кот!");
    }

    @Override
    public String fullInfo() {
        return "Меня заовут " +
                getName() + ", я - кот и я имею " +
                getColor() + " цвет шерстки, и я прыгаю на " +
                this.getJumpHeight() + " метра, а бегаю я на " +
                this.getRunLength() + " метра";
    }
}
