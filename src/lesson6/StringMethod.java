package lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Класс содержащий в себе методы для работы со строками;
 */
public class StringMethod {
    private static StringBuilder stringBuilder = new StringBuilder();

    /**
     * Метод, склеивающий два строковых ресурса. Добавляет перенос строки между склеиваемыми кусками текста.
     *
     * @param textFile1 переменная типа строка - основная часть текста;
     * @param textFile2 Переменная типа строка - "приклеиваемая" часть тексат;
     * @return возвращает объект класса StringBuilder;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static StringBuilder mergeTextMethod(String textFile1, String textFile2) throws FileNotFoundException {
        return stringBuilder.append(getTextFromFile(textFile1)).append("\n").append(getTextFromFile(textFile2));
    }

    /**
     * Метод "извлекающий" из текстового файла массив подстрок.
     *
     * @param fileName строковая переменная - имя файла из которого получаем массив подстрок (слов);
     * @return возвращает массив строк содержащий в себе подстроки переданного в параметры метода файла;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static String[] getsArr(String fileName) throws FileNotFoundException {
        String[] s;
        s = getTextFromFile(fileName).toString()
                .toLowerCase().replaceAll("\\W+", " ")
                .split("(\\s|,|!|'|`|\\.)");
        return s;
    }

    /**
     * Метод, извлекающий текст из переданного файла;
     *
     * @param fileName строковая переменная - имя файла из которого извлекаем тескт;
     * @return возвращает объект класса StringBuilder;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static StringBuilder getTextFromFile(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        return stringBuilder;
    }

    /**
     * Метод, записывающий переданный тескт в файл;
     *
     * @param name      строковая переменная - имя файла в который юудет записан переданный текст,
     *                  если файла не существует, то он будет создан;
     * @param resources строковая переменная содержащая текст, который будет записан в файл.
     * @return в случае успешной записи возвращает true;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static boolean getPrintStream(String name, String resources) throws FileNotFoundException {
        File file = new File(name);
        PrintStream printStream;
        printStream = new PrintStream(name);
        printStream.print(resources);
        return file.exists();
    }
}



