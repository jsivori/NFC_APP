package com.postas.postas.model.strategy;

import android.app.Activity;
import android.content.Intent;

import com.postas.postas.model.Juego;
import com.postas.postas.model.position.Posicion;
import com.postas.postas.model.state.JugadorEstado;
import com.postas.postas.model.state.JugadorEstadoJugando;
import com.postas.postas.model.state.JugadorEstadoTerminado;
import com.postas.postas.view.activities.FinActivity;
import com.postas.postas.view.activities.TareaActivity;

public class DinamicaIntermedia extends Dinamica {

    private boolean yaJugado = false;
    private boolean _ya_jugado = false;

    @Override
    public JugadorEstado conexionExitosa(Activity activity) {
        _ya_jugado = yaJugado;
        activity.startActivity(new Intent(activity, yaJugado ? FinActivity.class : TareaActivity.class));
        yaJugado = true;
        activity.finish();
        return _ya_jugado ? new JugadorEstadoTerminado() : new JugadorEstadoJugando();
    }

    @Override
    public Posicion getPuntoDeEncuentro() {
        return yaJugado ? Juego.getInstance().getPostaSiguiente().getPosicion() : Juego.getInstance().getPostaActualJugador().getPosicion_inicial();
    }
}