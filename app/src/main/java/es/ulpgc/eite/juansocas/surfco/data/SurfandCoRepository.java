package es.ulpgc.eite.juansocas.surfco.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import es.ulpgc.eite.juansocas.surfco.database.PicosDAO;
import es.ulpgc.eite.juansocas.surfco.database.SurfandCODatabase;
import es.ulpgc.eite.juansocas.surfco.database.UserDAO;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


public class SurfandCoRepository implements RepositoryContract{


    public static String TAG = SurfandCoRepository.class.getSimpleName();

    public static final String DB_FILE = "BaseSURFandCOcatalog.db";
    public static final String JSON_FILE = "BaseSURFandCOcatalog.json";
    public static final String JSON_ROOT = "categories";

    private static SurfandCoRepository INSTANCE;

    private SurfandCODatabase database;
    private Context context;

    public SurfandCoRepository(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context,SurfandCODatabase.class,DB_FILE).build();
    }

    public static RepositoryContract getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SurfandCoRepository(context);
        }
        return INSTANCE;

    }
/*
    @Override
    public void loadCatalog(final boolean clearFirst, final FetchCatalogDataCallback callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (clearFirst){
                    database.clearAllTables();
                }
                boolean error= false;
                if (getUserDao().loadUsers().size() == 0){
                    error =! loadSURFandCOCatalogFromJSON(loadJSONFromAsset());
                }
                if (callback != null){
                    callback.onCatalogDataFetched(error);
                }
            }
        });

    }


 */







    public void updateUser(final User user){

    }


    private UserDAO getUserDao(){
        return  database.userDAO();
    }

    private PicosDAO getPicosDao(){
        return database.picosDAO();
    }



    private boolean loadSURFandCOCatalogFromJSON(String json){
        Log.e(TAG,"loadSURFandCOCatalogFromJSON()");

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

            if (jsonArray.length() > 0){
                final List<User> users = Arrays.asList(gson.fromJson(jsonArray.toString(), User[].class));

                for(User user : users){
                    //getUserDAO().
                }

            }
        }catch (JSONException error){
            Log.e(TAG, "error: " + error);
        }

        return false;
    }


    private String loadJSONFromAsset(){
        //Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException error) {
            Log.e(TAG, "error: " + error);
        }

        return json;
    }


}
