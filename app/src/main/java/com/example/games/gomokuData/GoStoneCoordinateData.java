package com.example.games.gomokuData;

import android.util.Log;

public class GoStoneCoordinateData {
    final String TAG = "GoStoneCoordinateData";
    final int SQUARE_WIDTH = 58; //マスの正方形の幅
    Coordinate[][] coordinates = new Coordinate[18][18];

    public GoStoneCoordinateData() {
        coodinateInit();
        coordinates[0][0].X = 20;
        coordinates[0][0].Y = 588;
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

    void coodinateInit() {
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

