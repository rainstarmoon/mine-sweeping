package com.xiazeyu;

import com.xiazeyu.game.CreateGame;
import com.xiazeyu.game.PlayGame;

public class Starter {

    public static void main(String[] args) {
        CreateGame.create(30,16,99);
        PlayGame.play();
    }

}
