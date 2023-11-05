package com.example.games.gomokuData;

public class GomokuJudge {


    public  GoStoneAryIndex Nearbycoordinates(int x, int y, GoStoneData.Coordinate[][] coordinates) {
        double min = Math.sqrt((coordinates[0][0].X - x) * (coordinates[0][0].X - x) + (coordinates[0][0].Y - y) * (coordinates[0][0].Y - y));
        GoStoneAryIndex goStoneAryIndex = new GoStoneAryIndex(0, 0);
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                double IsItSmallerThanMin = Math.sqrt((coordinates[i][j].X - x) * (coordinates[i][j].X - x) + (coordinates[i][j].Y - y) * (coordinates[i][j].Y - y));
                if (min > IsItSmallerThanMin) {
                    min = IsItSmallerThanMin;
                    goStoneAryIndex = new GoStoneAryIndex(i, j);
                }
            }
        }
        return goStoneAryIndex;
    }

    public static class GoStoneAryIndex {
        final int i;
        final int j;

        public GoStoneAryIndex(final int i, final int j) {
            this.i = i;
            this.j = j;
        }

        public int getI(){
            return i;
        }
        public int getJ(){
            return j;
        }
    }

}
