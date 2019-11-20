package TP.Weather;

import TP.Weather.Ahora.ResponseConditions;
import TP.Weather.Ahora.Temperature;
import TP.Weather.CincoDias.ResponseForecast;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Weather {
    private static RetrofitAccuWeatherService service = cargarServicio();
    private static int locationKey = 7894;

    public static RetrofitAccuWeatherService cargarServicio(){
        String base_url = "http://dataservice.accuweather.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitAccuWeatherService.class);
    }
    public static double getTemperaturaAhora(){
        Call<List<ResponseConditions>> call = service.getCurrentConditions(locationKey);
        try{
            Response<List<ResponseConditions>> response = call.execute();
            Temperature temperatura = response.body().get(0).Temperature;

            return temperatura.valor();
        }
        catch (Exception ex){
        //    System.out.print(ex.getMessage());
            return -1;
        }
    }
    public static double getTemperaturaDia(int dia){  //1 es mañana y va de 1-5
        Call<ResponseForecast> call = service.getFiveDayForecast(locationKey);
        try{
            Response<ResponseForecast> response = call.execute();
            TP.Weather.CincoDias.Temperature temperatura = response.body().DailyForecasts.get(dia-1).Temperature;

            return temperatura.maxima();
        }

        catch (Exception ex){
        //    System.out.print(ex.getMessage() + ". La fecha debe estar entre 1 y 5.");
            return -1;
        }
    }
}
