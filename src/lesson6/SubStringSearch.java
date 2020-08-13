package lesson6;

import java.io.FileNotFoundException;

/**
 * Класс содержащий методы для поиска слова в указанном файле
 */
public class SubStringSearch extends StringMethod {
    /**
     * Метод, реализующий поиск в указанном файле;
     *
     * @param fileName переменная типа Строка. Файл, в котором производится поиск;
     * @param stringSearch переменная типа Строка, слово поиск которого производит метод;
     * @return случае успешного поиска возвращает true;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    public static Boolean searchString(String fileName, String stringSearch) throws FileNotFoundException {
        String[] array = getsArr(fileName);
        for (String s : array) {
            if (s.equals(stringSearch.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}