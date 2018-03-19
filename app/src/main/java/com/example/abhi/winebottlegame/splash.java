package com.example.abhi.winebottlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        b1=(Button)findViewById(R.id.play);
        t1=(TextView)findViewById(R.id.rules);

        t1.setText("Roll the Bottle Thrice\n each time u get a number if the number on 3rd turn lies in between the first and second " +
                "\nu win otherwise u loose!!");


        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent i=new Intent(splash.this,main.class);
                startActivity(i);
            }
        });


    }
}
