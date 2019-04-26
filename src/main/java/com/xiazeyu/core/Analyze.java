package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Info;
import com.xiazeyu.core.data.Aggregation;
import com.xiazeyu.core.data.AreaBlank;
import com.xiazeyu.core.data.Decision;
import com.xiazeyu.core.data.Node;

import java.util.Collection;

/**
 * 分析信息
 */
public class Analyze {

    public static void simpleNodeDeal(String direction) {
        Info.cleanDecisionSequence();
        Collection<Aggregation> values = Info.aggregationMap.values();
        for (Aggregation value : values) {
            Node node = value.getNode();
            if ("left".equals(direction)) {
                if (node.leftClickNode()) {
                    for (AreaBlank areaBlank : node.getAroundAreaBlanks()) {
                        Info.decisionSequence.add(
                                new Decision(Config.decision_type_simple, "com.xiazeyu.game.PlayGame" + Config.cmd_separation_sign + "clickLeft", new Object[]{areaBlank.getX(), areaBlank.getY()}));
                    }
                }
            } else if ("right".equals(direction)) {
                if (node.rightClickNode()) {
                    for (AreaBlank areaBlank : node.getAroundAreaBlanks()) {
                        Info.decisionSequence.add(
                                new Decision(Config.decision_type_simple, "com.xiazeyu.game.PlayGame" + Config.cmd_separation_sign + "clickRight", new Object[]{areaBlank.getX(), areaBlank.getY()}));
                    }
                }
            }
        }
    }

}
