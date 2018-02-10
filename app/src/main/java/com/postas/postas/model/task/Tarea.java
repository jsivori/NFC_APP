package com.postas.postas.model.task;

import android.widget.LinearLayout;
import com.postas.postas.view.OnTareaTerminada;

public interface Tarea {

    void dibujarTarea(LinearLayout v, OnTareaTerminada callback, String jugador);
}
