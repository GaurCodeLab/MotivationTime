package com.gaur.motivationtime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    Animation frombottom, fromtop;
    ImageView logo;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        logo = findViewById(R.id.lillyImgae);
        title = findViewById(R.id.title);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.alpha);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.translate);
        title.setAnimation(frombottom);
        logo.setAnimation(fromtop);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent  = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2500);
    }
}
