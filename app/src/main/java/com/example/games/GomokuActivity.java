package com.example.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.games.gomokuData.GoStoneCoordinateData;

public class GomokuActivity extends AppCompatActivity {
    private TextView coordinate;
    GoStoneCoordinateData goStoneCoordinateData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gomoku);
        coordinate = findViewById(R.id.coordinate);
        goStoneCoordinateData =new GoStoneCoordinateData();
        findViewById(R.id.home).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        //TextViewに表示
        coordinate.setText("座標X:"+String.valueOf(event.getX())+" 座標Y:"+String.valueOf(event.getY()));
        goStoneCoordinateData.printCoordinate();
        return true;
    }
}
