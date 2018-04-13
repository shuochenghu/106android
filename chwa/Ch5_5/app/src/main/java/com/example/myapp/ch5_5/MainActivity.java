package com.example.myapp.ch5_5;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener {
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.lblOutput);
        output.setTextSize(30);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int act = motionEvent.getAction();
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        switch (act) {
            case MotionEvent.ACTION_DOWN:
                output.setText("ACTION_DOWN");
                output.setTextColor(Color.RED);
                vb.vibrate(2000);
                break;
            case MotionEvent.ACTION_UP:
                output.setText("ACTION_UP");
                output.setTextColor(Color.GREEN);
                vb.cancel();
                break;
            case MotionEvent.ACTION_MOVE:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                output.setText("X = " + x + "\nY = " + y);
                output.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }
}
