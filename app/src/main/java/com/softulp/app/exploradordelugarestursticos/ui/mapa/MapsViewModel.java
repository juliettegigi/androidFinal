package com.softulp.app.exploradordelugarestursticos.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsViewModel extends AndroidViewModel {


    private FusedLocationProviderClient fused;
    private LocationCallback cb;
    private Marker marcador;
    private MutableLiveData<Integer> mutableTipoMapa;
    private MutableLiveData<LatLng> mutableLatLng;

    public MapsViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());

    }
public LiveData<Integer> getMutableTipoMapa(){
        if(mutableTipoMapa==null)
            mutableTipoMapa=new MutableLiveData<>();
        return  mutableTipoMapa;
}

public LiveData<LatLng> getMutableLatLng(){
        if(mutableLatLng==null)
            mutableLatLng=new MutableLiveData<>();
        return  mutableLatLng;
}

    public void setMutableTipoMapa(Integer i) {
        mutableTipoMapa.setValue(i);

    }


    public void lecturaPermanente( ) {

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)

            return;
        LocationRequest request = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();

        cb = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) return;
                Location location = locationResult.getLastLocation();
                //
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                mutableLatLng.postValue(latLng);

                //

            }
        };


        fused.requestLocationUpdates(request, cb, null);

    }
    public void pararLecturaPermanente(){

        fused.removeLocationUpdates(cb);
    }
}