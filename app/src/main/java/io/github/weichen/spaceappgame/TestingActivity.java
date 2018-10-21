package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Triple{
    String a,b1,b2,b3,b4;
    int c;
    public Triple(String a, String b1,String b2,String b3,String b4 ,int c) {
        this.a= a;
        this.b1= b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.c= c;
    }
    public String getQustions(){
        //get the question text
        return a;
    }
    public String getAnswera(){
        //get the answer a as text
        return b1;
    }
    public String getAnswerb(){
        //get the answer b as text
        return b2;
    }
    public String getAnswerc(){
        //get the answer c as text
        return b3;
    }
    public String getAnswerd(){
        //get the answer d as text
        return b4;
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
    InputStream isans,isqs;

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
        try {
            isqs  = getAssets().open("SpaceAppsQuestions.txt");
            isans = getAssets().open("SpaceAppsAnswers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
 

    }
    public int RNG(int max){

        return 0;
    }
}
