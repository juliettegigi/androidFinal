package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MasInfoViewModel extends ViewModel {
    private MutableLiveData<LugarTuristico> mutableLugar;
    private MutableLiveData<Integer> mutableImagen;
    private int i;



    public LiveData<LugarTuristico> getMutableLugar(){
        if(mutableLugar==null)
            mutableLugar=new MutableLiveData<>();
        return mutableLugar;
    }
    public LiveData<Integer> getMutableImagen(){
        if(mutableImagen==null){
            mutableImagen=new MutableLiveData<>();
            i=0;
        }
        return mutableImagen;
    }
   public void recibirLugar(Bundle bundle){
       LugarTuristico lugar=(LugarTuristico) bundle.get("lugar");
       if(lugar!=null){
           mutableLugar.setValue(lugar);
           if(lugar.getFotos()!=null)
               mutableImagen.setValue(lugar.getFotos().get(i));
       }
   }

   public void getImg(int num){
        if(i+num==-1)
            i=mutableLugar.getValue().getFotos().size()-1;
        else
           i=(i+num)%mutableLugar.getValue().getFotos().size();
        Log.d("valori",i+"");
        mutableImagen.setValue(mutableLugar.getValue().getFotos().get(i));
   }

}