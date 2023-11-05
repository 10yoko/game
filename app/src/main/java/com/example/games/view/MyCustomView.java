package com.example.games.view;

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
    GomokuJudge.GoStoneAryIndex goStoneAryIndex;


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
        if (goStoneAryIndex != null) {
            canvas.drawCircle(goStoneData.coordinates[goStoneAryIndex.getI()][goStoneAryIndex.getJ()].X, goStoneData.coordinates[goStoneAryIndex.getI()][goStoneAryIndex.getJ()].Y, 25, paint);
            debug("X:"+goStoneData.coordinates[0][0].X+" Y:"+goStoneData.coordinates[0][0].Y);
        }
//        for (int i = 0; i < goStoneData.coordinates.length; i++) {
//            for (int j = 0; j < goStoneData.coordinates[i].length; j++) {
//                canvas.drawCircle(goStoneData.coordinates[i][j].X, goStoneData.coordinates[i][j].Y,25,paint);
//            }
//        }
//        canvas.drawCircle(goStoneCoordinateData.coordinates[0][0].X, goStoneCoordinateData.coordinates[0][0].Y, 25, paint);
    }

    public void setGoStoneAryIndex(GomokuJudge.GoStoneAryIndex goStoneAryIndex) {
        this.goStoneAryIndex = goStoneAryIndex;

    }
}
