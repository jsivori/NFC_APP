package com.postas.postas.utils;

import com.google.gson.annotations.SerializedName;
import com.postas.postas.model.Posta;
import com.postas.postas.model.position.Area;
import com.postas.postas.model.position.LatLong;
import com.postas.postas.model.task.Frase;
import com.postas.postas.model.task.Pregunta;

import java.util.ArrayList;

public class PostasAdapter {

    @SerializedName("tipo")
    private String tipo;

    @SerializedName("frase")
    private String frase;

    @SerializedName("pregunta")
    private Pregunta pregunta;

    @SerializedName("posicion")
    private ArrayList<LatLong> posiciones;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<LatLong> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<LatLong> posiciones) {
        this.posiciones = posiciones;
    }

    public static ArrayList<Posta> getPostas(ArrayList<PostasAdapter> lista) {
        ArrayList<Posta> postas = new ArrayList<>();
        for (PostasAdapter p : lista) {
            if (p.getPregunta() != null)
                postas.add(new Posta(p.getPregunta(), p.getPosiciones().size() == 1 ? p.getPosiciones().get(0) : new Area(p.getPosiciones()), p.getPosiciones().get(p.getPosiciones().size()-1)));
            else
                postas.add(new Posta(new Frase(p.getFrase()), p.getPosiciones().size() == 1 ? p.getPosiciones().get(0) : new Area(p.getPosiciones()), p.getPosiciones().get(p.getPosiciones().size()-1)));
        }
        return postas;
    }
}
