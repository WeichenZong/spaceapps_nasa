package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
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
    int length=0;
    ArrayList<Triple> list = new ArrayList<Triple>();
    BufferedReader readerans,readerqs;
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
           final InputStream isqs  = getAssets().open("SpaceAppsQuestions.txt");
           final InputStream  isans = getAssets().open("SpaceAppsAnswers.txt");
            readerans = new BufferedReader(new InputStreamReader(isans));
            readerqs = new BufferedReader(new InputStreamReader(isqs));
            // get the number of how much question there are
                readerans.mark(0);

            while(readerans.readLine() !=null){
                String tmp = readerans.readLine();
                length++;
            }
            readerans.reset();
            // read data drom file build list
            while(readerans.readLine() != null && readerqs.readLine() != null){
                for(int i=0;i<length;i++){

                    list.add( new Triple(readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), Integer.parseInt(readerans.readLine())));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String Question = getQuestionfromindex(RNG(list.size())).getQustions();
        String anserA = getQuestionfromindex(RNG(list.size())).getAnswera();
        String anserB = getQuestionfromindex(RNG(list.size())).getAnswerb();
        String anserC = getQuestionfromindex(RNG(list.size())).getAnswerc();
        String anserD = getQuestionfromindex(RNG(list.size())).getAnswerd();
        int rightanswer = getQuestionfromindex(RNG(list.size())).getAnswerKey();



    }

    @Override
    public void onClick(View v) {
        if(v==a){

        }
        else if(v==b){

        }

    }
    public Triple getQuestionfromindex(int index){
        return list.get(index);
    }
    public int RNG(int max){

        return 0;
    }
}
