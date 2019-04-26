package com.xiazeyu.core.data;

import com.xiazeyu.common.Config;
import lombok.Data;

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


    public static String generateKey(int x, int y) {
        return x + Config.aggregation_key_sign + y;
    }

}
