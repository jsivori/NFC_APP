package com.postas.postas.model;

import com.postas.postas.model.position.Posicion;
import com.postas.postas.model.task.Tarea;

public class Posta {

    private Tarea tarea;
    private Posicion posicion;

    public Posicion getPosicion_inicial() {
        return posicion_inicial;
    }

    public void setPosicion_inicial(Posicion posicion_inicial) {
        this.posicion_inicial = posicion_inicial;
    }

    private Posicion posicion_inicial;

    public Posta(Tarea tarea, Posicion posicion, Posicion posicion_inicial) {
        this.tarea = tarea;
        this.posicion = posicion;
        this.posicion_inicial = posicion_inicial;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
