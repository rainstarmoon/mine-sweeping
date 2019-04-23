package com.xiazeyu;

import com.xiazeyu.game.CreateGame;
import com.xiazeyu.game.Game;
import com.xiazeyu.game.PlayGame;

public class Starter {

    public static void main(String[] args) {
        CreateGame.initChessBoard(9,9);
        CreateGame.initLandmine(10);
        PlayGame.click(1,1);
        PlayGame.show();

        System.out.println();
        System.out.println();
        System.out.println();
        for (int j = 0; j < Game.chessBoardWidth; j++) {
            for (int i = 0; i < Game.chessBoardLength; i++) {
                System.out.print(Game.chessBoard[i][j]);
            }
            System.out.println();
        }


    }

}
