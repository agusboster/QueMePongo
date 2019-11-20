package TP;

import TP.Messages.Email.EmailSender;
import TP.Messages.Whatsapp.WhatsappSender;
import TP.User.Usuario;
import TP.Weather.Weather;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id_evento")
    private int idEvento;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evento")
    public List<EventoXUsuario> eventoXUsuario = new ArrayList<>();

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Dias_que_faltan")
    private int diasQueFaltan;

    @Transient
    double abrigoPronosticado;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Id_frecuencia")
    Frecuencia frecuencia;

//    public List<Usuario> getUsuarios() {return (this.usuarios); }


    @Transient
    boolean esFormal;

    public int getIdEvento(){ return idEvento; }

    public int getDiasQueFaltan(){ return diasQueFaltan; }

    public String getDescripcion(){return descripcion;}
    public void setFrecuencia(Frecuencia unaFrecuencia){
        frecuencia = unaFrecuencia;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setDiasQueFaltan(Integer dias){
        this.diasQueFaltan = dias;
    }

    public Evento(String descripcion, int fecha, Frecuencia frecuencia){
        this.descripcion = descripcion;
        this.diasQueFaltan = fecha;
        this.frecuencia = frecuencia;
        this.esFormal = false;
    }
    public boolean esFormal(){
        return esFormal;
    }
    public void setEsFormal(boolean b){
        esFormal = b;
    }
    public void actualizarAbrigoPronosticado(){
        abrigoPronosticado = nivelDeAbrigoNecesario();
    }

    public void setAbrigoPronosticado(double abrigo){
        this.abrigoPronosticado = abrigo;
    }
    public double obtenerClima(){
        if (diasQueFaltan>=1)
            return Weather.getTemperaturaDia(diasQueFaltan);
        return Weather.getTemperaturaAhora();
    }

    public double nivelDeAbrigoNecesario(){
        return 30-obtenerClima();
    }

    @Override
    public String toString(){
        return descripcion;
    }

    public boolean estaPorOcurrir(){
        return diasQueFaltan==0;
    }

    public boolean yaOcurrio(){
        return diasQueFaltan<0;
    }
    public void notificarUsuario(Usuario usuario){
        WhatsappSender.get().avisarAtuendo(usuario);
        EmailSender.get().avisarAtuendo(usuario);
    }
    public void alertarUsuario(Usuario usuario){
        WhatsappSender.get().avisarAlerta(usuario, diferenciaDePronostico());
        EmailSender.get().avisarAlerta(usuario, diferenciaDePronostico());
    }

    public Evento(){
    }

    public void avanzarUnDia(Usuario usuario){
        diasQueFaltan--;
        if (estaPorOcurrir()){
            if (ocurreAlertaMeteorologica()){
                alertarUsuario(usuario);
            }else{
                notificarUsuario(usuario);
            }
            actualizarAbrigoPronosticado();
        }
        if(yaOcurrio()){
            if(frecuencia.seRepite()) {
                this.diasQueFaltan = frecuencia.getCadaCuanto();
            }
        }
    }

    public boolean ocurreAlertaMeteorologica(){
        return diferenciaDePronostico() > 8;
    }
    public double diferenciaDePronostico(){
        return Math.abs(abrigoPronosticado - nivelDeAbrigoNecesario());
    }
}
