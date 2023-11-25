package com.example.games.gomokuData;

import android.util.Log;

import com.example.games.gomokuData.GomokuJudge.GoStoneAryIndex;

public class GoStoneData {
    final String TAG = "GoStoneData";
    final int SQUARE_WIDTH = 57; //マスの正方形の幅
    // 各碁石が配置できる座標を所持
    public Coordinate[][] coordinates = new Coordinate[19][19];
    //　碁石が置かれている場所を所持
    String[][]  whereTSheGoStonesArePlaced = new String[19][19];

    public void setGoStoneAtTheSpecifiedLocation(GoStoneAryIndex goStoneAryIndex){
        int i=goStoneAryIndex.getI();
        int j= goStoneAryIndex.getJ();
        String colorGoStone = goStoneAryIndex.getGoStoneColor();
        whereTSheGoStonesArePlaced[i][j]=colorGoStone;
    }

    public GoStoneData() {
        coordinate();
        coordinates[0][0].X = 20;
        coordinates[0][0].Y = 530;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (j != 0) coordinates[i][j].X = coordinates[i][j - 1].X + SQUARE_WIDTH;
                if (i != 0) coordinates[i][j].Y = coordinates[i - 1][j].Y + SQUARE_WIDTH;
                if (j == 0) coordinates[i][j].X = coordinates[i - 1][j].X;
                if (i == 0) coordinates[i][j].Y = coordinates[i][j - 1].Y;
            }
        }
    }

    public class Coordinate {
        public int X;
        public int Y;
    }


    void coordinate() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] = new Coordinate();
            }
        }
    }

    public void printCoordinate() {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                debug("X:" + coordinates[i][j].X + " Y:" + coordinates[i][j].Y);
            }
        }
    }
    public String[][] getWhereTSheGoStonesArePlaced(){
        return whereTSheGoStonesArePlaced;
    }

    public void debug(String msg) {
        Log.d(TAG, msg);
    }
}

