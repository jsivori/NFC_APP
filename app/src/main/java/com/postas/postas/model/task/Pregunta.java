package com.postas.postas.model.task;


import android.widget.LinearLayout;
import com.google.gson.annotations.SerializedName;
import com.postas.postas.view.OnTareaTerminada;
import com.postas.postas.view.custom.PreguntaView;

public class Pregunta implements Tarea {

    @SerializedName("pregunta")
    private String pregunta;
    @SerializedName("opcion1")
    private String op1;
    @SerializedName("opcion2")
    private String op2;
    @SerializedName("opcion3")
    private String op3;
    @SerializedName("opcion4")
    private String op4;
    @SerializedName("correcta")
    private int correcta;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

    @Override
    public void dibujarTarea(LinearLayout v, OnTareaTerminada callback, String jugador) {
        PreguntaView view = new PreguntaView(v.getContext());
        view.popular(this, callback, jugador);
        v.addView(view);
    }
}
