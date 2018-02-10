package com.postas.postas.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.postas.postas.model.Posta;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LeerPostas {

    public static ArrayList<Posta> leer(int tipo, Context context) {
        ArrayList<PostasAdapter> postas;
        Type listType = new TypeToken<List<PostasAdapter>>() {}.getType();

        switch (tipo) {
            case 0:
                postas = new Gson().fromJson(loadJSONFromAsset(context, "postas_pregunta.json"), listType);
                break;
            case 1:
                postas = new Gson().fromJson(loadJSONFromAsset(context, "postas_frase.json"), listType);
                break;
            default:
                postas = null;
                break;
        }
        return PostasAdapter.getPostas(postas);
    }

    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
