package com.xiazeyu.common;

public class Tools {

    public static boolean checkCoordinateUtil(int x, int y) {
        if (x < 0 || y < 0 || x >= Config.chessBoardLength || y >= Config.chessBoardWidth) {
            // 点击越界
            return true;
        }
        return false;
    }


}
