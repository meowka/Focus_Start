package com.example.focus_start.API;

import com.example.focus_start.POJO.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

        @GET("daily_json.js")
        Call<APIResponse> doGetResponse();
}
