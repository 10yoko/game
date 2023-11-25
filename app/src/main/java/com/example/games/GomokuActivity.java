package com.example.games;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.games.gomokuData.GoStoneData;
import com.example.games.gomokuData.GomokuJudge;
import com.example.games.gomokuData.GomokuJudge.GoStoneAryIndex;
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
        if(event.getAction() != MotionEvent.ACTION_DOWN)return false;
        coordinate.setText("座標X:"+ event.getX() +" 座標Y:"+ event.getY());
        goStoneData.printCoordinate();
        GoStoneAryIndex goStoneAryIndex = gomokuJudge.Nearbycoordinates((int)event.getX(),(int)event.getY(),goStoneData.coordinates);
        goStoneData.setGoStoneAtTheSpecifiedLocation(goStoneAryIndex);
        customView.setWhereTSheGoStonesArePlaced(goStoneData.getWhereTSheGoStonesArePlaced());
        customView.invalidate();
        gomokuJudge.nextTarn();//ターンを移すタイミングは気を付ける事。ターンがずれたりする場合がある為
        return true;
    }
}
