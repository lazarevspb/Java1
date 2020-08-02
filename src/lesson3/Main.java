/**
 * Homework for lesson #3
 * Procedural Tic Tac Toe
 *
 * @author Valeriy Lazarev
 * @since 2020-08-01
 */

package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;
    public static final int WIN_POINT = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    private static char[][] square = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initMap();
        printMap();

        while (overflowMap()) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X, "Человек выиграл!")) {
                break;
            }
            aiTurn();
            printMap();
            if (checkEndGame(DOT_O, "Человек проиграл!")) {
                break;
            }
            printMap();
        }
        SCANNER.close();
    }

    private static boolean checkEndGame(char c, String s) {
        if (!overflowMap()) {
            System.out.println("Карта переполнена! Ничья!");
            return true;
        }
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        return false;
    }

    /**
     * Метод, в котором ИИ выявляет выигрышные ситуации на поле.
     *
     * @param sign - Символ для которого считаются комбинации.
     * @return - в случае успешно выявленной комбинации возвращает true
     */
    private static boolean checkWin(char sign) {
        byte divider = (WIN_POINT == 3) ? 0b0111 : 0b1111;
        byte[] arrayStateByte = new byte[8];
        byte[] rateByte = new byte[]{0b1, 0b10, 0b100, 0b1000, 0b10000,};

        for (int i = 0; i < square.length; i++) {
            arrayStateByte[0] += (sign == square[i][i]) ? rateByte[i] : 0;                       //левая диагональ
            arrayStateByte[1] += (sign == square[i][square.length - i - 1]) ? rateByte[i] : 0;   //правая диагональ

            if (i < SIZE - 1) {
                arrayStateByte[2] += (sign == square[i + 1][i]) ? rateByte[i] : 0;               //левая полудиагональ, низ
                arrayStateByte[3] += (sign == square[i][i + 1]) ? rateByte[i] : 0;               //левая полудиагональ, верх
                arrayStateByte[4] += (sign == square[SIZE - i - 1][i + 1]) ? rateByte[i] : 0;    //Правая полудиагональ, низ
                arrayStateByte[5] += (sign == square[SIZE - i - 2][i]) ? rateByte[i] : 0;        //Прпавая полудиагональ, верх
            }

            for (int j = 0; j < square.length; j++) {
                arrayStateByte[6] += (sign == square[i][j]) ? rateByte[j] : 0;                   //строки
                arrayStateByte[7] += (sign == square[j][i]) ? rateByte[j] : 0;                   //столбцы

                for (byte b : arrayStateByte) {                        // Поиск возможно возникших выиграшных комбинаций
                    if (b % divider == 0 && b != 0) {
                        return true;
                    }
                }
            }
            for (int l = 6; l < arrayStateByte.length; l++) {        // очистка временных переменных столбцов и строк
                arrayStateByte[l] = (byte) 0;
            }
        }
        Arrays.fill(arrayStateByte, (byte) 0);                          //Очистка всего временного массива
        return false;
    }

    private static boolean overflowMap() {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (isEmpty(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Тут определяется алгоритм ответного хода с учетом приоретеа расположенных фишек на поле.
     * Например: три "0" подряд для ИИ приоретентие трех "Х". Тоесть ИИ будет пытаться завершить игру победой,
     * если такой "выбор" будет предостален.
     */
    private static void aiTurn() {
        int x;
        int y;
        if (countingElements(DOT_O, (byte) 0b0111)) {      //Выбор приоритета
            return;
        } else if (countingElements(DOT_X, (byte) 0b0111)) {
            return;
        } else if (countingElements(DOT_O, (byte) 0b0011)) {
            return;
        } else if (countingElements(DOT_X, (byte) 0b0011)) {
            return;
        } else if (countingElements(DOT_O, (byte) 0b0001)) {
            return;
        } else {
            do {
                do {
                    x = RANDOM.nextInt(SIZE - 2) + 1; //Постараться поставить первый нолик в центр карты, чтобы получить преимущесвто над противником
                    y = RANDOM.nextInt(SIZE - 2) + 1;
                } while (false);
                x = RANDOM.nextInt(SIZE - 1);
                y = RANDOM.nextInt(SIZE - 1);
            } while (!(validation(x, y) && isEmpty(x, y)));
            square[x][y] = DOT_O;
        }
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до " + SIZE + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(validation(x, y) && isEmpty(x, y)));
        square[x][y] = DOT_X;
    }

    private static boolean isEmpty(int x, int y) {
        return square[x][y] == DOT_EMPTY;
    }

    private static boolean validation(int x, int y) {
        return SIZE > x && x > -1 && SIZE > y && y > -1;
    }

    private static void printMap() {
        System.out.print('0');
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3s", i + 1);
        }
        System.out.println();
        for (int i = 0; i < square.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < square.length; j++) {
                System.out.printf("%3c", square[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод, в котором ИИ ведет подсчет расположенных фишек на поле.
     *
     * @param c       - Символ для которого считаются комбинации.
     * @param divider - делитель, нужен для поиска и определения приоретеа сложившихся комбинаций на поле.
     * @return - в случае найденной комбинации фишек(считающейся приорететной)
     * и поставленной своей фишкой на поле возвращает true
     */
    private static boolean countingElements(char c, byte divider) {
        byte[] arrayAIbyte = new byte[8];
        byte[] rateAIbyte = new byte[]{0b1, 0b10, 0b100, 0b1000, 0b10000,};

        for (int i = 0; i < square.length; i++) {
            arrayAIbyte[0] += (c == square[i][i]) ? rateAIbyte[i] : 0;                                  //левая диагональ
            arrayAIbyte[1] += (c == square[i][square.length - i - 1]) ? rateAIbyte[i] : 0;               //правая диагональ

            if (i < SIZE - 1) {
                arrayAIbyte[2] += (c == square[i + 1][i]) ? rateAIbyte[i] : 0;              //левая полудиагональ низ
                arrayAIbyte[3] += (c == square[i][i + 1]) ? rateAIbyte[i] : 0;              //левая полудиагональ верх
                arrayAIbyte[4] += (c == square[SIZE - i - 1][i + 1]) ? rateAIbyte[i] : 0;   //Правая полудиагональ, низ
                arrayAIbyte[5] += (c == square[SIZE - i - 2][i]) ? rateAIbyte[i] : 0;       //Прпавая полудиагональ, верх
            }

            for (int j = 0; j < square.length; j++) {
                arrayAIbyte[6] += (c == square[i][j]) ? rateAIbyte[j] : 0;                  //строки
                arrayAIbyte[7] += (c == square[j][i]) ? rateAIbyte[j] : 0;                  //столбцы
/*
Ниже идет настройка поведения при выборе положения выставлемой на поле фишки во всех плосокостях где могут возникнуть
 комбинации требующие внимания в рамках заданного приоретета divider передаваемого из метода aiTurn().
* */
                for (int k = 0; k < arrayAIbyte.length; k++) {
                    if (arrayAIbyte[k] % divider == 0 && arrayAIbyte[k] != 0) {

                        if (arrayAIbyte[k] == arrayAIbyte[0]) {                                                     //ЛД
                            if ((validation(i, i) && isEmpty(i, i))) {
                                square[i][i] = DOT_O;
                                System.out.println("ЛД");
                                return true;
                            } else if ((validation(i - WIN_POINT + 2, i - WIN_POINT + 2) &&
                                    isEmpty(i - WIN_POINT + 2, i - WIN_POINT + 2))) {
                                square[i - WIN_POINT + 2][i - WIN_POINT + 2] = DOT_O;
                                System.out.println("ЛД");
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[1]) {                                                     //ПД

                            if ((validation(i + 1, square.length - i - 2) &&
                                    isEmpty(i + 1, square.length - i - 2))) {
                                square[i + 1][square.length - i - 2] = DOT_O;
                                return true;
                            } else if ((validation(square.length - i, i - 1)) &&
                                    isEmpty(square.length - i, i - 1) && arrayAIbyte[k] == 0b11100) {
                                square[square.length - i][i - 1] = DOT_O;
                                return true;
                            } else if ((validation(square.length - i - 1, i)) &&
                                    isEmpty(square.length - i - 1, i)) {
                                square[square.length - i - 1][i] = DOT_O;
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[2]) {
                            if (validation(i + 2, i + 1) && isEmpty((i + 2), (i + 1))) {                     //ЛПДН
                                square[i + 2][i + 1] = DOT_O;
                                return true;
                            } else if ((validation(i - 2, i - 3) && isEmpty(i - 2, i - 3))) {
                                square[i - 2][i - 3] = DOT_O;
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[3]) {                                                   //ЛПДВ
                            if (validation(SIZE - i, i + 2) && isEmpty(SIZE - i, i + 2)) {
                                square[SIZE - i][i + 2] = DOT_O;
                                return true;
                            } else if (validation(SIZE - i - 2, i - 2) && isEmpty(SIZE - i - 2, i - 2)) {
                                square[SIZE - i - 2][i - 2] = DOT_O;
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[4]) {
                            if (validation(SIZE - i - 2, i + 2) && isEmpty(SIZE - i - 2, i + 2)) {      //ППДН
                                square[SIZE - i - 2][i + 2] = DOT_O;
                                return true;
                            } else if (validation(i + 1, SIZE - i - 1) && isEmpty(i + 1, SIZE - i - 1)) {
                                square[i + 1][SIZE - i - 1] = DOT_O;
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[5]) {
                            if (validation(SIZE - i - 3, i + 1) && isEmpty(SIZE - i - 3, i + 1)) {      //ППДВ
                                square[SIZE - i - 3][i + 1] = DOT_O;
                                return true;
                            } else if (validation(i, SIZE - i - 2) && isEmpty(i, SIZE - i - 2)) {
                                square[i][SIZE - i - 2] = DOT_O;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[6]) {                                                 //Строки
                            if ((validation(i, j + 1) && isEmpty(i, j + 1))) {
                                square[i][j + 1] = DOT_O;
                                return true;
                            } else if ((validation(i, j - i - 1) && isEmpty(i, j - i - 1))) {
                                square[i][j - i - 1] = DOT_O;
                                return true;
                            }
                        }
                        if (arrayAIbyte[k] == arrayAIbyte[7]) {                                                //Столбцы
                            if ((validation(j + 1, i) && isEmpty(j + 1, i))) {
                                square[j + 1][i] = DOT_O;
                                return true;
                            } else if (validation(j - 2, i) && isEmpty(j - 2, i)) {
                                square[j - 2][i] = DOT_O;
                                return true;
                            }
                        }
                    }
                }
            }
            Arrays.fill(arrayAIbyte, 6, arrayAIbyte.length, (byte) 0);
        }
        Arrays.fill(arrayAIbyte, (byte) 0);
        return false;
    }
}
