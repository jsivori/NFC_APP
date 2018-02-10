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

public class DinamicaFinal extends Dinamica {

    @Override
    public JugadorEstado tareaTerminada(Activity activity) {
        activity.startActivity(new Intent(activity, FinActivity.class));
        activity.finish();
        return new JugadorEstadoTerminado();
    }

    @Override
    public JugadorEstado conexionExitosa(Activity activity) {
        activity.startActivity(new Intent(activity, TareaActivity.class));
        activity.finish();
        return new JugadorEstadoJugando();
    }

    @Override
    public Posicion getPuntoDeEncuentro() {
        return Juego.getInstance().getPostaActualJugador().getPosicion_inicial();
    }
}
