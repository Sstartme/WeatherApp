package sinthella.anpalagan.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity<linearLayoutManager> extends AppCompatActivity {

    private RelativeLayout homeRL;
    private ProgressBar loadingPB;
    private TextView cityNameTV,temperatureTV, conditionTV;
    private RecyclerView weatherRV;
    private TextInputEditText cityEdt;
    private ImageView backIV,iconIV,searchIV;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<WeatherRVModal> weatherRVModalArrayList;
    private WeatherRVAdapter weatherRVAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);
        homeRL=findViewById(R.id.idRLHome);
        loadingPB=findViewById(R.id.idPBLoading);
        cityNameTV=findViewById(R.id.idTVCityName);
        conditionTV=findViewById(R.id.idTVCondition);
        weatherRV=findViewById(R.id.idRvWeather);
        cityEdt=findViewById(R.id.idEdtCity);
        backIV=findViewById(R.id.idIVBack);
        iconIV=findViewById(R.id.idTVIcon);
        searchIV=findViewById(R.id.idIVSearch);
        weatherRVModalArrayList = new ArrayList<>();
        weatherRVAdapter = new WeatherRVAdapter(this,weatherRVModalArrayList);
        weatherRV.setAdapter(weatherRVAdapter);
    }
    private void  getWeatherInfo(String cityName){
            String url = "http://api.weatherapi.com/v1/forecast.json?key=8ca4db650e9842c9ab390658231701&q="+cityName+"&days=1&aqi=no&alerts=no";

    }
}