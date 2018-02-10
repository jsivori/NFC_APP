package com.postas.postas.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.postas.postas.R;
import com.postas.postas.model.Juego;
import com.postas.postas.model.Jugador;

import java.util.ArrayList;

public class ConfigActivity extends AppCompatActivity {

    private Spinner spJugador;
    private EditText etNombre;
    private Jugador jugador = new Jugador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Button btnSiguiente = (Button) findViewById(R.id.btn_next);
        Spinner spCantidad = (Spinner) findViewById(R.id.sp_count);
        spJugador = (Spinner) findViewById(R.id.sp_number);
        Spinner spTareas = (Spinner) findViewById(R.id.sp_tasks);
        etNombre = (EditText) findViewById(R.id.edtName);

        spCantidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Juego.getInstance().setCantidadJugadores(position + 2);
                ArrayList<String> numeros = new ArrayList<>();
                for (int i=1; i <= (position+2); i++)
                    numeros.add(String.valueOf(i));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ConfigActivity.this, android.R.layout.simple_spinner_item, numeros);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spJugador.setAdapter(adapter);
                spJugador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        jugador.setNumero(position + 1);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spTareas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Juego.getInstance().levantarPostas(position, ConfigActivity.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador.setNombre(etNombre.getText().toString());
                Juego.getInstance().setJugador(jugador);
                Juego.getInstance().comenzarJuego(ConfigActivity.this);
            }
        });
    }
}
