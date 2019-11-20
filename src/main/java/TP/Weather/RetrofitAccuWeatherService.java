package TP.Weather;

import TP.Weather.Ahora.ResponseConditions;
import TP.Weather.CincoDias.ResponseForecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface RetrofitAccuWeatherService {
    @GET("/currentconditions/v1/{locationKey}?apikey=XYufUv9ESFuNw0ViO8Ffd4CRdrJQRRLq")
    Call<List<ResponseConditions>> getCurrentConditions(@Path("locationKey") int locationKey);
    @GET("/forecasts/v1/daily/5day/{locationKey}?apikey=XYufUv9ESFuNw0ViO8Ffd4CRdrJQRRLq&metric=true")
    Call<ResponseForecast> getFiveDayForecast(@Path("locationKey") int locationKey);
}