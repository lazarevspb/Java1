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

    /**
     * Метод, склеивающий два строковых ресурса.
     *
     * @param textFile1 переменная типа строка - основная часть текста;
     * @param textFile2 Переменная типа строка - "приклеиваемая" часть тексат;
     * @return возвращает объект класса StringBuilder;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static StringBuilder mergeTextMethod(String textFile1, String textFile2)
            throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getTextFromFile(textFile1)).append(getTextFromFile(textFile2));
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
                .toLowerCase().replaceAll("\\W+", " ") // удаляет все не слова и заменяет их на пробел
                .split("(\\s|,|!|'|`|\\.)"); //разбивает на подстроки при выявлении символов
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
        scanner.close();
        return stringBuilder;
    }

    /**
     * Метод, записывающий переданный тескт в файл;
     *
     * @param name      строковая переменная - имя файла в который юудет записан переданный текст,
     *                  если файла не существует, то он будет создан;
     * @param resources строковая переменная содержащая текст, который будет записан в файл.
     * @return в случае успешной записи (если удалось создать файл) возвращает true;
     * @throws FileNotFoundException исключение обрабатывается в вызывающем методе;
     */
    protected static boolean createTextFile(String name, String resources) throws FileNotFoundException {
        File file = new File(name);
        PrintStream printStream;
        printStream = new PrintStream(name);
        printStream.print(resources);
        printStream.flush();
        printStream.close();
        return file.exists();
    }
}



