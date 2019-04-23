package com.xiazeyu.game;

public class Game {

    public static int chessBoardLength;

    public static int chessBoardWidth;

    public static int[][] chessBoard;

    public static int landmineNum;

    public static String[][] chessBoardShow;

    public static int[][] chessBoardClick;

    public static int clickNum;

    public static int[][] checkSuite = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

}
