package com.xiazeyu.common;

public class Tools {

    /**
     * 判断点击坐标是否合法
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean checkCoordinateUtil(int x, int y) {
        if (x < 0 || y < 0 || x >= Config.chessBoardLength || y >= Config.chessBoardWidth) {
            // 点击越界
            return true;
        }
        return false;
    }

    /**
     * 判断是否是node
     *
     * @param x
     * @param y
     * @return
     */
    public static boolean checkNodeUtil(int x, int y) {
        String value = Config.chessBoardShow[x][y];
        if (Config.area_sign.equals(value) || Config.effect_sign.equals(value) || Config.unEffect_sign.equals(value)) {
            return false;
        }
        return true;
    }

    /**
     * 展示棋盘的数据转换
     *
     * @param tmp
     * @return
     */
    public static String translateNumForShow(String tmp) {
        switch (tmp) {
            case "1":
                tmp = "①";
                break;
            case "2":
                tmp = "②";
                break;
            case "3":
                tmp = "③";
                break;
            case "4":
                tmp = "④";
                break;
            case "5":
                tmp = "⑤";
                break;
            case "6":
                tmp = "⑥";
                break;
            case "7":
                tmp = "⑦";
                break;
            case "8":
                tmp = "⑧";
                break;
        }
        return tmp;
    }

}
