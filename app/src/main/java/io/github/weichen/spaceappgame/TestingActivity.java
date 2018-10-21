package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Hashtable;
import java.util.Map;

public class TestingActivity extends Activity implements View.OnClickListener {

    Button a;
    Button b;
    Button c;
    Button d;
    Map<String,String> map1 = new Hashtable<String,String>();
    Map<String,Integer> map2 = new Hashtable<String,Integer>();

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
}
