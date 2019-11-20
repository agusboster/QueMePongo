package TP.User;
import TP.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_usuario")
    private int idUsuario;

//    @Column(name = "Conjunto_guardarropas")
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "usuarioDTO_id")
    UsuarioDTO usuarioDTO;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "UsuarioXAtuendo",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "atuendo_id")
    )
    private List<Atuendo> atuendos = new ArrayList<>();

    @Transient
    ArrayList<Prenda> atuendoActual = new ArrayList<Prenda>();

    public String getEmail(){
        return usuarioDTO.getEmail();
    }

    public UsuarioDTO getUsuarioDTO(){
        return usuarioDTO;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void quitarseAtuendoActual(){
        this.atuendoActual.stream().forEach(prenda -> prenda.setNoEstaEnUso());
        this.atuendoActual.clear();
    }

    public String getPhoneNumber(){
        return usuarioDTO.getPhoneNumber();
    }

   // public List<Guardarropas> listaGuardarropas() {return (this.conjuntoGuardarropas);}

    public void agregarAtuendo(ArrayList<Prenda> prendas){
        prendas.stream().forEach(prenda -> this.atuendoActual.add(prenda));
        prendas.stream().forEach(prenda -> prenda.setEstaEnUso());
    }
    public void tenerFrio(Categoria cat){
        medidorDeCategoria(cat).tuvoFrio();
    }
    public void tenerCalor(Categoria cat){
        medidorDeCategoria(cat).tuvoCalor();
    }
    public Sensibilidad medidorDeCategoria(Categoria cat){
        return usuarioDTO.getMedidores().stream().filter(med->med.mideCategoria(cat)).findFirst().get();
    }
    public List<Sensibilidad> getMedidores() {return this.usuarioDTO.getMedidores();}

    public Usuario(UsuarioDTO usuarioDTO){
        this.usuarioDTO = usuarioDTO;
    }

    public Usuario(){
    }

    public Atuendo pedirSugerencia(Guardarropas guardarropas, Evento unEvento, SugeridorDeAtuendos unSugeridor) throws excepcionGuardarropasNoSeEncuentraEnElConjunto{
      //  if (!seEncuentra(guardarropas)) {
       //     throw new excepcionGuardarropasNoSeEncuentraEnElConjunto("Error: El guardarropas no se encuentra en el conjunto.");
        //}
        try {
            return unSugeridor.sugerirAtuendo(unEvento, guardarropas.getPrendas(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    public Atuendo pedirSugerenciaAGuardarropasRandom(Evento unEvento, Integer gustoUsuario)  {
        Random rand = new Random();
        try {
            return new SugeridorDeAtuendos(conjuntoGuardarropas.get(rand.nextInt(conjuntoGuardarropas.size()-1))).sugerirAtuendo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    */

    public class excepcionGuardarropasNoSeEncuentraEnElConjunto extends Exception {
        public excepcionGuardarropasNoSeEncuentraEnElConjunto(String mensaje) {
            super(mensaje);
        }
    }
/*
    void agregarGuardarropas(Guardarropas guardarropas) {
        conjuntoGuardarropas.add(guardarropas);
    }
*/
/*
    private boolean seEncuentra(Guardarropas guardarropas) {
        return conjuntoGuardarropas.contains(guardarropas);
    }
*/
    public void agregarEvento(Evento evento){
        usuarioDTO.agregarEvento(evento);
    }
    public ArrayList<Evento> getEventos(){
        return usuarioDTO.getEventos();
    }
    public void removerEvento(Evento evento){
        usuarioDTO.removerEvento(evento);
    }

    public void actualizarEventos(Usuario usuario){
        usuarioDTO.actualizarEventos(usuario);
    }
}

