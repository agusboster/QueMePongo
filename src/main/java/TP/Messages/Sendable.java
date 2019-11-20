package TP.Messages;

import TP.User.Usuario;

public interface Sendable {

    void avisarAtuendo(Usuario usuario);

    void enviarMensaje(Usuario usuario, String mensaje);

    void avisarAlerta(Usuario usuario, double diferencia);
}
