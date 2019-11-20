package TP;
import TP.User.Usuario;
import TP.User.UsuarioDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Entity
@Table(name = "Guardarropas")
public class Guardarropas {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_guardarropas")
    private int idGuardarropas;

    @Column(name = "Descripcion")
    private String descripcion;

//    @Column(name = "Prendas")

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guardarropas")
    List<Prenda> prendas = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guardarropas")
    List<GuardarropasXUsuario> guardarropasXUsuario = new ArrayList<>();


    @Transient
    SugeridorDeAtuendos unSugeridor;

    @Transient
    atuendoNivelAltoCommand commandAlto;

    public List<Prenda> getPrendas() {return (this.prendas);}

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdGuardarropas() {
        return idGuardarropas;
    }

    public Guardarropas(){


    }


    public Guardarropas(SugeridorDeAtuendos unSugeridor, atuendoNivelAltoCommand commandAlto, String descripcion)  {

        this.unSugeridor = unSugeridor;
        this.commandAlto = commandAlto;
        this.descripcion = descripcion;

    }
    public void removerPrenda(Prenda prenda){
        prendas.remove(prenda);
    }
}