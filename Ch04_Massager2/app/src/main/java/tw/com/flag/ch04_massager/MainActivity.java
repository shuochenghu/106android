package tw.com.flag.ch04_massager;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txv = (TextView) findViewById(R.id.txv);
        txv.setOnTouchListener(this);   // 登錄觸控監聽物件
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(event.getAction() == MotionEvent.ACTION_DOWN) { // 按住螢幕中間的文字
            vb.vibrate(new long[]{0,100,1000,100}, 2);      //每秒震動0.1秒,不斷重複
        }
        else if(event.getAction() == MotionEvent.ACTION_UP) { // 放開手指
            vb.cancel(); // 停止震動
        }
        return true;
    }
}
