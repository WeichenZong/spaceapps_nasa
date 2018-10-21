package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener {

    Button learn;
    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        learn = (Button) findViewById(R.id.learn_button);
        learn.setOnClickListener(this);

        test = (Button) findViewById(R.id.test_button);
        test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == learn){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra( "name", "value");
            startActivity(intent);
        }
        else if (view == test){
            Intent intent = new Intent(this,TestingActivity.class);
            startActivity(intent);
        }
    }
}
