package TP;
import TP.*;
import TP.Config.PrendaImageConfig;
import TP.User.Usuario;

import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

@Entity
@Table(name = "Prenda")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_prenda")
    private int idPrenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardarropas_ID")
    public Guardarropas guardarropas;

    @Column(name = "Material")
    private String material;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atuendo")
    public Atuendo atuendo;

    @Transient
    Color[] colores;

    /*
    @Column(name = "Colores")
    Color[] colores;
*/
    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Categoria")
    private String categoria;

    @Column(name = "Capa")
    private int capa;

    @Column(name = "Nivel_de_abrigo")
    private Double nivelDeAbrigo;


    /*
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Id_categoria")
    private Categoria categoria;
*/

    /*
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Id_capa")
    Capa capa;
*/

    @Column(name = "Esta_en_uso")
    Boolean estaEnUso = false;

    @Transient
    Boolean esFormal;
   // @Transient
   // CategoriaCapa categoriaCapa;
    @Transient
    BufferedImage imagen;
    @Transient
    DTOPrenda dto;

    public String getDescripcion(){
        return descripcion;
    }
    public String getMaterial(){
        return this.material;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setNivelDeAbrigo(Double nivel){
        nivelDeAbrigo = nivel;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return this.descripcion;
    }

    public Prenda(String descripcion, Color[]colores, String material, String categoria, Integer capa, Double nivelDeAbrigo, Guardarropas guardarropas/*, BufferedImage unaImagen*/) {
        this.material = material;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.capa = capa;
        this.nivelDeAbrigo = nivelDeAbrigo;
        this.colores = colores;
        this.esFormal = false; //por defecto
        this.guardarropas = guardarropas;
//        this.imagen = PrendaImageConfig.resize(unaImagen, PrendaImageConfig.getMaxWidth(), PrendaImageConfig.getMaxHeight());
    }
    public void setEsFormal(boolean esFormal){
        this.esFormal = esFormal;
    }
    public boolean esFormal(){
        return esFormal;
    }
   /* public Prenda(DTOPrenda dto) {
        this.dto = dto;
    }
    */

    public Prenda(){


    }


    public class excepcionPrendaNoValida extends Exception{
        public excepcionPrendaNoValida(String mensaje){
            super(mensaje);
        }
    }




    public boolean esDe(String categoria){
        return (this.getCategoria() == categoria);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setearCapa(int capa) {
        this.capa = capa;
    }

    public void setearCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setearGuardarropas(Guardarropas guardarropas) {
        this.guardarropas = guardarropas;
    }


    public Double getNivelDeAbrigo(){
        return nivelDeAbrigo;
    }

    public int getCapa(){
        return capa;
    }

    public boolean suNivelEsMenorA(Double nivel){
        return (this.getNivelDeAbrigo() < nivel);
//                (this.categoria.suNivelEsMenorA(nivel, this.capa.getNumeroCapa()));
    }

    public boolean esDeCapa(Integer capa){
        return (this.getCapa() == capa);
    }


    public void setEstaEnUso(){
        this.estaEnUso = true;
    }

    public void setNoEstaEnUso(){
        this.estaEnUso = false;
    }

    /*
    public boolean suNivelEsMenorA(Integer nivel) {
        return dto.suNivelEsMenorA(nivel);
    }
    public boolean esDe(Categoria categoria){
        return this.dto.categoriaCapa.categoria() == categoria;
    }

    public double nivelDeAbrigo(){
        return dto.nivelDeAbrigo();

    }

    public boolean esDe(String categoria){
        return dto.esDe(categoria);
    }

    public boolean esDeCapa(Integer capa){
        return dto.esDeCapa(capa);
    }
*/

}