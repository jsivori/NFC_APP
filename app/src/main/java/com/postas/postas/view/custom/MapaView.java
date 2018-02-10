package com.postas.postas.view.custom;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.SupportMapFragment;
import com.postas.postas.R;

/**
 * Created by leandro on 20/5/17.
 */

public class MapaView extends RelativeLayout {

    public MapaView(Context context) {
        super(context);
        init(null);
    }

    public MapaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MapaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MapaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init (AttributeSet attrs) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.view_mapa, this, true);
//        SupportMapFragment mapFragment = (SupportMapFragment) ((AppCompatActivity)getContext()).getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }
}
