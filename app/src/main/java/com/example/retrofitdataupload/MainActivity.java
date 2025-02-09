package com.example.retrofitdataupload;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitdataupload.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //private String BASE_URL = "https://api.currencyapi.com/v3/";
    String shier = "";
    String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    Retrofit retrofit ;
    Object data = null;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Gson gson = new GsonBuilder().setLenient().create();




        shier = "ankara";
        BASE_URL += shier +"/";
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        // https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/kayseri/next7days?unitGroup=metric&include=days&key=465VU4URNA2EQMWEV9S8F863Q&contentType=json
        loadData();

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }





    public void loadData(){
        ModelApi modelApi = retrofit.create(ModelApi.class);
        Call<WeatherData> call = modelApi.getData();
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(@NonNull Call<WeatherData> call, @NonNull Response<WeatherData> response) {
                WeatherData weatherData = response.body();
                assert weatherData != null;


                ArrayList<String> yilAyGun = new ArrayList<>(Arrays.asList(weatherData.getDays().get(0).getDatetime().split("-")));

                Map<String, String> aylar = new HashMap<>();
                int day = Integer.valueOf(yilAyGun.get(2));
                // Ayları ekleyelim
                aylar.put("01","Ocak");
                aylar.put("02","Şubat");
                aylar.put("03","Mart");
                aylar.put("04","Nisan");
                aylar.put("05","Mayıs");
                aylar.put("06","Haziran");
                aylar.put("07","Temmuz");
                aylar.put("08","Ağustos");
                aylar.put("09","Eylül");
                aylar.put("10","Ekim");
                aylar.put("11","Kasım");
                aylar.put("12","Aralık");



                System.out.println("Adres: " + weatherData.getResolvedAddress());
                System.out.println("Bugünün Sıcaklığı: " + weatherData.getDays().get(0).getTemp() + "°C");
                System.out.println("Hava Durumu: " + weatherData.getDays().get(0).getDescription());
                System.out.println(weatherData.getDays().get(1).getTemp());
                System.out.println(weatherData.getResolvedAddress());
                System.out.println(weatherData.getTimezone());
                System.out.println(yilAyGun.get(1));












                binding.prop.setText(String.valueOf(weatherData.getDays().get(0).getPrecipcover()));
                binding.textView2.setText(aylar.get(yilAyGun.get(1)) +", " +yilAyGun.get(2));
                binding.humidity.setText(String.valueOf(weatherData.getDays().get(0).getHumidity()));
                binding.textViewTemp.setText(String.valueOf( (int) Math.floor(weatherData.getDays().get(0).getTemp())) + "°C");
                binding.textViewCity.setText(shier.toUpperCase());
                binding.temp1.setText(String.valueOf((int) Math.floor(weatherData.getDays().get(1).getTemp()))+ "°C");
                binding.temp2.setText(String.valueOf((int) Math.floor(weatherData.getDays().get(2).getTemp()))+ "°C");
                binding.temp3.setText(String.valueOf((int) Math.floor(weatherData.getDays().get(3).getTemp()))+ "°C");
                binding.temp4.setText(String.valueOf((int) Math.floor(weatherData.getDays().get(4).getTemp()))+ "°C");


                binding.day1.setText( yilAyGun.get(2) + " " + aylar.get(yilAyGun.get(1)));
                binding.day2.setText(String.valueOf(Integer.valueOf(yilAyGun.get(2)) +1)  + " " + aylar.get(yilAyGun.get(1)));
                binding.day3.setText(String.valueOf(Integer.valueOf(yilAyGun.get(2)) +2) + " " + aylar.get(yilAyGun.get(1)));
                binding.day4.setText(String.valueOf(Integer.valueOf(yilAyGun.get(2)) +3) + " " + aylar.get(yilAyGun.get(1)));





            }

            @Override
            public void onFailure(@NonNull Call<WeatherData> call, @NonNull Throwable t) {

            }
        });

    }


}