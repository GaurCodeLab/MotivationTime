package com.gaur.motivationtime;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gaur.motivationtime.data.QuoteAsyncResponse;
import com.gaur.motivationtime.data.QuoteData;
import com.gaur.motivationtime.data.QuoteViewPagerAdapter;
import com.gaur.motivationtime.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;
    private long backPressedTime;
    ImageView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);

        quoteViewPagerAdapter = new QuoteViewPagerAdapter(getSupportFragmentManager(),
                getFragments());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(quoteViewPagerAdapter);


    }



    private List<Fragment> getFragments(){

        final List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {

                for (int i =0; i<quotes.size(); i++){

                    QuoteFragment quoteFragment = QuoteFragment.newInstance(quotes.get(i).
                            getQuote(), quotes.get(i).getAuthor());
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdapter.notifyDataSetChanged();

            }
        });



        return fragmentList;


    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            finishAffinity();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }




}
