package lesson6;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Класс реализующий методы для поиска слова в каталоге.
 */
public class SubStringSearchInDirectory extends SubStringSearch {
    /**
     * Метод, реализующий поиск в указанном каталоге;
     *
     * @param dir переменная типа Строка. Каталог, в котором производится поиск;
     * @param searchString переменная типа Строка, слово поиск которого производит метод;
     * @return  в случае успешного поиска возвращает true;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    public static boolean searchInDirectory(String dir, String searchString) throws FileNotFoundException {
        File currentDirectory = new File(dir);
        String[] arrFileName = currentDirectory.list();
        if (arrFileName != null) {
            for (String s : arrFileName) {
                if (s.endsWith(".txt")) {
                    if (searchString(s, searchString)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
