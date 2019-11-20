package TP;

import java.awt.*;

public class DTOPrenda {
    String material;
    Color[] colores;
    String descripcion;
    //CategoriaCapa categoriaCapa;
    String categoria;
    Integer capa;
    Double nivelDeAbrigo;

    public DTOPrenda(String descripcion, String categoria, Color[]colores, String material, Integer capa, Double nivel) {
        this.material  = material;
        this.descripcion = descripcion;
        this.categoria = categoria;
        //    this.categoriaCapa = categoriaCapa;
        this.colores = colores;
        this.capa = capa;
        this.nivelDeAbrigo = nivel;
    }

   /*
   public Categoria categoria(){
        return categoriaCapa.categoria();
    }

    public int capa(){
        return categoriaCapa.capa();
    }
    */

    public double nivelDeAbrigo(){
        return nivelDeAbrigo;
    }

    public String descripcion(){
        return descripcion;
    }
    public boolean esDe(String categoria){
        return (this.categoria == categoria);
    }

    public boolean suNivelEsMenorA(Integer nivel){
        return (this.nivelDeAbrigo <= nivel);
    }

    /*
    public boolean esDe(Categoria categoria, Integer capa){
        return categoriaCapa.esDe(categoria,capa);
    }
     */
    public boolean esDeCapa(Integer capa){
        return ((this.capa) == capa );
    }
}
