package com.example.games.gomokuData;

import android.util.Log;

public class GoStoneCoordinateData {
    final String TAG = "GoStoneCoordinateData";
    final int SQUARE_WIDTH = 57; //マスの正方形の幅
    public Coordinate[][] coordinates = new Coordinate[19][19];

    public GoStoneCoordinateData() {
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

    public void debug(String msg) {
        Log.d(TAG, msg);
    }
}

