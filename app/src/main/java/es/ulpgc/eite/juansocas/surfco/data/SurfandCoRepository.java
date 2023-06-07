package es.ulpgc.eite.juansocas.surfco.data;

import android.content.Context;
import android.util.Log;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


public class SurfandCoRepository implements RepositoryContract{


    public static String TAG = SurfandCoRepository.class.getSimpleName();

    private static SurfandCoRepository INSTANCE;
    private Context context;

    public SurfandCoRepository(Context context) {
        this.context = context;


    }

    public static RepositoryContract getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SurfandCoRepository(context);
        }
        return INSTANCE;

    }

    private boolean loadSURFandCOCatalogFromJSON(String json){
        Log.e(TAG,"loadSURFandCOCatalogFromJSON()");
        /*
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

         */

        return false;
    }


}
