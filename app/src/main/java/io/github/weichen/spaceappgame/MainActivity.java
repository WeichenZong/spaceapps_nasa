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
import android.widget.TextView;
import java.util.*;

import java.io.InputStream;

public class MainActivity extends Activity implements OnClickListener {

    Map<Integer,String> map = new Hashtable<Integer,String>();
    Set<Integer> keys;
    ArrayList<Integer> list = new ArrayList<Integer>();
    int position = 0;
    Button b1;
    Button b2;
    TextView text;
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
        text = (TextView) findViewById(R.id.image_text);

        map.put(R.drawable.icon, "This is an icon");
        map.put(R.drawable.mars,"This is mars.");
        map.put(R.drawable.galaxy1, "A galaxy is a gravitationally bound system of stars, stellar remnants, interstellar gas, dust, and dark matter. Each is comprised of many solar systems, which are, depending on the form, sometimes divided into arms or sectors of said galaxy.");
        map.put(R.drawable.galaxy2, "Galaxies of various sizes exist. From dwarfs with just a few hundred million (10^8) stars to giants with one hundred trillion (10^14) stars, each orbiting its galaxy's center of mass. Galaxies are categorized according to their visual forms. Most of them have a supermassive black hole at their active center.");
        map.put(R.drawable.galaxy_cluster1, "A galaxy cluster is a structure that consists of hundreds of thousands of galaxies that are bonded together by gravity with typical masses ranging from 10^14 to 10^15 solar masses. They are attracted to each other and form giant clusters that stretch for thousands of light-years. Usually, the galaxies and intergalactic gas take up to 10% of the clusters. The rest is occupied by dark matter and/or nothingness.");
        map.put(R.drawable.spiral_galaxy1, "Spiral galaxies resemble spiraling pinwheels. Though the stars and other visible material contained in such galaxies lie mostly on a plane, the majority of mass in spiral galaxies exists in a roughly spherical halo of dark matter that extends beyond the visible component, as demonstrated by the universal rotation curve concept");
        map.put(R.drawable.spiral_galaxy2, "Spiral galaxies consist of a rotating disk of stars and interstellar medium, along with a central bulge of generally older stars. Extending outward from the bulge are relatively bright arms. In the Hubble classification scheme, spiral galaxies are listed as type S, followed by a letter (a, b, or c) that indicates the degree of tightness of the spiral arms and the size of the central bulge.");
        keys = map.keySet();
        for (int key : keys){
            list.add(key);
        }

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == b1)
        {
            position++;
            if (position >map.size()){
                position--;
                text.setText("This is already the last picture");
            }
            Log.d("position: ",Integer.toString(position));
            iw.setImageResource(list.get(position));
            text.setText(map.get(list.get(position)));
        }
        else if (v == b2)
        {
            position--;
            if (position <0){
                text.setText("This is already the first picture");
                position ++;
            }
            Log.d("position: ",Integer.toString(position));
            iw.setImageResource(list.get(position));
            text.setText(map.get(list.get(position)));

        }

    }
}
