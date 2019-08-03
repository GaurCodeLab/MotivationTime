package com.gaur.motivationtime.data;

import com.gaur.motivationtime.model.Quote;

import java.util.ArrayList;

public interface QuoteAsyncResponse {

    void processFinished(ArrayList<Quote> quotes);
}
