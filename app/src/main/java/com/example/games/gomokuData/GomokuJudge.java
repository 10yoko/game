package com.example.games.gomokuData;

public class GomokuJudge {


    public GoStoneAryIndex Nearbycoordinates(int x, int y, GoStoneData.Coordinate[][] coordinates) {
        double min = Math.sqrt((coordinates[0][0].X - x) * (coordinates[0][0].X - x) + (coordinates[0][0].Y - y) * (coordinates[0][0].Y - y));
        GoStoneAryIndex goStoneAryIndex = new GoStoneAryIndex(0, 0);//初期化しているだけ
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                double IsItSmallerThanMin = Math.sqrt((coordinates[i][j].X - x) * (coordinates[i][j].X - x) + (coordinates[i][j].Y - y) * (coordinates[i][j].Y - y));
                if (min > IsItSmallerThanMin) {
                    min = IsItSmallerThanMin;
                    goStoneAryIndex.i = i;
                    goStoneAryIndex.j = j;
                }
            }
        }

        // Adjusting coordinates
        // 座標が一つずれる為調整しています。原因が分かった際は直す
        goStoneAryIndex.i = goStoneAryIndex.i - 1;
        return goStoneAryIndex;
    }

    // 碁石を置いた、要素数
    public static class GoStoneAryIndex {
        private int i;
        private int j;

        public GoStoneAryIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }


        // setter,getter
        public void setI(int i) {
            this.i = i;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

}
