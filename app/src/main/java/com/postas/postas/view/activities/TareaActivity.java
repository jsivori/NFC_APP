package com.postas.postas.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import com.postas.postas.R;
import com.postas.postas.model.Juego;
import com.postas.postas.view.OnTareaTerminada;

public class TareaActivity extends AppCompatActivity implements OnTareaTerminada {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        LinearLayout content = (LinearLayout) findViewById(R.id.ll_content);
        Juego.getInstance().getPostaActualJugador().getTarea().dibujarTarea(content, this, Juego.getInstance().getNombreJugador());
    }

    @Override
    public void tareaTerminada() {
        Juego.getInstance().tareaTerminada(this);
    }
}
