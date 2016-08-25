package com.example.rivu.primemathquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.io.*;

public class CheatActivity extends AppCompatActivity {

    public static  String numb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); */
    }
    @Override
    public void onResume() {
        super.onResume();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            TextView showAns = (TextView) findViewById(R.id.text2);
            Intent intent = getIntent();
            if (null != intent) {
                numb1 = getIntent().getExtras().getString("Prime");
                int number = Integer.parseInt(numb1);
                int flag = 0;
                for (int i=2;i<=(number/2);i++)
                {
                    if(number%i==0) {
                        flag = 1;
                        break;
                    }
                }
                    if(flag==0)
                        showAns.setText("Prime Number");
                    else
                        showAns.setText("Not a Prime Number");
            }
        }
        catch(Exception e)
        {
            Log.e("some bug",e.getMessage());
        }
    }

}
