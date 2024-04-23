package com.softulp.app.exploradordelugarestursticos.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.softulp.app.exploradordelugarestursticos.R;


public class MapsFragment extends Fragment {
    private MapsViewModel vm;
    int tipoMapa;
    private ConfigurarMapa cm;
    Marker m1;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            Log.d("salida","tipo de mapa:_ "+tipoMapa);
            if(tipoMapa==3)
               googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            else   googleMap.setMapType(tipoMapa);

            LatLng iglesia = new LatLng(-33.302025, -66.336044);
            googleMap.addMarker(new MarkerOptions().position(iglesia).title("Iglesia Catedral"));
            iglesia = new LatLng(-33.328217, -66.391571);
            googleMap.addMarker(new MarkerOptions().position(iglesia).title("Terrazas del portezuelo"));
            iglesia = new LatLng(-33.290920, -66.292908);
            googleMap.addMarker(new MarkerOptions().position(iglesia).title("Cabildo"));
            iglesia = new LatLng(-33.235086, -66.234968);
            googleMap.addMarker(new MarkerOptions().position(iglesia).title("Potrero de los Funes"));

            vm.getMutableLatLng().observe(getViewLifecycleOwner(), new Observer<LatLng>() {
                @Override
                public void onChanged(LatLng latLng) {
                    if(m1==null) {
                        m1 = googleMap.addMarker(new MarkerOptions().position(latLng).title("Mi Ubicación"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                    }
                    else  m1.setPosition(latLng);
                }
            });

        }
    };

    /*método para inflar el xml
     * configurar cualquier vista necesaria dentro del fragmento,como la configuración de datos, la configuración de oyentes de eventos, etc. */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        tipoMapa=2;

        vm = new ViewModelProvider(this).get(MapsViewModel.class);
        vm.lecturaPermanente();


vm.getMutableTipoMapa().observe(getViewLifecycleOwner(), new Observer<Integer>() {
    @Override
    public void onChanged(Integer integer) {
        tipoMapa=integer;
    }
});

        cm = new ConfigurarMapa(this);
        getContext().registerReceiver(cm, new IntentFilter("com.softulp.app.exploradordelugaresturisticos.configurarTipoMapa"));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        //referencia al fragmento de mapa mapFragment. Esto te permite luego interactuar con el mapa, como añadir marcadores, configurar eventos, cambiar el estilo del mapa, etc.

        if (mapFragment != null) {

            mapFragment.getMapAsync(callback);
        }
    }


    @Override
    public void onPause() {
        super.onPause();


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        vm.pararLecturaPermanente();

    }



    public  void setTipoMapa(int mapType) {
        tipoMapa=mapType;
        vm.setMutableTipoMapa(mapType);

    }

    @Override
    public void onStart() {
        super.onStart();
    }



}