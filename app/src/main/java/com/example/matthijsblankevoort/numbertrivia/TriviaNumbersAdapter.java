package com.example.matthijsblankevoort.numbertrivia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TriviaNumbersAdapter extends RecyclerView.Adapter<TriviaNumbersAdapter.MyViewHolder>  {

    private List<TriviaNumber> triviaNumbers;
    private Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView numberText;
        public TextView numberDescription;

        public MyViewHolder(View v) {
            super(v);

            numberText = v.findViewById(R.id.numberText);
            numberDescription = v.findViewById(R.id.numberDescription);
        }
    }

    public TriviaNumbersAdapter(Context mContext, List<TriviaNumber> triviaNumbers) {
        this.mContext = mContext;
        this.triviaNumbers = triviaNumbers;
    }

    @NonNull
    @Override
    public TriviaNumbersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TriviaNumbersAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.numberText.setText(triviaNumbers.get(i).getNumber().toString());
        myViewHolder.numberDescription.setText(triviaNumbers.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return triviaNumbers.size();
    }
}
