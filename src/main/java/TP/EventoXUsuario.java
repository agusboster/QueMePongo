package TP;

import TP.User.UsuarioDTO;

import javax.persistence.*;

@Entity
@Table(name = "EventoXUsuario")
public class EventoXUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_EventoXUsuario")
    private int idEventoXUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_ID")
    public Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    public UsuarioDTO usuarioDTO;

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public EventoXUsuario(){}

    public EventoXUsuario(Evento unEvento, UsuarioDTO unUser){
        usuarioDTO = unUser;
        evento = unEvento;
    }

    public Evento Evento() {
        return evento;
    }

}