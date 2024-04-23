package com.softulp.app.exploradordelugarestursticos.ui.mapa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

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