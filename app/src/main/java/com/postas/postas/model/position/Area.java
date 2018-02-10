package com.postas.postas.model.position;

import android.graphics.Color;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class Area implements Posicion {

    private ArrayList<LatLong> puntos;

    public Area(ArrayList<LatLong> puntos) {
        this.puntos = puntos;
    }

    public ArrayList<LatLong> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<LatLong> puntos) {
        this.puntos = puntos;
    }

    @Override
    public void dibujarEnMapa(GoogleMap mMap) {
        PolylineOptions options = new PolylineOptions().width(7).color(Color.RED).geodesic(true);
        for(int i=0; i < puntos.size(); i++){
            options.add(new LatLng(puntos.get(i).getLatitud(), puntos.get(i).getLongitud()));
            if (i == 0) {
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)).position(new LatLng(puntos.get(i).getLatitud(), puntos.get(i).getLongitud())).title("Salida"));
            }else {
                if (i == puntos.size()-1) {
                    mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).position(new LatLng(puntos.get(i).getLatitud(), puntos.get(i).getLongitud())).title("Llegada"));
                }
            }
        }
        /*for (LatLong p : puntos) {
            options.add(new LatLng(p.getLatitud(), p.getLongitud()));
            mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_RED)).position(new LatLng(p.getLatitud(), p.getLongitud())).title("Encuentro"));
        }*/
        mMap.addPolyline(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(puntos.get(0).getLatitud(), puntos.get(0).getLongitud()), 15));
    }
}
