package com.example.games.view;

import static com.example.games.gomokuData.GomokuJudge.*;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.games.gomokuData.GoStoneData;
import com.example.games.gomokuData.GomokuJudge;

public class MyCustomView extends View {
    final String TAG = "MyCustomView";

    GoStoneData goStoneData;
    String[][] whereTSheGoStonesArePlaced = new String[19][19];


    public void debug(String msg) {
        Log.d(TAG, msg);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        goStoneData = new GoStoneData();
        // コンストラクタの処理を追加
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 描画コードをここに追加
        paintTest(canvas);

    }

    void paintTest(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        //描画処理
        for (int i = 0; i < whereTSheGoStonesArePlaced.length; i++) {
            for (int j = 0; j < whereTSheGoStonesArePlaced[i].length; j++) {
                if(whereTSheGoStonesArePlaced[i][j]==null)continue;
                if(whereTSheGoStonesArePlaced[i][j].equals("黒")){
                    paint.setColor(Color.BLACK);
                }else {
                    paint.setColor(Color.WHITE);
                }
                canvas.drawCircle(goStoneData.coordinates[i][j].X, goStoneData.coordinates[i][j].Y, 25, paint);
            }
        }
    }

    public void setWhereTSheGoStonesArePlaced(String[][] whereTSheGoStonesArePlaced) {
        this.whereTSheGoStonesArePlaced = whereTSheGoStonesArePlaced;
    }

}
