package com.xiazeyu.common;

public class Config {

    public static final String area_sign = "■";

    public static final String unEffect_sign = "□";

    public static final String aggregation_key_sign = ",";

    public static final String cmd_separation_sign = "#";

    public static final String decision_type_simple = "simple";

    public static final String decision_type_complex = "complex";

    public static int chessBoardLength;

    public static int chessBoardWidth;

    public static int[][] chessBoard;

    public static int landmineNum;

    public static String[][] chessBoardShow;

    public static int[][] chessBoardClick;

    public static int clickNum;

    public static int[][] checkSuite = {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};


}
