package com.xiazeyu.game;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Tools;

import java.util.Scanner;

public class PlayGame {

    public static void play() {
        PlayGame.show();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String inLine = scan.nextLine();
            String[] split = inLine.split(",|[.]");
            if (split.length != 2) {
                System.out.print("输入指令有误");
                continue;
            }
            Integer x = Integer.valueOf(split[0]);
            Integer y = Integer.valueOf(split[1]);
            try {
                PlayGame.click(x, y);
                if (win()) {
                    System.out.println("恭喜您获得了胜利！！！");
                    break;
                }
            } catch (RuntimeException e) {
                Config.chessBoardShow[x][y] = "*";
                throw e;
            } finally {
                PlayGame.show();
            }
        }
    }

    /**
     * 点击棋盘
     */
    public static void click(Integer x, Integer y) {
        if (Config.clickNum == 0) {
            // 初始化棋盘
            CreateGame.ready(x, y);
        }
        // 点击次数
        Config.clickNum++;
        if (Tools.checkCoordinateUtil(x, y)) {
            // 点击越界
            return;
        }
        if (Config.chessBoardClick[x][y] == 1) {
            // 点过了
            return;
        } else {
            // 记录点击
            Config.chessBoardClick[x][y] = 1;
        }
        // 点中地雷
        if (Config.chessBoard[x][y] == 1) {
            throw new RuntimeException("Config over");
        }
        // 计算所点位置显示值
        int calc = calc(x, y);
        if (calc == 0) {
            // 点击位置周围8格没有雷
            Config.chessBoardShow[x][y] = Config.unEffect_sign;
            // 周围8格递归点击
            for (int i = 0; i < Config.checkSuite.length; i++) {
                click(x + Config.checkSuite[i][0], y + Config.checkSuite[i][1]);
            }
        } else {
            // 点击位置周围8格有雷
            Config.chessBoardShow[x][y] = translateNum(calc);
        }
    }


    /**
     * 检查是否有雷
     */
    public static int check(int x, int y) {
        try {
            return Config.chessBoard[x][y];
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
        for (int i = 0; i < Config.checkSuite.length; i++) {
            tmpNum += check(x + Config.checkSuite[i][0], y + Config.checkSuite[i][1]);
        }
        return tmpNum;
    }

    /**
     * 展示结果
     */
    public static void show() {
        System.out.print("┏");
        for (int i = 1; i < Config.chessBoardLength + 1; i++) {
            System.out.print("━");
        }
        System.out.println("┓");
        for (int j = 0; j < Config.chessBoardWidth; j++) {
            System.out.print("┃");
            for (int i = 0; i < Config.chessBoardLength; i++) {
                System.out.print(Config.chessBoardShow[i][j]);
            }
            System.out.println("┃");
        }
        System.out.print("┗");
        for (int i = 1; i < Config.chessBoardLength + 1; i++) {
            System.out.print("━");
        }
        System.out.println("┛");

//        for (int j = 0; j < Config.chessBoardWidth; j++) {
//            for (int i = 0; i < Config.chessBoardLength; i++) {
//                System.out.print(Config.chessBoard[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static boolean win() {
        int noClick = 0;
        for (int j = 0; j < Config.chessBoardWidth; j++) {
            for (int i = 0; i < Config.chessBoardLength; i++) {
                if (Config.area_sign.equals(Config.chessBoardShow[i][j])) {
                    noClick++;
                }
            }
        }
        if (noClick == Config.landmineNum) {
            return true;
        }
        return false;
    }

    public static String translateNum(int num) {
        String tmp = null;
        switch (num) {
            case 1:
                tmp = "①";
                break;
            case 2:
                tmp = "②";
                break;
            case 3:
                tmp = "③";
                break;
            case 4:
                tmp = "④";
                break;
            case 5:
                tmp = "⑤";
                break;
            case 6:
                tmp = "⑥";
                break;
            case 7:
                tmp = "⑦";
                break;
            case 8:
                tmp = "⑧";
                break;
        }
        return tmp;
    }

}
