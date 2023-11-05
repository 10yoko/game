package com.example.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.games.gomokuData.GoStoneData;
import com.example.games.gomokuData.GomokuJudge;
import com.example.games.view.MyCustomView;

public class GomokuActivity extends AppCompatActivity {
    private TextView coordinate;
    GoStoneData goStoneData;
    MyCustomView customView;
    GomokuJudge gomokuJudge =new GomokuJudge();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gomoku);
        coordinate = findViewById(R.id.coordinate);
        goStoneData =new GoStoneData();
        customView = findViewById(R.id.customView);

        findViewById(R.id.home).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    public boolean onTouchEvent(MotionEvent event) {
        //TextViewに表示
        coordinate.setText("座標X:"+String.valueOf(event.getX())+" 座標Y:"+String.valueOf(event.getY()));
        goStoneData.printCoordinate();
        GomokuJudge.GoStoneAryIndex goStoneAryIndex = gomokuJudge.Nearbycoordinates((int)event.getX(),(int)event.getY(),goStoneData.coordinates);
        customView.setGoStoneAryIndex(goStoneAryIndex);
        customView.invalidate();
        return true;
    }
}
