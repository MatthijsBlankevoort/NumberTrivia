package com.example.matthijsblankevoort.numbertrivia;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addTriviaButton;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<TriviaNumber> triviaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTriviaButton = findViewById(R.id.addTriviaButton);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        triviaNumbers = new ArrayList<>();
        // specify an adapter (see also next example)
        mAdapter = new TriviaNumbersAdapter(triviaNumbers);
        mRecyclerView.setAdapter(mAdapter);

        addTriviaButton = findViewById(R.id.addTriviaButton);

        addTriviaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestData();
            }
        });

    }

    private void requestData()
    {
        NumbersApiService service = NumbersApiService.retrofit.create(NumbersApiService.class);

        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */
        Call<TriviaNumber> call = service.getRandomTrivia();

        call.enqueue(new Callback<TriviaNumber>() {
            @Override
            public void onResponse(Call<TriviaNumber> call, Response<TriviaNumber> response) {
                TriviaNumber randomTrivia = response.body();
                triviaNumbers.add(randomTrivia);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TriviaNumber> call, Throwable t) {
                Log.d("error",t.toString());
            }
        });

    }

}
