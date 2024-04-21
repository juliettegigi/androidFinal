package com.softulp.app.exploradordelugarestursticos.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
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
    private Marker marcador;
    private GoogleMap map;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {

             map=googleMap ;
            vm.getMutableLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
                @Override
                public void onChanged(Location location) {
                    if (location != null) {
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                        if (marcador == null) {
                            marcador = map.addMarker(new MarkerOptions().position(latLng).title("Mi Ubicación"));
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                        } else {
                            marcador.setPosition(latLng);
                        }

                    }
                }
            });
            vm.lecturaPermanente();


        }
    };

    /*método para inflar el xml
    * configurar cualquier vista necesaria dentro del fragmento,como la configuración de datos, la configuración de oyentes de eventos, etc. */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_maps, container, false);

        vm=new ViewModelProvider(this).get(MapsViewModel.class);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);


        if (mapFragment != null) {

            mapFragment.getMapAsync(callback);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        // Detener las actualizaciones de ubicación cuando la aplicación está en pausa
        //fusedLocationClient.removeLocationUpdates(locationCallback);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Solicitar actualizaciones de ubicación cuando la aplicación se reanuda
       // requestLocation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Llama al método para detener la lectura permanente
        vm.pararLecturaPermanente();
    }
}