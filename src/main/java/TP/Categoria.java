package TP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import TP.Capa;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_categoria")
    private int idCategoria ;

    @Column(name = "nombre_categoria")
    private String tipo;

//    @Column(name = "Capas")
/*
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "CategoriaXCapa",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "capa_id")
    )
*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    public List<Capa> capas = new ArrayList<>();

    public List<Capa> getCapas(){
        return this.capas;
    }

    public Categoria (String tipo){
        this.tipo = tipo;
    }

    //no esta bueno esto pero no encuentro el equivalente wollok de find en java


    public ArrayList<Capa> encontrarCapa (Integer numeroCapa) {
        return (this.capas.stream().filter(capa->capa.tieneNumero(numeroCapa)).collect(Collectors.toCollection(ArrayList::new)));
    }

    public boolean esDe(String categoria){ return (this.getTipo() == categoria);}

    public Capa obtenerCapa(Integer numeroCapa){ return (this.encontrarCapa(numeroCapa).get(0)); }

    public Double getNivelDeAbrigo(Integer numeroCapa){ return (this.obtenerCapa(numeroCapa)).getNivelDeAbrigo();}

    public Categoria(){
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getTipo(){
        return tipo;
    }

    public boolean suNivelEsMenorA(Double nivel, Integer numeroCapa){
        return ((this.getNivelDeAbrigo(numeroCapa)) <= nivel);
    }

}
