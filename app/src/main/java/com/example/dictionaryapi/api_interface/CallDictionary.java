package com.example.dictionaryapi.api_interface;

import com.example.dictionaryapi.models.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CallDictionary {

    @GET("entries/en/{word}")
    Call<List<ApiResponse>> callMeanings(
            @Path("word") String word
    );
}
