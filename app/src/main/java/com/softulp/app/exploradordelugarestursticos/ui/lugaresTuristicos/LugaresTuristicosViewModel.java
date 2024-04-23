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

        lt= new LugarTuristico();
        lt.setNombre("Cabildo");
        lt.setDescripcion("En conmemoración del bicentenario, San Luis construyó en La Punta la réplica exacta del Cabildo Histórico, símbolo por excelencia de la Revolución de Mayo de 1810. Está destinado a actividades recreativas, turísticas, culturales, pedagógicas y de interés histórico. Ofrece visitas guiadas para escuelas, turistas y residentes.");
        lt.setFotos(new ArrayList<>(Arrays.asList(R.drawable.cabildo1,R.drawable.cabildo2)));
        lt.setMasInfo(" La entrada general tiene un arancel de $50 pesos y se puede visitar todos los días.\nEn conmemoración del bicentenario, San Luis construyó en La Punta la réplica exacta del Cabildo Histórico, símbolo por excelencia de la Revolución de Mayo de 1810. Está destinado a actividades recreativas, turísticas, culturales, pedagógicas y de interés histórico. Ofrece visitas guiadas para escuelas, turistas y residentes.\n" +
                "\n" +
                "También se puede visitar la réplica de la Pirámide de Mayo, del primer aniversario del 25 de Mayo, en 1811. Para consulta por turnos para visitas guiadas de establecimientos educativos se pueden comunicar a la Autopista de la Información, al teléfono 4452010 int. 8983 – 8934");
        lt.setHorarios("8:00 a 20:00");
        lista.add(lt);

        lt= new LugarTuristico();
        lt.setNombre("Potrero de los funes");
        lt.setDescripcion("El Potrero de los Funes es una localidad de la Provincia de San Luis, Argentina1. Es un hermoso espacio verde de flora autóctona y exótica que cuenta con 7 Ha. de faldeo de serranías y se ubica en el margen este del lago2. El lago Potrero de los Funes es un espejo de agua de 91 hectáreas y una profundidad de 33 metros3. Es posible realizar pesca de carpas y pejerreyes y practicar deportes acuáticos sin motor como windsurf y canotaje3. El circuito de Potrero de los Funes es uno de los más espectaculares del mundo, no solamente por sus características propias como pista de carreras, sino por su construcción, su amplitud y más que nada por su entorno natural con un dibujo original que rodea a un enorme lago.");
        lt.setFotos(new ArrayList<>(Arrays.asList(R.drawable.potrero1,R.drawable.potrero2,R.drawable.potrero3,R.drawable.potrero4)));
        lt.setMasInfo(" Potrero de los Funes goza casi todo el año de un clima ameno muy favorable al turismo, especialmente con el atractivo del lago del Embalse Potrero de los Funes, el cual además de ofrecer hermosos paisajes permite la práctica de deportes náuticos y la pesca deportiva. En los meses de verano Potrero de los Funes es el centro del festival de Folclore llamado El Fogón y el Lago, con artistas locales, provinciales y nacionales; siendo este uno de los más reconocidos de la provincia de San Luis.\n" +
                "\n" +
                "Con diversos hoteles y cámpines alrededor del Embalse Potrero de los Funes, es uno de los sitios más turísticos de la zona adyacente al Gran San Luis.");

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