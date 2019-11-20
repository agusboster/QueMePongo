package TP.Weather.CincoDias;

public class Temperature {
    public Extremo Minimum;
    public Extremo Maximum;

    @Override
    public String toString(){
        return Minimum.toString();
    }
    public double minima(){
        return Minimum.valor();
    }
    public double maxima(){
        return Maximum.valor();
    }
}
