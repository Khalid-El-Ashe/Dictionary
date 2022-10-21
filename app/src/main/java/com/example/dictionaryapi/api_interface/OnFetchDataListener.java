package com.example.dictionaryapi.api_interface;

import com.example.dictionaryapi.models.ApiResponse;

public interface OnFetchDataListener {
    void onFetchData(ApiResponse apiResponse, String message);
    void onError(String message);
}
