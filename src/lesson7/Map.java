package lesson7;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Map extends JPanel {
    /**
     * Игровой режим - Человек против АИ;
     */
    public static final int MODE_HVA = 0;
    /**
     * Игровой режим - Человек против ИИ;
     */
    public static final int MODE_HVH = 1;

    /**
     * Класс, в котором создается игровое поле;
     */
    Map() {
        setBackground(new Color(230, 255, 242));
    }

    /**
     * Метод, инициализирующий игровое поле;
     *
     * @param fieldSizeX целочисленная переменная, ширина поля по Х;
     * @param fieldSizeY целочисленная переменная, ширина поля по У;
     */
    public void initMap(int fieldSizeX, int fieldSizeY) {
        this.removeAll();

        setLayout(new GridLayout(fieldSizeX, fieldSizeY));
        JButton[][] buttonField = new JButton[fieldSizeX][fieldSizeY];

        for (int i = 0; i < buttonField.length; i++) {
            for (int j = 0; j < buttonField.length; j++) {
                buttonField[i][j] = new JButton(i + "," + j);
                buttonField[i][j].setContentAreaFilled(false);
                add(buttonField[i][j]);
                buttonField[i][j].setText("" + i + j);
            }
        }
    }

    /**
     * Метод, принимающий игровые параметры из SettingsWindow;
     *
     * @param mode       целочисленная переменная - режим игры;
     * @param fieldSizeX целочисленная переменная размер поля, координаты по Х;
     * @param fieldSizeY целочисленная переменная размер поля, координаты по У;
     * @param winLength  целочисленная переменная - выиграшная длинна;
     */
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        initMap(fieldSizeX, fieldSizeY);
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
    }
}
