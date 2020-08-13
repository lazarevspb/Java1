package lesson5;

/* √ 1.Создать классы Собака и Кот с наследованием от класса Животное. */

/**
 * Абстрактный класс Животное.
 */
public abstract class Animal {
    /**
     * Поле устанавливает ограничение длинны плавания Животного.
     */
    private int swimLength;
    /**
     * Поле устанавливает имя Животного.
     */
    private String name;
    /**
     * Поле устанавливает цвет шерстки Животного.
     */
    private String color;
    /**
     * Поле устанавливает ограничение на высоту прыжка Животного
     */
    private float jumpHeight;
    /**
     * Поле устанавливает ограничение длинны пробега Животного
     */
    private int runLength;

    public int getSwimLength() {
        return swimLength;
    }

    /**
     * Переменная формирует случайное значение для максимальной длинны заплыва в заданном диапазоне;
     *
     * @param swimLength возвращает заданное значение;
     */
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


    /**
     * Переменная формирует случайное значение для максимального значения высоты прыжка в заданном диапазоне;
     *
     * @param jumpHeight переменная с плавающей точкой типа float;
     */
    protected void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    /**
     * Переменная формирует случайное значение для максимальной длинны бега в заданном диапазоне;
     *
     * @param runLength целочисленная переменная;
     */
    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    /**
     * В конструктор Животного передается два параметра.
     *
     * @param name  строковая переменная имя Животного.
     * @param color строковая переменная цвет шерстки Животного.
     */
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /* 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
     В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
      или высоту (для прыжков). */

    /**
     * Метод, в котором проверяется заданный параметр на соответсвие с ограничением у конкретной сущности
     * и выводящий соответсвуюший результат в консоль.
     *
     * @param runLenthValue целочисленная переменная.
     */
    protected boolean run(int runLenthValue) {
        if (runLenthValue <= this.getRunLength()) {
            System.out.printf("%s бежит на %d метров.\n", this.getName(), runLenthValue);
            return true;
        } else {
            System.out.printf("%s: расстояние %d метров для меня слишком большое, увы, " +
                            "я могу пробежать только - %d метров.\n",
                    this.getName(), runLenthValue, this.getRunLength());
            return false;
        }
    }

    /**
     * Метод, в котором проверяется заданный параметр на соответсвие с ограничением у конкретной сущности
     * и выводящий соответсвуюший результат в консоль.
     *
     * @param jumpHeightValue целочисленная переменная.
     */
    protected boolean jump(float jumpHeightValue) {
        if (jumpHeightValue <= this.getJumpHeight()) {
            System.out.printf("%s прыгает на %.1f метра.\n", this.getName(), this.getJumpHeight());
            return true;
        } else {
            System.out.printf("%s: высота %.2f метров для меня слишком высоко, увы, " +
                            "я могу прыгнуть только - %.2f метров.\n",
                    this.getName(), jumpHeightValue, this.getJumpHeight());
            return false;
        }
    }

    /**
     * Метод, в котором проверяется заданный параметр на соответсвие с ограничением у конкретной сущности
     * и выводящий соответсвуюший результат в консоль.
     *
     * @param swimLengthValue целочисленная переменная.
     */
    protected boolean swim(int swimLengthValue) {
        if (swimLengthValue <= this.getSwimLength()) {
            System.out.printf("%s плывет на %d метров.\n", this.getName(), this.getSwimLength());
            return true;
        } else {
            System.out.printf("%s: расстояние %d метров для меня слишком большое, увы, " +
                            "я могу проплыть только - %d метров.\n",
                    this.getName(), swimLengthValue, this.getSwimLength());
            return false;
        }
    }

    /**
     * Абстрактный метод, назначение которого - формировать полную информацию о сущности.
     *
     * @return Возвращает строковую переменную.
     */
    protected abstract String fullInfo();
}
