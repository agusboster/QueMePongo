package TP.User;

import TP.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Entity
@Table(name = "UsuarioDTO")
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "usuarioDTO_id")
    private int idUsuarioDTO;

    @Column(name = "Email")
    private String email;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

//    @OneToMany(mappedBy = "usuarioDTO", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @OneToMany(cascade=ALL, mappedBy="usuarioDTO")
//@OneToMany(mappedBy = "usuarioDTO", cascade = ALL)

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioDTO")
    public List<Sensibilidad> medidores = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioDTO")
    public List<GuardarropasXUsuario> guardarropasXUsuario = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioDTO")
    public List<EventoXUsuario> eventoXUsuario = new ArrayList<>();

    @Column(name = "Numero_de_telefono")
    private String phoneNumber;

    @Transient
    private Atuendo atuendoActual;

    @Transient
    private ArrayList<Evento> eventos;

    public Integer getId(){
        return idUsuarioDTO;
    }

    public UsuarioDTO(String email, String phoneNumber, String username, String password){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
     //   this.medidores = new ArrayList<>();
        eventos = new ArrayList<>();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public UsuarioDTO(){}

    public void agregarEvento(Evento evento){
        eventos.add(evento);
    }
    public List<Sensibilidad> getMedidores() {return (this.medidores); }

    public List<GuardarropasXUsuario> getGuardarropasXUsuario() {return (this.guardarropasXUsuario); }


    public void ponerseAtuendo(Atuendo atuendo){
        this.atuendoActual = atuendo;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void removerEvento(Evento evento){
        eventos.remove(evento);
    }
    public ArrayList<Evento> getEventos(){
        return eventos;
    }
    public void actualizarEventos(Usuario usuario){
        for(Evento e : eventos){
            e.avanzarUnDia(usuario);
        }
        eventos = eventos.stream().filter(evento->!evento.yaOcurrio()).collect(Collectors.toCollection(ArrayList::new));
    }
}
