package com.gaur.motivationtime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteview = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quotetext = quoteview.findViewById(R.id.quoteText);
        TextView byAuthor = quoteview.findViewById(R.id.byAuthor);
        CardView cardView = quoteview.findViewById(R.id.cardview);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        quotetext.setText("''" +quote +"''");
        byAuthor.setText("~"+author);

        int colors[] = new int[] {R.color.blue_500, R.color.pink_900, R.color.green_400,
                R.color.lime_400, R.color.orange_400, R.color.amber_800, R.color.pink_800,
                R.color.grey_700};
        cardView.setCardBackgroundColor(getRandomQuote(colors));
      //  cardView.setBackgroundResource(getRandomQuote(colors));
        cardView.setCardElevation(20);
        ImageView info = quoteview.findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AboutDev.class);
                startActivity(intent);
            }
        });

        return quoteview;
    }



    public static final QuoteFragment newInstance(String quote, String author){

        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);

        fragment.setArguments(bundle);
        return fragment;
    }

    int getRandomQuote(int[] colorArray) {
        int color;
        int quotesArrayLen = colorArray.length;

        int randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen);

        color = colorArray[randomNum];

        return  color;
    }

}
