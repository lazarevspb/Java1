package lesson7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GameWindow extends JFrame {
    public static final int WIN_WIDTH = 500;
    public static final int WIN_HEIGHT = 555;
    public static final int WIN_POSX = (1273 - WIN_WIDTH) / 2; // TODO: 15.08.2020 удалить
    public static final int WIN_POSY = (720 - WIN_HEIGHT) / 2;// TODO: 15.08.2020 удалить
    public static final String ICON_STR = "\\img\\ico.png";

   private Map map;
   private SettingsWindow settingsWindow;

    GameWindow() {
//


        URL resURL = getClass().getResource(ICON_STR);
        Image img = new ImageIcon(resURL).getImage();
        setIconImage(img);
        setTitle("TicTacToe");
        setSize(WIN_WIDTH, WIN_HEIGHT);

        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.darkGray ));
        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.BLUE));
        UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.ITALIC, 20));
        JFrame.isDefaultLookAndFeelDecorated();

//        setIconImage();
//        setLocation(WIN_POSX, WIN_POSY);
        setLocationRelativeTo(null);//Расположение окна точно по цетру экрана
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);


        JButton buttonStart = new JButton("Играть!");
//        JButton buttonExit = new JButton("<html><body><b>Выход</b></body></html>");
        JButton buttonExit = new JButton("Выход");

//        JPanel jPanelMap = new JPanel();
        map = new Map();
        settingsWindow = new SettingsWindow(this);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
//                while (settingsWindow.getWidth() < WIN_WIDTH) {
//                    settingsWindow.pack();
//                }

            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//        jPanelMap.setBorder(new EmptyBorder(6, 6, 6, 6));
//        jPanelMap.setBackground(Color.DARK_GRAY);
        JPanel jPanel = new JPanel(); //https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html

        jPanel.setBackground(Color.BLUE);
        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.setBorder(new EmptyBorder(6, 6, 6, 6));


        jPanel.add(buttonStart);
        jPanel.add(buttonExit);

        add(map, BorderLayout.CENTER);
        add(jPanel, BorderLayout.SOUTH);

        setVisible(true);

    }


    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX,fieldSizeY, winLength);
    }

}
