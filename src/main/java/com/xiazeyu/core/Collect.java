package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Info;

/**
 * 收集信息
 */
public class Collect {

    /**
     * 生成聚合根集合
     */
    public static void generateAggregationMap() {
        for (int j = 0; j < Config.chessBoardWidth; j++) {
            for (int i = 0; i < Config.chessBoardLength; i++) {
                String value = Config.chessBoardShow[i][j];
                if (Config.area_sign.equals(value) || Config.unEffect_sign.equals(value)) {
                    Info.aggregationMap.put(Aggregation.generateKey(i, j), generateAggregation(i, j));
                }
            }
        }
    }

    /**
     * 生成聚合根
     */
    public static Aggregation generateAggregation(int x, int y) {
        Node node = new Node();
        node.setX(x);
        node.setY(y);
        node.setAroundLandmineNum(Integer.valueOf(Config.chessBoardShow[x][y]));
        node.calcAroundAreas();
        Aggregation aggregation = new Aggregation();
        aggregation.setX(x);
        aggregation.setY(y);
        aggregation.setKey(Aggregation.generateKey(x, y));
        aggregation.setNode(node);
        aggregation.setAroundAreas(node.getAroundAreas());
        return aggregation;
    }

}
