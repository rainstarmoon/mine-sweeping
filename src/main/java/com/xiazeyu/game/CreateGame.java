package com.xiazeyu.game;

import com.xiazeyu.exception.ConfigException;
import com.xiazeyu.common.Config;

import java.util.Random;

public class CreateGame {

    public static void create(int length, int width, int landmineNum) {
        initChessBoard(length, width);
        initLandmine(landmineNum);
    }

    /**
     * 初始化棋盘
     */
    public static void initChessBoard(int length, int width) {
        if (length == 0 || width == 0) {
            throw new ConfigException("棋盘长宽有误");
        }
        // 初始化长宽
        Config.chessBoardLength = length;
        Config.chessBoardWidth = width;
        // 初始化地雷棋盘
        Config.chessBoard = new int[length][width];
        // 初始化展示棋盘
        Config.chessBoardShow = new String[length][width];
        // 初始化点击棋盘
        Config.chessBoardClick = new int[length][width];
        // 初始化展示棋盘数据
        for (int i = 0; i < Config.chessBoardLength; i++) {
            for (int j = 0; j < Config.chessBoardWidth; j++) {
                Config.chessBoardShow[i][j] = Config.area_sign;
            }
        }
    }

    /**
     * 初始地雷
     */
    public static void initLandmine(int landmineNum) {
        if (landmineNum == 0) {
            throw new ConfigException("地雷数量有误");
        }
        Config.landmineNum = landmineNum;
    }

    /**
     * 第一次点击之后正式开始准备环节
     */
    public static void ready(int x, int y) {
        Random ra = new Random();
        int canUsedGrid = Config.chessBoardLength * Config.chessBoardWidth - 1;
        int landmineNum = Config.landmineNum;
        if (canUsedGrid <= 0 || canUsedGrid <= Config.landmineNum) {
            throw new ConfigException("可用网格不足");
        }
        for (int i = 0; i < Config.chessBoardLength; i++) {
            for (int j = 0; j < Config.chessBoardWidth; j++) {
                // 跳过第一次点击的点
                if (i == x && j == y) {
                    Config.chessBoard[i][j] = 0;
                    continue;
                }
                int raNum = (landmineNum > 0) ? ra.nextInt(canUsedGrid) : Integer.MAX_VALUE;
                if (raNum <= landmineNum) {
                    Config.chessBoard[i][j] = 1;
                    landmineNum--;
                } else {
                    Config.chessBoard[i][j] = 0;
                }
                canUsedGrid--;
            }
        }
    }

}
