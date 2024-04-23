package com.softulp.app.exploradordelugarestursticos.ui.mapa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.google.android.gms.maps.GoogleMap;
import com.softulp.app.exploradordelugarestursticos.MainActivity;

public class ConfigurarMapa extends BroadcastReceiver {
    MapsFragment ma;
    public ConfigurarMapa(MapsFragment mf) {
        this.ma=mf;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("com.softulp.app.exploradordelugaresturisticos.configurarTipoMapa".equals(intent.getAction())) {
            int i=intent.getIntExtra("tipo",1);
            ma.setTipoMapa(i);


        }




    }
}