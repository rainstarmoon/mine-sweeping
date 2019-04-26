package com.xiazeyu.core.data;

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
     * 周边空白格数
     */
    private int aroundAreaBlanksNum;
    /**
     * 周边空白格
     */
    private Set<AreaBlank> aroundAreaBlanks;

    /**
     * 周边地雷格数
     */
    private int aroundAreaMinesNum;
    /**
     * 周边地雷格
     */
    private Set<AreaMine> aroundAreaMines;

    /**
     * 计算周边有效格数
     */
    public int calcAroundAreaBlanks() {
        aroundAreaBlanksNum = 0;
        aroundAreaBlanks = new HashSet<>();
        for (int i = 0; i < Config.checkSuite.length; i++) {
            int tmpX = x + Config.checkSuite[i][0];
            int tmpY = y + Config.checkSuite[i][1];
            if (Tools.checkCoordinateUtil(tmpX, tmpY)) {
                continue;
            }
            String tmp = Config.chessBoardShow[tmpX][tmpY];
            if (Config.area_sign.equals(tmp)) {
                aroundAreaBlanksNum++;
                aroundAreaBlanks.add(new AreaBlank(tmpX, tmpY));
            }
        }
        return 0;
    }

    /**
     * 计算周边地雷格数
     */
    public int calcAroundAreaMines() {
        aroundAreaMinesNum = 0;
        aroundAreaMines = new HashSet<>();
        for (int i = 0; i < Config.checkSuite.length; i++) {
            int tmpX = x + Config.checkSuite[i][0];
            int tmpY = y + Config.checkSuite[i][1];
            if (Tools.checkCoordinateUtil(tmpX, tmpY)) {
                continue;
            }
            String tmp = Config.chessBoardShow[tmpX][tmpY];
            if (Config.effect_sign.equals(tmp)) {
                aroundAreaMinesNum++;
                aroundAreaMines.add(new AreaMine(tmpX, tmpY));
            }
        }
        return 0;
    }

    /**
     * 可以直接左键点击所有格的节点
     *
     * @return
     */
    public boolean leftClickNode() {
        if (aroundLandmineNum == aroundAreaMinesNum) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 可以直接右键点击所有格的节点
     *
     * @return
     */
    public boolean rightClickNode() {
        if (aroundLandmineNum - aroundAreaMinesNum == aroundAreaBlanksNum) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否是有效节点
     *
     * @return
     */
    public boolean valid() {
        if (aroundAreaBlanksNum == 0) {
            return false;
        } else {
            return true;
        }
    }

}