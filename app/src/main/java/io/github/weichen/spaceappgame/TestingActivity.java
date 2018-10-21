package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Triple{
    String a,b;
    int c;
    public Triple(String a, String b, int c) {
        this.a= a;
        this.b = b;
        this.c= c;
    }
    public String getQustions(){
        //get the question text
        return a;
    }
    public String getAnswer(){
        //get the answer as text
        return b;
    }
    public int getAnswerKey(){
        // get the abcd in a int form 1-4
        return c;
    }
}

public class TestingActivity extends Activity implements View.OnClickListener {

    Button a;
    Button b;
    Button c;
    Button d;
    ArrayList<Triple> list = new ArrayList<Triple>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        a = (Button) findViewById(R.id.button_a);
        a.setOnClickListener(this);
        b = (Button) findViewById(R.id.button_b);
        b.setOnClickListener(this);
        c = (Button) findViewById(R.id.button_c);
        c.setOnClickListener(this);
        d = (Button) findViewById(R.id.button_d);
        d.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
    public int RNG(int max){

        return 0;
    }
}
