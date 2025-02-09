package com.example.retrofitdataupload;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ModelApi {
    //get post update delete

    // latest?apikey=cur_live_WRKWILt2BLAeQBb9WBiDlpkVqCkdZJMYScEHm99o
    //https://api.currencyapi.com/v3/latest?apikey=cur_live_WRKWILt2BLAeQBb9WBiDlpkVqCkdZJMYScEHm99o





    @GET("next7days?unitGroup=metric&include=days&key=465VU4URNA2EQMWEV9S8F863Q&contentType=json")
    Call<WeatherData> getData();
}
