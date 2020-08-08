package lesson5;

import java.util.Random;

public class Dog extends Animal {
    private Random random = new Random();

    public Dog(String name, String color) {
        super(name, color);
        setJumpHeight((random.nextInt(5) + 1) * 0.1f);
        setRunLength(random.nextInt(201) + 400);
        setSwimLength(random.nextInt(10) + 1);
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
        System.out.printf("%s плывет на %d метров.\n", this.getName(), this.getSwimLength());
    }

    @Override
    protected String fullInfo() {
        return "Меня заовут " +
                getName() + ", я - пёс и я имею " +
                getColor() + " цвет шерстки, и я прыгаю на " +
                this.getJumpHeight() + " метра, а бегаю я на " +
                this.getRunLength() + " метра";
    }
}
