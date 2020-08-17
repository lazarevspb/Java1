package lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;
    int fieldSizeX= 1;
    int  fieldSizeY = 1;
    int winLength, mode;

    Map(){
        setBackground(new Color(230, 255, 242));
    }

    public void initMap (int fieldSizeX, int  fieldSizeY) {
        this.removeAll();
        setLayout(new GridLayout(fieldSizeX, fieldSizeY));
        JButton[][] buttonField = new JButton[fieldSizeX][fieldSizeY];


        for (int i = 0; i <buttonField.length ; i++) {
            for (int j = 0; j < buttonField.length; j++) {
                buttonField[i][j] = new JButton(i + "," + j);
                buttonField[i][j].setContentAreaFilled(false);
                add(buttonField[i][j]);
                buttonField[i][j].setText(""+ i + j);
            }
        }
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        initMap(fieldSizeX, fieldSizeY);
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
    }

}
