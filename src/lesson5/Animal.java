package lesson5;


public abstract class Animal {
    private int swimLength;
    private String name;
    private String color;
    private float jumpHeight;
    private int runLength;

    public int getSwimLength() {
        return swimLength;
    }

    public void setSwimLength(int swimLength) {
        this.swimLength = swimLength;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    protected void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }


    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    protected abstract void run();

    protected abstract void jump();

    protected abstract void swim();

    protected abstract String fullInfo();


}
