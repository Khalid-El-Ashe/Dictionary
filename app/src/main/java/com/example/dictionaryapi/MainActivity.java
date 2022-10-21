package com.example.dictionaryapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionaryapi.adapters.MeaningAdapter;
import com.example.dictionaryapi.adapters.PhoneticsAdapter;
import com.example.dictionaryapi.api_interface.OnFetchDataListener;
import com.example.dictionaryapi.models.ApiResponse;
import com.example.dictionaryapi.networking.RequestManager;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private TextView text_view_word;
    RecyclerView recycler_phonetics, recycler_meanings;

    private ProgressDialog dialog;

    PhoneticsAdapter adapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);

        searchView = findViewById(R.id.search_view);
        text_view_word = findViewById(R.id.text_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);

        // in the first time run my application i need to show this data
        dialog.setTitle("Loading...");
        dialog.show();

        // i need to use api
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener, "hello");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching response for " + query);
                dialog.show();

                // i need to use api
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener, query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    // this method is my listener created
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(ApiResponse apiResponse, String message) {
            dialog.dismiss();
            if (apiResponse == null) {
                Toast.makeText(MainActivity.this, "no data found -_-", Toast.LENGTH_SHORT).show();
                return;
            }

            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    // this method to get the data from api
    private void showData(ApiResponse apiResponse) {
        text_view_word.setText("Word : " + apiResponse.getWord());

        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        adapter = new PhoneticsAdapter(MainActivity.this, apiResponse.getPhonetics());
        recycler_phonetics.setAdapter(adapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        meaningAdapter = new MeaningAdapter(MainActivity.this, apiResponse.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);
    }
}