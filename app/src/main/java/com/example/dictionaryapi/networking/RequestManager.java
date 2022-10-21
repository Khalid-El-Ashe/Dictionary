package com.example.dictionaryapi.networking;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionaryapi.api_interface.CallDictionary;
import com.example.dictionaryapi.api_interface.OnFetchDataListener;
import com.example.dictionaryapi.models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {
    private Context context;

    // i need to make object of retrofit
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();

    // this is constructor for this class
    public RequestManager(Context context) {
        this.context = context;
    }

    // make the method to get the data from the api response
    public void getWordMeaning(OnFetchDataListener listener, String word) {

        // i need to make object from the interface call
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);

        Call<List<ApiResponse>> call = callDictionary.callMeanings(word);

        // if you don't have the data you must to definde the exception
        try {
            call.enqueue(new Callback<List<ApiResponse>>() {
                @Override
                public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, "something is wrong...", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                    listener.onError("Request Failed!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "An Error Occurred!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
