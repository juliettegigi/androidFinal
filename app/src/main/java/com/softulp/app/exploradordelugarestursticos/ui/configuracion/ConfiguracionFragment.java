package com.softulp.app.exploradordelugarestursticos.ui.configuracion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.GoogleMap;
import com.softulp.app.exploradordelugarestursticos.R;
import com.softulp.app.exploradordelugarestursticos.databinding.FragmentConfiguracionBinding;
import com.softulp.app.exploradordelugarestursticos.ui.mapa.MapsViewModel;

import java.util.Locale;

public class ConfiguracionFragment extends Fragment {

    private FragmentConfiguracionBinding binding;
    private ConfiguracionViewModel vm;

    private TextView textViewSeleccionado;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(ConfiguracionViewModel.class);
        intent = new Intent("com.softulp.app.exploradordelugaresturisticos.configurarTipoMapa");
        binding = FragmentConfiguracionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textViewSeleccionado=binding.tvNormal;
        seleccionar(binding.tvNormal);


        vm.getMutableIdiomaEspanol().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                seleccionar(binding.tvEspanol);
                deseleccionar(binding.tvIngles);}

        });
        vm.getMutableIdiomaIngles().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                seleccionar(binding.tvIngles);
                deseleccionar(binding.tvEspanol);
            }
        });


        vm.inicializarIdioma();

        return root;
    }

    private void seleccionar(TextView tv){
        tv.setTextColor(getResources().getColor(android.R.color.white));
        tv.setBackgroundColor(Color.BLACK);
    }
    private void deseleccionar(TextView tv){
        tv.setTextColor(getResources().getColor(android.R.color.black));
        tv.setBackgroundColor(Color.WHITE);
        tv.setBackgroundResource(R.drawable.textviews);
    }




    private void eventoClick(TextView tv,int value){
        seleccionar(tv);
        deseleccionar(textViewSeleccionado);
        textViewSeleccionado=tv;
        intent.putExtra("tipo", value);
        getContext().sendBroadcast(intent);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvEspanol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionar(binding.tvEspanol);
                setLocale("es");
            }
        });

        binding.tvIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionar(binding.tvIngles);
                setLocale("en");
            }
        });


        binding.tvSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewSeleccionado != binding.tvSatelite)
                  eventoClick(binding.tvSatelite,2);


            }
        });
        binding.tvHibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if (textViewSeleccionado != binding.tvHibrido)
                    eventoClick(binding.tvHibrido,4);

            }
        });
        binding.tvNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     if (textViewSeleccionado != binding.tvNormal)
                   eventoClick(binding.tvNormal,1);

            }
        });

        binding.tvTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("salida","en on cliclk");
                    if (textViewSeleccionado != binding.tvTerreno)
                   eventoClick(binding.tvTerreno,3);

            }
        });

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reinicia la actividad para aplicar los cambios de idioma
        getActivity().recreate();
    }
}
