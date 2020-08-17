package lesson7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * GameWindow - класс, в котором создается игровое окно;
 */
public class GameWindow extends JFrame {
    /**
     * Размер окна по ширине;
     */
    public static final int WIN_WIDTH = 500;
    /**
     * Размер окна по высоте;
     */
    public static final int WIN_HEIGHT = 555;
    /**
     * Относительный путь к изображения мконки;
     */
    public static final String ICON_STR = "\\img\\ico.png";
    /**
     * Создание объекта типа Map;
     */
    private Map map;
    /**
     * Создание объекта типа settingsWindow;
     */
    private SettingsWindow settingsWindow;

    /**
     * Конструктор игрового окна;
     */
    GameWindow() {
        this.setUndecorated(true); //удаляет тайтл окна GameWindow
        setTitle("TicTacToe");
        iconInstall(ICON_STR);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo(null);//Расположение окна точно по цетру экрана

        settingsWindow = new SettingsWindow(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JButton buttonStart = new JButton("Играть!");
        JButton buttonExit = new JButton("Выход");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel(); //https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html
        jPanel.setBackground(Color.BLUE);
        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.setBorder(new EmptyBorder(6, 6, 6, 6));
        jPanel.add(buttonStart);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        map = new Map();
        JPanel jPanelMap = new JPanel();
        jPanelMap.setLayout(new BorderLayout(0, 0));
        jPanelMap.setBorder(new EmptyBorder(6, 6, 6, 6));
        jPanelMap.setBackground(Color.darkGray);
        jPanelMap.add(map);
        add(jPanelMap, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Метод, добавляющий иконку на тайтл;
     *
     * @param resIcon переменная типа String - путь к ресурсу;
     */
    private void iconInstall(String resIcon) {
        URL resURL = getClass().getResource(resIcon);
        Image img = new ImageIcon(resURL).getImage();
        setIconImage(img);
    }

    /**
     * Метод, вызывающий метод startNewGame через экемпляр класса map;
     *
     * @param mode       целочисленная переменная - режим игры;
     * @param fieldSizeX целочисленная переменная размер поля, координаты по Х;
     * @param fieldSizeY целочисленная переменная размер поля, координаты по У;
     * @param winLength  целочисленная переменная - выиграшная длинна;
     */
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
