package TP;
import TP.*;
import TP.User.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Atuendo")
public class Atuendo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_atuendo")
    private int idAtuendo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "atuendo")
    public List<Prenda> prendas = new ArrayList<>();

    @ManyToMany(mappedBy = "atuendos")
    List<Usuario> usuarios = new ArrayList<>();

    @Column(name = "Le_gusta")
    boolean leGusta;

    public Atuendo(ArrayList<Prenda> prendas){
        this.prendas = prendas;
    }
    public List<Prenda> getPrendas() {return (this.prendas);}
    public Atuendo(){

    }
    public void leGusta(boolean valor){
        leGusta = valor;
    }
    @Override
    public String toString(){
        return "Atuendo con " + prendas.stream().map(p->p.getDescripcion())
                .collect(Collectors.joining(", "));
    }
    /*
    public double nivelDeAbrigo(){
        return prendas.stream().map(p->p.categoriaCapa.nivelDeAbrigo).reduce(0.0, (subtotal,element)->subtotal+element);
    }*/
    public void agregarPrenda(Prenda prenda){
        prendas.add(prenda);
    }
}
