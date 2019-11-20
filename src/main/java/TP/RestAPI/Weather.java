package TP.RestAPI;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Weather {
    private RetrofitAccuWeatherService service;
    private int locationKey;
    public Weather(){
        this.service = cargarServicio();
        locationKey = 7894; // debe ir en config junto con api key
    }
    public RetrofitAccuWeatherService cargarServicio(){
        String base_url = "http://dataservice.accuweather.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitAccuWeatherService.class);
    }
    public double getTemperatura(){
        Call<List<ResponseConditions>> call = this.service.getCurrentConditions(locationKey);
        try{
            Response<List<ResponseConditions>> response = call.execute();
            Temperature temperatura = response.body().get(0).Temperature;

            return temperatura.valor();
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
            return -1;
        }
    }
}
