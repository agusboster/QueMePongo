package TP.RestAPI;

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
