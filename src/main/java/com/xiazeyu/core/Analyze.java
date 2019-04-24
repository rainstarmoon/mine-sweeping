package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Info;

import java.util.Collection;

/**
 * 分析信息
 */
public class Analyze {

    public static void simpleInfoDeal() {
        Collection<Aggregation> values = Info.aggregationMap.values();
        for (Aggregation value : values) {
            if (value.getNode().simpleNode()) {
                for (Area area : value.getAroundAreas()) {
                    Info.decisionSequence.add(
                            new Decision(Config.decision_type_simple, "com.xiazeyu.game.PlayGame" + Config.cmd_separation_sign + "click", new Object[]{area.getX(), area.getY()}));
                }
            }
        }
    }

}
