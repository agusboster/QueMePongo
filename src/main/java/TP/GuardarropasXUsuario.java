package TP;

import TP.User.UsuarioDTO;

import javax.persistence.*;

@Entity
@Table(name = "GuardarropasXUsuario")
public class GuardarropasXUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_GuardarropasXUsuario")
    private int idGuardarropasXUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    public UsuarioDTO usuarioDTO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardarropas_ID")
    public Guardarropas guardarropas;

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public GuardarropasXUsuario(){}

    public GuardarropasXUsuario(Guardarropas unGuardarropas, UsuarioDTO unUser){
        usuarioDTO = unUser;
        guardarropas = unGuardarropas;
    }

    public Guardarropas getGuardarropas() {
        return guardarropas;
    }

}
