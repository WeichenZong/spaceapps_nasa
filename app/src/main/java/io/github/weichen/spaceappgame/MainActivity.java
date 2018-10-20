package io.github.weichen.spaceappgame;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends Activity implements OnClickListener {


    Button b1;
    Button b2;
    ImageView iw;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        iw = (ImageView) findViewById(R.id.icon);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == b1)
        {
            iw.setImageResource(R.drawable.mars);
        }
        else if (v == b2)
        {
            iw.setImageResource(R.drawable.icon);
        }

    }
}
