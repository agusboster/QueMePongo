package TP;

import javax.persistence.*;

@Entity
@Table(name = "Frecuencia")
public class Frecuencia {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_frecuencia")
    private int idFrecuencia;

    @Column(name = "Se_repite")
    private boolean seRepite;

    @Column(name = "Cada_cuanto")
    private int cadaCuanto;

    public Frecuencia(boolean seRepite, int cadaCuanto){
        this.seRepite = seRepite;
        this.cadaCuanto = cadaCuanto;
    }
//ver si cambiar esto
    public Frecuencia(){
        cadaCuanto = 1;
    }
    public boolean seRepite(){
        return seRepite;
    }
    public int getCadaCuanto(){
        return cadaCuanto;
    }
    public void setSeRepite(boolean bool){
        seRepite = bool;
    }
    public void setCadaCuanto(Integer cadaCuanto){
        this.cadaCuanto = cadaCuanto;
    }
}
