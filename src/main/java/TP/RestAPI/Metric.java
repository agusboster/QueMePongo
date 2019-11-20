package TP.RestAPI;

public class Metric {
    public double Value;
    public String Unit;

    @Override
    public String toString(){
        return Value+"°"+Unit;
    }
    public double valor(){
        return Value;
    }
}
