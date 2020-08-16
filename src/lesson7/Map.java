package lesson7;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    String[] s;// TODO: 16.08.2020  если не используется, то удалить
    Map(){

        JPanel jPanelMap = new JPanel();

        jPanelMap.setBorder(new EmptyBorder(6, 6, 6, 6));
        jPanelMap.setBackground(Color.DARK_GRAY);

        add(jPanelMap, new GridLayout(3, 3));

        setBackground(Color.RED);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
    }

}
