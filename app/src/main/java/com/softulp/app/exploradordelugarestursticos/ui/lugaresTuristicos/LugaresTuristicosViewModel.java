package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.app.exploradordelugarestursticos.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LugaresTuristicosViewModel extends AndroidViewModel {
    private ArrayList<LugarTuristico> lista;
    private MutableLiveData<RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder>> mutableAdapter;

    public LugaresTuristicosViewModel(@NonNull Application application) {
        super(application);
        lista=new ArrayList<>();
    }



    public LiveData<RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder>> getMutableAdapter(){
        if(mutableAdapter==null) {
            mutableAdapter = new MutableLiveData<RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder>>();
            cargarDatos();
            RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder>  adapter=new LugarTuristicoAdapter(lista,getApplication());
            mutableAdapter.setValue(adapter);

        }
        return mutableAdapter;
    }

    private void cargarDatos(){
        LugarTuristico lt= new LugarTuristico();
        lt.setNombre("Catedral");
        lt.setDescripcion("La Catedral de la ciudad de San Luis es un sitio de gran valor histórico, religioso y cultural1. Fue escenario de la Jura de la Independencia en 1816 y en 1975 fue declarada Lugar Histórico Nacional1. Se encuentra en calle Rivadavia, frente a la Plaza Juan Pascual Pringles1. La iglesia comenzó a construirse en 1883 y finalizó en 19442. Es la única catedral en el mundo que cuenta con 24 apóstoles en su construcción, 12 de piedra y 12 de mármol.");

        lt.setFotos(new ArrayList<>(Arrays.asList(R.drawable.catedral1, R.drawable.catedral2, R.drawable.catedral3)));
        lt.setMasInfo("Excepcional testimonio arquitectónico, la Iglesia Catedral de la ciudad de San Luis comenzó a construirse en 1883 y finalizó a 1944. Una característica distinguible de esta edificación es su fachada neoclásica ornamentada por bajos relieves que simbolizan escenas de la vida de Luis Rey, mientras que dos torres gemelas, una cúpula semiesférica en la parte posterior, y una nave principal con capillas laterales, completan esta estructura en cuyo interior descansan los restos de dos Obispos y los del Coronel Juan Pascual Pringles.\n" +
                "La Catedral fue escenario de la Jura de la Independencia en 1816; y en 1975 fue declarada Lugar Histórico Nacional. Constituye por todo esto un sitio de gran valor histórico, religioso y cultural que no puede omitir en su itinerario por San Luis.\n" +
                "Se halla emplazada sobre calle Rivadavia, frente a la Plaza Juan Pascual Pringles.");
        lt.setHorarios("Abre a las 9:00.");
        lista.add(lt);
        lt= new LugarTuristico();
        lt.setNombre("Terrazas del portezuelo");
        lt.setDescripcion("Terrazas del Portezuelo es la denominación de un conjunto de edificios y parque cívico el cual incluye a la Casa de Gobierno de la provincia de San Luis, Argentina, primer edificio ecológico público del país, inaugurado el 9 de julio de 2010 (13 años) como homenaje al bicentenario de la Revolución de Mayo por el …");
        lt.setFotos(new ArrayList<>(Arrays.asList(R.drawable.terrazas1)));
        lt.setMasInfo("Terrazas del Portezuelo es la denominación de un conjunto de edificios y parque cívico el cual incluye a la Casa de Gobierno de la provincia de San Luis, Argentina, primer edificio ecológico público del país, inaugurado el 9 de julio de 2010 (13 años) como homenaje al bicentenario de la Revolución de Mayo por el gobernador Alberto Rodríguez Saá, el impulsor del proyecto. Su condición de primer edificio público sustentable de la República Argentina fue certificado por la Fundación Proyecto Climático iniciada por Al Gore en octubre de 2011.\n" +
                "\n" +
                "Este emprendimiento está destinado a sede de la administración pública provincial y se encuentra en un cerro de unas 20 ha poblado por flora autóctona ubicado en las márgenes del Dique Chico, un reservorio de agua para riego emplazado en una depresión de la cadena serrana puntana, en la periferia sur de la ciudad de San Luis y en el ingreso de la ciudad de Juana Koslay, en un punto señalado por algunos expertos como el lugar original de la fundación de la ciudad. Tiene vistas panorámicas hacia la ciudad, el Portezuelo y las sierras de San Luis. Se conecta con la ciudad de San Luis a través de la avenida circundante al mismo, la Avenida Parque y la Ruta Nacional 147 y desde la Autopista RN 7 llamada ‘Serranías Puntanas’. El proyecto del lugar pertenece al arquitecto cordobés Esteban Bondone y fue pensado como un parque cívico y sustentable en el que conviven espacios y edificios de uso público.\n" +
                "\n" +
                "Además de la Casa de Gobierno, el centro cívico está compuesto por cuatro edificios ministeriales: Proyección a Futuro (Tecnología), Estrategias (Desarrollo Estratégico), Conservador (Economía) y Capital (Recursos Humanos). El conjunto se cierra con una plaza pública y el Hito del Bicentenario, una torre de 125 metros de altura.");
        lista.add(lt);

        lista.add(new LugarTuristico("nnombre3","desc3"));
        lista.add(new LugarTuristico("nnombre4","desc4"));
        lista.add(new LugarTuristico("nnombre5","desc5"));
        lista.add(new LugarTuristico("nnombre6","desc5"));
        lista.add(new LugarTuristico("nnombre7","desc5"));
        lista.add(new LugarTuristico("nnombre8","desc5"));
        lista.add(new LugarTuristico("nnombre9","desc5"));
    }


}