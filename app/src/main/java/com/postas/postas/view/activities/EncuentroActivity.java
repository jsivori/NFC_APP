package com.postas.postas.view.activities;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.postas.postas.R;
import com.postas.postas.model.Juego;
import com.postas.postas.model.position.Posicion;

public class EncuentroActivity extends FragmentActivity implements OnMapReadyCallback, NfcAdapter.CreateNdefMessageCallback,
        NfcAdapter.OnNdefPushCompleteCallback {

    private GoogleMap mMap;
    private Posicion posicion;
    NfcAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentro);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        posicion = Juego.getInstance().puntoDeEncuentro();
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        checkNfc();
    }

    private void checkNfc() {
        if (mAdapter == null) {
            Toast.makeText(this, "Este dispositivo no cuenta con NFC", Toast.LENGTH_LONG).show();
            return;
        }
        if (!mAdapter.isEnabled()) {
            Toast.makeText(this, "Por favor, active el uso de NFC", Toast.LENGTH_LONG).show();
        }
        mAdapter.setNdefPushMessageCallback(this, this);
        mAdapter.setOnNdefPushCompleteCallback(this, this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        posicion.dibujarEnMapa(googleMap);
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        NdefRecord ndefRecord = NdefRecord.createMime("text/plain", "Conectado".getBytes());
        return new NdefMessage(ndefRecord);
    }

    @Override
    public void onNdefPushComplete(NfcEvent event) {
        Juego.getInstance().conexionExitosa(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction()))
            Juego.getInstance().conexionExitosa(this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }
}
