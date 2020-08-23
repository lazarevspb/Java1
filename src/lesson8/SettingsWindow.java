package lesson8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SettingsWindow extends JFrame {
    /**
     * Размер окна настроек по ширине;
     */
    private static final int WINDOW_WIDTH = 340;
//    private static final int WINDOW_WIDTH = 350;
    /**
     * Размер окна настроек по высоте;
     */
    private static final int WINDOW_HEIGHT = 259;
//    private static final int WINDOW_HEIGHT = 269;
    /**
     * Минимальная выиграшная длинна;
     */
    private static final int MIN_WIN_LENGTH = 3;
    /**
     * Минимальный размер поля;
     */
    private static final int MIN_FIELD_SIZE = 3;
    /**
     * Максимальный размер поля;
     */
    private static final int MAX_FIELD_SIZE = 10;
    /**
     * Строкоый ресурс;
     */
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    /**
     * Строкоый ресурс;
     */
    private static final String WIN_LENGTH_PREFIX = "Выигрышная длинна: ";
    /**
     * Строковый ресурс, отностиельный путь к папке содержайщий изображение иконки;
     */
    private static final String ICON_SETTINGS_STR = "\\img\\iconSettings.png";
    private GameWindow gameWindow;
    private JRadioButton hVa;
    private JRadioButton hVh;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private JPanel jPanel;

    /**
     * Конструктор окна SettingsWindow;
     *
     * @param gameWindow принимает объект класса gameWindow,
     *                   благодаря чему есть возможность передать настройки игры игровому окну;
     */
    SettingsWindow(GameWindow gameWindow) {
        this.setUndecorated(true);
        this.gameWindow = gameWindow;

        iconInstall(ICON_SETTINGS_STR);
        setTitle("Настройки игры");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);


        jPanel = new JPanel();
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(new EmptyBorder(0, 6, 6, 6));
        jPanel.setLayout(new GridLayout(10, 1));
        add(jPanel, BorderLayout.CENTER);

        JLabel jLabel = new JLabel();
        jLabel.setText("Выберите режим игры");
        jLabel.setForeground(new java.awt.Color(128, 128, 128));
        jPanel.add(jLabel);

        addGameModeControls();
        addGameFieldControls();

        JButton buttonStart = new JButton("Начать новую игру");
        buttonStart.setBackground(new Color(38, 38, 38));
        buttonStart.setForeground(new java.awt.Color(179, 179, 179));
        jPanel.add(buttonStart);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonStartClick();
            }
        });
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
     * Метод, добавляющий на Jpanel элемент интерфейса, радиокнопку
     * и устонавливающий ей цвет в соотсветсвии с интерфесом;;
     *
     * @param jPanel      объект класса jPanel;
     * @param radioButton радиокнопка;
     */
    private void createRadioButton(JPanel jPanel, JRadioButton radioButton) {
        jPanel.add(radioButton);
        radioButton.setBackground(Color.DARK_GRAY);
        radioButton.setForeground(new Color(179, 179, 179));
    }

    /**
     * Метод, в котором происходит инициализация и добавление
     * в контейнер Jpanel элементов интерфейса конструктора класса SettingsWindow;
     */
    private void addGameModeControls() {
        hVh = new JRadioButton("Человек против человека");
        hVa = new JRadioButton("Человек против ИИ", true);

        ButtonGroup gameMode = new ButtonGroup();

        hVa.setBackground(Color.white);
        hVh.setForeground(new java.awt.Color(128, 128, 128));
        gameMode.add(hVa);
        gameMode.add(hVh);
        createRadioButton(jPanel, hVa);
        createRadioButton(jPanel, hVh);
    }

    /**
     * Метод, в котором происходит инициализация и добавление
     * в контейнер Jpanel элементов интерфейса конструктора класса SettingsWindow;
     */
    private void addGameFieldControls() {
        JLabel jLabelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel jLabelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        jLabelFieldSize.setForeground(new java.awt.Color(179, 179, 179));
        jLabelWinLength.setForeground(new java.awt.Color(179, 179, 179));

        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setBackground(Color.DARK_GRAY);
        sliderFieldSize.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        sliderWinLength.setBackground(Color.DARK_GRAY);
        sliderWinLength.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        jPanel.add(new JLabel("Выберите размер поля")).setForeground(new java.awt.Color(128, 128, 128));
        jPanel.add(jLabelFieldSize);
        jPanel.add(sliderFieldSize);
        jPanel.add(new JLabel("Выберите выигрышную длинну")).setForeground(new java.awt.Color(128, 128, 128));
        jPanel.add(jLabelWinLength);
        jPanel.add(sliderWinLength);

        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                jLabelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });


    }

    /**
     * Метод, в котором передаются заданные значения настроек игры в игровое окно gameWindow,
     * делает невидимым окно настроек;
     */
    private void buttonStartClick() {
        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();
        int gameMode;

        if (hVa.isSelected()) {
            gameMode = Map.MODE_HVA;
        } else if (hVh.isSelected()) {
            gameMode = Map.MODE_HVH;
        } else {
            throw new RuntimeException("Unexpected game mode!");
        }
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }
}
