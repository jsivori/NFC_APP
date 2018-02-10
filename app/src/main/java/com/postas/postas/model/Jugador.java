package com.postas.postas.model;

import com.postas.postas.model.position.Posicion;
import com.postas.postas.model.state.JugadorEstado;

public class Jugador {

    private int numero;
    private JugadorEstado jugadorEstado;
    private String nombre;
    private Posicion posicion;
    private Posta posta;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setJugadorEstado(JugadorEstado jugadorEstado) {
        this.jugadorEstado = jugadorEstado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Posta getPosta() {
        return posta;
    }

    public void setPosta(Posta posta) {
        this.posta = posta;
    }
}
