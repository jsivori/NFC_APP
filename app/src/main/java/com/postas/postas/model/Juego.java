package com.postas.postas.model;

import android.app.Activity;
import android.content.Context;

import com.postas.postas.model.position.Posicion;
import com.postas.postas.model.strategy.Dinamica;
import com.postas.postas.model.strategy.DinamicaFinal;
import com.postas.postas.model.strategy.DinamicaInicial;
import com.postas.postas.model.strategy.DinamicaIntermedia;
import com.postas.postas.utils.LeerPostas;

import java.util.ArrayList;

public class Juego {

    private static Juego instance;
    private int jugadores;
    private Dinamica dinamica;
    private Jugador jugador;
    private ArrayList<Posta> postas;

    public static Juego getInstance() {
        if (instance == null)
            instance = new Juego();
        return instance;
    }

    public void levantarPostas(int tipo, Context context) {
        postas = LeerPostas.leer(tipo, context);
    }

    public void setCantidadJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;

        if (jugador.getNumero() == 1)
            dinamica = new DinamicaInicial();
        else if (jugador.getNumero() == jugadores)
            dinamica = new DinamicaFinal();
        else
            dinamica = new DinamicaIntermedia();
    }

    public Posta getPostaActualJugador() {
        return jugador.getPosta();
    }

    public Posta getPostaSiguiente() {
        return postas.get(jugador.getNumero());
    }

    public String getNombreJugador() {
        return jugador.getNombre();
    }

    public void comenzarJuego(Activity context) {
        jugador.setPosta(postas.get(jugador.getNumero()-1));
        jugador.setJugadorEstado(dinamica.comenzarTarea(context));
    }

    public void conexionExitosa (Activity context) {
        dinamica.conexionExitosa(context);
    }

    public void tareaTerminada(Activity context) {
        dinamica.tareaTerminada(context);
    }

    public Posicion puntoDeEncuentro() {
        return dinamica.getPuntoDeEncuentro();
    }
}
