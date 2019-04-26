package com.xiazeyu.core;

import com.xiazeyu.Exception.GameException;
import com.xiazeyu.common.Config;
import com.xiazeyu.game.PlayGame;

import java.util.Objects;
import java.util.Scanner;

public class AIRunner {

    public static void run() {
        PlayGame.show();
        Scanner scan = new Scanner(System.in);
        String inLine = scan.nextLine();
        String[] split = inLine.split(",|[.]");
        if (split.length != 2) {
            System.out.print("输入指令有误");
            return;
        }
        Integer x = Integer.valueOf(split[0]);
        Integer y = Integer.valueOf(split[1]);
        try {
            PlayGame.clickLeft(x, y);
            PlayGame.show();
            String flag = "right";
            Integer rightNum = 0;
            Integer leftNum = 0;
            while (true) {
                Collect.generateAggregationMap();
                Analyze.simpleNodeDeal(flag);
                Integer num = Evaluate.execute();
                if ("right".equals(flag)) {
                    flag = "left";
                    rightNum = num;
                } else {
                    if (Objects.equals(0, num)) {
                        // 继续执行
                    } else {
                        flag = "right";
                    }
                    leftNum = num;
                }
                if (leftNum == null && rightNum == null) {
                    break;
                }
            }
            if (PlayGame.win()) {
                System.out.println("恭喜您获得了胜利！！！");
                return;
            }
        } catch (GameException e) {
            Config.chessBoardShow[x][y] = "×";
            throw e;
        } finally {
            PlayGame.show();
        }
    }

}
