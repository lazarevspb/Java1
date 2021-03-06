package lesson2;

import java.util.Arrays;

/**
 * Homework for lesson #2
 *
 * @author Valeriy Lazarev
 * @since 2020-07-29
 */

public class Main {

    public static void main(String[] args) {
/*
1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
Написать метод, заменяющий в принятом массиве 0 на 1,
1 на 0;
*/
        int[] arrInt = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("#1: " + Arrays.toString(arrInt));
        changeArrInt(arrInt);
        System.out.println("#1: " + Arrays.toString(arrInt) + "\n");

/*
2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
*/
        int[] arrInt2 = new int[8];
        System.out.println("#2: " + Arrays.toString(arrInt2));
        fillArrInt(arrInt2);
        System.out.println("#2: " + Arrays.toString(arrInt2) + "\n");


/*
3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
*/
        int[] arrInt3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("#3: " + Arrays.toString(arrInt3));
        multiplyByTwo(arrInt3);
        System.out.println("#3: " + Arrays.toString(arrInt3) + "\n");


/*
4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
*/
        int[] arrInt4 = new int[]{18, 13, 5, 3, 2, 11, 4, 25, -2, 2, 4, 8, 49, 12, -10, 32};
        print("Минимальный", searchMin(arrInt4), arrInt4, 4.1f);
        print("Максимальный", searchMax(arrInt4), arrInt4, 4.2f);

/*
5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
*/
        int[][] arrInt5 = new int[5][5];
        for (int i = 0; i < arrInt5.length; i++) {
            arrInt5[i][i] = 1;
            arrInt5[i][arrInt5.length - i - 1] = 1;
        }
        System.out.println("#5");
        printMultiArray(arrInt5);

/*
    6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место,
в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, 1, 2, 3, 4]) → true.
 */
        int[] arrInt6 = new int[]{1, 1, 1, 2, 1};
        System.out.println("#6\n" + "Массив " + (checkBalance(arrInt6) ? "сбалансирован" : "несбалансирован") + "\n");

/*
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/
        int[] arrInt7 = new int[]{1, 2, 3, 4, 5};
        int shiftQuantity = -3;
        System.out.printf("#7\n%s%19s\n", "Исходный массив: ", Arrays.toString(arrInt7));
        arrayShift(arrInt7, shiftQuantity);
        System.out.println("Смещеие " + shiftQuantity + " элемента: " + Arrays.toString(arrInt7));
    }

    /**
     * Метод передает в консоль форматированный вывод двухмерного массива.
     *
     * @param arrInt5 - двухмерный массив.
     */
    private static void printMultiArray(int[][] arrInt5) {
        for (int i = 0; i < arrInt5[0].length; i++) {
            System.out.println(Arrays.toString(arrInt5[i]));
        }
        System.out.println();
    }

    /**
     * Метод передает в консоль форматированный вывод результатов работы других методов и служит для отладки их работы.
     *
     * @param s     - переменная типа строка;
     * @param i     - переменная тип int;
     * @param array - массив целочисленных переменных;
     */
    private static void print(String s, int i, int[] array, float task) {
        System.out.println("#" + task + "\n" + Arrays.toString(array) + "\n" + s + " элемент массива: " + i + "\n");
    }

    /**
     * Метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементымассива на n позиций.
     *
     * @param array - массив целочисленных переменных;
     * @param shift - целочисленная переменная отвечающая за сдвиг массива.
     */

    private static void arrayShift(int[] array, int shift) {
        if (shift % array.length == 0) return;
        if (shift < 0) shift += array.length;
        for (int i = shift; i > 0; i--) {
            int tmp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = tmp;
        }
    }

    /**
     * Метод, в который передается не пустой одномерный целочисленный массив, возвращает true если в массиве есть место,
     * в котором сумма левой и правой части массива равны
     *
     * @param array - массив целочисленных переменных;
     * @return - метод возвращает true, если в массиве есть место в котором сумма левой и правой части массива равны
     */
    private static boolean checkBalance(int[] array) {

        if (array != null && array.length > 0) {
            int sumLeft = 0;
            for (int i = 0; i < array.length; i++) {
                sumLeft += array[i];
                int sumRight = 0;
                for (int j = i + 1; j < array.length; j++) {
                    sumRight += array[j];
                }
                if (sumLeft == sumRight) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Метод поиска в массиве максимального элемента;
     *
     * @param array - массив целочисленных переменных;
     * @return - возвращает максимальный элемент массива.
     */
    private static int searchMax(int[] array) {
        int max = array[0];
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (i > 0) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
            }
        }
        return max;
    }

    /**
     * метод поиска в массиве минимального элемента;
     *
     * @param array - массив целочисленных переменных;
     * @return - возвращает минимальный элемент массива.
     */
    private static int searchMin(int[] array) {
        int min = array[0];
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (i > 0) {
                    if (array[i] < min) {
                        min = array[i];
                    }
                }
            }
        }
        return min;
    }

    /**
     * Метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
     *
     * @param array - целочисленный массив;
     */
    private static void multiplyByTwo(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 6) {
                    array[i] *= 2;
                }
            }
        }
    }

    /**
     * Метод, который с помощью цикла заполнит массив значениями 1 4 7 10 13 16 19 22;
     *
     * @param array - пустой целочисленный массив размером 8;
     */
    private static void fillArrInt(int[] array) {

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] += 3 * i + 1;

            }
        }
    }

    /**
     * Метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     *
     * @param array - массив, состоящий из элементов 0 и 1.
     */
    private static void changeArrInt(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else array[i] = 0;
            }
        }
    }
}
