package com.example.rivu.primemathquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    String numb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        //});
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  //  }
    @Override
    public void onResume() {
        super.onResume();
        TextView showHint = (TextView) findViewById(R.id.text1);
        Intent intent = getIntent();
        if (null != intent) {
            numb1 = getIntent().getExtras().getString("Prime");
            showHint.setText(numb1);   /* Displaying the prime number */


        }
    }
  @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(getApplication(),MainActivity.class);
        intent.putExtra("HintActivated",true);
        setResult(RESULT_OK, intent);
        finish();
    }

}
