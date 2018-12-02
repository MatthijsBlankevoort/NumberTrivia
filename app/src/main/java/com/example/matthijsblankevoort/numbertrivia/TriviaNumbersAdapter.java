package com.example.matthijsblankevoort.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TriviaNumbersAdapter extends RecyclerView.Adapter<TriviaNumbersAdapter.MyViewHolder>  {

    private List<TriviaNumber> triviaNumbers;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View v) {
            super(v);
        }
    }

    public TriviaNumbersAdapter( List<TriviaNumber> triviaNumbers) {
        this.triviaNumbers = triviaNumbers;
    }

    @NonNull
    @Override
    public TriviaNumbersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaNumbersAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
