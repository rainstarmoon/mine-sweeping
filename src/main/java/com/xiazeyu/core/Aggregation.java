package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import lombok.Data;

import java.util.Set;

/**
 * 聚合根
 */
@Data
public class Aggregation {

    /**
     * 横坐标
     */
    private int x;

    /**
     * 纵坐标
     */
    private int y;

    /**
     * 聚合根的key
     * x+","+y
     */
    private String key;

    /**
     * 对应node
     */
    private Node node;
    /**
     * 对应的空白区域
     */
    private Set<Area> aroundAreas;

    public static String generateKey(int x, int y) {
        return x + Config.aggregation_key_sign + y;
    }

}
