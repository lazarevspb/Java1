package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

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
    public static final String MSG_WIN_HUMAN = "Победил игрок!";
    public static final String MSG_WIN_AI = "Победил комьпютер!";
    public static final String MSG_DRAW = "Ничья";
    public static final Random RANDOM = new Random();
    private static final int DOT_EMPTY = 0;
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_PADDING = 5;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private int stateGameOver;
    private boolean isGameOver;
    private boolean initialized;
    private int[][] field;

    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;


    /**
     * Класс, в котором создается игровое поле;
     */

    Map() {
//        setBackground(new Color(230, 255, 242));
        setBackground(new Color(174, 191, 190));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initialized = false;
    }

    private boolean checkEndGame(int dot, int stateGameOver) {
        if (checkWin(dot)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
           this.stateGameOver = STATE_DRAW;
           isGameOver = true;
           repaint();
            return true;
        }
        return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) return false;

            }
        }
        return true;
    }

    private static boolean overflowMap() {
//        for (int i = 0; i < square.length; i++) {
//            for (int j = 0; j < square.length; j++) {
//                if (isEmpty(i, j)) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

    private void aiTurn() {
        if (turnAIWinCell()) return;    // проверим, не выиграет-ли игрок на следующем ходу
        if(turnHumanWinCell()) return;  // проверим, не выиграет-ли комп на следующем ходу
        int x, y;
        do{                             // или комп ходит в случайную клетку
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);

        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(isEmptyCell(j, i)){  // TODO: 22.08.2020 проверить j, i или i,j
                    field[i][j] = DOT_HUMAN;
                    if(checkWin(DOT_HUMAN)){
                        field[i][j]= DOT_AI;
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean turnAIWinCell(){
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                    if(isEmptyCell(j, i)){
                        field[i][j]  = DOT_AI;          // поставим нолик в каждую клетку поля по очереди
                        if(checkWin(DOT_AI)) return true;     // если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                        field[i][j]  = DOT_EMPTY;           // если нет - вернём обратно пустоту в клетку и пойдём дальше

                }
            }
        }
        return false;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }





    private void update(MouseEvent e) {
        if (isGameOver || !initialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        System.out.printf("x: %d, y: %d\n", cellX, cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY))
            return;

        field[cellY][cellX] = DOT_HUMAN;// TODO: 23.08.2020 проверить X и
        // Y
        if(checkEndGame(DOT_HUMAN, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if(checkEndGame(DOT_AI, STATE_WIN_AI)) return;
    }

    private boolean isValidCell(int x, int y) {

        return x >= 0 && x < fieldSizeX &&
                y >= 0 && y < fieldSizeY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!initialized) return;
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(new Color(132, 255, 255));
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) continue;
                if (field[y][x] == DOT_HUMAN){
                    g.setColor(new Color(1, 1, 255));
                    g.fillOval(x*cellWidth + DOT_PADDING,
                            y*cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING *2,
                            cellHeight - DOT_PADDING *2);
                } else if (field[y][x] == DOT_AI){
                    g.setColor(Color.RED);
                    g.fillRect(x*cellWidth+DOT_PADDING,
                            y*cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING*2,
                            cellHeight - DOT_PADDING*2);
                } else {
                    throw new  RuntimeException(
                            String.format("Can't recognize cell field[%d][%d]: %d", y, x, field[y][x]));

                }


            }
        }
        if (isGameOver) showMessageGameOver(g);

    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, (getHeight()/2)-75, getWidth(), 150);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (stateGameOver) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, (getHeight() / 2) + 15);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, (getHeight() / 2) + 15);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, (getHeight() / 2) + 15);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + stateGameOver);
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

        this.fieldSizeY = fieldSizeY;
        this.fieldSizeX = fieldSizeX;
        this.winLength = winLength;
        field = new int[fieldSizeY][fieldSizeX];
        isGameOver = false;
        initialized = true;
        repaint();
    }

    /**
     * Метод проверяет линию в заданном направлении.
     *
     * @param x          начальная координата X проверяемой линии;
     * @param y          начальная координата Y проверяемой линии;
     * @param vx         направление линии по X;
     * @param vy         направление линии по Y;
     * @param lengthLine длинна линии;
     * @param c          проверяемый символж
     * @return возвращает иснину при нахождении линии заданной длинны заданного символа;
     */
    private boolean checkLine(int x, int y, int vx, int vy, int lengthLine, int c) {
        final int endPoint_x = x + (lengthLine - 1) * vx;  // посчитаем конец проверяемой линии
        final int endPoint_y = y + (lengthLine - 1) * vy;  // посчитаем конец проверяемой линии
        if (!isValidCell(endPoint_x, endPoint_y))
            return false; // проверим не выйдет-ли проверяемая линия за пределы поля
        for (int i = 0; i < lengthLine; i++) { // ползём по проверяемой линии
            if (field[y + i * vy][x + i * vx] != c) return false; // проверим одинаковые-ли символы в ячейках
        }
        return true;
    }

    private boolean checkWin(int c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {// проход по всему полю
                if (checkLine(i, j, 1, 0, winLength, c)) return true;// проверим линию по х
                if (checkLine(i, j, 1, 1, winLength, c)) return true;// проверим по диагонали х у
                if (checkLine(i, j, 0, 1, winLength, c)) return true;// проверим линию по у
                if (checkLine(i, j, 1, -1, winLength, c)) return true;// проверим по диагонали х -у

            }
        }

        return false;
    }

}
