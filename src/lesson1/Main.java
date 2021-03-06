package lesson1;

/**
 * Homework for lesson #1
 *
 * @author Valeriy Lazarev
 * @since 2020-07-25
 */

public class Main {

    public static void main(String[] args) {
        /*
         *  1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
         * где a, b, c, d – целочисленные входные параметры этого метода;
         * */
        System.out.println("calcMathExpression: " + calcMathExpression(2, 3, 4, 5));

        /*
         * 2. Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
         * если да – вернуть true, в противном случае – false;
         * */
        System.out.println("valSumLimitCheck: " + valSumLimitCheck(10, 2));

        /*
         * 3. Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали,
         * или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
         * */
        System.out.println((numberSignCheck(-1) ? "Положительное" : "Отрицательное") + " число");
        System.out.println((numberSignCheck(0) ? "Положительное" : "Отрицательное") + " число");
        System.out.println((numberSignCheck(1) ? "Положительное" : "Отрицательное") + " число");

        /*
         * 4. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение
         * «Привет, переданное_имя!»; Вывести приветствие в консоль.
         * */
        System.out.println(printString("Иван"));

        /*
         * 5. Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го,
         * при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
         * */
        int[] year = {1600/**/ ,1605, 1606, 1607, 1608/**/ , 1700, 1800, 1900, 2000/**/ ,};
        for (int value : year) {
            System.out.println(value + " год является" + (leapYearCheck(value) ? " високосным" : " невисокосным"));
        }
    }

    /**
     * Метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го,
     * при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
     *
     * @param year - переменная содержащая год принадлежность которого к признаку "високосный" проверяет метод.
     * @return - возвращает переменную типа boolean;
     */
    private static boolean leapYearCheck(int year) {
        return (year % 4 == 0 && (!(year % 100 == 0) ^ year % 400 == 0));

    }

    /**
     * Метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение
     * «Привет, переданное_имя!»;
     * Вывести приветствие в консоль.
     *
     * @param name - переменная;
     * @return - возвращает переменную типа String.
     */
    private static String printString(String name) {
        return "Привет, " + name + "!";
    }

    /**
     * Метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали,
     * или отрицательное.
     * Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
     *
     * @param i - переменная, значение которой будет проверять метод;
     * @return - возвращает переменную типа boolean;
     */
    private static boolean numberSignCheck(int i) {
        return i > -1;
    }

    /**
     * Метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     * если да – вернуть true, в противном случае – false;
     *
     * @param i  - целочисленная переменная типа int;
     * @param i1 - целочисленная переменная типа int;
     * @return - возвращает переменную типа boolean;
     */
    private static boolean valSumLimitCheck(int i, int i1) {
        return i + i1 > 10 && i + i1 <= 20;
    }

    /**
     * Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
     * где a, b, c, d – целочисленные входные параметры этого метода;
     *
     * @param a - целочисленная переменная типа int;
     * @param b - целочисленная переменная типа int;
     * @param c - целочисленная переменная типа int;
     * @param d - целочисленная переменная типа int;
     * @return - возвращает число с плавающей точккой float;
     */
    private static float calcMathExpression(int a, int b, int c, int d) {
            return a * (b + ((c * 0.1f) / d));
    }
}
