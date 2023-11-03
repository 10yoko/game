package com.example.games.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.games.gomokuData.GoStoneCoordinateData;

public class MyCustomView extends View {
    GoStoneCoordinateData goStoneCoordinateData;

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        goStoneCoordinateData = new GoStoneCoordinateData();
        // コンストラクタの処理を追加
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 描画コードをここに追加
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        for (int i = 0; i < goStoneCoordinateData.coordinates.length; i++) {
            for (int j = 0; j < goStoneCoordinateData.coordinates[i].length; j++) {
                canvas.drawCircle(goStoneCoordinateData.coordinates[i][j].X,goStoneCoordinateData.coordinates[i][j].Y,25,paint);
            }
        }

    }
}
