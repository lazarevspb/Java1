package lesson7;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static lesson7.GameWindow.ICON_STR;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 340;
    private static final int WINDOW_HEIGHT = 259;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Выиграшная длинна: ";
    private static final String ICON_SETTINGS_STR = "\\img\\iconSettings.png";
    private GameWindow gameWindow;
    private JRadioButton hVa;
    private JRadioButton hVh;
    private JSlider sliderWinLength;
    private JSlider sliderFieldSize;
    private JPanel jPanel;

    SettingsWindow(GameWindow gameWindow) {

        this.setUndecorated(true);
        URL resURL = getClass().getResource(ICON_SETTINGS_STR);
        Image img = new ImageIcon(resURL).getImage();
        setIconImage(img);

        this.gameWindow = gameWindow;
//        setSize(WINDOW_WIDTH-10, WINDOW_HEIGHT-11);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);


        setTitle("Настройки игры");
        jPanel = new JPanel();
        jPanel.setBackground(Color.DARK_GRAY);
        jPanel.setBorder(new EmptyBorder(0, 6, 6, 6));

        JLabel jLabel = new JLabel();
        jLabel.setText("Выберите режим игры");

        jLabel.setForeground(new java.awt.Color(128, 128, 128));
        jPanel.setLayout(new GridLayout(10, 1));

        add(jPanel, BorderLayout.CENTER);
        jPanel.add(jLabel);

        addGameModeControls();
        addGameFieldControls();

        JButton buttonStart = new JButton("Начать новую игру");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStartClick();
            }


        });
buttonStart.setBackground(new Color(38, 38, 38));
        buttonStart.setForeground(new java.awt.Color(179, 179, 179));
        jPanel.add(buttonStart);


    }

    private void createRadioButton(JPanel jPanel, JRadioButton radioButton) {
        jPanel.add(radioButton);
        radioButton.setBackground(Color.DARK_GRAY);
        radioButton.setForeground(new Color(179, 179, 179));
    }


    private void addGameModeControls() {
        hVh = new JRadioButton("Человек против человека");
        hVa = new JRadioButton("Человек против ИИ", true);
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(hVa);
        gameMode.add(hVh);
        createRadioButton(jPanel, hVa);
        createRadioButton(jPanel, hVh);
    }

    private void addGameFieldControls() {
        JLabel jLabelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel jLabelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        jPanel.add(new JLabel("Выберите размер поля"));
        jPanel.add(jLabelFieldSize);

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

        sliderFieldSize.setBackground(Color.DARK_GRAY);
        sliderFieldSize.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        jPanel.add(sliderFieldSize);

        jPanel.add(new JLabel("Выберите выиграшную длинну"));
        jPanel.add(jLabelWinLength);
        sliderWinLength.setBackground(Color.DARK_GRAY);
        sliderWinLength.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        jPanel.add(sliderWinLength);
    }

    private void buttonStartClick() {
    int fieldSize = sliderFieldSize.getValue();
    int winLength = sliderWinLength.getValue();

    int gameMode;
    if (hVa.isSelected()){
gameMode = Map.MODE_HVA;
    }else if(hVh.isSelected()){
gameMode = Map.MODE_HVH;
    }else {
        throw new RuntimeException("Unexpected game mode!");
    }
gameWindow.startNewGame(gameMode, fieldSize,fieldSize,winLength);
    setVisible(false);
    }
}
