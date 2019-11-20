package TP;

import TP.User.UsuarioDTO;

import javax.persistence.*;

@Entity
@Table(name = "Sensibilidad")
public class Sensibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_medidor_frio")
    private int idMedidorFrio;

    @Column(name = "parte_del_cuerpo")
    String parte_del_cuerpo;

//    @ManyToOne
    //   @JoinColumn(name = "usuarioDTO_id", referencedColumnName = "usuarioDTO_id")

    //   @ManyToOne(fetch = FetchType.LAZY)
    //  @JoinColumn(name = "usuario_id", referencedColumnName = "usuarioDTO_id")
    // @ManyToOne
    //@JoinColumn(name="USERDTO_ID", nullable=false)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    public UsuarioDTO usuarioDTO;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoria_id")
    Categoria categoria;

    @Column(name = "variacion_rango")
    private Integer modificador;

    @Column(name = "es_friolento_aqui")
    String es_friolento = "no";



    public Sensibilidad(Categoria categoria, Integer modificador, UsuarioDTO userDto, String tipo){
        this.categoria = categoria;
        this.modificador = modificador;
        this.usuarioDTO = userDto;
        this.parte_del_cuerpo = tipo;

    }

    public Sensibilidad(){}
    public Categoria getCategoria(){return categoria;}
    public Integer getModificador(){return modificador;}

    public void tuvoFrio(){
        modificador+=1;
    }
    public void tuvoCalor(){
        modificador-=1;
    }

    public boolean mideCategoria(Categoria categoria){
        return this.categoria == categoria;
    }

}
