package com.postas.postas.view.custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.postas.postas.R;
import com.postas.postas.view.OnTareaTerminada;

/**
 * Created by leandro on 20/5/17.
 */

public class FraseView extends RelativeLayout {

    public FraseView(Context context) {
        super(context);
        init(null);
    }

    public FraseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public FraseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FraseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init (AttributeSet attrs) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.view_frase, this, true);
    }

    public void populate (String frase, final OnTareaTerminada callback, String jugador) {
        ((TextView) findViewById(R.id.tv_frase)).setText(frase);
        ((TextView) findViewById(R.id.nombre)).setText(jugador);
        findViewById(R.id.btn_continuar).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.tareaTerminada();
            }
        });

    }
}
