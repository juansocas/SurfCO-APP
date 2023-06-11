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

    public static final String DB_FILE = "usuarios.db";
    public static final String JSON_FILE = "usuarios.json";
    public static final String JSON_ROOT = "usuarios";

    private static SurfandCoRepository INSTANCE;

    private SurfandCODatabase database;
    private Context context;

    public static RepositoryContract getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new SurfandCoRepository(context);

        }
        return INSTANCE;

    }

    public SurfandCoRepository(Context context) {
        this.context = context;
        database = Room.databaseBuilder(context,SurfandCODatabase.class,DB_FILE).build();
    }



    @Override
    public void loadUsers(final boolean clearFirst, final FetchUsersDataCallback callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (clearFirst){
                    database.clearAllTables();
                }
                boolean error= false;
                if (getUserDao().getUsers().size() == 0){
                    error =! loadSURFandCOCatalogFromJSON(loadJSONFromAsset());
                }
                if (callback != null){
                    callback.onUsersDataFetched(error);
                }
            }
        });

    }



/*
    public void insertUser(User user, final OnUserInserted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                getUserDao().insertarUser(user);
                if (callback != null){
                    callback.onUserInserted(user);
                }
            }
        });

    }

 */
public void insertUser(User user, final OnUsersUpdated callback){
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            getUserDao().insertarUser(user);
            List<User> usuarios = getUserDao().getUsers();
            if (callback != null){
                callback.onUsersUpdated(usuarios);
            }
        }
    });

}

    public void getUsers( final OnUsergeted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<User> usuarios = getUserDao().getUsers();

                if (callback != null){
                    callback.onUsergeted(usuarios);

                }
            }
        });
    }

    @Override
    public void getUsersList(final GetUsersListCallback callback) {
    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            if(callback !=null){
                callback.setUsersList(getUserDao().getUsers());
            }
        }
    });

    }

    public void getgetAllPicos(final  OnPicosgetted callback){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                List<Picos> picos = getPicosDao().getAllPicos();
                if(callback !=null){
                    callback.onPicosgetted(picos);
                }
            }
        });
    }




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
                    getUserDao().insertarUser(user);


                }
                for(int i = 0; i<users.size(); i++){
                    Log.e(TAG, "Los Users son los siguientes con email: "+ users.get(i).getEmail() + " y de password " + users.get(i).getPassword());

                }
                return true;

            }
        }catch (JSONException error){
            Log.e(TAG, "error: " + error);
        }
        Log.e(TAG, "PASAAAA()");

        return false;
    }


    private String loadJSONFromAsset(){
        Log.e(TAG, "loadJSONFromAsset()");

        String json = null;

        try {
            InputStream is = context.getAssets().open("usuarios.json");
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
