package com.gaur.motivationtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class AboutDev extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);

        TextView dev = findViewById(R.id.dev);
        TextView piccredit = findViewById(R.id.pic_credit);
        CardView cardview= findViewById(R.id.cardview_credits);

        int colors[] = new int[] {R.color.blue_500, R.color.pink_900, R.color.green_400,
                R.color.lime_400, R.color.orange_400, R.color.amber_800, R.color.pink_800,
                R.color.grey_700};
        cardview.setCardBackgroundColor(getRandomQuote(colors));
    }



    int getRandomQuote(int[] colorArray) {
        int color;
        int quotesArrayLen = colorArray.length;

        int randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen);

        color = colorArray[randomNum];

        return  color;
    }
}
