package com.postas.postas.view.custom;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.postas.postas.R;
import com.postas.postas.model.task.Pregunta;
import com.postas.postas.view.OnTareaTerminada;


/**
 * Created by leandro on 20/5/17.
 */

public class PreguntaView extends RelativeLayout {

    public PreguntaView(Context context) {
        super(context);
        init(null);
    }

    public PreguntaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PreguntaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PreguntaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init (AttributeSet attrs) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.view_pregunta, this, true);
    }

    public void popular(final Pregunta pregunta, final OnTareaTerminada callback, String jugador) {
        ((TextView) findViewById(R.id.tv_pregunta)).setText(pregunta.getPregunta());
        ((TextView) findViewById(R.id.nombre)).setText(jugador);

        Button op1 = (Button) findViewById(R.id.btn_op1);
        Button op2 = (Button) findViewById(R.id.btn_op2);
        Button op3 = (Button) findViewById(R.id.btn_op3);
        Button op4 = (Button) findViewById(R.id.btn_op4);

        op1.setText(pregunta.getOp1());
        op2.setText(pregunta.getOp2());
        op3.setText(pregunta.getOp3());
        op4.setText(pregunta.getOp4());

        op1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getCorrecta() == 1) {
                    callback.tareaTerminada();
                }
                else {
                    v.setEnabled(false);
                    //                v.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_BD));
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Respuesta incorrecta");
                    alertDialog.setMessage("");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        op2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getCorrecta() == 2) {
                    callback.tareaTerminada();
                }
                else {
                    v.setEnabled(false);
                    //                v.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_BD));
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Respuesta incorrecta");
                    alertDialog.setMessage("");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        op3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getCorrecta() == 3) {
                    callback.tareaTerminada();
                }
                else {
                    v.setEnabled(false);
                    //                v.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_BD));
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Respuesta incorrecta");
                    alertDialog.setMessage("");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        op4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pregunta.getCorrecta() == 4) {
                    callback.tareaTerminada();
                }
                else {
                    v.setEnabled(false);
                    //                v.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.grey_BD));
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Respuesta incorrecta");
                    alertDialog.setMessage("");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}
