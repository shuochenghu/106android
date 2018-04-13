package com.example.lkuo.ticketradiobutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txv = (TextView)findViewById(R.id.txv);
        Button btnConfrim = (Button)findViewById(R.id.btnConfirm);
        final RadioGroup ticketType = (RadioGroup)findViewById(R.id.ticketType);

        btnConfrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = ticketType.getCheckedRadioButtonId();
                RadioButton select = (RadioButton)findViewById(id);
                txv.setText("買 "+select.getText());
            }
        });
    }
}
