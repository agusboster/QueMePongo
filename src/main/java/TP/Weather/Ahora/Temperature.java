package TP.Weather.Ahora;

public class Temperature {
    public Metric Metric;

    @Override
    public String toString(){
        return Metric.toString();
    }
    public double valor(){
        return Metric.valor();
    }
}
