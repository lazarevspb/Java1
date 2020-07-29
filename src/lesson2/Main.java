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
        print(Arrays.toString(arrInt), changeArrInt(arrInt), 1);

/*
2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
*/
        int[] arrInt2 = new int[8];
        print(Arrays.toString(arrInt2), fillArrInt(arrInt2), 2);

/*
3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
*/
        int[] arrInt3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        print(Arrays.toString(arrInt3), multiplyByTwo(arrInt3), 3);

/*
4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
*/
        int[] arrInt4 = new int[]{18, 13, 5, 3, 2, 11, 4, 25, -2, 2, 4, 8, 49, 12, -10, 32};
        print("Минимальный ", searchMin(arrInt4), arrInt4, 4);
        print("Максимальный ", searchMax(arrInt4), arrInt4, 4);

/*
5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);
*/
        int[][] arrInt5 = new int[5][5];
        for (int i = 0; i < arrInt5.length; i++) {
            for (int j = 0; j < arrInt5[i].length; j++) {
                if (i == j) {
                    arrInt5[i][j] = 1;
                } else if (j == (arrInt5.length - i - 1)) {
                    arrInt5[i][j] = 1;
                }
            }
        }
        printMultiArray(arrInt5);

/*
    6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место,
в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, 1, 2, 3, 4]) → true.
 */
        int[] arrInt6 = new int[]{2, 1, 1, 2, 1};
        System.out.println(checkBalance(arrInt6));

/*
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/
        int[] arrInt7 = new int[]{3, 5, 6, 1};
        int shiftQuantity = -2;
        arrayShift();
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
     * @param s
     * @param i
     * @param array
     */
    private static void print(String s, int i, int[] array, int task) {
        System.out.println("Задание №" + task + "\n" + Arrays.toString(array) + "\n" + s + " элемент массива: " + i + "\n");
    }

    /**
     * Метод передает в консоль форматированный вывод результатов работы других методов и служит для отладки их работы.
     *
     * @param firstArray
     * @param secondArray
     * @param task
     */
    private static void print(String firstArray, int[] secondArray, int task) {
        System.out.println("Задание №" + task + "\nИсходный массив:    " + firstArray + "\n" +
                "Обновленный массив: " + Arrays.toString(secondArray) + "\n");
    }

    private static void arrayShift() {
        // TODO: 29.07.2020
    }

    /**
     * Метод, в который передается не пустой одномерный целочисленный массив, возвращает true если в массиве есть место,
     * в котором сумма левой и правой части массива равны
     * 
     * @param array
     * @return
     */
    private static boolean checkBalance(int[] array) { //0, 1, 1, 0, 2, 1}

        if (array != null && array.length > 0) {
            int sumLeft = 0;
            for (int i = 0; i < array.length; i++) {
                sumLeft += array[i];
                int sumRight = 0;
                for (int j = i+1; j < array.length; j++) {
                    sumRight += array[j];
                    }
                if(sumLeft == sumRight){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * метод поиска в массиве максимального элемента;
     *
     * @param array
     * @return
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
     * @param array
     * @return
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
     * @return - меотод возвращает - целочисленный массив;
     */
    private static int[] multiplyByTwo(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 6) {
                    array[i] *= 2;
                }
            }
        }
        return array;
    }

    /**
     * Метод, который с помощью цикла заполнит массив значениями 1 4 7 10 13 16 19 22;
     *
     * @param array - пустой целочисленный массив размером 8;
     * @return - меотод возвращает - целочисленный массив;
     */
    private static int[] fillArrInt(int[] array) {
        int k = 1;
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] += k;
                k += 3;
            }
        }
        return array;
    }

    /**
     * Метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     *
     * @param array - массив, состоящий из элементов 0 и 1.
     * @return - меотод возвращает - целочисленный массив;
     */
    private static int[] changeArrInt(int[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else array[i] = 0;
            }
        }
        return array;
    }
}
