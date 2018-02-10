package com.postas.postas.model.strategy;

import android.app.Activity;
import android.content.Intent;

import com.postas.postas.model.position.Posicion;
import com.postas.postas.model.state.JugadorEstado;
import com.postas.postas.model.state.JugadorEstadoCaminando;
import com.postas.postas.model.state.JugadorEstadoEsperando;
import com.postas.postas.view.activities.EncuentroActivity;

public abstract class Dinamica {

    public JugadorEstado comenzarTarea (Activity activity) {
        activity.startActivity(new Intent(activity, EncuentroActivity.class));
        activity.finish();
        return new JugadorEstadoEsperando();
    }

    public JugadorEstado tareaTerminada (Activity activity) {
        activity.startActivity(new Intent(activity, EncuentroActivity.class));
        activity.finish();
        return new JugadorEstadoCaminando();
    }

    public abstract JugadorEstado conexionExitosa(Activity activity);

    public abstract Posicion getPuntoDeEncuentro();
}