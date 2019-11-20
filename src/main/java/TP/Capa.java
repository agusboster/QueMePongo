package TP;

import TP.User.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Capa")
public class Capa {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_capa")
    private int idCapa;

    @Column(name = "Nivel_de_abrigo")
    private Double nivelDeAbrigo;

    @Column(name = "Numero_de_capa")
    private Integer numeroCapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    /*
    @ManyToMany(mappedBy = "capas")
    private List<Categoria> categorias = new ArrayList<>();
*/
    public Capa(){
    }

    public int getIdCapa(){
        return idCapa;
    }

    public double getNivelDeAbrigo(){
        return nivelDeAbrigo;
    }

    public Integer getNumeroCapa(){
        return numeroCapa;
    }


    public Capa(Integer numeroCapa, Double nivelAbrigo, Categoria categoria){
        this.nivelDeAbrigo = nivelAbrigo;
        this.numeroCapa = numeroCapa;
        this.categoria = categoria;

    }

    public boolean tieneNumero(Integer numeroCapa){
        return (this.numeroCapa == numeroCapa);
    }

}
