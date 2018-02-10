package com.postas.postas.model.task;

import android.widget.LinearLayout;
import com.postas.postas.view.OnTareaTerminada;
import com.postas.postas.view.custom.FraseView;

public class Frase implements Tarea {

    private String frase;

    public Frase(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public void dibujarTarea(LinearLayout v, OnTareaTerminada callback, String jugador) {
        FraseView view = new FraseView(v.getContext());
        view.populate(frase, callback, jugador);
        v.addView(view);
    }
}
