
package com.example.rivu.primemathquiz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.*;
import java.util.*;
import android.os.CountDownTimer;

public class MainActivity extends Activity {

    Random r = new Random();
    int flag=0,correctAns=0,inCorrectAns=0,numb=0,i = r.nextInt();
    boolean active=true,cheat=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("CorrectAns", correctAns);
        savedInstanceState.putInt("InCorrectAns", inCorrectAns);
        savedInstanceState.putInt("NUMB",numb);
        savedInstanceState.putBoolean("active",active);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 0) {
            if (data.hasExtra("HintActivated")) {
                Toast.makeText(this, "You Have Seen The Hint",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        correctAns = savedInstanceState.getInt("CorrectAns");
        inCorrectAns= savedInstanceState.getInt("InCorrectAns");
        numb=savedInstanceState.getInt("NUMB");
        active=savedInstanceState.getBoolean("active");
    }


    @Override
    public void onResume() {
        super.onResume();
        Button f = (Button) findViewById(R.id.button3);         // for next button
        final Button f2 = (Button) findViewById(R.id.button2);  // for NO button
        final Button f3 = (Button) findViewById(R.id.button1);  //for YES button
        final Button f4 = (Button) findViewById(R.id.hint);     // for hint
        final Button f5=(Button)findViewById(R.id.Cheat);       // for checking the answer
        final TextView b = (TextView) findViewById(R.id.text1);   //for displaying the number
        final TextView b1 = (TextView) findViewById(R.id.text2);   // for displaying correct or incorrect
        b1.setText("Correct--" + "   " + correctAns + "           " + "Incorrect--" + "   " + inCorrectAns);
        if (numb != 0)
            i = numb;
        else
            numb=i;
        b.setText(String.valueOf(Math.abs(numb) % 100));  //flag
        numb = i;
            f2.setEnabled(active);
            f3.setEnabled(active);

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheat=false;
                i = r.nextInt(1000);
                i = Math.abs(i) % 100;
                numb = i;
                b.setText(String.valueOf(numb));    //flag
                f2.setEnabled(true);
                f3.setEnabled(true);
                active = true;
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = b.getText().toString();
                int x1 = Integer.valueOf(x);
                if (x1 == 0 || x1 == 1) {

                    flag = 1;
                }
                for (int i = 2; i <= (x1 / 2); i++) {
                    if (x1 % i == 0) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 1 && !cheat)
                {
                    CharSequence text = "Correct Ans!";
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                    correctAns++;
                } else
                    if(!cheat) {
                    CharSequence text = "Incorrect Ans!" ;
                        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                    inCorrectAns++;
                }
               else
                    {
                        cheat=false;
                        Toast.makeText(getApplicationContext(),"You Have Cheated",Toast.LENGTH_SHORT).show();
                        f2.setEnabled(false);
                        f3.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"Move on to the Next Ques",Toast.LENGTH_SHORT).show();
                    }
                flag = 0;
                //toast.show();
                b1.setText("Correct--" + "    " + correctAns + "              " + "Incorrect--" + "    " + inCorrectAns);
                f2.setEnabled(false);
                f3.setEnabled(false);
                active = false;
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = b.getText().toString();
                Integer x1 = Integer.valueOf(x);
                if (x1 == 0 || x1 == 1) {

                    flag = 1;
                }
                for (int i = 2; i <= (x1 / 2); i++) {
                    if (x1 % i == 0) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0 && !cheat) {
                    CharSequence text = "Correct Ans!";
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                    correctAns++;
                } else
                if(!cheat) {
                    CharSequence text = "Incorrect Ans!" ;
                    Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
                    inCorrectAns++;
                }
                else
                {
                    cheat=false;
                    Toast.makeText(getApplicationContext(),"You Have Cheated",Toast.LENGTH_SHORT).show();
                    f2.setEnabled(false);
                    f3.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Move on to the Next Ques",Toast.LENGTH_SHORT).show();
                }
                flag = 0;
                //toast.show();
                b1.setText("Correct--" + "  " + correctAns + "             " + "Incorrect--" + "  " + inCorrectAns);
                f2.setEnabled(false);
                f3.setEnabled(false);
                active = false;
            }
        });
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(active) {
                    Bundle b = new Bundle();
                    Intent intent = new Intent(getApplicationContext(), HintActivity.class);
                    b.putString("Prime", String.valueOf(Math.abs(numb) % 100));
                    intent.putExtras(b);
                    startActivityForResult(intent,0);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You have already Answered it",Toast.LENGTH_SHORT).show();

                }
            }
        });


        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             cheat=true;
                if(active) {
                    Bundle b = new Bundle();
                    Intent intent = new Intent(getApplicationContext(), CheatActivity.class);
                    b.putString("Prime", String.valueOf(Math.abs(numb) % 100));
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You have already Answered it",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
