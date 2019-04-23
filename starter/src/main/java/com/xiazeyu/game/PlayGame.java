package com.xiazeyu.game;

public class PlayGame {

    /**
     * 点击棋盘
     */
    public static void click(int x, int y) {
        if (Game.clickNum == 0) {
            CreateGame.ready(x, y);
        }
        Game.clickNum++;
        if (x < 0 || y < 0 || x >= Game.chessBoardLength || y >= Game.chessBoardWidth) {
            return;
        }
        if (Game.chessBoardClick[x][y] == 1) {
            return;
        } else {
            Game.chessBoardClick[x][y] = 1;
        }
        int calc = calc(x, y);
        if (calc == 0) {
            Game.chessBoardShow[x][y] = " ";
            for (int i = 0; i < Game.checkSuite.length; i++) {
                click(x + Game.checkSuite[i][0], y + Game.checkSuite[i][1]);
            }
        } else {
            Game.chessBoardShow[x][y] = String.valueOf(calc);
        }
    }


    /**
     * 检查是否有雷
     */
    public static int check(int x, int y) {
        try {
            return Game.chessBoard[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    /**
     * 计算周围8个格子的地雷数量
     *
     * @param x
     * @param y
     */
    public static int calc(int x, int y) {
        int tmpNum = 0;
        for (int i = 0; i < Game.checkSuite.length; i++) {
            tmpNum += check(x + Game.checkSuite[i][0], y + Game.checkSuite[i][1]);
        }
        return tmpNum;
    }

    /**
     * 展示结果
     */
    public static void show() {
        System.out.print("┏");
        for (int i = 1; i < Game.chessBoardLength + 1; i++) {
            System.out.print("━");
        }
        System.out.print("┓");
        System.out.println();
        for (int j = 0; j < Game.chessBoardWidth; j++) {
            System.out.print("┃");
            for (int i = 0; i < Game.chessBoardLength; i++) {
                System.out.print(Game.chessBoardShow[i][j]);
            }
            System.out.print("┃");
            System.out.println();
        }
        System.out.print("┗");
        for (int i = 1; i < Game.chessBoardLength + 1; i++) {
            System.out.print("━");
        }
        System.out.print("┛");
        System.out.println();
    }

}
