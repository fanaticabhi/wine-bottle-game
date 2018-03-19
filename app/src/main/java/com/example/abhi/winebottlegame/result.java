package com.example.abhi.winebottlegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView tt1,tt2,tt3;
    Button b1,b2;
    TextView c1, c2, c3;
    int no1,no2,no3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tt3=(TextView)findViewById(R.id.totalcoins);
        tt1=(TextView)findViewById(R.id.congrats);
        tt2=(TextView)findViewById(R.id.resulttext);
        b1=(Button)findViewById(R.id.playagain);
        b2=(Button)findViewById(R.id.exit);
        c1 = (TextView) findViewById(R.id.firstno);
        c2 = (TextView) findViewById(R.id.secondno);
        c3 = (TextView) findViewById(R.id.thirdno);
        no1=main.first;
        no2=main.second;
        no3=main.third;




        resultmethod();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                main.counter=0;
                Intent i=new Intent(result.this,main.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              android.os.Process.killProcess(android.os.Process.myPid());
              System.exit(1);


            }
        });
    }


    public void reset(){
        main.t1.setText("");
        main.t2.setText("");
       main.t3.setText("");

    }


    public void resultmethod() {
        c1.setText(""+no1);
        c2.setText(""+no2);
        c3.setText(""+no3);
        if ((main.third >= main.first && main.third <= main.second)||(main.third <= main.first && main.third >= main.second)) {
            tt1.setText("CONGRATULATIONS");
            tt2.setText("YOU WIN!!!");
             main.total++;
            tt3.setText(""+main.total);

        }
        else
        {
            tt1.setText("SORRY");
            tt2.setText("YOU LOOSE!!!");
            main.total--;
            tt3.setText(""+main.total);
        }


        {



        }
    }
}
