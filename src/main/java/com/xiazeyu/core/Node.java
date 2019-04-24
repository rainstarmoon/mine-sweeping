package com.xiazeyu.core;

import com.xiazeyu.common.Config;
import com.xiazeyu.common.Tools;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 带有信息的节点
 */
@Data
public class Node {

    /**
     * 横坐标
     */
    private int x;
    /**
     * 纵坐标
     */
    private int y;
    /**
     * 周边地雷数
     */
    private int aroundLandmineNum;
    /**
     * 周边有效格数
     */
    private int aroundAreasNum;
    /**
     * 对应的空白区域
     */
    private Set<Area> aroundAreas;

    /**
     * 计算周边有效格数
     */
    public int calcAroundAreas() {
        aroundAreasNum = 0;
        aroundAreas = new HashSet<>();
        for (int i = 0; i < Config.checkSuite.length; i++) {
            int tmpX = x + Config.checkSuite[i][0];
            int tmpY = y + Config.checkSuite[i][1];
            if (Tools.checkCoordinateUtil(tmpX, tmpY)) {
                continue;
            }
            String tmp = Config.chessBoardShow[tmpX][tmpY];
            if (Config.area_sign.equals(tmp)) {
                aroundAreasNum++;
                aroundAreas.add(new Area(tmpX, tmpY));
            }
        }
        return 0;
    }

    public boolean simpleNode() {
        if (aroundLandmineNum == aroundAreasNum) {
            return true;
        } else {
            return false;
        }
    }

}