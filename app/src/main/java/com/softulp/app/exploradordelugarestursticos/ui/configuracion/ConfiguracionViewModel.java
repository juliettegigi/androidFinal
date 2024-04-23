package com.softulp.app.exploradordelugarestursticos.ui.configuracion;



import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.app.exploradordelugarestursticos.R;

import java.util.Locale;

public class ConfiguracionViewModel extends AndroidViewModel {


    private  MutableLiveData<Boolean> mutableIdiomaEspanol;
    private  MutableLiveData<Boolean> mutableIdiomaIngles;
    private  MutableLiveData<TextView> mutableTextViewTipoSeleccionado;

    public ConfiguracionViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getMutableIdiomaEspanol(){
        Log.d("salida ","En el get");
     if(mutableIdiomaEspanol==null) {
         mutableIdiomaEspanol = new MutableLiveData<>();
     }
        return mutableIdiomaEspanol;
    }
    public LiveData<Boolean> getMutableIdiomaIngles(){
        if(mutableIdiomaIngles==null) {
            mutableIdiomaIngles = new MutableLiveData<>();

        }
        return mutableIdiomaIngles;
    }

    public LiveData<TextView> getMutableTextViewTipoSeleccionado(){
        if(mutableTextViewTipoSeleccionado==null)
            mutableTextViewTipoSeleccionado=new MutableLiveData<>();
        return mutableTextViewTipoSeleccionado;
    }



    public void inicializarIdioma(){

        String currentLanguage = Locale.getDefault().getLanguage();

        boolean esIngles = currentLanguage.equals("en");

        if(esIngles){
            mutableIdiomaIngles.postValue(true);
        }
        else {
            mutableIdiomaEspanol.postValue(false);
        }
    }


}