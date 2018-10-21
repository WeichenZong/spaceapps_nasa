package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.TextView;

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

 class TestingActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "Iteration";
    Button a;
    Button b;
    Button c;
    Button d;
    TextView question;
    ArrayList<Button> answers = new ArrayList<>();
    int length=0;
    ArrayList<Triple> list = new ArrayList<Triple>();
    BufferedReader readerans,readerqs;
    @Override
    protected void onCreate(Bundle savedInstanceState) throws  NumberFormatException {
        Intent intent = getIntent();
        Integer iteration = intent.getIntExtra(MenuActivity.EXTRA_MESSAGE,0);
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
        question = (TextView) findViewById(R.id.questiontext);
        try {
            final InputStream isqs = getAssets().open("questions");
            final InputStream isans = getAssets().open("answer");
            readerans = new BufferedReader(new InputStreamReader(isans));
            readerqs = new BufferedReader(new InputStreamReader(isqs));
            // get the number of how much question there are
            // read data drom file build


            for (int i = 0; i < 16; i++) {

                list.add(new Triple(readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), readerqs.readLine(), 1/*Integer.parseInt(readerans.readLine())*/));
                Log.d("ITEM of list = ", list.get(i).getQustions());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


        Log.d("list lengtj: ", Integer.toString(list.size()));
        int[] rng = RNG(list.size()-1,list.size());
        int first = rng[iteration];
        String Question = getQuestionfromindex(first).getQustions();
        String anserA = getQuestionfromindex(first).getAnswera();
        String anserB = getQuestionfromindex(first).getAnswerb();
        String anserC = getQuestionfromindex(first).getAnswerc();
        String anserD = getQuestionfromindex(first).getAnswerd();
        int rightanswer = getQuestionfromindex(first).getAnswerKey();
        a.setText(anserA);
        b.setText(anserB);
        c.setText(anserC);
        d.setText(anserD);
        question.setText(Question);

        answers.add(a);
        answers.add(b);
        answers.add(c);
        answers.add(d);


    }

    @Override
    public void onClick(View v) {
        Intent get_intent = getIntent();
        Integer iteration = get_intent.getIntExtra(MenuActivity.EXTRA_MESSAGE,0);
        if(v==answers.get(list.get(iteration).getAnswerKey())){
            //if he is right

            Intent intent = new Intent(this, CongratsActivity.class);
            intent.putExtra( EXTRA_MESSAGE,iteration+1);
            startActivity(intent);
        }
        else{
            //if he is not right
            Intent intent = new Intent(this, LessCongratsActivity.class);
            intent.putExtra( EXTRA_MESSAGE,iteration);
            startActivity(intent);

        }

    }
    public Triple getQuestionfromindex(int index){
        return list.get(index);
    }
    public static int[] RNG(int end,int count){
        Random rng = new Random();

        int[] result = new int[count];
        int cur = 0;
        int remaining = end - 0;
        for (int i = 0; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        return result;
    }
}
