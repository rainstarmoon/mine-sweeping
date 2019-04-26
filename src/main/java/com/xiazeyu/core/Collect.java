package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Info;
import com.xiazeyu.common.Tools;
import com.xiazeyu.core.data.Aggregation;
import com.xiazeyu.core.data.Node;

/**
 * 收集信息
 */
public class Collect {

    /**
     * 生成聚合根集合
     */
    public static void generateAggregationMap() {
        Info.cleanAggregationMap();
        for (int j = 0; j < Config.chessBoardWidth; j++) {
            for (int i = 0; i < Config.chessBoardLength; i++) {
                if (Tools.checkNodeUtil(i, j)) {
                    Aggregation aggregation = generateAggregation(i, j);
                    if (aggregation != null) {
                        Info.aggregationMap.put(Aggregation.generateKey(i, j), aggregation);
                    }
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
        node.calcAroundAreaBlanks();
        node.calcAroundAreaMines();
        if (!node.valid()) {
            return null;
        }
        Aggregation aggregation = new Aggregation();
        aggregation.setX(x);
        aggregation.setY(y);
        aggregation.setKey(Aggregation.generateKey(x, y));
        aggregation.setNode(node);
        return aggregation;
    }

}
