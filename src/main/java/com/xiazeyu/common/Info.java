package com.xiazeyu.common;

import com.xiazeyu.core.data.Aggregation;
import com.xiazeyu.core.data.Decision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Info {

    /**
     * 聚合根map
     */
    public static Map<String, Aggregation> aggregationMap = new HashMap<>();

    public static void cleanAggregationMap() {
        aggregationMap = new HashMap<>();
    }

    /**
     * 决策序列
     */
    public static List<Decision> decisionSequence = new ArrayList<>();

    public static void cleanDecisionSequence() {
        decisionSequence = new ArrayList<>();
    }

}
