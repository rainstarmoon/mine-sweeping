package com.xiazeyu.game;

import java.util.Random;

public class CreateGame {

    /**
     * 初始化棋盘
     */
    public static void initChessBoard(int length, int width) {
        if (length == 0 || width == 0) {
            throw new RuntimeException("棋盘长宽有误");
        }
        Game.chessBoardLength = length;
        Game.chessBoardWidth = width;
        Game.chessBoard = new int[length][width];
        Game.chessBoardShow = new String[length][width];
        Game.chessBoardClick = new int[length][width];
    }

    /**
     * 初始地雷
     */
    public static void initLandmine(int landmineNum) {
        if (landmineNum == 0) {
            throw new RuntimeException("地雷数量有误");
        }
        Game.landmineNum = landmineNum;
    }

    /**
     * 第一次点击之后正式开始准备环节
     */
    public static void ready(int x, int y) {
        Random ra = new Random();
        int canUsedGrid = Game.chessBoardLength * Game.chessBoardWidth - 1;
        int landmineNum = Game.landmineNum;
        if (canUsedGrid <= 0 || canUsedGrid <= Game.landmineNum) {
            throw new RuntimeException("可用网格不足");
        }
        for (int i = 0; i < Game.chessBoardLength; i++) {
            for (int j = 0; j < Game.chessBoardWidth; j++) {
                // 跳过第一次点击的点
                if (i == x && j == y) {
                    Game.chessBoard[i][j] = 0;
                    continue;
                }
                int raNum = (landmineNum > 0) ? ra.nextInt(canUsedGrid) : -1;
                if (raNum <= landmineNum) {
                    Game.chessBoard[i][j] = 1;
                    landmineNum--;
                } else {
                    Game.chessBoard[i][j] = 0;
                }
                canUsedGrid--;
            }
        }
        for (int i = 0; i < Game.chessBoardLength; i++) {
            for (int j = 0; j < Game.chessBoardWidth; j++) {
                Game.chessBoardShow[i][j] = "■";
            }
        }
    }


}
