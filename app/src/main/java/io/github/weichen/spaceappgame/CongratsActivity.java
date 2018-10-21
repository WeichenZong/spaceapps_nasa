package io.github.weichen.spaceappgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

 class CongratsActivity extends Activity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "Iteration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        try {
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        Intent get_intent = getIntent();
        Integer iteration = get_intent.getIntExtra(MenuActivity.EXTRA_MESSAGE,0);
        Intent intent = new Intent(this, TestingActivity.class);
        intent.putExtra( EXTRA_MESSAGE,iteration);
        startActivity(intent);
    }
}
