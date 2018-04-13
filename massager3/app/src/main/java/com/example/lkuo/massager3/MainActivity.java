package com.example.lkuo.massager3;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txv = (TextView)findViewById(R.id.txv);
        txv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //vb.vibrate(5000);
                    vb.vibrate(new long[]{0,100,2000,300},2);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    vb.cancel();
                }
                return true;
            }
        });
    }
}
