package com.xiazeyu;

import com.xiazeyu.core.AIRunner;
import com.xiazeyu.game.CreateGame;

public class Starter {

    public static void main(String[] args) {
        CreateGame.create(30, 16, 39);
        //PlayGame.play();
        AIRunner.run();
    }

}
